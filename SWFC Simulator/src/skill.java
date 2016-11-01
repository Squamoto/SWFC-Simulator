import java.util.ArrayList;
public class skill
{
	String info = "";
	boolean do_info = false;
	public int activatePrepSkill(int skillID, double proc_rate, formation ownFormation, formation enemyFormation, double effect)//Only SK40 skills
	{
		double random = Math.random();
		if(random <= proc_rate)
		{
			if(skillID == 2121 && enemyFormation.rangeInFormation('L'))//Long DEF down [Sml]
			{
				id_2121(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1361)//All EVA up [Sml]
			{
				id_1361(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2361)//All EVA down [Sml]
			{
				id_2361(enemyFormation, effect);
				return skillID;
			}
			if(skillID == 2001 && enemyFormation.rangeInFormation('S'))//Short ATK down [Sml]
			{
				id_2001(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 11042 && ownFormation.classInFormation(11))//Gungan ATK Up [Med]
			{
				id_11042(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2061)//All ATK down [Sml]
			{
				id_2061(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1051 && ownFormation.sideInFormation('N'))//Neutral ATK Up [Sml]
			{
				id_1051(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11091 && ownFormation.classInFormation(18))//Jedi ATK Up [Sml]
			{
				id_11091(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2131 && enemyFormation.sideInFormation('L'))//Light DEF down [Sml]
			{
				id_2131(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 2141 && enemyFormation.sideInFormation('D'))//Dark DEF down [Sml]
			{
				id_2141(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1231 && ownFormation.sideInFormation('L'))//Light ACC up [Sml]
			{
				id_1231(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2331 && enemyFormation.sideInFormation('L'))//Light EVA down [Sml]
			{
				id_2331(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1111 && ownFormation.rangeInFormation('M'))//Medium DEF Up [Sml]
			{
				id_1111(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2101 && enemyFormation.rangeInFormation('S'))//Short DEF Down [Sml]
			{
				id_2101(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 2232 && enemyFormation.sideInFormation('L'))//Light ACC Down [Med]
			{
				id_2232(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 2242 && enemyFormation.sideInFormation('D'))//Dark ACC Down [Med]
			{
				id_2242(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1342 && ownFormation.sideInFormation('D'))//Dark Eva Up [Med]
			{
				id_1342(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2342 && enemyFormation.sideInFormation('D'))//Dark Eva Down [Med]
			{
				id_2342(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 21101 && ownFormation.classInFormation(17))//Sith DEF Up [Sml]
			{
				id_21101(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 21001 && ownFormation.classInFormation(17))//Sith ATK Up [Sml]
			{
				id_21001(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11111 && ownFormation.classInFormation(21))//Droid DEF Up [Sml]
			{
				id_11111(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1141 && ownFormation.sideInFormation('D'))//Dark DEF Up [Sml]
			{
				id_1141(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 21371 && ownFormation.classInFormation(16))//Podracer Eva Up [Sml]
			{
				id_21371(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 12171 && enemyFormation.classInFormation(8))//Empire DEF Down [Sml]
			{
				id_12171(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 11311 && ownFormation.classInFormation(21))//Droid Eva Up [Sml]
			{
				id_11311(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1131 && ownFormation.sideInFormation('L'))//Light Def Up [Sml]
			{
				id_1131(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1021 && ownFormation.rangeInFormation('L'))//Long ATK Up [Sml]
			{
				id_1021(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1161)//All DEF Up [Sml]
			{
				id_1161(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11261 && ownFormation.classInFormation(9))//Rebel Acc Up [Sml]
			{
				id_11261(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11231 && ownFormation.classInFormation(15))//Bounty Hunter Acc Up [Sml]
			{
				id_11231(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1061)//All ATK Up [Sml]
			{
				id_1061(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1031 && ownFormation.sideInFormation('L'))//Light ATK Up [Sml]
			{
				id_1031(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1301 && ownFormation.rangeInFormation('S'))//Short EVA Up [Sml]
			{
				id_1301(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1011 && ownFormation.rangeInFormation('M'))//Medium ATK Up [Sml]
			{
				id_1011(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 22042 && enemyFormation.classInFormation(3))//Jabba's Crime Syndicate ATK Down [Med]
			{
				id_22042(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 12181 && enemyFormation.classInFormation(23))//Male DEF Down [Sml]
			{
				id_12181(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1101 && ownFormation.rangeInFormation('S'))//Short DEF Up [Sml]
			{
				id_1101(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11191 && ownFormation.classInFormation(18))//Jedi DEF Up [Sml]
			{
				id_11191(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11171 && ownFormation.classInFormation(8))//Empire DEF Up [Sml]
			{
				id_11171(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11011 && ownFormation.classInFormation(21))//Droid ATK Up [Sml]
			{
				id_11011(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2041 && enemyFormation.sideInFormation('D'))//Dark ATK Down [Sml]
			{
				id_2041(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 2161)//All Def Down [Sml]
			{
				id_2161(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 2222 && enemyFormation.rangeInFormation('L'))//Long ACC Down [Med]
			{
				id_2222(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 22362 && enemyFormation.classInFormation(7))//Republic Eva Down [Med]
			{
				id_22362(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1332 && ownFormation.sideInFormation('L'))//Light Eva Up [Med]
			{
				id_1332(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 21051 && ownFormation.classInFormation(6))//Separatist ATK Up [Sml]
			{
				id_21051(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 12111 && enemyFormation.classInFormation(21))//Droid DEF Down [Sml]
			{
				id_12111(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 2261)//All ACC Down [Sml]
			{
				id_2261(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 22352 && enemyFormation.classInFormation(6))//Separatist EVA Down [Med]
			{
				id_22352(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 11022 && ownFormation.classInFormation(13))//Ewok ATK Up [Med]
			{
				id_11022(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2021 && enemyFormation.rangeInFormation('L'))//Long ATK Down [Sml]
			{
				id_2021(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1221 && ownFormation.rangeInFormation('L'))//Long ACC Up [Sml]
			{
				id_1221(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2211 && enemyFormation.rangeInFormation('M'))//Medium ACC Down [Sml]
			{
				id_2211(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 2111 && enemyFormation.rangeInFormation('M'))//Medium DEF Down [Sml]
			{
				id_2111(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 2221 && enemyFormation.rangeInFormation('L'))//Long ACC Down [Sml]
			{
				id_2221(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1331 && ownFormation.sideInFormation('L'))//Light Eva Up [Sml]
			{
				id_1331(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2201 && enemyFormation.rangeInFormation('S'))//Short ACC Down [Sml]
			{
				id_2201(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 11361 && ownFormation.classInFormation(9))//Rebel Eva Up [Sml]
			{
				id_11361(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11371 && ownFormation.classInFormation(8))//Empire Eva Up [Sml]
			{
				id_11371(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11122 && ownFormation.classInFormation(13))//Ewok DEF Up [Med]
			{
				id_11122(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1211 && ownFormation.rangeInFormation('M'))//Medium ACC Up [Sml]
			{
				id_1211(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1121 && ownFormation.rangeInFormation('L'))//Long DEF Up [Sml]
			{
				id_1121(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1241 && ownFormation.sideInFormation('D'))//Dark ACC Up [Sml]
			{
				id_1241(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2011 && enemyFormation.rangeInFormation('M'))//Medium ATK Down [Sml]
			{
				id_2011(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 11061 && ownFormation.classInFormation(9))//Rebel ATK Up [Sml]
			{
				id_11061(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 12161 && enemyFormation.classInFormation(9))//Rebel DEF Down [Sml]
			{
				id_12161(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 2151 && enemyFormation.sideInFormation('N'))//Neutral DEF Down [Sml]
			{
				id_2151(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 11161 && ownFormation.classInFormation(9))//Rebel DEF Up [Sml]
			{
				id_11161(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11101 && ownFormation.classInFormation(22))//Female DEF Up [Sml]
			{
				id_11101(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11322 && ownFormation.classInFormation(13))//Ewok EVA Up [Med]
			{
				id_11322(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1041 && ownFormation.sideInFormation('D'))//Dark ATK Up [Sml]
			{
				id_1041(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 12311 && enemyFormation.classInFormation(21))//Droid EVA Down [Sml]
			{
				id_12311(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 12071 && enemyFormation.classInFormation(8))//Empire ATK Down [Sml]
			{
				id_12071(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 11001 && ownFormation.classInFormation(22))//Female ATK Up [Sml]
			{
				id_11001(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2031 && enemyFormation.sideInFormation('L'))//Light ATK Down [Sml]
			{
				id_2031(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1311 && ownFormation.rangeInFormation('M'))//Medium EVA Up [Sml]
			{
				id_1311(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 2231 && enemyFormation.sideInFormation('L'))//Light ACC Down [Sml]
			{
				id_2231(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1001 && ownFormation.rangeInFormation('S'))//Short ATK Up [Sml]
			{
				id_1001(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11222 && ownFormation.classInFormation(13))//Ewok ACC Up [Med]
			{
				id_11222(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 1341 && ownFormation.sideInFormation('D'))//Dark EVA Up [Sml]
			{
				id_1341(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 21331 && ownFormation.classInFormation(4))//Tatooinian EVA Up [Sml]
			{
				id_21331(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 21131 && ownFormation.classInFormation(4))//Tatooinian DEF Up [Sml]
			{
				id_21131(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11351 && ownFormation.classInFormation(10))//Nabooan EVA Up [Sml]
			{
				id_11351(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11251 && ownFormation.classInFormation(10))//Nabooan ACC Up [Sml]
			{
				id_11251(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11151 && ownFormation.classInFormation(10))//Nabooan DEF Up [Sml]
			{
				id_11151(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11051 && ownFormation.classInFormation(10))//Nabooan ATK Up [Sml]
			{
				id_11051(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 5011)//Morale Boost Up [Sml]
			{
				ownFormation.leader_boost_multiplier += effect;
				return skillID;
			}
			else if(skillID == 5031)//Morale Boost Up [Sml]
			{
				ownFormation.force_boost_multiplier += effect;
				return skillID;
			}
			else if(skillID == 5002)//Skill Effect Down [Med]
			{
				enemyFormation.skill_multiplier -= effect;
				return skillID;
			}
			else if(skillID == 5001)//Skill Effect Down [Sml]
			{
				enemyFormation.skill_multiplier -= effect;
				return skillID;
			}
			else if(skillID == 62421 && ownFormation.classInFormation(8))//Veers Pain for Power
			{
				id_62421(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 62411 && ownFormation.sideInFormation('L'))//Ackbar's Strength in Numbers
			{
				id_62411(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11071 && ownFormation.classInFormation(8))//Empire ATK Up [Sml]
			{
				id_11071(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 21351 && ownFormation.classInFormation(6))//Separatist Eva Up [Sml]
			{
				id_21351(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 21361 && ownFormation.classInFormation(7))//Republic Eva Up [Sml]
			{
				id_21361(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 11211 && ownFormation.classInFormation(21))//Droid Acc Up [Sml]
			{
				id_11211(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 21261 && ownFormation.classInFormation(7))//Republic Acc Up [Sml]
			{
				id_21261(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 22161 && enemyFormation.classInFormation(7))//Republic DEF Down [Sml]
			{
				id_22161(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 21021 && ownFormation.classInFormation(12))//Clone Trooper ATK Up [Sml]
			{
				id_21021(ownFormation, effect);
				return skillID;
			}
			else if(skillID == 12411 && enemyFormation.classInFormation(21))//Droid All Stats Down [Sml]
			{
				id_12411(enemyFormation, effect);
				return skillID;
			}
			else if(skillID == 1621 && ownFormation.rangeInFormation('L'))//Long ATK & ACC Up [Sml]
			{
				id_1621(ownFormation, effect);
				return skillID;
			}
		}
		return 0;
	}

	public boolean activateSelfSkill(card card, ArrayList<card> ownCards, card[][] battlefield, formation ownFormation, formation enemyFormation)
	{
		double random = Math.random();
		if(random <= card.proc_rate && !card.combat_unable)
		{
			if(card.skillID == 31011)//Self ATK Up [Sml]
			{
				double boost = card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAtkBoost(boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 31012)//Self ATK Up [Med]
			{
				double boost = card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAtkBoost(boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 31111)//Self DEF Up [Sml]
			{
				double boost = card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundDefBoost(boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! DEF boosted by " + (int) boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 31112)//Self DEF Up [Med]
			{
				double boost = card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundDefBoost(boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! DEF boosted by " + (int) boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 31211)//Self ACC Up [Sml]
			{
				double boost = card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAccBoost(boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ACC boosted by " + (int) boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 31311)//Self EVA Up [Sml]
			{
				double boost = card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundEvaBoost(boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! EVA boosted by " + (int) boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 31312)//Self EVA Up [Med]
			{
				double boost = card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundEvaBoost(boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! EVA boosted by " + (int) boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 31511)//Self HEA/REP Up [Sml]
			{
				double boost = card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAtkBoost(boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! HEA/REP boosted by " + (int) boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 31512)//Self HEA/REP Up [Med]
			{
				double boost = card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAtkBoost(boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! HEA/REP boosted by " + (int) boost + "<br>\r";
				return true;
			}
			else if(card.skillID == 31611)//Last of the Order (Loto)
			{
				double atk_boost, def_boost, acc_boost, eva_boost = 0.0;
				atk_boost = card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				def_boost = card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				acc_boost = card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				eva_boost = card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAtkBoost(atk_boost);
				card.addRoundDefBoost(def_boost);
				card.addRoundAccBoost(acc_boost);
				card.addRoundEvaBoost(eva_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", DEF boosted by " + (int) def_boost + ", ACC boosted by " + (int) acc_boost + ", EVA boosted by " + (int) eva_boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 31711)//The Fallen One (TFO)
			{
				double atk_boost, def_boost, acc_boost, eva_boost = 0;
				atk_boost = card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				def_boost = card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				acc_boost = card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				eva_boost = card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAtkBoost(atk_boost);
				card.addRoundDefBoost(def_boost);
				card.addRoundAccBoost(acc_boost);
				card.addRoundEvaBoost(eva_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", DEF boosted by " + (int) def_boost + ", ACC boosted by " + (int) acc_boost + ", EVA boosted by " + (int) eva_boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 31811)//Defender of the Weak (YGM)
			{
				double atk_boost = 0, def_boost = 0;
				for(int i = 0; i < ownCards.size(); i++)
				{
					if(ownCards.get(i) != null && ownCards.get(i).alive() && ownCards.get(i).side != 'D')
					{
						if(card.atk > ownCards.get(i).atk)
						{
							atk_boost += (card.atk-ownCards.get(i).atk) * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
						}
						if(card.def > ownCards.get(i).def)
						{
							def_boost += (card.def-ownCards.get(i).def) * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
						}
					}
				}
				card.addRoundAtkBoost(atk_boost);
				card.addRoundDefBoost(def_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", DEF boosted by " + (int) def_boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 31911)//Dark Absorption (Sid SD)
			{
				double atk_boost = 0, def_boost = 0, left_atk_decrease = 0, left_def_decrease = 0, right_atk_decrease = 0, right_def_decrease = 0;
				if(card.left != null && card.left.side != 'L')
				{
					atk_boost += card.left.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					def_boost += card.left.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					left_atk_decrease += card.left.baseAtk * 1.5 * card.skill_effect * (card.left.skill_multiplier + 1 - card.combat_multiplier);//TODO Not too sure about 1.5
					left_def_decrease += card.left.baseDef * 1.5 * card.skill_effect * (card.left.skill_multiplier + 1 - card.combat_multiplier);
				}
				if(card.right != null && card.right.side != 'L')
				{
					atk_boost += card.right.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					def_boost += card.right.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					right_atk_decrease += card.right.baseAtk * 1.5 * card.skill_effect * (card.right.skill_multiplier + 1 - card.right.combat_multiplier);
					right_def_decrease += card.right.baseDef * 1.5 * card.skill_effect * (card.right.skill_multiplier + 1 - card.right.combat_multiplier);
				}
				if(atk_boost != 0.0 || def_boost != 0.0)
				{
					card.addRoundAtkBoost(atk_boost);
					card.addRoundDefBoost(def_boost);
					if(card.left != null)
					{
						card.left.addRoundAtkBoost(-left_atk_decrease);
						card.left.addRoundDefBoost(-left_def_decrease);
					}
					if(card.right != null)
					{
						card.right.addRoundAtkBoost(-right_atk_decrease);
						card.right.addRoundDefBoost(-right_def_decrease);
					}
					if(do_info)
					{
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", DEF boosted by " + (int) def_boost + "<br>\r";
						if(card.left != null && card.left.side != 'L')
							info += card.left.name + "'s (" + card.left.x_coordinate + "|" + card.left.y_coordinate + ") ATK decreased by " + (int) left_atk_decrease + ", DEF decreased by " + (int) left_def_decrease + " due to " + card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\"<br>\r";
						if(card.right != null && card.right.side != 'L')
							info += card.right.name + "'s (" + card.right.x_coordinate + "|" + card.right.y_coordinate + ") ATK decreased by " + (int) right_atk_decrease + ", DEF decreased by " + (int) right_def_decrease + " due to " + card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\"<br>\r";
					}
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 32011)//Clone Marshall Commander (Cody)
			{
				double atk_boost = 0, acc_boost = 0;
				int clones = 0;
				if(card.front != null)
				{
					if(card.front.races[12] && card.front.rarity < card.rarity)
						clones++;
					if(card.front.front != null && card.front.front.races[12] && card.front.front.rarity < card.rarity)
						clones++;
				}
				if(card.behind != null)
				{
					if(card.behind.races[12] && card.behind.rarity < card.rarity)
						clones++;
					if(card.behind.behind != null && card.behind.behind.races[12] && card.behind.behind.rarity < card.rarity)
						clones++;
				}
				atk_boost += card.baseAtk * (card.skill_effect * clones) * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAtkBoost(atk_boost);
				acc_boost += card.baseAcc * (card.skill_effect * clones) * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAccBoost(acc_boost);
				if(clones > 0)
				{
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", ACC boosted by " + (int) acc_boost + "<br>\r"; 
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 32101)//Merciless Execution (TM Tarkin)
			{
				card.addRoundAtkBoost(card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier));
				card.addRoundAccBoost(card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier));
				card.delay = 60;
				card.real_delay = 60;
				return true;
			}
			else if(card.skillID == 32301)//Shield of The Empire (ERG)
			{
				double eva_boost = 0;
				if(card.left != null && card.left.races[8])
					eva_boost += card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				if(card.right != null && card.right.races[8])
					eva_boost += card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				if(eva_boost > 0)
				{
					card.addRoundEvaBoost(eva_boost);
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! EVA boosted by " + (int) eva_boost + "<br>\r"; 
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 32501)//Rogue Leader (Luke HTE)
			{
				double atk_boost = 0, def_boost = 0;
				for(int i = 0; i < ownCards.size(); i++)
				{
					if(ownCards.get(i) != null && ownCards.get(i).alive() && ownCards.get(i).races[9])
					{
						if(card.atk > ownCards.get(i).atk)
						{
							atk_boost += (card.atk-ownCards.get(i).atk) * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
						}
						if(card.def > ownCards.get(i).def)
						{
							def_boost += (card.def-ownCards.get(i).def) * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
						}
					}
				}
				card.addRoundAtkBoost(atk_boost);
				card.addRoundDefBoost(def_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", DEF boosted by " + (int) def_boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 32801 && card.front == null)//Confront Droid Army (Obi VC)
			{
				card enemy;
				double eva_boost = 0;
				if(card.y_coordinate < 16)
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate+1];
				}
				else
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate-1];
				}
				if(enemy != null && enemy.races[21])//Maybe also if not front
				{
					eva_boost += card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					card.addRoundEvaBoost(eva_boost);
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! EVA boosted by " + (int) eva_boost + "<br>\r"; 
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 32901)//Blitz (Ani DW), Affected by chanjar?
			{
				double freq_boost = 0;
				freq_boost += 1;
				if(Math.random() <= card.skill_effect)
				{
					freq_boost += 1;
				}
				card.addRoundFreqBoost(freq_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! Attack frequency boosted by " + (int) freq_boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 33101 && card.hp <= card.max_hp / 2)//Die Hard (Cad Bane)
			{
				double def_boost = 0, eva_boost = 0;
				def_boost += card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundDefBoost(def_boost);
				eva_boost += card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundEvaBoost(eva_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! DEF boosted by " + (int) def_boost + ", EVA boosted by " + (int) eva_boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 33201)//Form 4 (Yoda RG)
			{
				double atk_boost = 0, acc_boost = 0, eva_boost = 0, def_decrease = 0;
				atk_boost += card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAtkBoost(atk_boost);
				acc_boost += card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAccBoost(acc_boost);
				eva_boost += card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundEvaBoost(eva_boost);
				def_decrease += card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundDefBoost(-def_decrease);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", ACC boosted by " + (int) acc_boost + ", EVA boosted by " + (int) eva_boost + ", DEF decreased by " + (int) def_decrease +"<br>\r"; 
				return true;
			}
			else if(card.skillID == 33901 && card.front == null)//Call of the Dark Side (Vader DU)
			{
				card enemy;
				int multiplier = 1;
				double atk_decrease = 0, acc_decrease = 0;
				if(card.y_coordinate < 16)
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate+1];
				}
				else
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate-1];
				}
				if(enemy != null)
				{
					if(enemy.side == 'L')
						multiplier = 2;
					atk_decrease += enemy.baseAtk * card.skill_effect * multiplier * (enemy.skill_multiplier + 1 - enemy.combat_multiplier);
					enemy.addRoundAtkBoost(-atk_decrease);
					acc_decrease += enemy.baseAcc * card.skill_effect * multiplier * (enemy.skill_multiplier + 1 - enemy.combat_multiplier);
					enemy.addRoundAccBoost(-acc_decrease);
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! " + enemy.name + "'s (" + enemy.x_coordinate + "|" + enemy.y_coordinate + ") ATK decreased by " + (int) atk_decrease + ", ACC decreased by " + (int) acc_decrease + "<br>\r"; 
					return true;	
				}
				else
					return false;
			}
			else if(card.skillID == 34002 && card.front == null)//Force Push [Med] (Kit Fisto)
			{
				card enemy;
				String def_red_1 = "", def_red_2 = "";
				if(card.y_coordinate < 16)
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate+1];
				}
				else
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate-1];
				}
				if(enemy != null)
				{
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated:<br>\r";
					if(enemy.behind != null)//Base atk?
					{
						double damage = card.atk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier) * (1-enemy.def/(enemy.def + enemy.behind.def));
						double damage_2 = card.atk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier) * (1-enemy.behind.def/(enemy.def + enemy.behind.def));
						def_red_1 += enemy.decreaseHp(damage);
						def_red_2 += enemy.behind.decreaseHp(damage_2);
						if(do_info)
						{
							info += enemy.name + "'s (" + enemy.x_coordinate + "|" + enemy.y_coordinate + ") HP decreased by " + (int) damage + def_red_1 + "<br>\r";
							info += enemy.behind.name + "'s (" + enemy.behind.x_coordinate + "|" + enemy.behind.y_coordinate + ") HP decreased by " + (int) damage_2 + def_red_2 + "<br>\r";
						}
					}
					else
					{
						enemy.decreaseHp(10);
						if(do_info)
							info += enemy.name + "'s (" + enemy.x_coordinate + "|" + enemy.y_coordinate + ") HP decreased by 10. Decreasing " + enemy.name + "'s DEF by 90<br>\r";
					}
					return true;
				}
			}
			else if(card.skillID == 34301)//Recovery (Ani RD)
			{
				double hp_boost = 0;
				hp_boost += card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				if(card.hp + hp_boost > card.max_hp)
					hp_boost = card.max_hp - card.hp;
				card.hp += hp_boost;
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! " + (int) hp_boost + " HP recovered!<br>\r"; 
				return true;
			}
			else if(card.skillID == 34401 && card.front != null)//Dual-Range (BX Droid)
			{
				card.addRoundAtkBoost(card.baseAtk * (card.skill_effect - 1) * (card.skill_multiplier + 1 - card.combat_multiplier));
				card.range = 'M';
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill " + card.skill_name + " activated and is performing a medium-ranged attack!<br>\r"; 
				return true;
			}
			else if(card.skillID == 34501)//Regenerate (Bossk)
			{
				double hp_boost = 0;
				hp_boost += card.max_hp * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				if(card.hp + hp_boost > card.max_hp)
					hp_boost = card.max_hp - card.hp;
				card.hp += hp_boost;
				if(hp_boost > 0)
				{
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! " + (int) hp_boost + " HP recovered!<br>\r"; 
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 42002 && card.front == null)//Pacify [Med] (DDL/PFT)
			{
				card enemy = null;
				double atk_decrease_1 = 0, atk_decrease_2 = 0, atk_decrease_3 = 0, atk_decrease_4 = 0, atk_decrease_5 = 0;
				if(card.y_coordinate > 15)//Lower formation
				{
					for(int i = 15; i >= 0; i--)//Find the upper formation's front row
					{
						if(battlefield[card.x_coordinate][i] != null)
						{
							enemy = battlefield[card.x_coordinate][i];
							break;
						}
					}
				}
				else
				{
					enemy = battlefield[card.x_coordinate][16];
				}
				if(card.behind != null && !card.behind.appliedSkill(card.skillID))
				{
					atk_decrease_1 += card.behind.baseAtk * card.skill_effect * (card.behind.skill_multiplier + 1 - card.behind.combat_multiplier);
					card.behind.addRoundAtkBoost(-atk_decrease_1);
					card.behind.appliedCombatSkills.add(card.skillID);
					if(card.behind.behind != null && !card.behind.behind.appliedSkill(card.skillID))
					{
						atk_decrease_2 += card.behind.behind.baseAtk * card.skill_effect * (card.behind.behind.skill_multiplier + 1 - card.behind.behind.combat_multiplier);
						card.behind.behind.addRoundAtkBoost(-atk_decrease_2);
						card.behind.behind.appliedCombatSkills.add(card.skillID);
					}
				}
				if(enemy != null && !enemy.appliedSkill(card.skillID))
				{
					atk_decrease_3 += enemy.baseAtk * card.skill_effect * (enemy.skill_multiplier + 1 - enemy.combat_multiplier);
					enemy.addRoundAtkBoost(-atk_decrease_3);
					enemy.appliedCombatSkills.add(card.skillID);
					if(enemy.behind != null && !enemy.behind.appliedSkill(card.skillID))
					{
						atk_decrease_4 += enemy.behind.baseAtk * card.skill_effect * (enemy.behind.skill_multiplier + 1 - enemy.behind.combat_multiplier);
						enemy.behind.addRoundAtkBoost(-atk_decrease_4);
						enemy.behind.appliedCombatSkills.add(card.skillID);
						if(enemy.behind.behind != null && !enemy.behind.behind.appliedSkill(card.skillID))
						{
							atk_decrease_5 += enemy.behind.behind.baseAtk * card.skill_effect * (enemy.behind.behind.skill_multiplier + 1 - enemy.behind.behind.combat_multiplier);
							enemy.behind.behind.addRoundAtkBoost(-atk_decrease_5);
							enemy.behind.behind.appliedCombatSkills.add(card.skillID);
						}
					}
				}
				if(do_info)
				{
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
					if(card.behind != null)
					{
						info += card.behind.name + "'s (" + card.behind.x_coordinate + "|" + card.behind.y_coordinate + ") ATK decreased by " + (int) atk_decrease_1 + "<br>\r";
						if(card.behind.behind != null)
							info += card.behind.behind.name + "'s (" + card.behind.behind.x_coordinate + "|" + card.behind.behind.y_coordinate + ") ATK decreased by " + (int) atk_decrease_2 + "<br>\r";
					}
					if(enemy != null)
					{
						info += enemy.name + "'s (" + enemy.x_coordinate + "|" + enemy.y_coordinate + ") ATK decreased by " + (int) atk_decrease_3 + "<br>\r";
						if(enemy.behind != null)
						{
							info += enemy.behind.name + "'s (" + enemy.behind.x_coordinate + "|" + enemy.behind.y_coordinate + ") ATK decreased by " + (int) atk_decrease_4 + "<br>\r";
							if(enemy.behind.behind != null)
								info += enemy.behind.behind.name + "'s (" + enemy.behind.behind.x_coordinate + "|" + enemy.behind.behind.y_coordinate + ") ATK decreased by " + (int) atk_decrease_5 + "<br>\r";
						}
					}
				}
				return true;
			}
			else if(card.skillID == 51331 && card.front != null && card.front.side != 'D')//1-Card Light Side & Neutral Acceleration [Sml] (Mon)//TODO
			{
				double eva_increase = 0;
				eva_increase += card.front.baseEva * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
				card.front.addRoundEvaBoost(eva_increase);
				if(card.front.delay == 1)
					card.front.addRoundFreqBoost(1);
				else
					card.front.delay -= 1;//Maybe wrong (counting towards next possible attack?)
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! " + card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") EVA increased by " + (int) eva_increase + ", attack frequency increased<br>\r"; 
				return true;
			}
			else if(card.skillID == 51341 && card.front != null && card.front.side != 'L')//1-Card Dark Side & Neutral Acceleration [Sml] (Orn)
			{
				double eva_increase = 0;
				eva_increase += card.front.baseEva * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
				card.front.addRoundEvaBoost(eva_increase);
				if(card.front.delay == 1)
					card.front.addRoundFreqBoost(1);
				else
					card.front.delay -= 1;//Maybe wrong (counting towards next possible attack?)
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! " + card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") EVA increased by " + (int) eva_increase + ", attack frequency increased<br>\r"; 
				return true;
			}
			else if(card.skillID == 51431 && card.front != null)//3-Unit Light Side All Stats Up [Sml] (Bail)
			{
				double front_atk = 0, front_acc = 0, front_eva = 0, front_def = 0, left_atk = 0, left_acc = 0, left_eva = 0, left_def = 0, right_atk = 0, right_acc = 0, right_eva = 0, right_def = 0;
				String front = "", left = "", right = "";
				if(card.front.side == 'L' && !card.front.appliedSkill(card.skillID))
				{
					front_atk += card.front.baseAtk * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAtkBoost(front_atk);
					front_acc += card.front.baseAcc * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAccBoost(front_acc);
					front_eva += card.front.baseEva * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundEvaBoost(front_eva);
					front_def += card.front.baseDef * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundDefBoost(front_def);
					card.front.appliedCombatSkills.add(card.skillID);
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) front_atk + " / " + (int) front_def + " / " + (int) front_acc + " / " + (int) front_eva + "<br>\r";
				}
				if(card.front.left != null && card.front.left.side == 'L' && !card.front.left.appliedSkill(card.skillID))
				{
					left_atk += card.front.left.baseAtk * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAtkBoost(left_atk);
					left_acc += card.front.left.baseAcc * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAccBoost(left_acc);
					left_eva += card.front.left.baseEva * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundEvaBoost(left_eva);
					left_def += card.front.left.baseDef * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundDefBoost(left_def);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) left_atk + " / " + (int) left_def + " / " + (int) left_acc + " / " + (int) left_eva + "<br>\r";
				}
				if(card.front.right != null && card.front.right.side == 'L' && !card.front.right.appliedSkill(card.skillID))
				{
					right_atk += card.front.right.baseAtk * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAtkBoost(right_atk);
					right_acc += card.front.right.baseAcc * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAccBoost(right_acc);
					right_eva += card.front.right.baseEva * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundEvaBoost(right_eva);
					right_def += card.front.right.baseDef * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundDefBoost(right_def);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) right_atk + " / " + (int) right_def + " / " + (int) right_acc + " / " + (int) right_eva + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 51432 && card.front != null)//3-Unit Light Side All Stats Up [Med] (Queen)
			{
				double front_atk = 0, front_acc = 0, front_eva = 0, front_def = 0, left_atk = 0, left_acc = 0, left_eva = 0, left_def = 0, right_atk = 0, right_acc = 0, right_eva = 0, right_def = 0;
				String front = "", left = "", right = "";
				if(card.front.side == 'L' && !card.front.appliedSkill(card.skillID))
				{
					front_atk += card.front.baseAtk * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAtkBoost(front_atk);
					front_acc += card.front.baseAcc * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAccBoost(front_acc);
					front_eva += card.front.baseEva * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundEvaBoost(front_eva);
					front_def += card.front.baseDef * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundDefBoost(front_def);
					card.front.appliedCombatSkills.add(card.skillID);
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) front_atk + " / " + (int) front_def + " / " + (int) front_acc + " / " + (int) front_eva + "<br>\r";
				}
				if(card.front.left != null && card.front.left.side == 'L' && !card.front.left.appliedSkill(card.skillID))
				{
					left_atk += card.front.left.baseAtk * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAtkBoost(left_atk);
					left_acc += card.front.left.baseAcc * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAccBoost(left_acc);
					left_eva += card.front.left.baseEva * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundEvaBoost(left_eva);
					left_def += card.front.left.baseDef * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundDefBoost(left_def);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) left_atk + " / " + (int) left_def + " / " + (int) left_acc + " / " + (int) left_eva + "<br>\r";
				}
				if(card.front.right != null && card.front.right.side == 'L' && !card.front.right.appliedSkill(card.skillID))
				{
					right_atk += card.front.right.baseAtk * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAtkBoost(right_atk);
					right_acc += card.front.right.baseAcc * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAccBoost(right_acc);
					right_eva += card.front.right.baseEva * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundEvaBoost(right_eva);
					right_def += card.front.right.baseDef * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundDefBoost(right_def);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) right_atk + " / " + (int) right_def + " / " + (int) right_acc + " / " + (int) right_eva + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 51441 && card.front != null)//3-Unit Dark Side All Stats Up [Sml] (Mas)
			{
				double front_atk = 0, front_acc = 0, front_eva = 0, front_def = 0, left_atk = 0, left_acc = 0, left_eva = 0, left_def = 0, right_atk = 0, right_acc = 0, right_eva = 0, right_def = 0;
				String front = "", left = "", right = "";
				if(card.front.side == 'D' && !card.front.appliedSkill(card.skillID))
				{
					front_atk += card.front.baseAtk * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAtkBoost(front_atk);
					front_acc += card.front.baseAcc * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAccBoost(front_acc);
					front_eva += card.front.baseEva * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundEvaBoost(front_eva);
					front_def += card.front.baseDef * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundDefBoost(front_def);
					card.front.appliedCombatSkills.add(card.skillID);
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) front_atk + " / " + (int) front_def + " / " + (int) front_acc + " / " + (int) front_eva + "<br>\r";
				}
				if(card.front.left != null && card.front.left.side == 'D' && !card.front.left.appliedSkill(card.skillID))
				{
					left_atk += card.front.left.baseAtk * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAtkBoost(left_atk);
					left_acc += card.front.left.baseAcc * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAccBoost(left_acc);
					left_eva += card.front.left.baseEva * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundEvaBoost(left_eva);
					left_def += card.front.left.baseDef * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundDefBoost(left_def);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) left_atk + " / " + (int) left_def + " / " + (int) left_acc + " / " + (int) left_eva + "<br>\r";
				}
				if(card.front.right != null && card.front.right.side == 'D' && !card.front.right.appliedSkill(card.skillID))
				{
					right_atk += card.front.right.baseAtk * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAtkBoost(right_atk);
					right_acc += card.front.right.baseAcc * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAccBoost(right_acc);
					right_eva += card.front.right.baseEva * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundEvaBoost(right_eva);
					right_def += card.front.right.baseDef * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundDefBoost(right_def);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) right_atk + " / " + (int) right_def + " / " + (int) right_acc + " / " + (int) right_eva + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 51442 && card.front != null)//3-Unit Dark Side All Stats Up [Med] (SCP)
			{
				double front_atk = 0, front_acc = 0, front_eva = 0, front_def = 0, left_atk = 0, left_acc = 0, left_eva = 0, left_def = 0, right_atk = 0, right_acc = 0, right_eva = 0, right_def = 0;
				String front = "", left = "", right = "";
				if(card.front.side == 'D' && !card.front.appliedSkill(card.skillID))
				{
					front_atk += card.front.baseAtk * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAtkBoost(front_atk);
					front_acc += card.front.baseAcc * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAccBoost(front_acc);
					front_eva += card.front.baseEva * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundEvaBoost(front_eva);
					front_def += card.front.baseDef * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundDefBoost(front_def);
					card.front.appliedCombatSkills.add(card.skillID);
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) front_atk + " / " + (int) front_def + " / " + (int) front_acc + " / " + (int) front_eva + "<br>\r";
				}
				if(card.front.left != null && card.front.left.side == 'D' && !card.front.left.appliedSkill(card.skillID))
				{
					left_atk += card.front.left.baseAtk * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAtkBoost(left_atk);
					left_acc += card.front.left.baseAcc * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAccBoost(left_acc);
					left_eva += card.front.left.baseEva * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundEvaBoost(left_eva);
					left_def += card.front.left.baseDef * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundDefBoost(left_def);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) left_atk + " / " + (int) left_def + " / " + (int) left_acc + " / " + (int) left_eva + "<br>\r";
				}
				if(card.front.right != null && card.front.right.side == 'D' && !card.front.right.appliedSkill(card.skillID))
				{
					right_atk += card.front.right.baseAtk * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAtkBoost(right_atk);
					right_acc += card.front.right.baseAcc * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAccBoost(right_acc);
					right_eva += card.front.right.baseEva * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundEvaBoost(right_eva);
					right_def += card.front.right.baseDef * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundDefBoost(right_def);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) right_atk + " / " + (int) right_def + " / " + (int) right_acc + " / " + (int) right_eva + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 53232)//Adjacent Light ACC Up [Med] (R4-G9)
			{
				double left_acc = 0, right_acc = 0;
				if(card.left != null && card.left.side == 'L' && !card.left.appliedSkill(card.skillID))
				{
					left_acc += card.left.baseAcc * card.skill_effect * (card.left.skill_multiplier + 1 - card.left.combat_multiplier);
					card.left.addRoundAccBoost(left_acc);
					card.left.appliedCombatSkills.add(card.skillID);
				}
				if(card.right != null && card.right.side == 'L' && !card.right.appliedSkill(card.skillID))
				{
					right_acc += card.right.baseAcc * card.skill_effect * (card.right.skill_multiplier + 1 - card.right.combat_multiplier);
					card.right.addRoundAccBoost(right_acc);
					card.right.appliedCombatSkills.add(card.skillID);
				}
				if(left_acc != 0 || right_acc != 0)
				{
					if(do_info)
					{
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
						if(left_acc != 0)
							info += card.left.name + "'s (" + card.left.x_coordinate + "|" + card.left.y_coordinate + ") ACC increased by " + (int) left_acc + "<br>\r";
						if(right_acc != 0)
							info += card.right.name + "'s (" + card.right.x_coordinate + "|" + card.right.y_coordinate + ") ACC increased by " + (int) right_acc + "<br>\r";
					}
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 53242)//Adjacent Dark ACC Up [Med] (R2-Q5)
			{
				double left_acc = 0, right_acc = 0;
				if(card.left != null && card.left.side == 'D' && !card.left.appliedSkill(card.skillID))
				{
					left_acc += card.left.baseAcc * card.skill_effect * (card.left.skill_multiplier + 1 - card.left.combat_multiplier);
					card.left.addRoundAccBoost(left_acc);
					card.left.appliedCombatSkills.add(card.skillID);
				}
				if(card.right != null && card.right.side == 'D' && !card.right.appliedSkill(card.skillID))
				{
					right_acc += card.right.baseAcc * card.skill_effect * (card.right.skill_multiplier + 1 - card.right.combat_multiplier);
					card.right.addRoundAccBoost(right_acc);
					card.right.appliedCombatSkills.add(card.skillID);
				}
				if(left_acc != 0 || right_acc != 0)
				{
					if(do_info)
					{
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
						if(left_acc != 0)
							info += card.left.name + "'s (" + card.left.x_coordinate + "|" + card.left.y_coordinate + ") ACC increased by " + (int) left_acc + "<br>\r";
						if(right_acc != 0)
							info += card.right.name + "'s (" + card.right.x_coordinate + "|" + card.right.y_coordinate + ") ACC increased by " + (int) right_acc + "<br>\r";
					}
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 61012)//Adjacent Galactic Republic ATK Up [Med] (Sen Palp)
			{
				double left_atk = 0, right_atk = 0;
				if(card.left != null && card.left.races[7] && !card.left.appliedSkill(card.skillID))
				{
					left_atk += card.left.baseAtk * card.skill_effect * (card.left.skill_multiplier + 1 - card.left.combat_multiplier);
					card.left.addRoundAtkBoost(left_atk);
					card.left.appliedCombatSkills.add(card.skillID);
				}
				if(card.right != null && card.right.races[7] && !card.right.appliedSkill(card.skillID))
				{
					right_atk += card.right.baseAtk * card.skill_effect * (card.right.skill_multiplier + 1 - card.right.combat_multiplier);
					card.right.addRoundAtkBoost(right_atk);
					card.right.appliedCombatSkills.add(card.skillID);
				}
				if(left_atk != 0 || right_atk != 0)
				{
					if(do_info)
					{
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
						if(left_atk != 0)
							info += card.left.name + "'s (" + card.left.x_coordinate + "|" + card.left.y_coordinate + ") ATK increased by " + (int) left_atk + "<br>\r";
						if(right_atk != 0)
							info += card.right.name + "'s (" + card.right.x_coordinate + "|" + card.right.y_coordinate + ") ATK increased by " + (int) right_atk + "<br>\r";
					}
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 61022)//Adjacent Separatist ATK Up [Med] (Nute)
			{
				double left_atk = 0, right_atk = 0;
				if(card.left != null && card.left.races[6] && !card.left.appliedSkill(card.skillID))
				{
					left_atk += card.left.baseAtk * card.skill_effect * (card.left.skill_multiplier + 1 - card.left.combat_multiplier);
					card.left.addRoundAtkBoost(left_atk);
					card.left.appliedCombatSkills.add(card.skillID);
				}
				if(card.right != null && card.right.races[6] && !card.right.appliedSkill(card.skillID))
				{
					right_atk += card.right.baseAtk * card.skill_effect * (card.right.skill_multiplier + 1 - card.right.combat_multiplier);
					card.right.addRoundAtkBoost(right_atk);
					card.right.appliedCombatSkills.add(card.skillID);
				}
				if(left_atk != 0 || right_atk != 0)
				{
					if(do_info)
					{
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
						if(left_atk != 0)
							info += card.left.name + "'s (" + card.left.x_coordinate + "|" + card.left.y_coordinate + ") ATK increased by " + (int) left_atk + "<br>\r";
						if(right_atk != 0)
							info += card.right.name + "'s (" + card.right.x_coordinate + "|" + card.right.y_coordinate + ") ATK increased by " + (int) right_atk + "<br>\r";
					}
					return true;
				}
				return false;
			}
			else if(card.skillID == 61031 && card.front != null)//3-Unit Clone Trooper ATK Up [Sml] (Appo)
			{
				double front_atk = 0, left_atk = 0, right_atk = 0;
				String front = "", left = "", right = "";
				if(card.front.races[12] && !card.front.appliedSkill(card.skillID))
				{
					front_atk += card.front.baseAtk * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAtkBoost(front_atk);
					card.front.appliedCombatSkills.add(card.skillID);	
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") ATK increased by " + (int) front_atk + "<br>\r";
				}
				if(card.front.left != null && card.front.left.races[12] && !card.front.left.appliedSkill(card.skillID))
				{
					left_atk += card.front.left.baseAtk * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAtkBoost(left_atk);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") ATK increased by " + (int) left_atk + "<br>\r";
				}
				if(card.front.right != null && card.front.right.races[12] && !card.front.right.appliedSkill(card.skillID))
				{
					right_atk += card.front.right.baseAtk * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAtkBoost(right_atk);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") ATK increased by " + (int) right_atk + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 61041 && card.front != null)//3-Unit Wookiee ATK Up [Sml] (Chewie HoK)
			{
				double front_atk = 0, left_atk = 0, right_atk = 0;
				String front = "", left = "", right = "";
				if(card.front.races[5] && !card.front.appliedSkill(card.skillID))
				{
					front_atk += card.front.baseAtk * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAtkBoost(front_atk);
					card.front.appliedCombatSkills.add(card.skillID);	
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") ATK increased by " + (int) front_atk + "<br>\r";
				}
				if(card.front.left != null && card.front.left.races[5] && !card.front.left.appliedSkill(card.skillID))
				{
					left_atk += card.front.left.baseAtk * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAtkBoost(left_atk);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") ATK increased by " + (int) left_atk + "<br>\r";
				}
				if(card.front.right != null && card.front.right.races[5] && !card.front.right.appliedSkill(card.skillID))
				{
					right_atk += card.front.right.baseAtk * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAtkBoost(right_atk);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") ATK increased by " + (int) right_atk + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 61061 && card.front != null && !card.front.appliedSkill(card.skillID))//3-Unit Jabba's Crime Syndicate ATK Up [Sml] (Bib Majordomo)
			{
				double front_atk = 0, left_atk = 0, right_atk = 0;
				String front = "", left = "", right = "";
				if(card.front.races[3] && !card.front.appliedSkill(card.skillID))
				{
					front_atk += card.front.baseAtk * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAtkBoost(front_atk);
					card.front.appliedCombatSkills.add(card.skillID);	
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") ATK increased by " + (int) front_atk + "<br>\r";
				}
				if(card.front.left != null && card.front.left.races[3] && !card.front.left.appliedSkill(card.skillID))
				{
					left_atk += card.front.left.baseAtk * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAtkBoost(left_atk);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") ATK increased by " + (int) left_atk + "<br>\r";
				}
				if(card.front.right != null && card.front.right.races[3] && !card.front.right.appliedSkill(card.skillID))
				{
					right_atk += card.front.right.baseAtk * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAtkBoost(right_atk);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") ATK increased by " + (int) right_atk + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 61081)//Adjacent Rebel Alliance ATK Up [Sml] (Orrimaarko)
			{
				double left_atk = 0, right_atk = 0;
				if(card.left != null && card.left.races[9] && !card.left.appliedSkill(card.skillID))
				{
					left_atk += card.left.baseAtk * card.skill_effect * (card.left.skill_multiplier + 1 - card.left.combat_multiplier);
					card.left.addRoundAtkBoost(left_atk);
					card.left.appliedCombatSkills.add(card.skillID);
				}
				if(card.right != null && card.right.races[9] && !card.right.appliedSkill(card.skillID))
				{
					right_atk += card.right.baseAtk * card.skill_effect * (card.right.skill_multiplier + 1 - card.right.combat_multiplier);
					card.right.addRoundAtkBoost(right_atk);
					card.right.appliedCombatSkills.add(card.skillID);
				}
				if(left_atk != 0 || right_atk != 0)
				{
					if(do_info)
					{
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
						if(left_atk != 0)
							info += card.left.name + "'s (" + card.left.x_coordinate + "|" + card.left.y_coordinate + ") ATK increased by " + (int) left_atk + "<br>\r";
						if(right_atk != 0)
							info += card.right.name + "'s (" + card.right.x_coordinate + "|" + card.right.y_coordinate + ") ATK increased by " + (int) right_atk + "<br>\r";
					}
					return true;
				}
				return false;
			}
			else if(card.skillID == 61091)//Adjacent Galactic Empire ATK Up [Sml] (Sim)
			{
				double left_atk = 0, right_atk = 0;
				if(card.left != null && card.left.races[8] && !card.left.appliedSkill(card.skillID))
				{
					left_atk += card.left.baseAtk * card.skill_effect * (card.left.skill_multiplier + 1 - card.left.combat_multiplier);
					card.left.addRoundAtkBoost(left_atk);
					card.left.appliedCombatSkills.add(card.skillID);
				}
				if(card.right != null && card.right.races[8] && !card.right.appliedSkill(card.skillID))
				{
					right_atk += card.right.baseAtk * card.skill_effect * (card.right.skill_multiplier + 1 - card.right.combat_multiplier);
					card.right.addRoundAtkBoost(right_atk);
					card.right.appliedCombatSkills.add(card.skillID);
				}
				if(left_atk != 0 || right_atk != 0)
				{
					if(do_info)
					{
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
						if(left_atk != 0)
							info += card.left.name + "'s (" + card.left.x_coordinate + "|" + card.left.y_coordinate + ") ATK increased by " + (int) left_atk + "<br>\r";
						if(right_atk != 0)
							info += card.right.name + "'s (" + card.right.x_coordinate + "|" + card.right.y_coordinate + ") ATK increased by " + (int) right_atk + "<br>\r";
					}
					return true;
				}
				return false;
			}
			else if(card.skillID == 61131 && card.front != null)//3-Unit Clone Trooper DEF Up [Sml] (Thire)
			{
				double front_def = 0, left_def = 0, right_def = 0;
				String front = "", left = "", right = "";
				if(card.front.races[12] && !card.front.appliedSkill(card.skillID))
				{
					front_def += card.front.baseDef * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundDefBoost(front_def);
					card.front.appliedCombatSkills.add(card.skillID);	
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") DEF increased by " + (int) front_def + "<br>\r";
				}
				if(card.front.left != null && card.front.left.races[12] && !card.front.left.appliedSkill(card.skillID))
				{
					left_def += card.front.left.baseDef * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundDefBoost(left_def);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") DEF increased by " + (int) left_def + "<br>\r";
				}
				if(card.front.right != null && card.front.right.races[12] && !card.front.right.appliedSkill(card.skillID))
				{
					right_def += card.front.right.baseDef * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundDefBoost(right_def);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") DEF increased by " + (int) right_def + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 61151 && card.front != null)//3-Unit Bounty Hunter DEF Up [Sml] (Boba Kid)
			{
				double front_def = 0, left_def = 0, right_def = 0;
				String front = "", left = "", right = "";
				if(card.front.races[15] && !card.front.appliedSkill(card.skillID))
				{
					front_def += card.front.baseDef * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundDefBoost(front_def);
					card.front.appliedCombatSkills.add(card.skillID);	
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") DEF increased by " + (int) front_def + "<br>\r";
				}
				if(card.front.left != null && card.front.left.races[15] && !card.front.left.appliedSkill(card.skillID))
				{
					left_def += card.front.left.baseDef * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundDefBoost(left_def);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") DEF increased by " + (int) left_def + "<br>\r";
				}
				if(card.front.right != null && card.front.right.races[15] && !card.front.right.appliedSkill(card.skillID))
				{
					right_def += card.front.right.baseDef * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundDefBoost(right_def);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") DEF increased by " + (int) right_def + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 61401 && card.front != null)//3-Unit Beast All Stats Up [Sml] (Malakili)
			{
				double front_atk = 0, front_acc = 0, front_eva = 0, front_def = 0, left_atk = 0, left_acc = 0, left_eva = 0, left_def = 0, right_atk = 0, right_acc = 0, right_eva = 0, right_def = 0;
				String front = "", left = "", right = "";
				if(card.front.races[14] && !card.front.appliedSkill(card.skillID))
				{
					front_atk += card.front.baseAtk * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAtkBoost(front_atk);
					front_acc += card.front.baseAcc * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAccBoost(front_acc);
					front_eva += card.front.baseEva * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundEvaBoost(front_eva);
					front_def += card.front.baseDef * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundDefBoost(front_def);
					card.front.appliedCombatSkills.add(card.skillID);
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) front_atk + " / " + (int) front_def + " / " + (int) front_acc + " / " + (int) front_eva + "<br>\r";
				}
				if(card.front.left != null && card.front.left.races[14] && !card.front.left.appliedSkill(card.skillID))
				{
					left_atk += card.front.left.baseAtk * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAtkBoost(left_atk);
					left_acc += card.front.left.baseAcc * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAccBoost(left_acc);
					left_eva += card.front.left.baseEva * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundEvaBoost(left_eva);
					left_def += card.front.left.baseDef * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundDefBoost(left_def);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) left_atk + " / " + (int) left_def + " / " + (int) left_acc + " / " + (int) left_eva + "<br>\r";
				}
				if(card.front.right != null && card.front.right.races[14] && !card.front.right.appliedSkill(card.skillID))
				{
					right_atk += card.front.right.baseAtk * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAtkBoost(right_atk);
					right_acc += card.front.right.baseAcc * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAccBoost(right_acc);
					right_eva += card.front.right.baseEva * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundEvaBoost(right_eva);
					right_def += card.front.right.baseDef * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundDefBoost(right_def);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) right_atk + " / " + (int) right_def + " / " + (int) right_acc + " / " + (int) right_eva + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 61481 && card.front != null)//3-Unit Gungan All Stats Up [Sml]
			{
				double front_atk = 0, front_acc = 0, front_eva = 0, front_def = 0, left_atk = 0, left_acc = 0, left_eva = 0, left_def = 0, right_atk = 0, right_acc = 0, right_eva = 0, right_def = 0;
				String front = "", left = "", right = "";
				if(card.front.races[11] && !card.front.appliedSkill(card.skillID))
				{
					front_atk += card.front.baseAtk * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAtkBoost(front_atk);
					front_acc += card.front.baseAcc * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAccBoost(front_acc);
					front_eva += card.front.baseEva * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundEvaBoost(front_eva);
					front_def += card.front.baseDef * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundDefBoost(front_def);
					card.front.appliedCombatSkills.add(card.skillID);
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) front_atk + " / " + (int) front_def + " / " + (int) front_acc + " / " + (int) front_eva + "<br>\r";
				}
				if(card.front.left != null && card.front.left.races[11] && !card.front.left.appliedSkill(card.skillID))
				{
					left_atk += card.front.left.baseAtk * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAtkBoost(left_atk);
					left_acc += card.front.left.baseAcc * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAccBoost(left_acc);
					left_eva += card.front.left.baseEva * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundEvaBoost(left_eva);
					left_def += card.front.left.baseDef * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundDefBoost(left_def);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) left_atk + " / " + (int) left_def + " / " + (int) left_acc + " / " + (int) left_eva + "<br>\r";
				}
				if(card.front.right != null && card.front.right.races[11] && !card.front.right.appliedSkill(card.skillID))
				{
					right_atk += card.front.right.baseAtk * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAtkBoost(right_atk);
					right_acc += card.front.right.baseAcc * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAccBoost(right_acc);
					right_eva += card.front.right.baseEva * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundEvaBoost(right_eva);
					right_def += card.front.right.baseDef * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundDefBoost(right_def);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) right_atk + " / " + (int) right_def + " / " + (int) right_acc + " / " + (int) right_eva + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 61472 && card.front != null)//3-Unit Ewok All Stats Up [Med] (Zephee)
			{
				double front_atk = 0, front_acc = 0, front_eva = 0, front_def = 0, left_atk = 0, left_acc = 0, left_eva = 0, left_def = 0, right_atk = 0, right_acc = 0, right_eva = 0, right_def = 0;
				String front = "", left = "", right = "";
				if(card.front.races[13] && !card.front.appliedSkill(card.skillID))
				{
					front_atk += card.front.baseAtk * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAtkBoost(front_atk);
					front_acc += card.front.baseAcc * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundAccBoost(front_acc);
					front_eva += card.front.baseEva * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundEvaBoost(front_eva);
					front_def += card.front.baseDef * card.skill_effect * (card.front.skill_multiplier + 1 - card.front.combat_multiplier);
					card.front.addRoundDefBoost(front_def);
					card.front.appliedCombatSkills.add(card.skillID);
					if(do_info)
						front += card.front.name + "'s (" + card.front.x_coordinate + "|" + card.front.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) front_atk + " / " + (int) front_def + " / " + (int) front_acc + " / " + (int) front_eva + "<br>\r";
				}
				if(card.front.left != null && card.front.left.races[13] && !card.front.left.appliedSkill(card.skillID))
				{
					left_atk += card.front.left.baseAtk * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAtkBoost(left_atk);
					left_acc += card.front.left.baseAcc * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundAccBoost(left_acc);
					left_eva += card.front.left.baseEva * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundEvaBoost(left_eva);
					left_def += card.front.left.baseDef * card.skill_effect * (card.front.left.skill_multiplier + 1 - card.front.left.combat_multiplier);
					card.front.left.addRoundDefBoost(left_def);
					card.front.left.appliedCombatSkills.add(card.skillID);
					if(do_info)
						left += card.front.left.name + "'s (" + card.front.left.x_coordinate + "|" + card.front.left.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) left_atk + " / " + (int) left_def + " / " + (int) left_acc + " / " + (int) left_eva + "<br>\r";
				}
				if(card.front.right != null && card.front.right.races[13] && !card.front.right.appliedSkill(card.skillID))
				{
					right_atk += card.front.right.baseAtk * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAtkBoost(right_atk);
					right_acc += card.front.right.baseAcc * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundAccBoost(right_acc);
					right_eva += card.front.right.baseEva * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundEvaBoost(right_eva);
					right_def += card.front.right.baseDef * card.skill_effect * (card.front.right.skill_multiplier + 1 - card.front.right.combat_multiplier);
					card.front.right.addRoundDefBoost(right_def);
					card.front.right.appliedCombatSkills.add(card.skillID);
					if(do_info)
						right += card.front.right.name + "'s (" + card.front.right.x_coordinate + "|" + card.front.right.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) right_atk + " / " + (int) right_def + " / " + (int) right_acc + " / " + (int) right_eva + "<br>\r";
				}
				if(do_info && (front != "" || right != "" || left != ""))
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r" + left + front + right;
				return true;
			}
			else if(card.skillID == 62401 && ownFormation.leader.alive()  && !ownFormation.leader.appliedSkill(card.skillID))//Attendant (C3R2)
			{
				double atk_boost = 0, acc_boost = 0, def_boost = 0, eva_boost = 0;
				atk_boost += ownFormation.leader.baseAtk * card.skill_effect * (ownFormation.leader.skill_multiplier + 1 - ownFormation.leader.combat_multiplier);
				ownFormation.leader.addRoundAtkBoost(atk_boost);
				acc_boost += ownFormation.leader.baseAcc * card.skill_effect * (ownFormation.leader.skill_multiplier + 1 - ownFormation.leader.combat_multiplier);
				ownFormation.leader.addRoundAccBoost(acc_boost);
				eva_boost += ownFormation.leader.baseEva * card.skill_effect * (ownFormation.leader.skill_multiplier + 1 - ownFormation.leader.combat_multiplier);
				ownFormation.leader.addRoundEvaBoost(eva_boost);
				def_boost += ownFormation.leader.baseDef * card.skill_effect * (ownFormation.leader.skill_multiplier + 1 - ownFormation.leader.combat_multiplier);
				ownFormation.leader.addRoundDefBoost(def_boost);
				ownFormation.leader.appliedCombatSkills.add(card.skillID);
				if(do_info)
				{
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
					info += ownFormation.leader.name + "'s (" + ownFormation.leader.x_coordinate + "|" + ownFormation.leader.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) atk_boost + " / " + (int) def_boost + " / " + (int) acc_boost + " / " + (int) eva_boost + "<br>\r";
				}
				return true;
			}
			else if(card.skillID == 45002 && card.front == null)//3-Unit Combat Skill Effect Down [Med] (Lumi/ToW)
			{
				card enemy;
				if(card.y_coordinate < 16)
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate+1];
				}
				else
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate-1];
				}
				if(enemy != null)
				{
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
					if(!enemy.appliedSkill(card.skillID))
					{
						if(do_info)		
							info += "All combat skills that affect " + enemy.name + " (" + enemy.x_coordinate + "|" + enemy.y_coordinate + ") decreased by 15.0%<br>\r";
						enemy.combat_multiplier -= card.skill_effect;
						enemy.appliedCombatSkills.add(card.skillID);
					}
					if(enemy.left != null && !enemy.left.appliedSkill(card.skillID))
					{
						if(do_info)		
							info += "All combat skills that affect " + enemy.left.name + " (" + enemy.left.x_coordinate + "|" + enemy.left.y_coordinate + ") decreased by 15.0%<br>\r";
						enemy.left.combat_multiplier -= card.skill_effect;
						enemy.left.appliedCombatSkills.add(card.skillID);
					}
					if(enemy.right != null && !enemy.right.appliedSkill(card.skillID))
					{
						if(do_info)		
							info += "All combat skills that affect " + enemy.right.name + " (" + enemy.right.x_coordinate + "|" + enemy.right.y_coordinate + ") decreased by 15.0%<br>\r";
						enemy.right.combat_multiplier -= card.skill_effect;
						enemy.right.appliedCombatSkills.add(card.skillID);
					}
				}
				return true;
			}
			else if(card.skillID == 32701)//Counter Attack [Sml]
			{
				double eva_boost = 0;
				eva_boost += card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundEvaBoost(eva_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! EVA boosted by " + (int) eva_boost + ". Unit is about to perform a counter attack!<br>\r"; 
				return true;
			}
			else if(card.skillID == 32702)//Counter Attack [Med]
			{
				double eva_boost = 0;
				eva_boost += card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundEvaBoost(eva_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! EVA boosted by " + (int) eva_boost + ". Unit is about to perform a counter attack!<br>\r"; 
				return true;
			}
			else if(card.skillID == 40001)//Blaster Reflection [Sml]
			{
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! Unit is about to reflect all blaster shots!<br>\r"; 
				return true;
			}
			else if(card.skillID == 40002)//Blaster Reflection [Med]
			{
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! Unit is about to reflect all blaster shots!<br>\r"; 
				return true;
			}
			else if(card.skillID == 32401)//Minion Shield (ggec)
			{
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! Unit is about to transfer all received damage to an adjacent Droid unit!<br>\r"; 
				return true;
			}
			else if(card.skillID == 32601 && card.front == null)//Jedi Purge (Vader MoE)
			{
				card enemy;
				if(card.y_coordinate < 16)
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate+1];
				}
				else
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate-1];
				}
				if(enemy != null && enemy.races[18])
				{
					double atk_boost, def_boost, acc_boost, eva_boost = 0.0;
					atk_boost = card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					def_boost = card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					acc_boost = card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					eva_boost = card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					card.addRoundAtkBoost(atk_boost);
					card.addRoundDefBoost(def_boost);
					card.addRoundAccBoost(acc_boost);
					card.addRoundEvaBoost(eva_boost);
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", DEF boosted by " + (int) def_boost + ", ACC boosted by " + (int) acc_boost + ", EVA boosted by " + (int) eva_boost + "<br>\r"; 
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 33301)//Form 2 (Dooku EoR)
			{
				return true;	
			}
			else if(card.skillID == 33001)//Concentrated Fire (Rex)//TODO do they stack?
			{
				card enemy;
				if(card.y_coordinate < 16)
				{
					enemy = battlefield[card.x_coordinate][16];
				}
				else
				{
					int upperFrontRow = 0;
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
					enemy = battlefield[card.x_coordinate][upperFrontRow];
				}
				if(enemy != null)
				{
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
					if(!card.appliedSkill(card.skillID))
					{
						double acc_boost = 0;
						acc_boost += card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
						card.addRoundAccBoost(acc_boost);
						card.concentrated_fire = card.x_coordinate;
						card.friendly_fire = 0;
						card.appliedCombatSkills.add(card.skillID);
						if(do_info)		
							info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") ACC increased by " + (int) acc_boost + ". Unit concentrates fire at spot " + card.concentrated_fire + "<br>\r";
					}
					for(int i = 0; i < ownFormation.cards.size(); i++)
					{
						if(ownFormation.cards.get(i) != null && ownFormation.cards.get(i).races[12] && Math.abs(ownFormation.cards.get(i).x_coordinate - card.x_coordinate) <= 1 && !ownFormation.cards.get(i).appliedSkill(card.skillID))
						{
							double acc_boost = 0;
							acc_boost += ownFormation.cards.get(i).baseAcc * card.skill_effect * (ownFormation.cards.get(i).skill_multiplier + 1 - ownFormation.cards.get(i).combat_multiplier);
							ownFormation.cards.get(i).addRoundAccBoost(acc_boost);
							ownFormation.cards.get(i).concentrated_fire = card.x_coordinate;
							ownFormation.cards.get(i).friendly_fire = 0;
							ownFormation.cards.get(i).appliedCombatSkills.add(card.skillID);
							if(do_info)		
								info += ownFormation.cards.get(i).name + "'s (" + ownFormation.cards.get(i).x_coordinate + "|" + ownFormation.cards.get(i).y_coordinate + ") ACC increased by " + (int) acc_boost + ". Unit concentrates fire at spot " + ownFormation.cards.get(i).concentrated_fire + "<br>\r";
						}
					}
					return true;
				}
			}
			else if(card.skillID == 34101)//Concentrated Fire (Kalani)//TODO
			{
				card enemy;
				if(card.y_coordinate < 16)
				{
					enemy = battlefield[card.x_coordinate][16];
				}
				else
				{
					int upperFrontRow = 0;
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
					enemy = battlefield[card.x_coordinate][upperFrontRow];
				}
				if(enemy != null)
				{
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
					if(!card.appliedSkill(card.skillID))
					{
						double acc_boost = 0;
						acc_boost += card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
						card.addRoundAccBoost(acc_boost);
						card.concentrated_fire = card.x_coordinate;
						card.friendly_fire = 0;
						card.appliedCombatSkills.add(card.skillID);
						if(do_info)		
							info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") ACC increased by " + (int) acc_boost + ". Unit concentrates fire at spot " + card.concentrated_fire + "<br>\r";
					}
					for(int i = 0; i < ownFormation.cards.size(); i++)
					{
						if(ownFormation.cards.get(i) != null && ownFormation.cards.get(i).races[6] && ownFormation.cards.get(i).races[21] && Math.abs(ownFormation.cards.get(i).x_coordinate - card.x_coordinate) <= 1 && !ownFormation.cards.get(i).appliedSkill(card.skillID))
						{
							double acc_boost = 0;
							acc_boost += ownFormation.cards.get(i).baseAcc * card.skill_effect * (ownFormation.cards.get(i).skill_multiplier + 1 - ownFormation.cards.get(i).combat_multiplier);
							ownFormation.cards.get(i).addRoundAccBoost(acc_boost);
							ownFormation.cards.get(i).concentrated_fire = card.x_coordinate;
							ownFormation.cards.get(i).friendly_fire = 0;
							ownFormation.cards.get(i).appliedCombatSkills.add(card.skillID);
							if(do_info)		
								info += ownFormation.cards.get(i).name + "'s (" + ownFormation.cards.get(i).x_coordinate + "|" + ownFormation.cards.get(i).y_coordinate + ") ACC increased by " + (int) acc_boost + ". Unit concentrates fire at spot " + ownFormation.cards.get(i).concentrated_fire + "<br>\r";
						}
					}
					return true;
				}
			}
			else if(card.skillID == 34201 && card.front == null)//Guardian (Shaak Ti)
			{
				int defenderFrontRow = card.y_coordinate-1;
				if(card.y_coordinate < 16)
				{
					defenderFrontRow = card.y_coordinate+1;
				}
				if((battlefield[card.x_coordinate][defenderFrontRow] != null && battlefield[card.x_coordinate][defenderFrontRow].range == 'S') || (card.x_coordinate > 0 && battlefield[card.x_coordinate-1][defenderFrontRow] != null && battlefield[card.x_coordinate-1][defenderFrontRow].range == 'S') || (card.x_coordinate < 5 && battlefield[card.x_coordinate+1][defenderFrontRow] != null && battlefield[card.x_coordinate+1][defenderFrontRow].range == 'S'))
				{
					double def_boost = 0;
					def_boost += card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					card.addRoundDefBoost(def_boost);
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! DEF boosted by " + (int) def_boost + ". Unit will engage the attacks from the short ranged units directly and diagonally in front<br>\r"; 
					return true;
				}
			}
			else if(card.skillID == 32201)//Golden God (C-3PO)
			{
				double eva_boost = 0;
				eva_boost += card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundEvaBoost(eva_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! EVA boosted by " + (int) eva_boost + ". Unit has become a decoy and will engage the attacks from enemy units<br>\r"; 
				return true;
			}
			else if(card.skillID == 34701)//Barrage (Aurra HG, Chewie HR)
			{
				double atk_boost = 0;
				atk_boost += card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAtkBoost(atk_boost);
				card.addRoundFreqBoost(4);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ". Unit's attack frequency increased by 4 for this turn<br>\r"; 
				return true;
			}
			else if(card.skillID == 34601)//Dauntless Heroine(Padme RS)//TODO
			{
				double left_atk = 0, right_atk = 0, left_def = 0, right_def = 0;
				int hit_multiplier = card.hits_received;
				if(hit_multiplier > 100)
					hit_multiplier = 100;
				if(card.left != null && card.left.side == 'L' && !card.left.appliedSkill(card.skillID))
				{
					left_atk += card.left.baseAtk * card.skill_effect / 100 * hit_multiplier *  (card.left.skill_multiplier + 1 - card.left.combat_multiplier);
					card.left.addRoundAtkBoost(left_atk);
					left_def += card.left.baseDef * card.skill_effect / 100 * hit_multiplier *  (card.left.skill_multiplier + 1 - card.left.combat_multiplier);
					card.left.addRoundDefBoost(left_def);
					card.left.appliedCombatSkills.add(card.skillID);
				}
				if(card.right != null && card.right.side == 'L' && !card.right.appliedSkill(card.skillID))
				{
					right_atk += card.right.baseAtk * card.skill_effect / 100 * hit_multiplier *  (card.right.skill_multiplier + 1 - card.right.combat_multiplier);
					card.right.addRoundAtkBoost(right_atk);
					right_def += card.right.baseDef * card.skill_effect / 100 * hit_multiplier *  (card.right.skill_multiplier + 1 - card.right.combat_multiplier);
					card.right.addRoundDefBoost(right_def);
					card.right.appliedCombatSkills.add(card.skillID);
				}
				if(left_atk != 0 || right_atk != 0)
				{
					if(do_info)
					{
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
						if(left_atk != 0)
							info += card.left.name + "'s (" + card.left.x_coordinate + "|" + card.left.y_coordinate + ") ATK / DEF increased by " + (int) left_atk + " / " + (int) left_def + "<br>\r";
						if(right_atk != 0)
							info += card.right.name + "'s (" + card.right.x_coordinate + "|" + card.right.y_coordinate + ") ATK / DEF increased by " + (int) right_atk + " / " + (int) right_def + "<br>\r";
					}
					return true;
				}
				return false;
			}
			else if(card.skillID == 33401)//One with the Force (Ben)//TODO
			{
				if(card.revived)
				{
					for(int i = 0; i < ownCards.size(); i++)
					{
						if(ownCards.get(i) != null && ownCards.get(i).alive() && ownCards.get(i).races[18])
						{
							ownCards.get(i).addRoundAtkBoost(ownCards.get(i).baseAtk * card.skill_effect * (ownCards.get(i).skill_multiplier + 1 - ownCards.get(i).combat_multiplier));
							ownCards.get(i).addRoundDefBoost(ownCards.get(i).baseDef * card.skill_effect * (ownCards.get(i).skill_multiplier + 1 - ownCards.get(i).combat_multiplier));
							ownCards.get(i).addRoundAccBoost(ownCards.get(i).baseAcc * card.skill_effect * (ownCards.get(i).skill_multiplier + 1 - ownCards.get(i).combat_multiplier));
							ownCards.get(i).addRoundEvaBoost(ownCards.get(i).baseEva * card.skill_effect * (ownCards.get(i).skill_multiplier + 1 - ownCards.get(i).combat_multiplier));
							ownCards.get(i).appliedCombatSkills.add(card.skillID);
						}
					}
					return true;
				}
			}
			else if(card.skillID == 34901)//Tempter of Fate (Boba DfH)
			{
				double multiplier = 1.0, eva_boost = 0;
				if(card.front != null && card.front.front != null)
				{
					multiplier /= 3.0;
				}
				else if(card.front != null)
				{
					multiplier /= 2.0;
				}
				eva_boost += card.baseEva * multiplier * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundEvaBoost(eva_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! EVA boosted by " + (int) eva_boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 34801 && enemyFormation.classInFormation(8))//Rebel Spirit (Leia SC)
			{
				double atk_boost = 0, acc_boost = 0;
				atk_boost += card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAtkBoost(atk_boost);
				acc_boost += card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAccBoost(acc_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", ACC boosted by " + (int) acc_boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 35001 && card.front == null)//Joined Fates (VaderPalp)//TODO
			{
				card enemy;
				if(card.y_coordinate < 16)
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate+1];
				}
				else
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate-1];
				}
				if(enemy != null)
				{
					enemy.hp = -1;
					card.hp = -1;
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 41101)//Predator (Rancor)
			{
				if(card.front == null)
				{
					card enemy;
					if(card.y_coordinate < 16)
						enemy = battlefield[card.x_coordinate][card.y_coordinate+1];
					else
						enemy = battlefield[card.x_coordinate][card.y_coordinate-1];
					if(enemy != null && (enemy.races[23] || enemy.races[22] || enemy.races[14]) && ((enemy.hp / enemy.max_hp) < (card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier))))
					{
						if(do_info)
							info += card.name + " is about to devour an enemy unit!<br>\r";
						return true;
					}
					else
						return false;
				}
			}
			else if(card.skillID == 35101)//Rule of Two (Sid RA)
			{
				int total_sith = 0, own_sith = 0, enemy_sith = 0;
				for(int i = 0; i < ownFormation.cards.size(); i++)
				{
					if(ownFormation.cards.get(i) != null && ownFormation.cards.get(i).races[17])
						own_sith++;
				}
				for(int i = 0; i < enemyFormation.cards.size(); i++)
				{
					if(enemyFormation.cards.get(i) != null && enemyFormation.cards.get(i).races[17])
						enemy_sith++;
				}
				total_sith = own_sith + enemy_sith;
				if(total_sith >= 3 && own_sith <= 2)
				{
					double atk_boost, def_boost, acc_boost, eva_boost = 0;
					atk_boost = card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					def_boost = card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					acc_boost = card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					eva_boost = card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					card.addRoundAtkBoost(atk_boost);
					card.addRoundDefBoost(def_boost);
					card.addRoundAccBoost(acc_boost);
					card.addRoundEvaBoost(eva_boost);
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", DEF boosted by " + (int) def_boost + ", ACC boosted by " + (int) acc_boost + ", EVA boosted by " + (int) eva_boost + "<br>\r"; 
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 35201 && enemyFormation.classInFormation(12))//Friendly Fire (Pong Krell)
			{
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated:<br>\r";
				for(int i = 0; i < enemyFormation.cards.size(); i++)
				{
					if(enemyFormation.cards.get(i) != null && enemyFormation.cards.get(i).races[12] && enemyFormation.cards.get(i).concentrated_fire == -1 && !enemyFormation.cards.get(i).champion)
					{
						double acc_stat = card.skill_effect * (enemyFormation.cards.get(i).skill_multiplier + 1 - enemyFormation.cards.get(i).combat_multiplier);
						enemyFormation.cards.get(i).friendly_fire = acc_stat;
						card.appliedCombatSkills.add(card.skillID);
						if(do_info)
							info += enemyFormation.cards.get(i).name + "'s (" + enemyFormation.cards.get(i).x_coordinate + "|" + enemyFormation.cards.get(i).y_coordinate + ") is about to attack a friendly unit with " + Math.round(acc_stat * 100) + "% ACC<br>\r";
					}
				}
				return true;
			}
			else if(card.skillID == 35701)//Daredevil (Quinlan)
			{
				card enemy = null;
				if(card.y_coordinate > 15)//Lower formation
				{
					for(int i = 15; i >= 0; i--)//Find the upper formation's front row
					{
						if(battlefield[card.x_coordinate][i] != null)
						{
							enemy = battlefield[card.x_coordinate][i];
							break;
						}
					}
				}
				else
				{
					enemy = battlefield[card.x_coordinate][16];
				}
				if(enemy != null && enemy.baseAtk > card.baseAtk && enemy.baseDef > card.baseDef)
				{
					double atk_boost = 0, def_boost = 0;
					atk_boost += (enemy.baseAtk-card.baseAtk) * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					card.addRoundAtkBoost(atk_boost);
					def_boost += (enemy.baseDef-card.baseDef) * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					card.addRoundDefBoost(def_boost);
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", DEF boosted by " + (int) def_boost + "<br>\r"; 
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 35801 && card.front == null)//Darksaber (Pre Viszla)
			{
				card enemy;
				if(card.y_coordinate < 16)
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate+1];
				}
				else
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate-1];
				}
				if(enemy != null && ((enemy.weapon_type < 30 || enemy.weapon_type == 215) || (enemy.right != null && (enemy.right.weapon_type < 30 || enemy.right.weapon_type == 215)) || (enemy.left != null && (enemy.left.weapon_type < 30 || enemy.left.weapon_type == 215))))
				{
					double acc_decrease1 = 0, acc_decrease2 = 0, acc_decrease3 = 0, acc_decrease4 = 0;
					acc_decrease1 += card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					card.addRoundAccBoost(-acc_decrease1);
					if(do_info)
					{
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") ACC decreased by " + (int) acc_decrease1 + "<br>\r";
					}
					if(!enemy.appliedSkill(card.skillID))
					{
						acc_decrease2 += enemy.baseAcc * card.skill_effect * (enemy.skill_multiplier + 1 - enemy.combat_multiplier);
						enemy.addRoundAccBoost(-acc_decrease2);
						if(do_info)		
							info += enemy.name + "'s (" + enemy.x_coordinate + "|" + enemy.y_coordinate + ") ACC decreased by " + (int) acc_decrease2 + "<br>\r";
						enemy.appliedCombatSkills.add(card.skillID);
					}
					if(enemy.left != null && !enemy.left.appliedSkill(card.skillID))
					{
						acc_decrease3 += enemy.left.baseAcc * card.skill_effect * (enemy.left.skill_multiplier + 1 - enemy.left.combat_multiplier);
						enemy.left.addRoundAccBoost(-acc_decrease3);
						if(do_info)		
							info += enemy.left.name + "'s (" + enemy.left.x_coordinate + "|" + enemy.left.y_coordinate + ") ACC decreased by " + (int) acc_decrease3 + "<br>\r";
						enemy.left.appliedCombatSkills.add(card.skillID);
					}
					if(enemy.right != null && !enemy.right.appliedSkill(card.skillID))
					{
						acc_decrease4 += enemy.right.baseAcc * card.skill_effect * (enemy.right.skill_multiplier + 1 - enemy.right.combat_multiplier);
						enemy.right.addRoundAccBoost(-acc_decrease4);
						if(do_info)		
							info += enemy.right.name + "'s (" + enemy.right.x_coordinate + "|" + enemy.right.y_coordinate + ") ACC decreased by " + (int) acc_decrease4 + "<br>\r";
						enemy.right.appliedCombatSkills.add(card.skillID);
					}
				}
				return true;
			}
			else if(card.skillID == 35401)//Form 3 (Luke Jedi Knight)
			{
				return true;
			}
			else if(card.skillID == 35501)//My Kind Of Scum (Jabba CL)
			{
				return true;
			}
			else if(card.skillID == 35901)//Champion (Aayla)
			{
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
				if(!card.appliedSkill(card.skillID))
				{
					double eva_boost = 0, def_boost = 0;
					eva_boost += card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					def_boost += card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					card.addRoundEvaBoost(eva_boost);
					card.addRoundDefBoost(def_boost);
					card.champion = true;
					card.friendly_fire = 0;
					card.appliedCombatSkills.add(card.skillID);
					if(do_info)		
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") DEF increased by " + (int) def_boost + ", EVA increased by " + (int) eva_boost + "<br>\r";
				}
				for(int i = 0; i < ownFormation.cards.size(); i++)
				{
					if(ownFormation.cards.get(i) != null && ownFormation.cards.get(i).races[7] && Math.abs(ownFormation.cards.get(i).x_coordinate - card.x_coordinate) <= 1 && !ownFormation.cards.get(i).appliedSkill(card.skillID))
					{
						double eva_boost = 0, def_boost = 0;
						eva_boost += ownFormation.cards.get(i).baseEva * card.skill_effect * (ownFormation.cards.get(i).skill_multiplier + 1 - ownFormation.cards.get(i).combat_multiplier);
						def_boost += ownFormation.cards.get(i).baseDef * card.skill_effect * (ownFormation.cards.get(i).skill_multiplier + 1 - ownFormation.cards.get(i).combat_multiplier);
						ownFormation.cards.get(i).addRoundEvaBoost(eva_boost);
						ownFormation.cards.get(i).addRoundDefBoost(def_boost);
						ownFormation.cards.get(i).champion = true;
						ownFormation.cards.get(i).friendly_fire = 0;
						ownFormation.cards.get(i).appliedCombatSkills.add(card.skillID);
						if(do_info)		
							info += ownFormation.cards.get(i).name + "'s (" + ownFormation.cards.get(i).x_coordinate + "|" + ownFormation.cards.get(i).y_coordinate + ") DEF increased by " + (int) def_boost + ", EVA increased by " + (int) eva_boost + "<br>\r";
					}
				}
				return true;
			}
			else if(card.skillID == 36001 && enemyFormation.classesInFormation(5, 16))//Betrayer (DS Barriss)
			{
				double atk_boost = 0.0, def_boost = 0.0;
				atk_boost = card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				def_boost = card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundAtkBoost(atk_boost);
				card.addRoundDefBoost(def_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! ATK boosted by " + (int) atk_boost + ", DEF boosted by " + (int) def_boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 36101)//Swindler (Lando CM)
			{
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! Unit about to execute a special attack<br>\r"; 
				return true;
			}
			else if(card.skillID == 36201)//Neural Inhibitor Launcher (IG-88B)
			{
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! Unit about to execute a special attack<br>\r"; 
				return true;
			}
			else if(card.skillID == 35601)//Strangle (Leia ATtS)
			{
				card enemy;
				String def_red = "";
				if(card.y_coordinate < 16)
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate+1];
				}
				else
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate-1];
				}
				if(enemy != null && (enemy.races[22] || enemy.races[23] || enemy.races[14]))
				{
					if(card.strangle_enemy == null || enemy == card.strangle_enemy)
					{
						card.strangle_damage += card.skill_effect * (enemy.skill_multiplier + 1 - enemy.combat_multiplier) * 50;
						if(card.strangle_damage > 750)
							card.strangle_damage = 750;
						card.strangle_eva += card.eva * 0.06;
					}
					else
					{
						card.strangle_damage = 50;
						card.strangle_eva = 0;
					}
					card.strangle_enemy = enemy;
					def_red += enemy.decreaseHp(card.strangle_damage);
					card.addRoundEvaBoost(-card.strangle_eva);
					if(do_info)
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! Inflicted " + (int) card.strangle_damage + " damage onto " + enemy.name + " (" + enemy.x_coordinate + "|" + enemy.y_coordinate + "). EVA decreased by " + (int) card.strangle_eva + def_red + "<br>\r"; 
					return true;	
				}
				else
					return false;
			}
			else if(card.skillID == 43301)//Same Column EVA Down [Sml] (Bane Malar)
			{
				card target = null;
				double eva_decrease = 0;
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
				for(int i = 0; i < battlefield[card.x_coordinate].length; i++)
				{
					if(battlefield[card.x_coordinate][i] != null && battlefield[card.x_coordinate][i].ownFormation != ownFormation)
					{
						target = battlefield[card.x_coordinate][i];
						if(target != null && !target.appliedSkill(card.skillID))
						{
							eva_decrease = target.baseEva * card.skill_effect * (target.skill_multiplier + 1 - target.combat_multiplier);
							target.addRoundEvaBoost(-eva_decrease);
							target.appliedCombatSkills.add(card.skillID);
							if(do_info)
								info += target.name + "'s (" + target.x_coordinate + "|" + target.y_coordinate + ") EVA decreased by " + (int) eva_decrease + "<br>\r";
						}
					}
				}
				return true;
			}
			else if(card.skillID == 43201)//Same Column ACC Down [Sml] (Boushh)
			{
				card target = null;
				double acc_decrease = 0;
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
				for(int i = 0; i < battlefield[card.x_coordinate].length; i++)
				{
					if(battlefield[card.x_coordinate][i] != null && battlefield[card.x_coordinate][i].ownFormation != ownFormation)
					{
						target = battlefield[card.x_coordinate][i];
						if(target != null && !target.appliedSkill(card.skillID))
						{
							acc_decrease = target.baseAcc * card.skill_effect * (target.skill_multiplier + 1 - target.combat_multiplier);
							target.addRoundAccBoost(-acc_decrease);
							target.appliedCombatSkills.add(card.skillID);
							if(do_info)
								info += target.name + "'s (" + target.x_coordinate + "|" + target.y_coordinate + ") ACC decreased by " + (int) acc_decrease + "<br>\r";
						}
					}
				}
				return true;
			}
			else if(card.skillID == 62131)//Adjacent Jabba's Crime Syndicate DEF Up [Sml] (Pagetti)
			{
				double left_def = 0, right_def = 0;
				if(card.left != null && card.left.races[3] && !card.left.appliedSkill(card.skillID))
				{
					left_def += card.left.baseDef * card.skill_effect * (card.left.skill_multiplier + 1 - card.left.combat_multiplier);
					card.left.addRoundDefBoost(left_def);
					card.left.appliedCombatSkills.add(card.skillID);
				}
				if(card.right != null && card.right.races[3] && !card.right.appliedSkill(card.skillID))
				{
					right_def += card.right.baseDef * card.skill_effect * (card.right.skill_multiplier + 1 - card.right.combat_multiplier);
					card.right.addRoundDefBoost(right_def);
					card.right.appliedCombatSkills.add(card.skillID);
				}
				if(left_def != 0 || right_def != 0)
				{
					if(do_info)
					{
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
						if(left_def != 0)
							info += card.left.name + "'s (" + card.left.x_coordinate + "|" + card.left.y_coordinate + ") DEF increased by " + (int) left_def + "<br>\r";
						if(right_def != 0)
							info += card.right.name + "'s (" + card.right.x_coordinate + "|" + card.right.y_coordinate + ") DEF increased by " + (int) right_def + "<br>\r";
					}
					return true;
				}
				else
					return false;
			}
			else if(card.skillID == 36301 && card == ownFormation.leader)//One Who Seeks the Light (Rey)
			{
				double atk_boost = 0, def_boost = 0, eva_boost = 0;
				card target = null;
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
				for(int i = 0; i < ownFormation.cards.size(); i++)
				{
					target = ownFormation.cards.get(i);
					if(target != null && target.side == 'L' && !target.appliedSkill(card.skillID))
					{
						atk_boost = target.baseAtk * card.skill_effect * (target.skill_multiplier + 1 - target.combat_multiplier);
						target.addRoundAtkBoost(atk_boost);
						def_boost = target.baseDef * card.skill_effect * (target.skill_multiplier + 1 - target.combat_multiplier);
						target.addRoundDefBoost(def_boost);
						eva_boost = target.baseEva * card.skill_effect * (target.skill_multiplier + 1 - target.combat_multiplier);
						target.addRoundEvaBoost(eva_boost);
						if(do_info)
							info += target.name + "'s (" + target.x_coordinate + "|" + target.y_coordinate + ") ATK / DEF / EVA increased by " + (int) atk_boost + " / " + (int) def_boost + " / " + (int) eva_boost + "<br>\r";
					}
				}
				return true;
			}
			else if(card.skillID == 36401 && card == ownFormation.leader)//Heir to the Dark (Kylo Ren)
			{
				double atk_boost = 0, def_boost = 0, acc_boost = 0;
				card target = null;
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
				for(int i = 0; i < ownFormation.cards.size(); i++)
				{
					target = ownFormation.cards.get(i);
					if(target != null && target.side == 'D' && !target.appliedSkill(card.skillID))
					{
						atk_boost = target.baseAtk * card.skill_effect * (target.skill_multiplier + 1 - target.combat_multiplier);
						target.addRoundAtkBoost(atk_boost);
						def_boost = target.baseDef * card.skill_effect * (target.skill_multiplier + 1 - target.combat_multiplier);
						target.addRoundDefBoost(def_boost);
						acc_boost = target.baseAcc * card.skill_effect * (target.skill_multiplier + 1 - target.combat_multiplier);
						target.addRoundAccBoost(acc_boost);
						if(do_info)
							info += target.name + "'s (" + target.x_coordinate + "|" + target.y_coordinate + ") ATK / DEF / ACC increased by " + (int) atk_boost + " / " + (int) def_boost + " / " + (int) acc_boost + "<br>\r";
					}
				}
				return true;
			}
			else if(card.skillID == 36701)//Deserter (Finn)
			{
				double eva_boost = 0;
				eva_boost += card.baseEva * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundEvaBoost(eva_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! EVA boosted by " + (int) eva_boost + ". Unit has become a decoy and will engage the attacks from enemy units<br>\r"; 
				return true;
			}
			else if(card.skillID == 36601)//Merciless Commander (Captain Phasma)
			{
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
				if(!card.appliedSkill(card.skillID))
				{
					double atk_boost = 0, acc_boost = 0;
					atk_boost += card.baseAtk * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					acc_boost += card.baseAcc * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
					card.addRoundAtkBoost(atk_boost);
					card.addRoundAccBoost(acc_boost);
					card.merciless = true;
					card.appliedCombatSkills.add(card.skillID);
					if(do_info)		
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") ATK increased by " + (int) atk_boost + ", ACC increased by " + (int) acc_boost + "<br>\r";
				}
				for(int i = 0; i < ownFormation.cards.size(); i++)
				{
					if(ownFormation.cards.get(i) != null && (ownFormation.cards.get(i).races[0] || ownFormation.cards.get(i).races[8]) && Math.abs(ownFormation.cards.get(i).x_coordinate - card.x_coordinate) <= 1 && !ownFormation.cards.get(i).appliedSkill(card.skillID))
					{
						double atk_boost = 0, acc_boost = 0;
						atk_boost += ownFormation.cards.get(i).baseAtk * card.skill_effect * (ownFormation.cards.get(i).skill_multiplier + 1 - ownFormation.cards.get(i).combat_multiplier);
						acc_boost += ownFormation.cards.get(i).baseAcc * card.skill_effect * (ownFormation.cards.get(i).skill_multiplier + 1 - ownFormation.cards.get(i).combat_multiplier);
						ownFormation.cards.get(i).addRoundAtkBoost(atk_boost);
						ownFormation.cards.get(i).addRoundAccBoost(acc_boost);
						ownFormation.cards.get(i).merciless = true;
						ownFormation.cards.get(i).appliedCombatSkills.add(card.skillID);
						if(do_info)		
							info += ownFormation.cards.get(i).name + "'s (" + ownFormation.cards.get(i).x_coordinate + "|" + ownFormation.cards.get(i).y_coordinate + ") ATK increased by " + (int) atk_boost + ", ACC increased by " + (int) acc_boost + "<br>\r";
					}
				}
				return true;
			}
			else if(card.skillID == 36501 && ownFormation.leader.alive()  && !ownFormation.leader.appliedSkill(card.skillID))//Little Hero (BB-8)
			{
				double atk_boost = 0, acc_boost = 0, def_boost = 0, eva_boost = 0;
				atk_boost += ownFormation.leader.baseAtk * card.skill_effect * (ownFormation.leader.skill_multiplier + 1 - ownFormation.leader.combat_multiplier);
				ownFormation.leader.addRoundAtkBoost(atk_boost);
				acc_boost += ownFormation.leader.baseAcc * card.skill_effect * (ownFormation.leader.skill_multiplier + 1 - ownFormation.leader.combat_multiplier);
				ownFormation.leader.addRoundAccBoost(acc_boost);
				eva_boost += ownFormation.leader.baseEva * card.skill_effect * (ownFormation.leader.skill_multiplier + 1 - ownFormation.leader.combat_multiplier);
				ownFormation.leader.addRoundEvaBoost(eva_boost);
				def_boost += ownFormation.leader.baseDef * card.skill_effect * (ownFormation.leader.skill_multiplier + 1 - ownFormation.leader.combat_multiplier);
				ownFormation.leader.addRoundDefBoost(def_boost);
				ownFormation.leader.appliedCombatSkills.add(card.skillID);
				if(do_info)
				{
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
					info += ownFormation.leader.name + "'s (" + ownFormation.leader.x_coordinate + "|" + ownFormation.leader.y_coordinate + ") ATK / DEF / ACC / EVA increased by " + (int) atk_boost + " / " + (int) def_boost + " / " + (int) acc_boost + " / " + (int) eva_boost + "<br>\r";
				}
				return true;
			}
			else if(card.skillID == 37001)//Raise Morale (General Hux)
			{
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r"; 
				for(int i = 0; i < ownFormation.cards.size(); i++)
				{
					if(ownFormation.cards.get(i) != null && ownFormation.cards.get(i) != card && ownFormation.cards.get(i).races[0] && !ownFormation.cards.get(i).appliedSkill(card.skillID))
					{
						double rarity_multiplier = 1, atk_boost, def_boost, acc_boost, eva_boost = 0.0;
						if(ownFormation.cards.get(i).rarity == 4)
							rarity_multiplier = 0.25;
						else if(ownFormation.cards.get(i).rarity == 5)
							rarity_multiplier = 1.0/6.0;
						atk_boost = ownFormation.cards.get(i).baseAtk * card.skill_effect * rarity_multiplier * (ownFormation.cards.get(i).skill_multiplier + 1 - ownFormation.cards.get(i).combat_multiplier);
						def_boost = ownFormation.cards.get(i).baseDef * card.skill_effect * rarity_multiplier * (ownFormation.cards.get(i).skill_multiplier + 1 - ownFormation.cards.get(i).combat_multiplier);
						acc_boost = ownFormation.cards.get(i).baseAcc * card.skill_effect * rarity_multiplier * (ownFormation.cards.get(i).skill_multiplier + 1 - ownFormation.cards.get(i).combat_multiplier);
						eva_boost = ownFormation.cards.get(i).baseEva * card.skill_effect * rarity_multiplier * (ownFormation.cards.get(i).skill_multiplier + 1 - ownFormation.cards.get(i).combat_multiplier);
						card.addRoundAtkBoost(atk_boost);
						card.addRoundDefBoost(def_boost);
						card.addRoundAccBoost(acc_boost);
						card.addRoundEvaBoost(eva_boost);
						if(do_info)
							info += ownFormation.cards.get(i).name + "'s (" + ownFormation.cards.get(i).x_coordinate + "|" + ownFormation.cards.get(i).y_coordinate + ") ATK boosted by " + (int) atk_boost + ", DEF boosted by " + (int) def_boost + ", ACC boosted by " + (int) acc_boost + ", EVA boosted by " + (int) eva_boost + "<br>\r"; 
					}
				}
				return true;
			}
			else if(card.skillID == 37101)//Sparhead (Phasma)
			{
				double multiplier = 1.0, def_boost = 0;
				if(card.front != null && card.front.front != null)
				{
					multiplier /= 3.0;
				}
				else if(card.front != null)
				{
					multiplier /= 2.0;
				}
				def_boost += card.baseDef * multiplier * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
				card.addRoundDefBoost(def_boost);
				if(do_info)
					info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated! DEF boosted by " + (int) def_boost + "<br>\r"; 
				return true;
			}
			else if(card.skillID == 37201)//Protector (Finn)
			{
				//TODO
				return true;
			}
			else if(card.skillID == 37301 && card.front == null)//Unending Grudge (Maul MR)
			{
				card enemy;
				int obi_multiplier = 1;
				if(card.y_coordinate < 16)
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate+1];
				}
				else
				{
					enemy = battlefield[card.x_coordinate][card.y_coordinate-1];
				}
				if(enemy != null && (enemy.races[18] || (enemy.right != null && enemy.right.races[18]) || (enemy.left != null && enemy.left.races[18])))
				{
					if(enemy.char_id == 133|| (enemy.right != null && enemy.right.char_id == 133) || (enemy.left != null && enemy.left.char_id == 133))//Check if one of those 3 is Obi
						obi_multiplier = 2;
					double def_decrease1 = 0, def_decrease2 = 0, def_decrease3 = 0, def_decrease4 = 0, eva_decrease1 = 0, eva_decrease2 = 0, eva_decrease3 = 0, eva_decrease4 = 0;
					def_decrease1 += card.baseDef * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier) * obi_multiplier;
					eva_decrease1 += card.baseEva * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier) * obi_multiplier;
					card.addRoundDefBoost(def_decrease1);
					card.addRoundEvaBoost(eva_decrease1);
					if(do_info)
					{
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") skill \"" + card.skill_name + "\" activated!:<br>\r";
						info += card.name + "'s (" + card.x_coordinate + "|" + card.y_coordinate + ") DEF increased by " + (int) def_decrease1 + ", EVA increased by " + (int) eva_decrease1 + "<br>\r";
					}
					if(!enemy.appliedSkill(card.skillID))
					{
						def_decrease2 += enemy.baseDef * card.skill_effect * (enemy.skill_multiplier + 1 - enemy.combat_multiplier) * obi_multiplier;
						eva_decrease2 += enemy.baseEva * card.skill_effect * (enemy.skill_multiplier + 1 - enemy.combat_multiplier) * obi_multiplier;
						enemy.addRoundDefBoost(-def_decrease2);
						enemy.addRoundEvaBoost(-eva_decrease2);
						if(do_info)		
							info += enemy.name + "'s (" + enemy.x_coordinate + "|" + enemy.y_coordinate + ") DEF decreased by " + (int) def_decrease2 + ", EVA decreased by " + (int) eva_decrease2 + "<br>\r";
						enemy.appliedCombatSkills.add(card.skillID);
					}
					if(enemy.left != null && !enemy.left.appliedSkill(card.skillID))
					{
						def_decrease3 += enemy.left.baseDef * card.skill_effect * (enemy.left.skill_multiplier + 1 - enemy.left.combat_multiplier) * obi_multiplier;
						eva_decrease3 += enemy.left.baseEva * card.skill_effect * (enemy.left.skill_multiplier + 1 - enemy.left.combat_multiplier) * obi_multiplier;
						enemy.left.addRoundDefBoost(-def_decrease3);
						enemy.left.addRoundEvaBoost(-eva_decrease3);
						if(do_info)		
							info += enemy.left.name + "'s (" + enemy.left.x_coordinate + "|" + enemy.left.y_coordinate + ") DEF decreased by " + (int) def_decrease3 + ", EVA decreased by " + (int) eva_decrease3 + "<br>\r";
						enemy.left.appliedCombatSkills.add(card.skillID);
					}
					if(enemy.right != null && !enemy.right.appliedSkill(card.skillID))
					{
						def_decrease4 += enemy.right.baseDef * card.skill_effect * (enemy.right.skill_multiplier + 1 - enemy.right.combat_multiplier) * obi_multiplier;
						eva_decrease4 += enemy.right.baseEva * card.skill_effect * (enemy.right.skill_multiplier + 1 - enemy.right.combat_multiplier) * obi_multiplier;
						enemy.right.addRoundDefBoost(-def_decrease4);
						enemy.right.addRoundEvaBoost(-eva_decrease4);
						if(do_info)		
							info += enemy.right.name + "'s (" + enemy.right.x_coordinate + "|" + enemy.right.y_coordinate + ") DEF decreased by " + (int) def_decrease4 + ", EVA decreased by " + (int) eva_decrease4 + "<br>\r";
						enemy.right.appliedCombatSkills.add(card.skillID);
					}
				}
				return true;
			}
		}
		else
			card.combat_unable = false;
		return false;
	}
	
	public void id_1621(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'L')
			{
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc * effect;
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
			}
		}
	}
	
	public void id_12411(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[12])
			{
				a.cards.get(i).prep_atk -= a.cards.get(i).baseAtk * effect;
				a.cards.get(i).prep_acc -= a.cards.get(i).baseAcc * effect;
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
				a.cards.get(i).prep_eva -= a.cards.get(i).baseEva * effect;
			}
		}
	}
	
	public void id_21021(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[12])
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk* effect;
		}
	}
	
	public void id_22161(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[7])
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef* effect;
		}
	}
	
	public void id_21261(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[7])
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc* effect;
		}
	}
	
	public void id_11211(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[11])
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc* effect;
		}
	}
	
	public void id_21361(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[7])
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva* effect;
		}
	}
	
	public void id_21351(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[6])
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva* effect;
		}
	}
	
	public void id_11071(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[8])
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk* effect;
		}
	}
	
	public String id_40001(card attacker, card defender)//Blaster Reflection(Sml and Med)
	{
		double hp_decrease = 0;
		String to_return = "";
		if(attacker.anti_lightsaber && !hits(defender.acc, attacker.eva))
		{
			hp_decrease = 0;
			to_return += ":<br>\r" + defender.name + " (" + defender.x_coordinate + "|" + defender.y_coordinate + ") reflects " + attacker.name + "'s (" + attacker.x_coordinate + "|" + attacker.y_coordinate + ") blaster shot, but the reflected shot gets evaded<br>\r";
		}
		else
		{
			hp_decrease = (attacker.atk * defender.skill_effect * (defender.skill_multiplier + 1 - defender.combat_multiplier) - attacker.def) / 10;
			if(hp_decrease < 10)
				hp_decrease = 10;
			to_return += ":<br>\r" + defender.name + " (" + defender.x_coordinate + "|" + defender.y_coordinate + ") reflects " + attacker.name + "'s (" + attacker.x_coordinate + "|" + attacker.y_coordinate + ") blaster shot and inflicts " + (int) hp_decrease + " damage onto the target" + attacker.decreaseHp(hp_decrease) + "<br>\r";
		}
		return to_return;
	}
	
	public double id_33601(card card)//Resolve (MagnaGuard)
	{
		double revive_hp = 0;
		revive_hp = card.max_hp * card.skill_effect * (card.skill_multiplier + 1 - card.combat_multiplier);
		card.max_hp = (int) revive_hp;
		card.hp = card.max_hp;
		card.atk = card.baseAtk;
		card.def = card.baseDef;
		card.acc = card.baseAcc;
		card.eva = card.baseEva;
		card.revived = true;
		return revive_hp;
	}
	
	public double[] id_33301(card attacker, card defender)
	{
		double def_boost = 0, eva_boost = 0;
		if(attacker.weapon_type < 30 || attacker.weapon_type == 215)
		{	
			def_boost += defender.baseDef * 0.4 * (defender.skill_multiplier + 1 - defender.combat_multiplier);
			eva_boost += defender.baseEva * 0.4 * (defender.skill_multiplier + 1 - defender.combat_multiplier);
			defender.def += def_boost;
			defender.eva += eva_boost;	
		}
		double[] a = {def_boost, eva_boost};
		return a;
	}
	
	public double[] id_35401(card attacker, card defender)
	{
		double def_boost = 0, eva_boost = 0;
		if(attacker.weapon_type > 40 && attacker.weapon_type < 47)
		{	
			def_boost += defender.baseDef * defender.skill_effect * (defender.skill_multiplier + 1 - defender.combat_multiplier);
			eva_boost += defender.baseEva * defender.skill_effect * (defender.skill_multiplier + 1 - defender.combat_multiplier);
			defender.def += def_boost;
			defender.eva += eva_boost;	
		}
		double[] a = {def_boost, eva_boost};
		return a;
	}
	
	public String id_32401(card defender, int damage, int halfDef)//TODO Using GGEC's def stats
	{
		card target = null;
		String to_return = "";
		if(defender.front != null && defender.front.skillID != 32401 && defender.front.races[21])
			target = defender.front;
		if(defender.right != null && defender.right.skillID != 32401 && defender.right.races[21] && (target == null || defender.right.hp > target.hp))
			target = defender.right;
		if(defender.behind != null && defender.behind.skillID != 32401 && defender.behind.races[21] && (target == null || defender.behind.hp > target.hp))		
			target = defender.behind;
		if(defender.left != null && defender.left.skillID != 32401 && defender.left.races[21] && (target == null || defender.left.hp > target.hp))
			target = defender.left;
		
		if(target != null)
		{
			double hp_decrease = 0;
			hp_decrease = damage * (1 - defender.skill_effect) * (defender.skill_multiplier + 1 - defender.combat_multiplier);
			to_return += ":<br>\r" + defender.name + " (" + defender.x_coordinate + "|" + defender.y_coordinate + ") transfers the attack to " + target.name + " (" + target.x_coordinate + "|" + target.y_coordinate + "), inflicting " + (int) hp_decrease + " damage onto the target" + target.decreaseHp(hp_decrease) + "<br>\r";
		}
		else
			to_return += ":<br>\r" + defender.name + " (" + defender.x_coordinate + "|" + defender.y_coordinate + ") can't transfer the attack and gets hit for " + (int) damage + " HP" + defender.decreaseHp(damage) + "<br>\r";
		return to_return;
	}
	
	public String id_41001(card attacker, card defender)//Self Destruction, Dwarf Spider Droid
	{
		double hp_decrease = 0;
		String to_return = "";
		if(defender.y_coordinate - attacker.y_coordinate == 1 || defender.y_coordinate - attacker.y_coordinate == -1)
		{
			hp_decrease = defender.max_hp * defender.skill_effect * (defender.skill_multiplier + 1 - defender.combat_multiplier);
			to_return += "<br>\r" + defender.name + " (" + defender.x_coordinate + "|" + defender.y_coordinate + ") explodes and inflicts " + (int) hp_decrease + " damage onto " + attacker.name + " (" + attacker.x_coordinate + "|" + attacker.y_coordinate + ")" + attacker.decreaseHp(hp_decrease) + "<br>\r";
		}
		return to_return;
	}
	
	public void id_62411(formation a, double effect)
	{
		double count_classes = 0;
		for(int i = 0; i < a.cards.get(0).races.length; i++)
		{
			if(a.lightClassInFormation(i))
				count_classes++;			
		}
		
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'L')
			{
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect * (count_classes / 20);
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect * (count_classes / 20);
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc * effect * (count_classes / 20);
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect * (count_classes / 20);
			}
		}
	}
	
	public void id_62421(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[8])
			{
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc * effect;
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect;
				a.cards.get(i).prep_hp -= a.cards.get(i).max_hp * effect;
			}
		}
	}
	
	public void id_11051(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[10])
				a.cards.get(i).prep_def += a.cards.get(i).baseDef* effect;
		}
	}
	
	public void id_11151(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[10])
				a.cards.get(i).prep_def += a.cards.get(i).baseDef* effect;
		}
	}
	
	public void id_11251(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[10])
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc* effect;
		}
	}
	
	public void id_11351(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[10])
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva* effect;
		}
	}
	
	public void id_21131(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[4])
				a.cards.get(i).prep_def += a.cards.get(i).baseDef* effect;
		}
	}
	
	public void id_21331(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[4])
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva* effect;
		}
	}
	
	public void id_1341(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'D')
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva* effect;
		}
	}
	
	public void id_11222(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[13])
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc* effect;
		}
	}
	
	public void id_1001(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'S')
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_2231(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'L')
				a.cards.get(i).prep_acc -= a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_1311(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'M')
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva* effect;
		}
	}
	
	public void id_2031(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'L')
				a.cards.get(i).prep_atk -= a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_11001(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[22])
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_12071(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[8])
				a.cards.get(i).prep_atk -= a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_12311(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[21])
				a.cards.get(i).prep_eva -= a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_1041(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'D')
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_11322(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[13])
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_11101(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[22])
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_11161(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[9])
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_2151(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'N')
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_12161(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[9])
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_11061(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[9])
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_2011(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'M')
				a.cards.get(i).prep_atk -= a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_1241(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'D')
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_1121(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'L')
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_1211(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'M')
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_11122(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[13])
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_11371(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[8])
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_11361(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[9])
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_2201(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'S')
				a.cards.get(i).prep_acc -= a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_1331(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'L')
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_2221(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'L')
				a.cards.get(i).prep_acc -= a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_2111(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'M')
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_2211(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'M')
				a.cards.get(i).prep_acc -= a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_1221(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'L')
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_2021(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'L')
				a.cards.get(i).prep_atk -= a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_11022(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[13])
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_22352(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[6])
				a.cards.get(i).prep_eva -= a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_2261(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null)
				a.cards.get(i).prep_acc -= a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_12111(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[22])
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_21051(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[6])
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_1332(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'L')
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_22362(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[7])
				a.cards.get(i).prep_eva -= a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_2222(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'L')
				a.cards.get(i).prep_acc -= a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_2161(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null)
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_2041(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'D')
				a.cards.get(i).prep_atk -= a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_11011(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[21])
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_11171(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[8])
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_11191(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[18])
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_1101(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'S')
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_12181(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[23])
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_22042(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[3])
				a.cards.get(i).prep_atk -= a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_1011(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'M')
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_1301(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'S')
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_1031(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'L')
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_1061(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null)
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_1361(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null)
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_2121(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'L')
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_2361(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null)
				a.cards.get(i).prep_eva -= a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_2001(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'S')
				a.cards.get(i).prep_atk -= a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_11042(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[11])
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_2061(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null)
				a.cards.get(i).prep_atk -= a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_1051(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'N')
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_11091(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[18])
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_2131(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'L')
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_2141(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'D')
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_1231(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'L')
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_2331(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'L')
				a.cards.get(i).prep_eva -= a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_1111(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'M')
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_2101(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'S')
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_2232(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'L')
				a.cards.get(i).prep_acc -= a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_2242(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'D')
				a.cards.get(i).prep_acc -= a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_1342(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'D')
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_2342(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'D')
				a.cards.get(i).prep_eva -= a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_21101(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[17])
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_21001(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[17])
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_11111(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[21])
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_1141(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'D')
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_21371(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[16])
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_12171(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[8])
				a.cards.get(i).prep_def -= a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_11311(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[21])
				a.cards.get(i).prep_eva += a.cards.get(i).baseEva * effect;
		}
	}
	
	public void id_1131(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).side == 'L')
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_1021(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).range == 'L')
				a.cards.get(i).prep_atk += a.cards.get(i).baseAtk * effect;
		}
	}
	
	public void id_1161(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null)
				a.cards.get(i).prep_def += a.cards.get(i).baseDef * effect;
		}
	}
	
	public void id_11261(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[9])
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc * effect;
		}
	}
	
	public void id_11231(formation a, double effect)
	{
		for(int i = 0; i < a.cards.size(); i++)
		{
			if(a.cards.get(i) != null && a.cards.get(i).races[15])
				a.cards.get(i).prep_acc += a.cards.get(i).baseAcc * effect;
		}
	}
		
	public String info()
	{
		String a = info;
		info = "";
		return a;
	}
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
}