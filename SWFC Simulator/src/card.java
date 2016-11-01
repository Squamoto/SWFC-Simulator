import java.util.*;

public class card
{
	String name, pattern, skill_name;
	int hp, atk, def, acc, eva, attackCount, numberOfTurns, delay, skillID, baseAtk, baseDef, baseAcc, baseEva, skill_type, skill_priority, max_hp, weapon_type, dmg_received, hits_received, 
		roundAtkBoost, roundDefBoost, roundAccBoost, roundEvaBoost, roundFreqBoost, rarity, x_coordinate, y_coordinate, real_delay, prep_def, prep_atk, prep_eva, prep_acc, prep_hp, card_id, 
		concentrated_fire = -1, strangle_damage = 50, strangle_eva, evo_state, skill_level, char_id;
	double combat_multiplier = 1.0, skill_multiplier = 1.0, proc_rate, friendly_fire, skill_effect;
	char range, side, real_range;
	boolean stunned, leader, self_skill_activated, revived, nullified, champion, merciless, combat_unable, anti_lightsaber;
	boolean[] races = new boolean[24];
	card left, right, front, behind, strangle_enemy;
	formation ownFormation;
	ArrayList<Integer> appliedCombatSkills = new ArrayList <Integer>();
	
	/* 0 = First Order, 1 = Resistance, 2 = Mandalorian, 3 = Jabba, 4 = Tatooinian, 5 = Wookiee, 6 = Separatists, 7 = Republic, 8 = Empire, 9 = Rebel, 10 = Nabooan, 11 = Gungan, 
	 * 12 = Clone, 13 = Ewok, 14 = Beast, 15 = Bounty Hunter, 16 = Pod Racer, 17 = Sith, 18 = Jedi, 19 = Senator, 20 = Military?, 21 = Droid, 22 = Female, 23 = Male*/
	
	card(int card_id, String name, int hp, int atk, int def, int acc, int eva, int evo_state, int attackCount, char range, String pattern, int delay, int race, int skillID, String skill_name, int skill_level, double skill_effect, int skill_type, int skill_priority, char side, int rarity, int weapon_type, double proc_rate, formation ownFormation, int char_id)
	{
		this.card_id = card_id;
		this.name = name;
		this.skill_name = skill_name;
		this.skill_level = skill_level;
		this.skill_effect = skill_effect / 100;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.acc = acc;
		this.eva = eva;
		this.evo_state = evo_state;
		this.attackCount = attackCount;
		this.range = range;
		this.pattern = pattern;
		this.delay = delay;
		raceConverter(Integer.toBinaryString(race).toCharArray());
		this.skillID = skillID;
		this.skill_type = skill_type;
		this.skill_priority = skill_priority;
		this.side = side;
		this.rarity = rarity;
		this.weapon_type = weapon_type;
		this.proc_rate = proc_rate / 100;
		this.ownFormation = ownFormation;
		max_hp = hp;
		baseAtk = atk;
		baseDef = def;
		baseAcc = acc;
		baseEva = eva;
		real_range = range;
		real_delay = delay;
		this.char_id = char_id;
	}
	
	public boolean alive()
	{
		if(hp > 0)
			return true;
		else
			return false;
	}

	public String info()
	{
		return "<img width=\"50\" height=\"70\" src=\"/SWFC/images/cards/all/" + (card_id+evo_state) + ".png\" />";
	}

	public void raceConverter(char[] a)
	{
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] == '1')
				races[i+(races.length-a.length)] = true;
			else
				races[i+(races.length-a.length)] = false;
		}
	}
	
	public void die()
	{
		left = null;
		right = null;
		front = null;
		behind = null;
		strangle_enemy = null;
	}
	
	public boolean appliedSkill(int a)
	{
		for(int i = 0; i < appliedCombatSkills.size(); i++)
		{
			if(appliedCombatSkills.get(i) == a)
				return true;
		}
		return false;
	}
	
	public void addRoundAtkBoost(double boost)
	{
		atk += boost;
		roundAtkBoost += boost;
	}
	
	public void addRoundDefBoost(double boost)
	{
		def += boost;
		roundDefBoost += boost;
	}
	
	public void addRoundAccBoost(double boost)
	{
		acc += boost;
		roundAccBoost += boost;
	}
	
	public void addRoundEvaBoost(double boost)
	{
		eva += boost;
		roundEvaBoost += boost;
	}
	
	public void addRoundFreqBoost(double boost)
	{
		attackCount += boost;
		roundFreqBoost += boost;
	}
	
	public String decreaseHp(double hp_decrease)
	{
		String to_return = "";
		hp -= hp_decrease;
		dmg_received += hp_decrease;
		if(hp_decrease < 100 && def > baseDef / 2)//Might be wrong for multiple attacks
		{
			double def_reduction = 100 - hp_decrease;
			def -= def_reduction;
			to_return += ". Decreasing " + name + "'s DEF by " + (int) def_reduction;
			if(def < baseDef / 2)
				def = baseDef / 2;
		}
		return to_return;
	}
}