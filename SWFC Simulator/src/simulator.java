public class simulator
{
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		double darkWins = 0;//Rancor: 1090230450, 1090230450, 1027310650, 1027310650, 1090230450, 1090230450, 1097830230, 1020310650, 1041410130, 1041410130, 1020310650, 1097830230, 1046020140, 1071010640, 1034420350, 1034420350, 1034420350, 1034420350
		double lightWins = 0;
		double draws = 0;// YGM: 1024410750, 1024410750, 1027310650, 1027310650, 1024410750, 1024410750, 1041410130, 1020310650, 1029110340, 1029110340, 1020310650, 1041410130, 1016210450, 1020520640, 1112530130, 1112530130, 1112530130, 1027330750
		double timeouts = 0;// Zams form: 1020520150, 1035220450, 1020520150, 1020520150, 1035220450, 1020520150, 1034420350, 1034420350, 1034420350, 1034420350, 1034420350, 1034420350, 1111420140, 1020520450, 1023320130, 1057320140, 1020520450, 1106620240
		int amount = Integer.valueOf(args[0]);//									0			1			2			3			4			5			6			7			8			9			10			11			12			13			14			15			16			17
		if(amount > 10000)
			amount = 10000;
		formation formation_1 = new formation(args[1], Integer.valueOf(args[2]), Integer.valueOf(args[3]), Integer.valueOf(args[4]), Integer.valueOf(args[5]), Integer.valueOf(args[6]),
				Integer.valueOf(args[7]), Integer.valueOf(args[8]), Integer.valueOf(args[9]), Integer.valueOf(args[10]), Integer.valueOf(args[11]), Integer.valueOf(args[12]), 
				Integer.valueOf(args[13]), Integer.valueOf(args[14]), Integer.valueOf(args[15]), Integer.valueOf(args[16]), Integer.valueOf(args[17]), Integer.valueOf(args[18]), 
				Integer.valueOf(args[19]), Integer.valueOf(args[20]), Integer.valueOf(args[21]), Integer.valueOf(args[22]), Integer.valueOf(args[23]), Integer.valueOf(args[24]), 
				Integer.valueOf(args[25]), Integer.valueOf(args[26]), Integer.valueOf(args[27]), Integer.valueOf(args[28]), Integer.valueOf(args[29]), Integer.valueOf(args[30]), 
				Integer.valueOf(args[31]), Integer.valueOf(args[32]), Integer.valueOf(args[33]), Integer.valueOf(args[34]), Integer.valueOf(args[35]), Integer.valueOf(args[36]), 
				Integer.valueOf(args[37]));
		formation formation_2 = new formation(args[54], Integer.valueOf(args[55]), Integer.valueOf(args[56]), Integer.valueOf(args[57]), Integer.valueOf(args[58]), Integer.valueOf(args[59]),
				Integer.valueOf(args[60]), Integer.valueOf(args[61]), Integer.valueOf(args[62]), Integer.valueOf(args[63]), Integer.valueOf(args[64]), Integer.valueOf(args[65]), 
				Integer.valueOf(args[66]), Integer.valueOf(args[67]), Integer.valueOf(args[68]), Integer.valueOf(args[69]), Integer.valueOf(args[70]), Integer.valueOf(args[71]), 
				Integer.valueOf(args[72]), Integer.valueOf(args[73]), Integer.valueOf(args[74]), Integer.valueOf(args[75]), Integer.valueOf(args[76]), Integer.valueOf(args[77]), 
				Integer.valueOf(args[78]), Integer.valueOf(args[79]), Integer.valueOf(args[80]), Integer.valueOf(args[81]), Integer.valueOf(args[82]), Integer.valueOf(args[83]), 
				Integer.valueOf(args[84]), Integer.valueOf(args[85]), Integer.valueOf(args[86]), Integer.valueOf(args[87]), Integer.valueOf(args[88]), Integer.valueOf(args[89]), 
				Integer.valueOf(args[90]));
		if(amount == 1)
		{
			formation_1.do_info = true;
			formation_2.do_info = true;
		}
		formation_1.setLeader(Integer.valueOf(args[38]));
		formation_2.setLeader(Integer.valueOf(args[91]));		
		formation_1.setSupport(Integer.valueOf(args[40]), Boolean.valueOf(args[41]), Integer.valueOf(args[42]), Boolean.valueOf(args[43]), Boolean.valueOf(args[44]), Integer.valueOf(args[45]), 
				Integer.valueOf(args[46]), Boolean.valueOf(args[47]), Integer.valueOf(args[48]), Integer.valueOf(args[49]), Integer.valueOf(args[50]), Integer.valueOf(args[51]), 
				Integer.valueOf(args[52]), Integer.valueOf(args[53]));//Ambush, call ls, hp up, lure ds, nullification, proc up, proximity, anti lightsaber, undercover 1 - 3
		formation_2.setSupport(Integer.valueOf(args[93]), Boolean.valueOf(args[94]), Integer.valueOf(args[95]), Boolean.valueOf(args[96]), Boolean.valueOf(args[97]), Integer.valueOf(args[98]), 
				Integer.valueOf(args[99]), Boolean.valueOf(args[100]), Integer.valueOf(args[101]), Integer.valueOf(args[102]), Integer.valueOf(args[103]), Integer.valueOf(args[104]), 
				Integer.valueOf(args[105]), Integer.valueOf(args[106]));
		for(int a = 0; a < amount; a++)
		{	
			formation_1.rebuild();
			formation_2.rebuild();
			battlefield battlefield = new battlefield(formation_1, formation_2);
			if(amount == 1)
				battlefield.activate_info();
			int rounds = 0;
			battlefield.start(args[39].charAt(0), args[92].charAt(0));
			while(formation_1.alive() && formation_2.alive() && rounds < 61)
			{
				battlefield.activateSelfSkills();
				battlefield.attack();
				battlefield.refresh();
				if(amount == 1)
					System.out.print("Round " + rounds + ":<br>\r" + battlefield.info());
				rounds++;
			}
			
			if(formation_1.alive() && !formation_2.alive())
				darkWins++;
			else if(!formation_1.alive() && formation_2.alive())
				lightWins++;
			else if(!formation_1.alive() && !formation_2.alive())
				draws++;
			else
				timeouts++;
			if(amount >= 100 && a % (amount/100) == 0)
				System.out.print(".");
		}
		System.out.println("<br>\r" + formation_1.name + " won " + String.format("%.2f", darkWins / amount * 100) + "%, " + formation_2.name + " won " + String.format("%.2f", lightWins / amount * 100) + "% out of " + amount + " Battles; Draws: " + String.format("%.2f", draws / amount * 100) + "%, Timeouts: " + String.format("%.2f", timeouts / amount * 100) + "%");
		System.out.println("<br>\rSimulation took " + (System.currentTimeMillis() - startTime)/1000.0 + " sec");
	}
}