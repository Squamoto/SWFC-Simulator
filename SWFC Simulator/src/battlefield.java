public class battlefield
{
	card[][] battlefield = new card[6][19];
	card[] upperDecoys, lowerDecoys;
	battle battle = new battle();
	formation a, b;
	skill skill = new skill();
	String info = "";
	boolean do_info = false;
	
	battlefield(formation a, formation b)
	{
		this.a = a;
		this.b = b;
		battlefield[0][8+a.start_row_change+b.start_row_change] = a.cards.get(0);//Front rows
		battlefield[1][8+a.start_row_change+b.start_row_change] = a.cards.get(1);
		battlefield[2][8+a.start_row_change+b.start_row_change] = a.cards.get(2);
		battlefield[3][8+a.start_row_change+b.start_row_change] = a.cards.get(3);
		battlefield[4][8+a.start_row_change+b.start_row_change] = a.cards.get(4);
		battlefield[5][8+a.start_row_change+b.start_row_change] = a.cards.get(5);
		battlefield[0][16] = b.cards.get(0);
		battlefield[1][16] = b.cards.get(1);
		battlefield[2][16] = b.cards.get(2);
		battlefield[3][16] = b.cards.get(3);
		battlefield[4][16] = b.cards.get(4);
		battlefield[5][16] = b.cards.get(5);
		
		battlefield[0][7+a.start_row_change+b.start_row_change] = a.cards.get(6);//Mid rows
		battlefield[1][7+a.start_row_change+b.start_row_change] = a.cards.get(7);
		battlefield[2][7+a.start_row_change+b.start_row_change] = a.cards.get(8);
		battlefield[3][7+a.start_row_change+b.start_row_change] = a.cards.get(9);
		battlefield[4][7+a.start_row_change+b.start_row_change] = a.cards.get(10);
		battlefield[5][7+a.start_row_change+b.start_row_change] = a.cards.get(11);
		battlefield[0][17] = b.cards.get(6);
		battlefield[1][17] = b.cards.get(7);
		battlefield[2][17] = b.cards.get(8);
		battlefield[3][17] = b.cards.get(9);
		battlefield[4][17] = b.cards.get(10);
		battlefield[5][17] = b.cards.get(11);
		
		battlefield[0][6+a.start_row_change+b.start_row_change] = a.cards.get(12);//Back rows
		battlefield[1][6+a.start_row_change+b.start_row_change] = a.cards.get(13);
		battlefield[2][6+a.start_row_change+b.start_row_change] = a.cards.get(14);
		battlefield[3][6+a.start_row_change+b.start_row_change] = a.cards.get(15);
		battlefield[4][6+a.start_row_change+b.start_row_change] = a.cards.get(16);
		battlefield[5][6+a.start_row_change+b.start_row_change] = a.cards.get(17);
		battlefield[0][18] = b.cards.get(12);
		battlefield[1][18] = b.cards.get(13);
		battlefield[2][18] = b.cards.get(14);
		battlefield[3][18] = b.cards.get(15);
		battlefield[4][18] = b.cards.get(16);
		battlefield[5][18] = b.cards.get(17);
	}
	
	public void refresh()
	{
		deleteDeadCards();
		deleteDeadCards();
		deleteDeadCards();//Three times as one run would skip one or two cards if two or three cards die in a column in the same phase
		fillHolesFromRightSide();
		fillHolesFromLeftSide();	
		lopsideShuffle();
		moveForward();
		a.deleteRoundBoosts();
		b.deleteRoundBoosts();
		
		for(int i = 1; i < battlefield.length; i++)
		{
			for(int j = 0; j < 19; j++)
			{
				if(battlefield[i][j] != null)
				{
					battlefield[i][j].left = battlefield[i-1][j];
					battlefield[i][j].x_coordinate = i;
					battlefield[i][j].y_coordinate = j;
				}
			}
		}
		for(int i = 4; i >= 0; i--)
		{
			for(int j = 0; j < 19; j++)
			{
				if(battlefield[i][j] != null)
				{
					battlefield[i][j].right = battlefield[i+1][j];
					battlefield[i][j].x_coordinate = i;
					battlefield[i][j].y_coordinate = j;
				}
			}
		}
		for(int i = 0; i < battlefield.length; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				if(battlefield[i][j] != null)
					battlefield[i][j].front = battlefield[i][j+1];
			}
			for(int j = 1; j < 16; j++)
			{
				if(battlefield[i][j] != null)
					battlefield[i][j].behind = battlefield[i][j-1];
			}
			for(int j = 16; j < 18; j++)
			{
				if(battlefield[i][j] != null)
					battlefield[i][j].behind = battlefield[i][j+1];
			}
			for(int j = 17; j < 19; j++)
			{
				if(battlefield[i][j] != null)
					battlefield[i][j].front = battlefield[i][j-1];
			}
		}
	}

	public boolean cardAlive(int a, int b)
	{
		if(battlefield[a][b] != null && battlefield[a][b].alive())
			return true;
		else
			return false;
	}

	public void start(char n, char m)//Order of boosts?
	{
		a.activatePrepSkills(b);
		b.activatePrepSkills(a);
		a.applyPrepSkills();
		b.applyPrepSkills();
		a.activateForceBoost(n);
		b.activateForceBoost(m);
		a.activateLeaderBoost();
		b.activateLeaderBoost();
		for(int i = 1; i < battlefield.length; i++)
		{
			for(int j = 0; j < 19; j++)
			{
				if(battlefield[i][j] != null)
				{
					battlefield[i][j].left = battlefield[i-1][j];
					battlefield[i][j].x_coordinate = i;
					battlefield[i][j].y_coordinate = j;
				}
			}
		}
		for(int i = 4; i >= 0; i--)
		{
			for(int j = 0; j < 19; j++)
			{
				if(battlefield[i][j] != null)
				{
					battlefield[i][j].right = battlefield[i+1][j];
					battlefield[i][j].x_coordinate = i;
					battlefield[i][j].y_coordinate = j;
				}
			}
		}
		for(int i = 0; i < battlefield.length; i++)
		{
			for(int j = 0; j < 15; j++)
			{
				if(battlefield[i][j] != null)
					battlefield[i][j].front = battlefield[i][j+1];
			}
			for(int j = 1; j < 16; j++)
			{
				if(battlefield[i][j] != null)
					battlefield[i][j].behind = battlefield[i][j-1];
			}
			for(int j = 16; j < 18; j++)
			{
				if(battlefield[i][j] != null)
					battlefield[i][j].behind = battlefield[i][j+1];
			}
			for(int j = 17; j < 19; j++)
			{
				if(battlefield[i][j] != null)
					battlefield[i][j].front = battlefield[i][j-1];
			}
		}
		for(int i = 0; i < battlefield.length; i++)
		{
			for(int j = 8+a.start_row_change+b.start_row_change; j > 6+a.start_row_change+b.start_row_change; j--)
			{
				if(battlefield[i][j] == null && battlefield[i][j-1] != null)
				{
					battlefield[i][j] = battlefield[i][j-1];
					battlefield[i][j-1] = null;
				}
			}
			for(int j = 16; j < 18; j++)
			{
				if(battlefield[i][j] == null && battlefield[i][j+1] != null)
				{
					battlefield[i][j] = battlefield[i][j+1];
					battlefield[i][j+1] = null;
				}
			}
		}
	}
	
	public void activateSelfSkills()
	{
		upperDecoys = a.activateSelfSkills(battlefield, b);
		lowerDecoys = b.activateSelfSkills(battlefield, a);
	}
	
	public void attack()
	{
		for(int j = 0; j < 19; j++) 
		{
			for(int i = 0; i < battlefield.length; i++)
			{
				card attacker = battlefield[i][j];
				int defenderFrontRow = 16;
				int defenderMidRow = 17;
				int defenderBackRow = 18;
				if(j == 16 && i == 0 && do_info)
					battle.addBreak();
				if(j > 15)//If lower formation; just the rows when both formations are facing (for shorts)
				{
					defenderFrontRow = 15;
					defenderMidRow = 14;
					defenderBackRow = 13;
				}
				if(attacker != null && !attacker.stunned)// Only attack if card is not null ("dead" cards still attack for that turn) and not stunned
				{
					if(!attacker.champion && attacker.friendly_fire > 0 && attacker.pattern != "Pierce" && attacker.pattern != "Sweep")
					{
						card defender = null;
						if(attacker.left != null && attacker.right != null)
						{
							double random = Math.random();
							if(random < 0.5)
								defender = attacker.left;
							else
								defender = attacker.right;
						}
						else if(attacker.left != null && attacker.right == null)
							defender = attacker.left;
						else if(attacker.left == null && attacker.right != null)
							defender = attacker.right;
						else if(attacker.front != null && attacker.behind != null)
						{
							double random = Math.random();
							if(random < 0.5)
								defender = attacker.front;
							else
								defender = attacker.behind;
						}
						else if(attacker.front != null && attacker.behind == null)
							defender = attacker.front;
						else if(attacker.front == null && attacker.behind != null)
							defender = attacker.behind;
						if(defender != null)
							battle.attack(attacker, defender, 1.0, 0.0, false);
					}
					if(((attacker.numberOfTurns+1) % attacker.delay == 0 || (attacker.numberOfTurns+1) % attacker.real_delay == 0) && attacker.friendly_fire == 0)//For cards with delays like MoV
					{
						card defender = null;				
						if(attacker.range == 'S' && (j == 15 || j == 16))//Short range
						{
							if(attacker.pattern.equals("1-on-1"))
								defender = shortFindDefender(i, j, defenderFrontRow);
							else if(attacker.pattern.equals("Pierce"))//TRH
							{
								if(cardAlive(i, defenderFrontRow))//Attacks all 3 cards in his column
								{
									battle.attack(attacker, battlefield[i][defenderFrontRow], 1.0, 0.0, false);
									if(cardAlive(i, defenderMidRow))
										battle.attack(attacker, battlefield[i][defenderMidRow], 1.0, 0.0, false);
									if(cardAlive(i, defenderBackRow))
										defender = battlefield[i][defenderBackRow];
								}
							}
							else if(attacker.pattern.equals("Sweep"))//TODO Maybe
							{
								if(i == 0)//Far left side
								{
									if(cardAlive(i, defenderFrontRow))
										battle.attack(attacker, battlefield[i][defenderFrontRow], 1.0, 0.0, false);
									if(cardAlive(i+1, defenderFrontRow))
										defender = battlefield[i+1][defenderFrontRow];
								}
								else if(i == 5)//Far right side
								{
									if(cardAlive(i, defenderFrontRow))
										battle.attack(attacker, battlefield[i][defenderFrontRow], 1.0, 0.0, false);
									if(cardAlive(i-1, defenderFrontRow))
										defender = battlefield[i-1][defenderFrontRow];
								}
								else
								{
									if(cardAlive(i, defenderFrontRow))
										battle.attack(attacker, battlefield[i][defenderFrontRow], 1.0, 0.0, false);
									if(cardAlive(i-1, defenderFrontRow))
										battle.attack(attacker, battlefield[i-1][defenderFrontRow], 1.0, 0.0, false);
									if(cardAlive(i+1, defenderFrontRow))
										defender = battlefield[i+1][defenderFrontRow];
								}
							}
							else if(attacker.pattern.equals("Semi-Circle"))//TODO Maybe
							{
								if(i == 0)//Far left side
								{
									if(cardAlive(i, defenderFrontRow))
										defender = battlefield[i][defenderFrontRow];
									if(cardAlive(i, defenderMidRow))
										battle.attack(attacker, battlefield[i][defenderMidRow], 0.95, 0.0, false);
									if(cardAlive(i+1, defenderFrontRow))
										battle.attack(attacker, battlefield[i+1][defenderFrontRow], 0.95, 0.0, false);
								}
								else if(i == 5)//Far right side
								{
									if(cardAlive(i, defenderFrontRow))
										defender = battlefield[i][defenderFrontRow];
									if(cardAlive(i, defenderMidRow))
										battle.attack(attacker, battlefield[i][defenderMidRow], 0.95, 0.0, false);
									if(cardAlive(i-1, defenderFrontRow))
										battle.attack(attacker, battlefield[i-1][defenderFrontRow], 0.95, 0.0, false);
								}
								else
								{
									if(cardAlive(i, defenderFrontRow))
										defender = battlefield[i][defenderFrontRow];
									if(cardAlive(i, defenderMidRow))
										battle.attack(attacker, battlefield[i][defenderMidRow], 0.95, 0.0, false);
									if(cardAlive(i-1, defenderFrontRow))
										battle.attack(attacker, battlefield[i-1][defenderFrontRow], 0.95, 0.0, false);
									if(cardAlive(i+1, defenderFrontRow))
										battle.attack(attacker, battlefield[i+1][defenderFrontRow], 0.95, 0.0, false);
								}
							}
							
							if(defender != null)
								battle.attack(attacker, defender, 1.0, 0.0, false);
						}
						else if(attacker.pattern.equals("Repair"))
						{
							if(j+1 < 19 && cardAlive(i, j+1) && j+1 != defenderFrontRow && battlefield[i][j+1].races[21] && battlefield[i][j+1].hp < battlefield[i][j+1].max_hp)
								defender = battlefield[i][j+1];
							if(i-1 >= 0 && cardAlive(i-1, j) && battlefield[i-1][j].races[21] && battlefield[i-1][j].hp < battlefield[i-1][j].max_hp && (defender == null || battlefield[i-1][j].hp < defender.hp))
								defender = battlefield[i-1][j];
							if(i+1 < 6 && cardAlive(i+1, j) && battlefield[i+1][j].races[21] && battlefield[i+1][j].hp < battlefield[i+1][j].max_hp && (defender == null || battlefield[i+1][j].hp < defender.hp))		
								defender = battlefield[i+1][j];
							if(j-1 >= 0 && cardAlive(i, j-1) && j-1 != defenderFrontRow && battlefield[i][j-1].races[21] && battlefield[i][j-1].hp < battlefield[i][j-1].max_hp && (defender == null || battlefield[i][j-1].hp < defender.hp))
								defender = battlefield[i][j-1];
							if(defender != null)
							{
								int hp_increase = 0;
								hp_increase += attacker.atk * 0.1 * (0.95 + Math.random()/10);
								defender.hp += hp_increase;
								if(do_info)
									info += attacker.name + " (" + attacker.x_coordinate + "|" + attacker.y_coordinate + ") repairs " + defender.name + " (" + defender.x_coordinate + "|" + defender.y_coordinate + ") by " + hp_increase + "<br>\r";
								if(defender.hp > defender.max_hp)
									defender.hp = defender.max_hp;
							}
						}
						
						else if(attacker.pattern.equals("Heal"))
						{
							if(j+1 < 19 && cardAlive(i, j+1) && j+1 != defenderFrontRow && (battlefield[i][j+1].races[23] || battlefield[i][j+1].races[22] || battlefield[i][j+1].races[14]) && battlefield[i][j+1].hp < battlefield[i][j+1].max_hp)
								defender = battlefield[i][j+1];
							if(i-1 >= 0 && cardAlive(i-1, j) && (battlefield[i-1][j].races[23] || battlefield[i-1][j].races[22] || battlefield[i-1][j].races[14]) && battlefield[i-1][j].hp < battlefield[i-1][j].max_hp && (defender == null || battlefield[i-1][j].hp < defender.hp))
								defender = battlefield[i-1][j];
							if(i+1 < 6 && cardAlive(i+1, j) && (battlefield[i+1][j].races[23] || battlefield[i+1][j].races[22] || battlefield[i+1][j].races[14]) && battlefield[i+1][j].hp < battlefield[i+1][j].max_hp && (defender == null || battlefield[i+1][j].hp < defender.hp))		
								defender = battlefield[i+1][j];
							if(j-1 >= 0 && cardAlive(i, j-1) && j-1 != defenderFrontRow && (battlefield[i][j-1].races[23] || battlefield[i][j-1].races[22] || battlefield[i][j-1].races[14]) && battlefield[i][j-1].hp < battlefield[i][j-1].max_hp && (defender == null || battlefield[i][j-1].hp < defender.hp))
								defender = battlefield[i][j-1];
							if(defender != null)
							{
								int hp_increase = 0;
								hp_increase += attacker.atk * 0.1 * (0.95 + Math.random()/10);
								defender.hp += hp_increase;
								if(do_info)
									info += attacker.name + " (" + attacker.x_coordinate + "|" + attacker.y_coordinate + ") heals " + defender.name + " (" + defender.x_coordinate + "|" + defender.y_coordinate + ") by " + hp_increase + "<br>\r";
								if(defender.hp > defender.max_hp)
									defender.hp = defender.max_hp;
							}
						}
						
						else if((attacker.range == 'M' || attacker.range == 'L') && !attacker.pattern.equals("Superlaser") && !attacker.pattern.equals("Semi-Circle") && !attacker.pattern.equals("Pierce"))//L/M range
						{
							for(double turn = 0.0; turn < attacker.attackCount; turn++)//Multiple attack L/M range cards hit different targets 
							{
								defender = null;
								if(attacker.pattern.equals("Sniper"))
									defender = sniperFindDefender(i ,j, defenderMidRow, defenderFrontRow, attacker);
								if(defender == null)
									defender = mediumLongFindDefender(i, j, defenderFrontRow, attacker);
								if(defender != null)
								{
									if(attacker.pattern.equals("Stun") && battle.hits(attacker.acc, defender.eva))
										defender.stunned = true;
									else
										battle.attack(attacker, defender, 1.0, turn, false);
								}
							}
						}
						
						else if(attacker.pattern.equals("Superlaser"))
						{
							int laser_damage = 0;
							laser_damage += attacker.atk * 0.02;
							for(int k = 0; k < battlefield.length; k++)
							{
								if(cardAlive(k, defenderFrontRow))
								{
									battlefield[k][defenderFrontRow].hp -= laser_damage;
									battlefield[k][defenderFrontRow].dmg_received += laser_damage;
									if(do_info)
										info += attacker.name + " hits " + battlefield[k][defenderFrontRow].name + " with his skill " + attacker.skill_name + " for " + laser_damage + "<br>\r";
								}
								if(cardAlive(k, defenderMidRow))
								{
									battlefield[k][defenderMidRow].hp -= laser_damage;
									battlefield[k][defenderMidRow].dmg_received += laser_damage;
									if(do_info)
										info += attacker.name + " hits " + battlefield[k][defenderMidRow].name + " with his skill " + attacker.skill_name + " for " + laser_damage + "<br>\r";
								}
								if(cardAlive(k, defenderBackRow))
								{
									battlefield[k][defenderBackRow].hp -= laser_damage;
									battlefield[k][defenderBackRow].dmg_received += laser_damage;
									if(do_info)
										info += attacker.name + " hits " + battlefield[k][defenderBackRow].name + " with his skill " + attacker.skill_name + " for " + laser_damage + "<br>\r";
								}
							}
						}
						else if(attacker.range == 'M' && attacker.pattern.equals("Semi-Circle"))//TODO Maybe
						{
							for(double turn = 0.0; turn < attacker.attackCount; turn++)//Multiple attack L/M range cards hit different targets 
							{
								defender = mediumLongFindDefender(i, j, defenderFrontRow, attacker);
								if(defender != null)
								{
									if(defender.x_coordinate == 0)//Far left side
									{
										if(cardAlive(defender.x_coordinate, defenderMidRow))
											battle.attack(attacker, battlefield[defender.x_coordinate][defenderMidRow], 0.95, turn, false);
										if(cardAlive(defender.x_coordinate+1, defenderFrontRow))
											battle.attack(attacker, battlefield[defender.x_coordinate+1][defenderFrontRow], 0.95, turn, false);
									}
									else if(defender.x_coordinate == 5)//Far right side
									{
										if(cardAlive(defender.x_coordinate, defenderMidRow))
											battle.attack(attacker, battlefield[defender.x_coordinate][defenderMidRow], 0.95, turn, false);
										if(cardAlive(defender.x_coordinate-1, defenderFrontRow))
											battle.attack(attacker, battlefield[defender.x_coordinate-1][defenderFrontRow], 0.95, turn, false);
									}
									else
									{
										if(cardAlive(defender.x_coordinate, defenderMidRow))
											battle.attack(attacker, battlefield[defender.x_coordinate][defenderMidRow], 0.95, turn, false);
										if(cardAlive(defender.x_coordinate-1, defenderFrontRow))
											battle.attack(attacker, battlefield[defender.x_coordinate-1][defenderFrontRow], 0.95, turn, false);
										if(cardAlive(defender.x_coordinate+1, defenderFrontRow))
											battle.attack(attacker, battlefield[defender.x_coordinate+1][defenderFrontRow], 0.95, turn, false);
									}
								}
							}
						}
						else if(attacker.range == 'M' && attacker.pattern.equals("Pierce"))
						{
							int upperFrontRow = 0;
							if(j > 15)//Lower formation
							{
								for(int k = 15; k >= 0; k--)//Find the upper formation's front row
								{
									for(int l = 2; l <= 3; l++)
									{
										if(battlefield[l][k] != null)
										{
											upperFrontRow = k;
											break;
										}
									}
									if(upperFrontRow != 0)
										break;
								}
								defenderFrontRow = upperFrontRow;
							}
							if(cardAlive(i, defenderFrontRow) && (Math.abs(j - defenderFrontRow) < 4))//Attacks all 3 cards in his column
							{
								battle.attack(attacker, battlefield[i][defenderFrontRow], 1.0, 0.0, false);
								if(cardAlive(i, defenderMidRow))
									battle.attack(attacker, battlefield[i][defenderMidRow], 1.0, 0.0, false);
								if(cardAlive(i, defenderBackRow))
									battle.attack(attacker, battlefield[i][defenderBackRow], 1.0, 0.0, false);
							}
						}
						if((attacker.numberOfTurns+1) % attacker.delay == 0)
							attacker.delay = attacker.real_delay;
					}
					attacker.numberOfTurns++;
				}
				else if(attacker != null && attacker.stunned)
				{
					attacker.stunned = false;
					if(do_info)
						info += attacker.name + " could not attack for this turn as he was stunned.<br>\r";
				}
			}
		}	
	}

	public String info()
	{
		String battlefield_info = "";
		String battle_info = "";
		String formation_info = "";
		String skill_info = "";
	    battlefield_info += info + "<br>\r";
	    info = "";
		for(int j = 13; j < 19; j++)//Only print the important rows
		{
			for(int i = 0; i < battlefield.length; i++)
			{
				if(battlefield[i][j] != null)
					battlefield_info += battlefield[i][j].info();
				else
					battlefield_info += "<img width=\"50\" height=\"70\" src=\"/SWFC/images/cards/all/0.png\" />";
			}
			battlefield_info += "<br>\r";
		}
		battle_info = battle.getInfo();
		if(battle_info == null)
			battle_info = "";
		formation_info = a.info() + "<br>\r" + b.info();
		skill_info = a.skill.info() + "<br>\r" + b.skill.info();
		return formation_info + "<br>\r" + skill_info + "<br>\r" + battle_info + "<br>\r" + battlefield_info + "<br>\r";
	}
	
	public void activate_info()
	{
		do_info = true;
		battle.do_info = true;
		a.do_info = true;
		b.do_info = true;
		a.skill.do_info = true;
		b.skill.do_info = true;
	}

	public void deleteDeadCards()//Causes an arrayOutOfBoundsException if a row 2 or 3 card dies in the first 2 rounds (upper formation)
	{
		int upper_end = -1;
		for(int i = 0; i < battlefield.length; i++)
		{
			for(int j = 0; j < battlefield[i].length; j++)
			{
				if(j > upper_end && j < 16 && battlefield[i][j] != null && battlefield[i][j].ownFormation == a)
					upper_end = j;
				if(battlefield[i][j] != null && !battlefield[i][j].alive())//If card isn't deleted yet but <=0 HP, delete it
				{
					if(battlefield[i][j].leader)
					{
						if(j < 16)
							a.removeLeaderBoost();
						else
							b.removeLeaderBoost();
					}
					if(battlefield[i][j].skillID == 33601 && !battlefield[i][j].revived)//MagnaGuard
					{
						double revive_hp = skill.id_33601(battlefield[i][j]);
						if(do_info)
							info += battlefield[i][j].name + " (" + battlefield[i][j].x_coordinate + "|" + battlefield[i][j].y_coordinate + ") revived. The unit rejoins the battlefield with " + (int) revive_hp + " HP<br>\r"; 
					}
					else	
					{
						if(battlefield[i][j].left != null)
							battlefield[i][j].left.right = null;
						if(battlefield[i][j].right != null)
							battlefield[i][j].right.left = null;
						if(battlefield[i][j].front != null)
							battlefield[i][j].front.behind = null;
						if(battlefield[i][j].behind != null)
							battlefield[i][j].behind.front = null;
						battlefield[i][j].die();	
						if(do_info)
							info += battlefield[i][j].name + " defeated!<br>\r";
						if(battlefield[i][j].skillID == 35501)
							battlefield[i][j].ownFormation.jabba--;
						if(!battlefield[i][j].ownFormation.bountyHunters.isEmpty() && battlefield[i][j].ownFormation.summoned < battlefield[i][j].ownFormation.jabba && battlefield[i][j].ownFormation.bountyHunters.get(0).range == 'S')
						{
							card bounty = battlefield[i][j].ownFormation.bountyHunters.get(0);
							battlefield[i][j].ownFormation.bountyHunters.remove(0);
							battlefield[i][j] = bounty;
							battlefield[i][j].ownFormation.cards.add(bounty);
							battlefield[i][j].ownFormation.summoned++;
							if(do_info)
								info += bounty.name + " summoned!<br>\r";
						}
						else
						{
							battlefield[i][j] = null;
							if(j < 16 && battlefield[i][j-1] != null)//Move the two cards behind the deleted one one forward (upper deck)
							{
								battlefield[i][j] = battlefield[i][j-1];
								battlefield[i][j-1] = battlefield[i][j-2];
								if(!a.bountyHunters.isEmpty() && a.summoned < a.jabba  && a.bountyHunters.get(0).range != 'S')
								{
									card bounty = a.bountyHunters.get(0);
									a.bountyHunters.remove(0);
									battlefield[i][j-2] = bounty;
									a.cards.add(bounty);
									a.summoned++;
									if(do_info)
										info += bounty.name + " summoned!<br>\r";
								}
								else
								{
									formation enemyFormation = b;
									if(!enemyFormation.undercover.isEmpty())
									{
										card undercover = enemyFormation.undercover.get(0);
										enemyFormation.undercover.remove(0);
										battlefield[i][j-2] = undercover;
										battlefield[i][j].ownFormation.cards.add(undercover);
										if(do_info)
											info += undercover.name + " sent as undercover card!<br>\r";
									}
									else
										battlefield[i][j-2] = null;
								}
							}
							else if((j == 16 || j == 17) && battlefield[i][j+1] != null)//Move the two cards behind the deleted one one forward (lower deck)
							{
								battlefield[i][j] = battlefield[i][j+1];
								battlefield[i][j+1] = null;
								if(j == 16)
								{
									battlefield[i][j+1] = battlefield[i][j+2];
									battlefield[i][j+2] = null;
								}
							}
						}
					}
				}
			}
		}
		if(!a.bountyHunters.isEmpty() || !b.undercover.isEmpty())
		{
			for(int j = upper_end; j > upper_end-3; j--)
			{
				for(int i = 0; i < battlefield.length; i++)
				{
					if(battlefield[i][j] == null)
					{
						if(!a.bountyHunters.isEmpty() && a.summoned < a.jabba && a.bountyHunters.get(0).range != 'S')
						{
							card bounty = a.bountyHunters.get(0);
							a.bountyHunters.remove(0);
							battlefield[i][j] = bounty;
							a.cards.add(bounty);
							battlefield[i][j].ownFormation.summoned++;
							if(do_info)
								info += bounty.name + " summoned!<br>\r";
						}
						else
						{
							formation enemyFormation = b;
							if(!enemyFormation.undercover.isEmpty())
							{
								card undercover = enemyFormation.undercover.get(0);
								enemyFormation.undercover.remove(0);
								battlefield[i][j] = undercover;
								a.cards.add(undercover);
								if(do_info)
									info += undercover.name + " sent as undercover card!<br>\r";
							}
						}
					}
				}
			}
		}
		if(!b.bountyHunters.isEmpty() || !a.undercover.isEmpty())
		{
			for(int j = 16; j < battlefield[0].length; j++)
			{
				for(int i = 0; i < battlefield.length; i++)
				{
					if(battlefield[i][j] == null)
					{
						if(!b.bountyHunters.isEmpty() && b.summoned < b.jabba && b.bountyHunters.get(0).range != 'S')
						{
							card bounty = b.bountyHunters.get(0);
							b.bountyHunters.remove(0);
							battlefield[i][j] = bounty;
							b.cards.add(bounty);
							battlefield[i][j].ownFormation.summoned++;
							if(do_info)
								info += bounty.name + " summoned!<br>\r";
						}
						else
						{
							formation enemyFormation = a;
							if(!enemyFormation.undercover.isEmpty())
							{
								card undercover = enemyFormation.undercover.get(0);
								enemyFormation.undercover.remove(0);
								battlefield[i][j] = undercover;
								b.cards.add(undercover);
								if(do_info)
									info += undercover.name + " sent as undercover card!<br>\r";
							}
						}
					}
				}
			}
		}
	}

	public void fillHolesFromRightSide() //Causes problems if a complete row is destroyed before facing the other formation
	{
		for(int i = 4; i < 6; i++)//Right side of
		{
			for(int j = 15; j <= 16; j++)//the front lines
			{
				if(battlefield[i][j] != null && battlefield[i-1][j] == null)//If a card left is missing
				{
					battlefield[i-1][j] = battlefield[i][j];//Move the card to the left
					battlefield[i][j] = null;
					if(j == 15)//Upper formation
					{
						battlefield[i-1][j-1] = battlefield[i][j-1];//Also move the two cards behind to the left
						battlefield[i-1][j-2] = battlefield[i][j-2];
						battlefield[i][j-1] = null;
						battlefield[i][j-2] = null;
					}
					else//Lower formation
					{
						battlefield[i-1][j+1] = battlefield[i][j+1];//Also move the two cards behind to the left
						battlefield[i-1][j+2] = battlefield[i][j+2];
						battlefield[i][j+1] = null;
						battlefield[i][j+2] = null;
					}
				}
			}
		}
	}

	public void fillHolesFromLeftSide() //Causes problems if a complete row is destroyed before facing the other formation
	{
		for(int i = 1; i >= 0; i--)//Left side
		{
			for(int j = 15; j <= 16; j++)//of the front lines
			{
				if(battlefield[i][j] != null && battlefield[i+1][j] == null)//If a card right is missing
				{
					battlefield[i+1][j] = battlefield[i][j];//Move the card to the right
					battlefield[i][j] = null;
					if(j == 15)//Upper formation
					{
						battlefield[i+1][j-1] = battlefield[i][j-1];//Also move the two cards behind to the right
						battlefield[i+1][j-2] = battlefield[i][j-2];
						battlefield[i][j-1] = null;
						battlefield[i][j-2] = null;
					}
					else///Lower formation
					{
						battlefield[i+1][j+1] = battlefield[i][j+1];//Also move the two cards behind to the right
						battlefield[i+1][j+2] = battlefield[i][j+2];
						battlefield[i][j+1] = null;
						battlefield[i][j+2] = null;
					}
				}
			}
		}
	}

	public void lopsideShuffle() //Causes problems if a complete row is destroyed before facing the other formation
	{
		int[] emptyLeft = new int[19];
		int[] emptyRight = new int[19];
		
		for(int j = 15; j <= 16; j++)
		{
			for(int i = 0; i <= 2; i++)
			{
				if(battlefield[i][j] == null)//Checks and saves the empty columns on the left side for both front lines
					emptyLeft[j]++;
			}
			for(int i = 3; i < battlefield.length; i++)
			{
				if(battlefield[i][j] == null)//Checks and saves the empty columns on the right side for both front lines
					emptyRight[j]++;
			}
		}
		
		for(int i = 15; i <= 16; i++)
		{
			if(emptyLeft[i] - emptyRight[i] > 1)//If the front line is lopsided to the right
			{
				for(int j = 0; j < battlefield.length-1; j++)//Go through the whole row
				{
					card a = battlefield[j][i];
					battlefield[j][i] = battlefield[j+1][i];//And move all cards in this row one to the left
					battlefield[j+1][i] = a;
					if(i == 15)//Upper formation
					{
						card b = battlefield[j][i-1];//And also move all cards in row 2 and 3 one to the left
						card c = battlefield[j][i-2];
						battlefield[j][i-1] = battlefield[j+1][i-1];
						battlefield[j][i-2] = battlefield[j+1][i-2];
						battlefield[j+1][i-1] = b;
						battlefield[j+1][i-2] = c;
					}
					else//Lower formation
					{
						card b = battlefield[j][i+1];//And also move all cards in row 2 and 3 one to the left
						card c = battlefield[j][i+2];
						battlefield[j][i+1] = battlefield[j+1][i+1];
						battlefield[j][i+2] = battlefield[j+1][i+2];
						battlefield[j+1][i+1] = b;
						battlefield[j+1][i+2] = c;
					}
				}
			}
			
			if(emptyRight[i] - emptyLeft[i] > 1)//If the front line is lopsided to the left
			{
				for(int j = 5; j > 0; j--)//Go through the whole row
				{
					card a = battlefield[j][i];
					battlefield[j][i] = battlefield[j-1][i];//And move all cards in this row one to the right
					battlefield[j-1][i] = a;
					if(i == 15)//Upper formation
					{
						card b = battlefield[j][i-1];//And also move all cards in row 2 and 3 one to the right
						card c = battlefield[j][i-2];
						battlefield[j][i-1] = battlefield[j-1][i-1];
						battlefield[j][i-2] = battlefield[j-1][i-2];
						battlefield[j-1][i-1] = b;
						battlefield[j-1][i-2] = c;
					}
					else//Lower formation
					{
						card b = battlefield[j][i+1];//And also move all cards in row 2 and 3 one to the right
						card c = battlefield[j][i+2];
						battlefield[j][i+1] = battlefield[j-1][i+1];
						battlefield[j][i+2] = battlefield[j-1][i+2];
						battlefield[j-1][i+1] = b;
						battlefield[j-1][i+2] = c;
					}
				}
			}
		}
	}

	public void moveForward()
	{
		for(int i = 0; i < battlefield.length; i++)
		{
			for(int j = 15; j > 0; j--)
			{
				if(battlefield[i][j] == null && battlefield[i][j-1] != null)//If the slot is empty and a card exists one slot behind
				{
					battlefield[i][j] = battlefield[i][j-1];//Move the card behind forward
					battlefield[i][j-1] = null;
				}
			}
		}
	}

	public card shortFindDefender(int i, int j, int defenderFrontRow)
	{
		card defender = null;
		if(battlefield[i][j].concentrated_fire != -1)
		{
			defender = battlefield[battlefield[i][j].concentrated_fire][defenderFrontRow];
		}
		else if(cardAlive(i, defenderFrontRow) && !battlefield[i][j].champion && !battlefield[i][j].merciless && (battlefield[i][defenderFrontRow].skillID == 34201 || battlefield[i][defenderFrontRow].skillID == 32201 || battlefield[i][defenderFrontRow].skillID == 36701) && battlefield[i][defenderFrontRow].self_skill_activated)
		{
			defender = battlefield[i][defenderFrontRow];
		}
		else if(battlefield[i][j].x_coordinate > 0 && cardAlive(i-1, defenderFrontRow) && !battlefield[i][j].champion && !battlefield[i][j].merciless && (battlefield[i-1][defenderFrontRow].skillID == 34201 || battlefield[i-1][defenderFrontRow].skillID == 32201 || battlefield[i-1][defenderFrontRow].skillID == 36701) && battlefield[i-1][defenderFrontRow].self_skill_activated)
		{
			defender = battlefield[i-1][defenderFrontRow];
		}
		else if(battlefield[i][j].x_coordinate < 5 && cardAlive(i+1, defenderFrontRow) &&  !battlefield[i][j].champion && !battlefield[i][j].merciless && (battlefield[i+1][defenderFrontRow].skillID == 34201 || battlefield[i+1][defenderFrontRow].skillID == 32201 || battlefield[i+1][defenderFrontRow].skillID == 36701) && battlefield[i+1][defenderFrontRow].self_skill_activated)
		{
			defender = battlefield[i+1][defenderFrontRow];
		}
		else
		{
			if(cardAlive(i, defenderFrontRow))//If card directly in front is alive, attack it
				defender = battlefield[i][defenderFrontRow];
			else if(i == 0)//If attacker is on the far left, attack one to the right
			{
				if(cardAlive(i+1, defenderFrontRow))
					defender = battlefield[i+1][defenderFrontRow];
			}
			else if(i == 5)//If attacker is on the far right, attack one to the left
			{
				if(cardAlive(i-1, defenderFrontRow))
					defender = battlefield[i-1][defenderFrontRow];
			}
			else
			{
				if(cardAlive(i+1, defenderFrontRow) && !cardAlive(i-1, defenderFrontRow))//Only one option to attack, attack there
					defender = battlefield[i+1][defenderFrontRow];	
				else if(!cardAlive(i+1, defenderFrontRow) && cardAlive(i-1, defenderFrontRow))//Only one option to attack, attack there
					defender = battlefield[i-1][defenderFrontRow];
				else if(cardAlive(i+1, defenderFrontRow) && cardAlive(i-1, defenderFrontRow))//Both diagonally right and left to the card are alive, randomly decide
				{
					double a = Math.random()*2;
					if(a >= 1)
						defender = battlefield[i+1][defenderFrontRow];
					else
						defender = battlefield[i-1][defenderFrontRow];
				}
			}
		}
		return defender;
	}

	public card mediumLongFindDefender(int i, int j, int defenderFrontRow, card attacker)
	{
		card defender = null;
		int upperFrontRow = 0;
		if(j > 15)//Lower formation
		{
			for(int k = 15; k >= 0; k--)//Find the upper formation's front row
			{
				for(int l = 2; l <= 3; l++)
				{
					if(battlefield[l][k] != null)
					{
						upperFrontRow = k;
						break;
					}
				}
				if(upperFrontRow != 0)
					break;
			}
			defenderFrontRow = upperFrontRow;
		}
		
		if((j <= 15 && j >= 13) || (j > 15 && (j - upperFrontRow) < 4) || attacker.range == 'L')//In range//TODO for c3po
		{
			if(battlefield[i][j].concentrated_fire != -1)
			{
				defender = battlefield[battlefield[i][j].concentrated_fire][defenderFrontRow];
			}
			else if(!battlefield[i][j].champion && !battlefield[i][j].merciless && (j > 15 && upperDecoys[0] != null) || (j <= 15 && lowerDecoys[0] != null))
			{
				if(j > 15)
				{
					for(int l = 4; l >= 0; l--)
					{
						for(int k = 0; k < upperDecoys.length; k++)
						{
							if(upperDecoys[k] != null && Math.abs(upperDecoys[k].x_coordinate - i) <= l)//TODO c3po x-range
							{
								defender = upperDecoys[k];
								break;
							}
							if(upperDecoys[k] == null)
								break;
						}
					}
				}
				else
				{
					for(int l = 4; l >= 0; l--)
					{
						for(int k = 0; k < lowerDecoys.length; k++)
						{
							if(lowerDecoys[k] != null && Math.abs(lowerDecoys[k].x_coordinate - i) <= l)//TODO c3po x-range
							{
								defender = lowerDecoys[k];
								break;
							}
							if(lowerDecoys == null)
								break;
						}
					}
				}
			}
			else
			{
				if(i > 1 && i < 4)//Cards on columns 2 & 3
				{
					if(attacker.numberOfTurns % 3 == 0)
					{
						if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i+1, defenderFrontRow))
							defender = battlefield[i+1][defenderFrontRow];
						else if(cardAlive(i-1, defenderFrontRow))
							defender = battlefield[i-1][defenderFrontRow];
						else if(cardAlive(i+2, defenderFrontRow))
							defender = battlefield[i+2][defenderFrontRow];
						else if(cardAlive(i-2, defenderFrontRow))
							defender = battlefield[i-2][defenderFrontRow];
					}
					else if(attacker.numberOfTurns % 3 == 1)
					{
						if(cardAlive(i+1, defenderFrontRow))
							defender = battlefield[i+1][defenderFrontRow];
						else if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i-1, defenderFrontRow))
							defender = battlefield[i-1][defenderFrontRow];
						else if(cardAlive(i+2, defenderFrontRow))
							defender = battlefield[i+2][defenderFrontRow];
						else if(cardAlive(i-2, defenderFrontRow))
							defender = battlefield[i-2][defenderFrontRow];
					}
					else if(attacker.numberOfTurns % 3 == 2)
					{
						if(cardAlive(i-1, defenderFrontRow))
							defender = battlefield[i-1][defenderFrontRow];		
						else if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i+1, defenderFrontRow))
							defender = battlefield[i+1][defenderFrontRow];
						else if(cardAlive(i+2, defenderFrontRow))
							defender = battlefield[i+2][defenderFrontRow];
						else if(cardAlive(i-2, defenderFrontRow))
							defender = battlefield[i-2][defenderFrontRow];
					}	
				}
				
				else if(i == 1)//Attacker in column 2
				{
					if(attacker.numberOfTurns % 3 == 0)
					{
						if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i+1, defenderFrontRow))
							defender = battlefield[i+1][defenderFrontRow];
						else if(cardAlive(i-1, defenderFrontRow))
							defender = battlefield[i-1][defenderFrontRow];
						else if(cardAlive(i+2, defenderFrontRow))
							defender = battlefield[i+2][defenderFrontRow];
					}
					else if(attacker.numberOfTurns % 3 == 1)
					{
						if(cardAlive(i+1, defenderFrontRow))
							defender = battlefield[i+1][defenderFrontRow];
						else if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i-1, defenderFrontRow))
							defender = battlefield[i-1][defenderFrontRow];
						else if(cardAlive(i+2, defenderFrontRow))
							defender = battlefield[i+2][defenderFrontRow];
					}
					else if(attacker.numberOfTurns % 3 == 2)
					{
						if(cardAlive(i-1, defenderFrontRow))
							defender = battlefield[i-1][defenderFrontRow];		
						else if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i+1, defenderFrontRow))
							defender = battlefield[i+1][defenderFrontRow];
						else if(cardAlive(i+2, defenderFrontRow))
							defender = battlefield[i+2][defenderFrontRow];
					}	
				}
				
				else if(i == 4)//Attacker in column 5
				{
					if(attacker.numberOfTurns % 3 == 0)
					{
						if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i+1, defenderFrontRow))
							defender = battlefield[i+1][defenderFrontRow];
						else if(cardAlive(i-1, defenderFrontRow))
							defender = battlefield[i-1][defenderFrontRow];
						else if(cardAlive(i-2, defenderFrontRow))
							defender = battlefield[i-2][defenderFrontRow];
					}
					else if(attacker.numberOfTurns % 3 == 1)
					{
						if(cardAlive(i+1, defenderFrontRow))
							defender = battlefield[i+1][defenderFrontRow];
						else if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i-1, defenderFrontRow))
							defender = battlefield[i-1][defenderFrontRow];
						else if(cardAlive(i-2, defenderFrontRow))
							defender = battlefield[i-2][defenderFrontRow];
					}
					else if(attacker.numberOfTurns % 3 == 2)
					{
						if(cardAlive(i-1, defenderFrontRow))
							defender = battlefield[i-1][defenderFrontRow];		
						else if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i+1, defenderFrontRow))
							defender = battlefield[i+1][defenderFrontRow];
						else if(cardAlive(i-2, defenderFrontRow))
							defender = battlefield[i-2][defenderFrontRow];
					}	
				}
				
				else if(i == 0)//If attacker is on the far left
				{
					if(attacker.numberOfTurns % 3 == 0)
					{
						if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i+1, defenderFrontRow))
							defender = battlefield[i+1][defenderFrontRow];
						else if(cardAlive(i+2, defenderFrontRow))
							defender = battlefield[i+2][defenderFrontRow];
					}
					else
					{
						if(cardAlive(i+1, defenderFrontRow))
							defender = battlefield[i+1][defenderFrontRow];
						else if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i+2, defenderFrontRow))
							defender = battlefield[i+2][defenderFrontRow];
					}
				}
				
				else if(i == 5)//If attacker is on the far right
				{
					if(attacker.numberOfTurns % 3 == 0)
					{
						if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i-1, defenderFrontRow))
							defender = battlefield[i-1][defenderFrontRow];
						else if(cardAlive(i-2, defenderFrontRow))
							defender = battlefield[i-2][defenderFrontRow];
					}
					else
					{
						if(cardAlive(i-1, defenderFrontRow))
							defender = battlefield[i-1][defenderFrontRow];
						else if(cardAlive(i, defenderFrontRow))
							defender = battlefield[i][defenderFrontRow];
						else if(cardAlive(i-2, defenderFrontRow))
							defender = battlefield[i-2][defenderFrontRow];
					}
				}
			}
		}
		return defender;
	}

	public card sniperFindDefender(int i, int j, int defenderMidRow, int defenderFrontRow, card attacker)
	{
		card defender = null;
		int upperMidRow = 0;
		if(j > 15)//Lower formation
		{
			for(int k = 15; k >= 0; k--)//Find the upper formation's front row
			{
				for(int l = 2; l <= 3; l++)
				{
					if(battlefield[l][k] != null)
					{
						upperMidRow = k-1;
						break;
					}
				}
				if(upperMidRow != 0)
					break;
			}
			defenderMidRow = upperMidRow;
		}
		if(battlefield[i][j].concentrated_fire != -1)
		{
			defender = battlefield[battlefield[i][j].concentrated_fire][defenderFrontRow];
		}
		else if(!battlefield[i][j].champion && !battlefield[i][j].merciless && (j > 15 && upperDecoys[0] != null) || (j <= 15 && lowerDecoys[0] != null))
		{
			if(j > 15)
			{
				for(int l = 4; l >= 0; l--)
				{
					for(int k = 0; k < upperDecoys.length; k++)
					{
						if(upperDecoys[k] != null && Math.abs(upperDecoys[k].x_coordinate - i) <= l)//TODO c3po x-range
						{
							defender = upperDecoys[k];
							break;
						}
						if(upperDecoys[k] == null)
							break;
					}
				}
			}
			else
			{
				for(int l = 4; l >= 0; l--)
				{
					for(int k = 0; k < lowerDecoys.length; k++)
					{
						if(lowerDecoys[k] != null && Math.abs(lowerDecoys[k].x_coordinate - i) <= l)//TODO c3po x-range
						{
							defender = lowerDecoys[k];
							break;
						}
						if(lowerDecoys[k] == null)
							break;
					}
				}
			}
		}
		else
		{
			if(i > 1 && i < 4)//Cards on columns 2 & 3
			{
				if(attacker.numberOfTurns % 3 == 0)
				{
					if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i+1, defenderMidRow))
						defender = battlefield[i+1][defenderMidRow];
					else if(cardAlive(i-1, defenderMidRow))
						defender = battlefield[i-1][defenderMidRow];
					else if(cardAlive(i+2, defenderMidRow))
						defender = battlefield[i+2][defenderMidRow];
					else if(cardAlive(i-2, defenderMidRow))
						defender = battlefield[i-2][defenderMidRow];
				}
				else if(attacker.numberOfTurns % 3 == 1)
				{
					if(cardAlive(i+1, defenderMidRow))
						defender = battlefield[i+1][defenderMidRow];
					else if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i-1, defenderMidRow))
						defender = battlefield[i-1][defenderMidRow];
					else if(cardAlive(i+2, defenderMidRow))
						defender = battlefield[i+2][defenderMidRow];
					else if(cardAlive(i-2, defenderMidRow))
						defender = battlefield[i-2][defenderMidRow];
				}
				else if(attacker.numberOfTurns % 3 == 2)
				{
					if(cardAlive(i-1, defenderMidRow))
						defender = battlefield[i-1][defenderMidRow];		
					else if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i+1, defenderMidRow))
						defender = battlefield[i+1][defenderMidRow];
					else if(cardAlive(i+2, defenderMidRow))
						defender = battlefield[i+2][defenderMidRow];
					else if(cardAlive(i-2, defenderMidRow))
						defender = battlefield[i-2][defenderMidRow];
				}	
			}
			
			else if(i == 1)//Attacker in column 2
			{
				if(attacker.numberOfTurns % 3 == 0)
				{
					if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i+1, defenderMidRow))
						defender = battlefield[i+1][defenderMidRow];
					else if(cardAlive(i-1, defenderMidRow))
						defender = battlefield[i-1][defenderMidRow];
					else if(cardAlive(i+2, defenderMidRow))
						defender = battlefield[i+2][defenderMidRow];
				}
				else if(attacker.numberOfTurns % 3 == 1)
				{
					if(cardAlive(i+1, defenderMidRow))
						defender = battlefield[i+1][defenderMidRow];
					else if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i-1, defenderMidRow))
						defender = battlefield[i-1][defenderMidRow];
					else if(cardAlive(i+2, defenderMidRow))
						defender = battlefield[i+2][defenderMidRow];
				}
				else if(attacker.numberOfTurns % 3 == 2)
				{
					if(cardAlive(i-1, defenderMidRow))
						defender = battlefield[i-1][defenderMidRow];		
					else if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i+1, defenderMidRow))
						defender = battlefield[i+1][defenderMidRow];
					else if(cardAlive(i+2, defenderMidRow))
						defender = battlefield[i+2][defenderMidRow];
				}	
			}
			
			else if(i == 4)//Attacker in column 5
			{
				if(attacker.numberOfTurns % 3 == 0)
				{
					if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i+1, defenderMidRow))
						defender = battlefield[i+1][defenderMidRow];
					else if(cardAlive(i-1, defenderMidRow))
						defender = battlefield[i-1][defenderMidRow];
					else if(cardAlive(i-2, defenderMidRow))
						defender = battlefield[i-2][defenderMidRow];
				}
				else if(attacker.numberOfTurns % 3 == 1)
				{
					if(cardAlive(i+1, defenderMidRow))
						defender = battlefield[i+1][defenderMidRow];
					else if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i-1, defenderMidRow))
						defender = battlefield[i-1][defenderMidRow];
					else if(cardAlive(i-2, defenderMidRow))
						defender = battlefield[i-2][defenderMidRow];
				}
				else if(attacker.numberOfTurns % 3 == 2)
				{
					if(cardAlive(i-1, defenderMidRow))
						defender = battlefield[i-1][defenderMidRow];		
					else if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i+1, defenderMidRow))
						defender = battlefield[i+1][defenderMidRow];
					else if(cardAlive(i-2, defenderMidRow))
						defender = battlefield[i-2][defenderMidRow];
				}	
			}
			
			else if(i == 0)//If attacker is on the far left
			{
				if(attacker.numberOfTurns % 3 == 0)
				{
					if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i+1, defenderMidRow))
						defender = battlefield[i+1][defenderMidRow];
					else if(cardAlive(i+2, defenderMidRow))
						defender = battlefield[i+2][defenderMidRow];
				}
				else
				{
					if(cardAlive(i+1, defenderMidRow))
						defender = battlefield[i+1][defenderMidRow];
					else if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i+2, defenderMidRow))
						defender = battlefield[i+2][defenderMidRow];
				}
			}
			
			else if(i == 5)//If attacker is on the far right
			{
				if(attacker.numberOfTurns % 3 == 0)
				{
					if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i-1, defenderMidRow))
						defender = battlefield[i-1][defenderMidRow];
					else if(cardAlive(i-2, defenderMidRow))
						defender = battlefield[i-2][defenderMidRow];
				}
				else
				{
					if(cardAlive(i-1, defenderMidRow))
						defender = battlefield[i-1][defenderMidRow];
					else if(cardAlive(i, defenderMidRow))
						defender = battlefield[i][defenderMidRow];
					else if(cardAlive(i-2, defenderMidRow))
						defender = battlefield[i-2][defenderMidRow];
				}
			}
		}
		return defender;
	}
}