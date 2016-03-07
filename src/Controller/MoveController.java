package Controller;

import Model.FightMoveDatabase;
import Model.MoveEffects;

public class MoveController {

	RandomGen random = new RandomGen();
//		moves.add(new MoveEffects("STRUGGLE", "N/A", 50, 100, 1, -0.5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0));

	
	public int getStrength(String move)
	{
		int positionStrength  = getIndex(move);
		int strength = FightMoveDatabase.getInstance().getMoves().get(positionStrength).getStrength();
		return strength;
	}
	
	public boolean getEnemySleep(String move)
	{
		int position = getIndex(move);
		boolean enemySleeping = FightMoveDatabase.getInstance().getMoves().get(position).getDefenderSleep();
		return enemySleeping;
	}
	public boolean getPoison(String move) {
		int position = getIndex(move);
		boolean poisoned = FightMoveDatabase.getInstance().getMoves().get(position).getPoison();
		return poisoned;
	}
	
	public boolean getParalysed(String move) {
		int position = getIndex(move);
		boolean Paralysed = FightMoveDatabase.getInstance().getMoves().get(position).getParalysed();
		return Paralysed;
	}
	
	public boolean getFrozen(String move) {
		int position = getIndex(move);
		boolean frozen = FightMoveDatabase.getInstance().getMoves().get(position).getFrozen();
		return frozen;
	}
	
	public boolean getConfused(String move) {
		int position = getIndex(move);
		boolean confused = FightMoveDatabase.getInstance().getMoves().get(position).getConfusion();
		return confused;
	}
	
	public boolean getBurned(String move) {
		int position = getIndex(move);
		boolean burned = FightMoveDatabase.getInstance().getMoves().get(position).getBurned();
		return burned;
	}
	public int getAccuracy(String move)
	{
		int positionAccuracy = getIndex(move);
		int accuracy = FightMoveDatabase.getInstance().getMoves().get(positionAccuracy).getAccuracy();
		return accuracy;
	}

	public int getIndex(String moveName)
	{
		boolean found = false;
		int index = 0;
		while(found == false)
		{
			for(MoveEffects a: FightMoveDatabase.getInstance().getMoves())
			{
				String b = a.getName();
				if(b.equals(moveName))
				{
					int odds = a.getExceptionsOdds();
					if(odds > 0)
					{
						if(random.GenerateNumber(100) > odds)
						{
							return index;
						}
						else
						{
							index++;
							return index;
						}
					}
					return index;
				}
				else
				{
					index++;
				}
			}
		}
		return 0;	
	}
	
	public double getHealthRegeneration(String move)
	{
		int healthRegeneration = getIndex(move);
		double regeneration = FightMoveDatabase.getInstance().getMoves().get(healthRegeneration).getHealthRegeneration();
		return regeneration;
	}
	public int getMovePP(String move)
	{
		int moveLimit = getIndex(move);
		int pp = FightMoveDatabase.getInstance().getMoves().get(moveLimit).getPP();
		return pp;
	}


}