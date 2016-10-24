public class battle
{
	skill skill = new skill();
	String info = "";
	boolean do_info = false;
	public boolean hits(int acc, int eva)
	{
		int hitChance = 0;
		if(acc-eva < 5)
			hitChance = 5;
		else if(acc-eva > 100)//Maybe caps at 95
			hitChance = 100;
		else
			hitChance = acc-eva;
		
		if(Math.random() * 100 <= hitChance)
			return true;
		else
			return false;
	}
	
	public void attack(card attacker, card defender, double multiplier, double turn, boolean counter_attack)//Multiple attacks use base or combat atk/acc?
	{		
		int damage = 0;
		int halfDef = defender.baseDef/2;
		int normalAcc = attacker.acc;
		int normalAtk = attacker.atk;
		int normalDef = attacker.def;
		int normalEva = attacker.eva;
		int attackCount = 1;
		double[] battle_boosts = new double[2];
		if(!attacker.champion && attacker.friendly_fire > 0)
		{
			double acc_decrease = attacker.acc * attacker.friendly_fire;
			attacker.acc -= acc_decrease;
			info += attacker.name + "'s (" + attacker.x_coordinate + "|" + attacker.y_coordinate + ") ACC decreased by " + (int) acc_decrease + " due to the Friendly Fire skill<br>\r";
		}
		if(attacker.pattern == "Pierce")
		{
			int row = 0;
			if(defender.front != null)
			{
				row++;
				if(defender.front.front != null)
					row++;
			}
			int acc_decrease = 16 * row;
			attacker.acc -= acc_decrease;
			if(acc_decrease != 0 && do_info)
				info += attacker.name + "'s (" + attacker.x_coordinate + "|" + attacker.y_coordinate + ") ACC decreased by " + acc_decrease + " due to attacking a back row:<br>\r";
		}
		if(defender.skillID == 33301)//Dooku EoR
		{
			battle_boosts = skill.id_33301(attacker, defender);
			if((battle_boosts[0] != 0 || battle_boosts[1] != 0) && do_info)
				info += defender.name + "'s (" + defender.x_coordinate + "|" + defender.y_coordinate + ") DEF and EVA increased by " + (int) battle_boosts[0] + " / " + (int) battle_boosts[1] + " due to getting attacked by the lightsaber wielding unit " + attacker.name + " (" + attacker.x_coordinate + "|" + attacker.y_coordinate + ")<br>\r";
		}
		if(defender.skillID == 35401)//Luke JK
		{
			battle_boosts = skill.id_35401(attacker, defender);
			if((battle_boosts[0] != 0 || battle_boosts[1] != 0) && do_info)
				info += defender.name + "'s (" + defender.x_coordinate + "|" + defender.y_coordinate + ") DEF and EVA increased by " + (int) battle_boosts[0] + " / " + (int) battle_boosts[1] + " due to getting attacked by the blaster shooting unit " + attacker.name + " (" + attacker.x_coordinate + "|" + attacker.y_coordinate + ")<br>\r"; 
		}
		if(attacker.range == 'S')
			attackCount = attacker.attackCount;
		if(defender.skillID == 33501 && defender.dmg_received < defender.max_hp * defender.skill_effect && defender.x_coordinate == attacker.x_coordinate)//Droideka
		{
			defender.self_skill_activated = true;
			if(do_info)
				info += defender.name + " (" + defender.x_coordinate + "|" + defender.y_coordinate + ") is immune to the attack from " + attacker.name + " (" + attacker.x_coordinate + "|" + attacker.y_coordinate + ")" + " as it only received " + defender.dmg_received + " damage yet<br>\r";
		}
		else
		{
			for(double i = 0; i < attackCount; i++)
			{
				turn += i;
				defender.hits_received++;
				attacker.acc *= 1.0 + turn/10;
				attacker.atk *= 1.0 - turn/10;
				if(do_info)
					info += attacker.name + " (" + attacker.x_coordinate + "|" + attacker.y_coordinate + ") attacks " + defender.name + " (" + defender.x_coordinate + "|" + defender.y_coordinate + ")";
				if((defender.skillID == 40001 || defender.skillID == 40002) && defender.self_skill_activated && attacker.weapon_type > 40 && attacker.weapon_type < 47)//Blaster Reflection
				{
					String blaster_reflection = skill.id_40001(attacker, defender);
					if(do_info)
						info += blaster_reflection;
				}
				else if(((attacker.skillID == 36101 && Math.random() <= attacker.skill_effect) || (attacker.skillID == 36201 && Math.random() <= attacker.skill_effect)) && attacker.self_skill_activated)//Lando & IG-88B
				{
					if(attacker.atk > defender.def + 100)
						damage = (int) Math.floor(((attacker.atk - defender.def) * (0.95 + Math.random()/10.0)/10.0) * multiplier);
					/*if(attacker.acc <= defender.eva)
					{
						damage -= defender.eva-attacker.acc; //Wrong calculation for unclean hits
						if(do_info)
							info += " (Unclean hit)";
					}*/
					if(damage < 10)
						damage = 10;
				
					if(do_info)
						info += ", dealing " + damage + " damage";
					String def_red = defender.decreaseHp(damage);
					if(do_info)
						info += def_red;
					if(!defender.combat_unable)
						defender.combat_unable = true;
					if(do_info)
						info += ":<br>\r" + defender.name + " (" + defender.x_coordinate + "|" + defender.y_coordinate + ") rendered unable to activate its Combat Skill during the next turn<br>\r";
				}
				else if(hits(attacker.acc, defender.eva))
				{
					if(attacker.skillID == 41101 && attacker.self_skill_activated)//Rancor
					{
						defender.hp = -1;
						if(do_info)
							info += ": " + attacker.name + " devoured " + defender.name + "!<br>\r";
					}
					else
					{
						if(attacker.atk > defender.def + 100)
							damage = (int) Math.floor(((attacker.atk - defender.def) * (0.95 + Math.random()/10.0)/10.0) * multiplier);
						if(attacker.acc <= defender.eva)
						{
							damage -= defender.eva-attacker.acc; //Wrong calculation for unclean hits
							if(do_info)
								info += " (Unclean hit)";
						}
						if(damage < 10)
							damage = 10;
						
						if(defender.skillID == 32401 && defender.self_skill_activated && !attacker.pattern.equals("Pierce") && ((defender.left != null && defender.left.races[21]) || (defender.right != null && defender.right.races[21]) || (defender.front != null && defender.front.races[21]) || (defender.behind != null && defender.behind.races[21])))//GGEC
						{
							String ggec_info = skill.id_32401(defender, damage, halfDef);
							if(do_info)
								info += ggec_info;
						}
						else
						{
							if(do_info)
								info += ", dealing " + damage + " damage";
							String def_red = defender.decreaseHp(damage);
							if(do_info)
								info += def_red;
						}
					}
				}
				
				else if((defender.skillID == 32701 || defender.skillID == 32702) && defender.self_skill_activated && !counter_attack)
				{
					if(do_info)
						info += " - the attack was dodged!";
					if(defender.range != 'S' || Math.abs(defender.y_coordinate - attacker.y_coordinate) == 1)
					{
						if(do_info)
							info += " " + defender.name + " performs a counter attack onto " + attacker.name + ":<br>\r";
						attack(defender, attacker, 0.0, 1.0, true);
					}
				}
				else
				{
					if(do_info)
						info += " - the attack was dodged!";
				}
				if(defender.skillID == 41001 && !defender.alive())//Dwarf Spider Droid
				{
					String dwarf = skill.id_41001(attacker, defender);
					if(do_info)
						info += dwarf;
				}
				if(battle_boosts[0] != 0 || battle_boosts[1] != 0)
				{
					defender.def -= battle_boosts[0];
					defender.eva -= battle_boosts[1];
				}
				attacker.acc = normalAcc;
				attacker.atk = normalAtk;
				attacker.def = normalDef;
				attacker.eva = normalEva;
				if(info != null && !info.endsWith("<br>\r") && do_info)
					info += "<br>\r";
			}
		}
	}
	
	public String getInfo()
	{
		String a = info;
		info = "";
		return a;
	}
	
	public void addBreak()
	{
		info += "<br>\r";
	}
}