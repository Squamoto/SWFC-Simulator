import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class formation
{
	String name;
	skill skill = new skill();
	ArrayList<card> cards = new ArrayList<card>(Arrays.asList(new card[18]));
	int[] card_ids = new int[18];
	int[] evo_methods = new int[18];
	String info = "";
	card leader;
	int leader_slot = -1, start_row_change, jabba, jabba_backup, summoned;
	double leader_boost, leader_boost_multiplier = 0.0, force_boost_multiplier = 0.0, skill_multiplier = 1.0;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	ArrayList<card> skills = new ArrayList<card>();
	ArrayList<card> medSkills = new ArrayList<card>();
	ArrayList<card> bountyHunters = new ArrayList<card>();
	ArrayList<card> bountyHunters_backup = new ArrayList<card>();
	ArrayList<card> undercover = new ArrayList<card>();
	ArrayList<card> undercover_backup = new ArrayList<card>();
	boolean do_info = false;
	
	formation(String name, int a1, int a1_evo, int b1, int b1_evo, int c1, int c1_evo, int d1, int d1_evo, int e1, int e1_evo, int f1, int f1_evo, int a2, int a2_evo, int b2, int b2_evo, 
			int c2, int c2_evo, int d2, int d2_evo, int e2, int e2_evo, int f2, int f2_evo, int a3, int a3_evo, int b3, int b3_evo, int c3, int c3_evo, int d3, int d3_evo, int e3, int e3_evo, 
			int f3, int f3_evo)
	{
		this.name = name;
		card_ids[0] = a1;
		evo_methods[0] = a1_evo;
		card_ids[1] = b1;
		evo_methods[1] = b1_evo;
		card_ids[2] = c1;
		evo_methods[2] = c1_evo;
		card_ids[3] = d1;
		evo_methods[3] = d1_evo;
		card_ids[4] = e1;
		evo_methods[4] = e1_evo;
		card_ids[5] = f1;
		evo_methods[5] = f1_evo;
		card_ids[6] = a2;
		evo_methods[6] = a2_evo;
		card_ids[7] = b2;
		evo_methods[7] = b2_evo;
		card_ids[8] = c2;
		evo_methods[8] = c2_evo;
		card_ids[9] = d2;
		evo_methods[9] = d2_evo;
		card_ids[10] = e2;
		evo_methods[10] = e2_evo;
		card_ids[11] = f2;
		evo_methods[11] = f2_evo;
		card_ids[12] = a3;
		evo_methods[12] = a3_evo;
		card_ids[13] = b3;
		evo_methods[13] = b3_evo;
		card_ids[14] = c3;
		evo_methods[14] = c3_evo;
		card_ids[15] = d3;
		evo_methods[15] = d3_evo;
		card_ids[16] = e3;
		evo_methods[16] = e3_evo;
		card_ids[17] = f3;
		evo_methods[17] = f3_evo;
		createCards();
	}
	
	public boolean alive()
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && cards.get(i).alive())
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean rangeInFormation(char a)
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && cards.get(i).range == a)
				return true;
		}
		return false;
	}

	public boolean classInFormation(int a)
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && cards.get(i).races[a])
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean lightClassInFormation(int a)
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && cards.get(i).races[a] && cards.get(i).side == 'L')
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean classesInFormation(int a, int b)
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && cards.get(i).races[a] && cards.get(i).races[b])
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean sideInFormation(char a)
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && cards.get(i).side == a)
			{
				return true;
			}
		}
		return false;
	}

	public void rebuild()
	{
		for(int i = 0; i < cards.size(); i++)
		{	
			if(cards.get(i) != null)
			{
				cards.get(i).dmg_received = 0;
				cards.get(i).hits_received = 0;
				cards.get(i).max_hp -= cards.get(i).prep_hp * skill_multiplier;
				cards.get(i).hp = cards.get(i).max_hp;
				cards.get(i).acc = cards.get(i).baseAcc;
				cards.get(i).eva = cards.get(i).baseEva;
				cards.get(i).atk = cards.get(i).baseAtk;
				cards.get(i).def = cards.get(i).baseDef;
				cards.get(i).prep_atk = 0;
				cards.get(i).prep_def = 0;
				cards.get(i).prep_acc = 0;
				cards.get(i).prep_eva = 0;
				cards.get(i).prep_hp = 0;
				cards.get(i).numberOfTurns = 0;
				cards.get(i).strangle_damage = 50;
				cards.get(i).strangle_eva = 0;
				cards.get(i).skill_multiplier = 1.0;
				cards.get(i).stunned = false;
				cards.get(i).revived = false;
				cards.get(i).die();
			}
		}
		leader_boost_multiplier = 0.0;
		force_boost_multiplier = 0.0;
		skill_multiplier = 1.0;
		jabba = jabba_backup;
		summoned = 0;
		skills.clear();
		medSkills.clear();
		if(!bountyHunters_backup.isEmpty())
		{
			bountyHunters.clear();
			bountyHunters.addAll(bountyHunters_backup);
			Collections.shuffle(bountyHunters);
		}
		if(!undercover_backup.isEmpty())
		{
			undercover.clear();
			undercover.addAll(undercover_backup);
		}
	}

	public ArrayList<card> getPrepSkills()
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && cards.get(i).skillID != 0 && cards.get(i).skill_type == 0 && cards.get(i).skill_priority == 1)
			{
				skills.add(cards.get(i));
			}
		}
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && cards.get(i).skillID != 0 && cards.get(i).skill_type == 0 && cards.get(i).skill_priority == 2)
			{
				medSkills.add(cards.get(i));
			}
		}
		Collections.shuffle(skills);
		Collections.sort(skills, new Comparator<card>()
			{
				public int compare(card card1, card card2)
				{
						if(card1.skill_level > card2.skill_level)
							return -1;
						else
							return 1;
				}
			});
		Collections.shuffle(medSkills);
		Collections.sort(medSkills, new Comparator<card>()
				{
					public int compare(card card1, card card2)
					{
							if(card1.skill_level > card2.skill_level)
								return -1;
							else
								return 1;
					}
				});
		skills.addAll(0, medSkills);
		return skills;
	}
	
	private void createCards()
	{
		for(int i = 0; i < card_ids.length; i++)
		{
			try
			{
				con = DriverManager.getConnection("jdbc:mysql://localhost/cardinfo", "root", "");
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM cardinfo WHERE card_id = " + card_ids[i]);
				String pattern = "Unknown";
				char range = ' ', side = ' ';
				int delay, attackCount, skill_level = 0, effect = 0;
				
				while(rs.next())
				{
					int[] stats = computeStats(evo_methods[i], rs.getInt("lvup_attack"), rs.getInt("lvup_defence"), rs.getInt("accuracy"), rs.getInt("avoid"));
					if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 0)
					{
						if(rs.getInt("is_stun") == 1)
							pattern = "Stun";
						else if(rs.getInt("is_repairer") == 1)
							pattern = "Repair";
						else if(rs.getInt("is_healer") == 1)
							pattern = "Heal";
						else
							pattern = "1-on-1";
					}
					else if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 3)
						pattern = "Semi-Circle";
					else if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 4)
						pattern = "Rocket Launcher";
					else if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 6)
						pattern = "Sniper";
					else if(rs.getInt("attack_area") == 2 && rs.getInt("attack_area_type") == 1)
						pattern = "Sweep";
					else if(rs.getInt("attack_area") == 2 && rs.getInt("attack_area_type") == 2)
						pattern = "Pierce";
					else if(rs.getInt("attack_area") == 2 && rs.getInt("attack_area_type") == 7)
						pattern = "Superlaser";
					
					if(rs.getString("card_range").equals("Short"))
						range = 'S';
					else if(rs.getString("card_range").equals("Medium"))
						range = 'M';
					else if(rs.getString("card_range").equals("Long"))
						range = 'L';
					
					if(rs.getInt("attack_time") == 0)
						delay = 1;
					else
						delay = rs.getInt("attack_time");
					
					if(rs.getInt("per_num") == 0)
						attackCount = 1;
					else
						attackCount = rs.getInt("per_num");
					
					if(rs.getInt("card_attribute") == 1)
						side = 'L';
					else if(rs.getInt("card_attribute") == 2)
						side = 'D';
					else
						side = 'N';
						
					if(stats[6] == 40)
					{
						skill_level = rs.getInt("max_level");
						effect = rs.getInt("lvup_effect");
					}
					else if(stats[6] == 50)
					{
						skill_level = rs.getInt("max_level_2");
						effect = rs.getInt("lvup_effect_2");
					}
					
					cards.set(i, (new card(card_ids[i], rs.getString("card_name"), stats[5], stats[1], stats[2], stats[3], stats[4], stats[0], attackCount, range, pattern, delay, 
							rs.getInt("race"), rs.getInt("skill_id"), rs.getString("skill_name"), skill_level, effect, rs.getInt("type"), rs.getInt("priority"), side, rs.getInt("rarity")+1, rs.getInt("weapon_type"), 
							rs.getInt("lvup_prob"), this)));
					//if(do_info)
						System.out.println(rs.getString("card_name") + " created with " + stats[1] + " ATK, " + stats[2] + " DEF, " + stats[3] + " ACC, " + stats[4] + " EVA and " + stats[5] + " HP<br>\r");
					if(card_ids[i] == 1016420550)//Jabba CL
					{	
						if(jabba == 0)
						{
							create_bountyHunters(stats[0]);
						}
						jabba++;
						jabba_backup++;
					}
				}
			}
			catch(SQLException e)
			{
				System.out.println("Database error: " + e);
			}
		}
		System.out.println("<br>\r");
	}

	private void create_bountyHunters(int evo_level)
	{
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/cardinfo", "root", "");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM `cardinfo` WHERE `race` % 512 > 256 and `rarity` = 4");
			String pattern = "Unknown";
			char range = ' ', side = ' ';
			int delay, attackCount, skill_level = 0, effect = 0;
			int[] stats = new int[6];
			
			while(rs.next())
			{
				switch(evo_level)
				{
					case 0: stats = computeStats(0, rs.getInt("lvup_attack"), rs.getInt("lvup_defence"), rs.getInt("accuracy"), rs.getInt("avoid"));
							break;
					case 1: stats = computeStats(1, rs.getInt("lvup_attack"), rs.getInt("lvup_defence"), rs.getInt("accuracy"), rs.getInt("avoid"));
							break;
					case 2: stats = computeStats(3, rs.getInt("lvup_attack"), rs.getInt("lvup_defence"), rs.getInt("accuracy"), rs.getInt("avoid"));
							break;
					case 3: stats = computeStats(8, rs.getInt("lvup_attack"), rs.getInt("lvup_defence"), rs.getInt("accuracy"), rs.getInt("avoid"));
							break;
					case 4: stats = computeStats(10, rs.getInt("lvup_attack"), rs.getInt("lvup_defence"), rs.getInt("accuracy"), rs.getInt("avoid"));
							break;
					default: info += "Proc % up level inserted incorrect";
				}
				if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 0)
				{
					if(rs.getInt("is_stun") == 1)
						pattern = "Stun";
					else if(rs.getInt("is_repairer") == 1)
						pattern = "Repair";
					else if(rs.getInt("is_healer") == 1)
						pattern = "Heal";
					else
						pattern = "1-on-1";
				}
				else if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 3)
					pattern = "Semi-Circle";
				else if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 4)
					pattern = "Rocket Launcher";
				else if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 6)
					pattern = "Sniper";
				else if(rs.getInt("attack_area") == 2 && rs.getInt("attack_area_type") == 1)
					pattern = "Sweep";
				else if(rs.getInt("attack_area") == 2 && rs.getInt("attack_area_type") == 2)
					pattern = "Pierce";
				else if(rs.getInt("attack_area") == 2 && rs.getInt("attack_area_type") == 7)
					pattern = "Superlaser";
				
				if(rs.getString("card_range").equals("Short"))
					range = 'S';
				else if(rs.getString("card_range").equals("Medium"))
					range = 'M';
				else if(rs.getString("card_range").equals("Long"))
					range = 'L';
				
				if(rs.getInt("attack_time") == 0)
					delay = 1;
				else
					delay = rs.getInt("attack_time");
				
				if(rs.getInt("per_num") == 0)
					attackCount = 1;
				else
					attackCount = rs.getInt("per_num");
				
				if(rs.getInt("card_attribute") == 1)
					side = 'L';
				else if(rs.getInt("card_attribute") == 2)
					side = 'D';
				else
					side = 'N';
					
				if(stats[6] == 40)
				{
					skill_level = rs.getInt("max_level");
					effect = rs.getInt("lvup_effect");
				}
				else if(stats[6] == 50)
				{
					skill_level = rs.getInt("max_level_2");
					effect = rs.getInt("lvup_effect_2");
				}
				
				bountyHunters.add(new card(rs.getInt("card_id"), rs.getString("card_name"), stats[5], stats[1], stats[2], stats[3], stats[4], stats[0], attackCount, range, pattern, delay, rs.getInt("race"), rs.getInt("skill_id"), rs.getString("skill_name"), skill_level, effect, rs.getInt("type"), rs.getInt("priority"), side, rs.getInt("rarity")+1, rs.getInt("weapon_type"), rs.getInt("lvup_prob"), this));
			}
			bountyHunters_backup.addAll(bountyHunters);
		}
		catch(SQLException e)
		{
			System.out.println("Database error: " + e);
		}
		Collections.shuffle(bountyHunters);
	}
	
	public void setLeader(int a)
	{
		if(a >= 0 && cards.get(a) != null)
		{
			cards.get(a).leader = true;
			leader = cards.get(a);
			leader_slot = a;
			if(do_info)
				info += cards.get(a).name + " chosen as leader card<br>\r";
		}
		else
		{
			if(do_info)
				info += "No card at slot " + a + ". Simulation started without leader.<br>\r";
		}
	}

	public void activateLeaderBoost()
	{
		if(leader_slot < 6)//Front row
			leader_boost = 0.06;
		else if(leader_slot < 12)//Mid row
			leader_boost = 0.04;
		else//Back row
			leader_boost = 0.02;
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null)
			{
				int atk_boost = 0;
				int def_boost = 0;
				atk_boost += cards.get(i).baseAtk * leader_boost;
				def_boost += cards.get(i).baseDef * leader_boost;
				cards.get(i).atk += atk_boost;
				cards.get(i).def += def_boost;
				if(do_info)
					info += cards.get(i).name + "'s ATK and DEF increased bv " + atk_boost + " / " + def_boost + " (Morale Boost)<br>\r";
			}
		}
	}
	
	public void removeLeaderBoost()
	{
		if(do_info)
			info += "Leader card died, remaining cards losing morale boost:<br>\r";
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null)
			{
				int atk_decrease = 0;
				int def_decrease = 0;
				atk_decrease += cards.get(i).baseAtk * leader_boost;
				def_decrease += cards.get(i).baseDef * leader_boost;
				cards.get(i).atk -= atk_decrease;
				cards.get(i).def -= def_decrease;
				if(do_info)
					info += cards.get(i).name + "'s ATK and DEF decreased bv " + atk_decrease + " / " + def_decrease + " (Morale Boost)<br>\r";
			}
		}
	}
	
	public void activateForceBoost(char a)
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && cards.get(i).side == a)
			{
				int atk_boost = 0;
				int def_boost = 0;
				atk_boost += cards.get(i).baseAtk * 0.03;
				def_boost += cards.get(i).baseDef * 0.03;
				cards.get(i).atk += atk_boost;
				cards.get(i).def += def_boost;
				if(do_info)
					info += cards.get(i).name + "'s ATK and DEF increased bv " + atk_boost + " / " + def_boost + " (Force Boost)<br>\r";
			}
		}
	}
	
	public void activatePrepSkills(formation opponent)
	{
		int count = 0;
		int skill_id = 0;
		int[] activatedSkills = new int[3];
		ArrayList<card> skillOrder = getPrepSkills();
		for(int i = 0; i < skillOrder.size(); i++)
		{
			if(count < 3 && skillOrder.get(i).skillID != activatedSkills[0] && skillOrder.get(i).skillID != activatedSkills[1])
			{
				skill_id = skill.activatePrepSkill(skillOrder.get(i).skillID, skillOrder.get(i).proc_rate, this, opponent, skillOrder.get(i).skill_effect);
				if(skill_id != 0)
				{
					activatedSkills[count] = skill_id;
					if(do_info)
						info += skillOrder.get(i).name + "'s skill \"" + skillOrder.get(i).skill_name + "\" (SK" + skillOrder.get(i).skill_level + ") activated<br>\r";
					count++;
				}
			}
		}
	}
	
	public void applyPrepSkills()
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && !cards.get(i).nullified)
			{
				if(cards.get(i).prep_atk != 0)
				{
					int atk_increase = 0;
					atk_increase += cards.get(i).prep_atk * skill_multiplier;
					cards.get(i).atk += atk_increase;
					if(do_info)
						info += cards.get(i).name + "'s ATK increased/decreased by " + atk_increase + " (from ATK Up/Down)<br>\r";
				}
				if(cards.get(i).prep_def != 0)
				{
					int def_increase = 0;
					def_increase += cards.get(i).prep_def * skill_multiplier;
					cards.get(i).def += def_increase;
					if(do_info)
						info += cards.get(i).name + "'s DEF increased/decreased by " + def_increase + " (from DEF Up/Down)<br>\r";
				}
				if(cards.get(i).prep_acc != 0)
				{
					int acc_increase = 0;
					acc_increase += cards.get(i).prep_acc * skill_multiplier;
					cards.get(i).acc += acc_increase;
					if(do_info)
						info += cards.get(i).name + "'s ACC increased/decreased by " + acc_increase + " (from ACC Up/Down)<br>\r";
				}
				if(cards.get(i).prep_eva != 0)
				{
					int eva_increase = 0;
					eva_increase += cards.get(i).prep_eva * skill_multiplier;
					cards.get(i).eva += eva_increase;
					if(do_info)
						info += cards.get(i).name + "'s EVA increased/decreased by " + eva_increase + " (from EVA Up/Down)<br>\r";
				}
				if(leader_boost_multiplier != 0.0)
				{
					int atk_increase = 0;
					int def_increase = 0;
					atk_increase += cards.get(i).baseAtk * leader_boost * leader_boost_multiplier * skill_multiplier;
					def_increase += cards.get(i).baseDef * leader_boost * leader_boost_multiplier * skill_multiplier;
					cards.get(i).atk += atk_increase;
					cards.get(i).def += def_increase;
					if(do_info)
					{
						info += cards.get(i).name + "'s ATK increased by " + atk_increase + " (from Morale Boost Up)<br>\r";
						info += cards.get(i).name + "'s DEF increased by " + def_increase + " (from Morale Boost Up)<br>\r";
					}
				}
				if(force_boost_multiplier != 0.0)
				{
					int atk_increase = 0;
					int def_increase = 0;
					atk_increase += cards.get(i).baseAtk * 0.03 * force_boost_multiplier * skill_multiplier;
					def_increase += cards.get(i).baseDef * 0.03 * force_boost_multiplier * skill_multiplier;
					cards.get(i).atk += atk_increase;
					cards.get(i).def += def_increase;
					if(do_info)
					{
						info += cards.get(i).name + "'s ATK increased by " + atk_increase + " (from Force Boost Up)<br>\r";
						info += cards.get(i).name + "'s DEF increased by " + def_increase + " (from Force Boost Up)<br>\r";
					}
				}
				if(cards.get(i).prep_hp != 0)
				{
					int hp_increase = 0;
					hp_increase += cards.get(i).prep_hp * skill_multiplier;
					cards.get(i).max_hp += hp_increase;
					if(do_info)
						info += cards.get(i).name + "'s HP increased/decreased by " + hp_increase + " (from Pain For Power)<br>\r";
				}
				cards.get(i).hp = cards.get(i).max_hp;
				cards.get(i).skill_multiplier = skill_multiplier;
			}
		}
	}

	public card[] activateSelfSkills(card[][] battlefield, formation enemyFormation)
	{
		card[] decoys = new card[18];
		int count = 0;
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && cards.get(i).alive() && cards.get(i).skillID == 45002)//ToW & Lumi first
			{
				cards.get(i).self_skill_activated = skill.activateSelfSkill(cards.get(i), cards, battlefield, this, enemyFormation);
			}
		}
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null && cards.get(i).alive() && cards.get(i).skill_type > 0 && cards.get(i).skillID != 45002)
			{
				cards.get(i).self_skill_activated = skill.activateSelfSkill(cards.get(i), cards, battlefield, this, enemyFormation);
				if((cards.get(i).skillID == 32201 || cards.get(i).skillID == 36701) && cards.get(i).self_skill_activated)
				{
					decoys[count] = cards.get(i);
					count++;
				}
			}
		}
		return decoys;
	}
	
	public void deleteRoundBoosts()
	{
		for(int i = 0; i < cards.size(); i++)
		{
			if(cards.get(i) != null)
			{
				cards.get(i).atk -= cards.get(i).roundAtkBoost;
				cards.get(i).def -= cards.get(i).roundDefBoost;
				cards.get(i).acc -= cards.get(i).roundAccBoost;
				cards.get(i).eva -= cards.get(i).roundEvaBoost;
				cards.get(i).attackCount -= cards.get(i).roundFreqBoost;
				cards.get(i).roundAtkBoost = 0;
				cards.get(i).roundDefBoost = 0;
				cards.get(i).roundAccBoost = 0;
				cards.get(i).roundEvaBoost = 0;
				cards.get(i).roundFreqBoost = 0;
				cards.get(i).range = cards.get(i).real_range;
				cards.get(i).combat_multiplier = 1.0;
				cards.get(i).concentrated_fire = -1;
				cards.get(i).champion = false;
				cards.get(i).merciless = false;
				cards.get(i).friendly_fire = 0;
				cards.get(i).appliedCombatSkills.clear();
				cards.get(i).self_skill_activated = false;
			}
		}
	}
	
	public void setSupport(int ambush, boolean call_ls, int hp_up, boolean lure_ds, boolean nullification, int proc_up, int proximity, boolean anti_lightsaber, int undercover_1, int evo_1, int undercover_2, int evo_2, int undercover_3, int evo_3)
	{
		if(ambush > 0)
		{
			start_row_change += ambush;
			if(do_info)
				info += "Ambush (Level " + ambush + ") activated. Formations now start " + start_row_change + " rows closer<br>\r";
		}
		if(call_ls)
		{
			if(do_info)
				info += "Call to the Light Side activated:<br>\r";
			for(int i = 0; i < cards.size(); i++)
			{
				if(cards.get(i) != null && cards.get(i).side == 'N')
				{
					cards.get(i).side = 'L';
					if(do_info)
						info += "Changed " + cards.get(i).name + "'s force affinity from Neutral to Light<br>\r";
				}
			}
			if(do_info && !info.endsWith("from Neutral to Light<br>\r"))
				info += "No card changed it's force affinity!<br>\r";
		}
		if(hp_up > 0)
		{
			int hp_increase = 50 * hp_up;
			for(int i = 0; i < cards.size(); i++)
			{
				if(cards.get(i) != null)
				{
					cards.get(i).max_hp += hp_increase;
					cards.get(i).hp = cards.get(i).max_hp;
				}
			}
			if(do_info)
				info += "Character Card HP Up (Level " + hp_up + ") activated. All character card's HP increased by " + hp_increase + "<br>\r";
		}
		if(lure_ds)
		{
			if(do_info)
				info += "Lure of the Dark Side activated:<br>\r";
			for(int i = 0; i < cards.size(); i++)
			{
				if(cards.get(i) != null && cards.get(i).side == 'N')
				{
					cards.get(i).side = 'D';
					if(do_info)
						info += "Changed " + cards.get(i).name + "'s force affinity from Neutral to Dark<br>\r";
				}
			}
			if(do_info && !info.endsWith("from Neutral to Dark<br>\r"))
				info += "No card changed it's force affinity!<br>\r";
		}
		if(nullification && leader != null)
		{
			if(do_info)
				info += "Prep Skill Nullification activated:<br>\r";
			int a, b;
			if(leader_slot < 6)//Front
			{
				a = 0;
				b = 6;
			}
			else if(leader_slot < 12)//Mid
			{
				a = 6;
				b = 12;
			}
			else//Back
			{
				a = 12;
				b = 18;
			}
			for(int i = a; i < b; i++)
			{
				if(cards.get(i) != null)
				{
					cards.get(i).nullified = true;
					if(do_info)
						info += cards.get(i).name + " nullified<br>\r";
				}
			}
		}
		if(proc_up > 0)
		{
			double effect = 0;
			switch(proc_up)
			{
				case 1: effect = 0.1;
						break;
				case 2: effect = 0.2;
						break;
				case 3: effect = 0.3;
						break;
				case 4: effect = 0.45;
						break;
				case 5: effect = 0.6;
						break;
				default: info += "Proc % up level inserted incorrect";
			}
			if(do_info)
				info += "Prep Skill Trigger Up (Level " + proc_up + ") activated:<br>\r";
			for(int i = 0; i < cards.size(); i++)
			{
				if(cards.get(i) != null && cards.get(i).skill_type == 0 && cards.get(i).proc_rate > 0.0)
				{
					cards.get(i).proc_rate += effect;
					if(do_info)
						info += cards.get(i).name + "'s proc rate increased by " + effect*100 + "% (" + cards.get(i).skill_name + ")<br>\r";
				}
			}
			if(do_info && !info.endsWith(")<br>\r"))
				info += "No card changed it's force affinity!<br>\r";
		}
		if(proximity > 0)
		{
			start_row_change -= proximity;
			if(do_info)
				info += "Proximity Alarm (Level " + proximity + ") activated. Formations now start " + Math.abs(start_row_change) + " rows more distanted<br>\r";
		}
		if(anti_lightsaber)
		{
			for(int i = 0; i < cards.size(); i++)
			{
				if(cards.get(i) != null)
					cards.get(i).anti_lightsaber = true;
			}
			if(do_info)
				info += "Anti Lightsaber tactics activated. Cards are now able to evade reflected blaster shots.<br>\r";
		}	
		if(undercover_1 > 0)
		{
			createUndercover(undercover_1, evo_1);
			String info_undercover = undercover.get(0).name;
			if(undercover_2 > 0)
			{
				createUndercover(undercover_2, evo_2);
				info_undercover +=  ", " + undercover.get(1).name;
				if(undercover_3 > 0)
				{
					createUndercover(undercover_3, evo_3);
					info_undercover +=  " and " + undercover.get(2).name;
				}
			}
			undercover_backup.addAll(undercover);
			if(do_info)
				info += "Undercover activated. " + info_undercover + " selected as undercover card(s).<br>\r";
		}	
	}
	
	public String info()
	{
		String a = info;
		info = "";
		return a;
	}
	
	public void createUndercover(int card_id, int evo_method)
	{
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/cardinfo", "root", "");
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM `cardinfo` WHERE `card_id` = " + card_id);
			String pattern = "Unknown";
			char range = ' ', side = ' ';
			int delay, attackCount, skill_level = 0, effect = 0;
			
			while(rs.next())
			{
				int[] stats = computeStats(evo_method, rs.getInt("lvup_attack"), rs.getInt("lvup_defence"), rs.getInt("accuracy"), rs.getInt("avoid"));
				if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 0)
				{
					if(rs.getInt("is_stun") == 1)
						pattern = "Stun";
					else if(rs.getInt("is_repairer") == 1)
						pattern = "Repair";
					else if(rs.getInt("is_healer") == 1)
						pattern = "Heal";
					else
						pattern = "1-on-1";
				}
				else if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 3)
					pattern = "Semi-Circle";
				else if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 4)
					pattern = "Rocket Launcher";
				else if(rs.getInt("attack_area") == 1 && rs.getInt("attack_area_type") == 6)
					pattern = "Sniper";
				else if(rs.getInt("attack_area") == 2 && rs.getInt("attack_area_type") == 1)
					pattern = "Sweep";
				else if(rs.getInt("attack_area") == 2 && rs.getInt("attack_area_type") == 2)
					pattern = "Pierce";
				else if(rs.getInt("attack_area") == 2 && rs.getInt("attack_area_type") == 7)
					pattern = "Superlaser";
				
				if(rs.getString("card_range").equals("Short"))
					range = 'S';
				else if(rs.getString("card_range").equals("Medium"))
					range = 'M';
				else if(rs.getString("card_range").equals("Long"))
					range = 'L';
				
				if(rs.getInt("attack_time") == 0)
					delay = 1;
				else
					delay = rs.getInt("attack_time");
				
				if(rs.getInt("per_num") == 0)
					attackCount = 1;
				else
					attackCount = rs.getInt("per_num");
				
				if(rs.getInt("card_attribute") == 1)
					side = 'L';
				else if(rs.getInt("card_attribute") == 2)
					side = 'D';
				else
					side = 'N';
					
				if(stats[6] == 40)
				{
					skill_level = rs.getInt("max_level");
					effect = rs.getInt("lvup_effect");
				}
				else if(stats[6] == 50)
				{
					skill_level = rs.getInt("max_level_2");
					effect = rs.getInt("lvup_effect_2");
				}
				
				undercover.add(new card(card_id, rs.getString("card_name"), stats[5], stats[1], stats[2], stats[3], stats[4], stats[0], attackCount, range, pattern, delay, 
						rs.getInt("race"), rs.getInt("skill_id"), rs.getString("skill_name"), skill_level, effect, rs.getInt("type"), rs.getInt("priority"), side, rs.getInt("rarity")+1, rs.getInt("weapon_type"), 
						rs.getInt("lvup_prob"), this));
			}
		}
		catch(SQLException e)
		{
			System.out.println("Database error: " + e);
		}
	}

	public int[] computeStats(int evo_method, int atk, int def, int acc, int eva)
	{
		int[] stats = {0, atk, def, acc, eva, 1000, 40};
		if(evo_method > 0)
		{
			int halfatk = (int) Math.floor(atk * 0.07);
			int evo1atk = (int) (atk + (Math.floor((atk * 0.07)*2)));
			int evo23cardatk = (int) Math.floor((evo1atk * 1.07) + halfatk);
			int evo24cardatk = (int) (evo1atk + (Math.floor((evo1atk * 0.07)*2)));
			int evomax47atk = (int) Math.floor((evo23cardatk * 1.07) + halfatk);
			int evomax815atk = (int) (evo24cardatk + (Math.floor((evo24cardatk * 0.07)*2)));
			int awakened_atk = (int) (evomax47atk + (Math.floor((evomax47atk * 0.1)*2)));
			int awakened_plus_atk = (int) (evomax815atk + (Math.floor((evomax815atk * 0.1)*2)));
	
			int halfdef = (int) Math.floor(def * 0.07);
			int evo1def = (int) (def + (Math.floor((def * 0.07)*2)));
			int evo23carddef = (int) Math.floor((evo1def * 1.07) + halfdef);
			int evo24carddef = (int) (evo1def + (Math.floor((evo1def * 0.07)*2)));
			int evomax47def = (int) Math.floor((evo23carddef * 1.07) + halfdef);
			int evomax815def = (int) (evo24carddef + (Math.floor((evo24carddef * 0.07)*2)));
			int awakened_def = (int) (evomax47def + (Math.floor((evomax47def * 0.1)*2)));
			int awakened_plus_def = (int) (evomax815def + (Math.floor((evomax815def * 0.1)*2)));
			
			int awakened_acc = (int) Math.floor(acc + acc * 0.1);
			int awakened_eva = (int) Math.floor(eva + eva * 0.1);
			
			switch(evo_method)
			{
				case 1: stats[0] = 1;
						stats[1] = evo1atk;
						stats[2] = evo1def;
						stats[5] = 1250;
						break;
				case 2: stats[0] = 2;
						stats[1] = evo23cardatk;
						stats[2] = evo23carddef;
						stats[5] = 1500;
						break;
				case 3: stats[0] = 2;
						stats[1] = evo24cardatk;
						stats[2] = evo24carddef;
						stats[5] = 1500;
						break;
				case 4: stats[0] = 3;
						stats[1] = evomax47atk;
						stats[2] = evomax47def;
						stats[5] = 1750;
						break;
				case 5: stats[0] = 3;
						stats[1] = (int) Math.floor((evo23cardatk * 1.07) + (evo1atk * 0.07));
						stats[2] = (int) Math.floor((evo23carddef * 1.07) + (evo1def * 0.07));
						stats[5] = 1750;
						break;
				case 6: stats[0] = 3;
						stats[1] = (int) Math.floor(evo23cardatk * 1.14);
						stats[2] = (int) Math.floor(evo23carddef * 1.14);
						stats[5] = 1750;
						break;
				case 7: stats[0] = 3;
						stats[1] = (int) Math.floor((evo24cardatk * 1.07) + (evo23cardatk * 0.07));
						stats[2] = (int) Math.floor((evo24carddef * 1.07) + (evo23carddef * 0.07));
						stats[5] = 1750;
						break;
				case 8: stats[0] = 3;
						stats[1] = evomax815atk;
						stats[2] = evomax815def;
						stats[5] = 1750;
						break;
				case 9: stats[0] = 4;
						stats[1] = awakened_atk;
						stats[2] = awakened_def;
						stats[3] = awakened_acc;
						stats[4] = awakened_eva;
						stats[5] = 2000;
						stats[6] = 50;
						break;
				case 10: stats[0] = 4;
						stats[1] = awakened_plus_atk;
						stats[2] = awakened_plus_def;
						stats[3] = awakened_acc;
						stats[4] = awakened_eva;
						stats[5] = 2000;
						stats[6] = 50;
						break;
				default: info += "Wrong evo level";
			}
		}
		
		return stats;

	}
}