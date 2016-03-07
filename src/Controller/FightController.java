package Controller;

import java.util.ArrayList;

import javax.swing.JFrame;

import Model.FightModel;
import Model.PokemonState;
import Sound.SoundDemo;
import View.FightView;

public class FightController {
	MoveController FM = new MoveController();
	RandomGen RM = new RandomGen();
	FightView FV = new FightView();
	AI.Random AIR = new AI.Random();
	AI.MonteCarlo AMC = new AI.MonteCarlo();
	Calculations C = new Calculations();
	Choices CH = new Choices();
	SoundDemo SD = new SoundDemo();

	public Runnable runBattle(ArrayList<PokemonState> currentPokemon, ArrayList<PokemonState> enemyPokemon){	
		FightModel.getInstance().setPlayerCurrent(0);
		FightModel.getInstance().setEnemyCurrent(0);
		FightModel.getInstance().setPlayerParty(currentPokemon);
		FightModel.getInstance().setEnemyParty(enemyPokemon);

		
		FightModel.getInstance().setSpoken("A wild " + FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getName() + " appeared");
		FV.Pause(1000);
		FightModel.getInstance().setSpoken("Wild " + FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getName() + " attacked");
		FV.Pause(1000);
		FightModel.getInstance().setSpoken(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " GO!");
		FV.Pause(1000);
		System.out.println("Here");

		while(FightModel.getInstance().isPlayable() == true){
			FightModel.getInstance().setMainScreen(true);
			FightModel.getInstance().setSpeech(false);
			playerTurn();
			System.out.println("here");
			enemyTurn();
		}
		return null;
	}

	public void enemyTurn() {
		FightModel.getInstance().setChoice(0);
		FightModel.getInstance().setStruggle(C.isStruggle(FightModel.getInstance().getEnemyParty(), FightModel.getInstance().getEnemyCurrent()));
		boolean change = C.changeablePokemon(FightModel.getInstance().getEnemyParty());
		while(FightModel.getInstance().isPlayerTurn() != true && FightModel.getInstance().isPlayable() == true)
		{
			//check for any status ailments
			System.out.println(FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getSleeping());
			if(FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getSleeping() == true)
			{
				System.out.println("Deciding whether asleep or not");
				//if there are decide whether they are removed
				int x = RM.GenerateNumber(5);
				if(x > 5)
				{
					//enemy becomes free of status
					FightModel.getInstance().setSpoken("Enemy woke up!");
					System.out.println("Enemy woke up!");
					FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).setSleeping(false);
				}
				else
				{
					FightModel.getInstance().setSpoken("Enemy is fast asleep");
					System.out.println("Enemy is fast asleep");
					FV.Pause(1000);
					FightModel.getInstance().setPlayerTurn(true);
				}
			}
			if(FightModel.getInstance().getEnemyParty().get(FightModel.getInstance().getEnemyCurrent()).getSleeping() == false)
			{
				//			FightModel.getInstance().setChoice(AIR.generateRandomChoice(FightModel.getInstance().getStruggle(), change));
				FightModel.getInstance().setChoice(AMC.generateMonteCarloChoice(FightModel.getInstance().getPlayerCurrent(), 
						FightModel.getInstance().getEnemyCurrent(), FightModel.getInstance().getPlayerParty(), FightModel.getInstance().getEnemyParty()));
				CH.choices();
				//play sound of move
				//			SD.playSound("battlemusic.wav");
			}
		}
	}

	public void playerTurn(){

		FightModel.getInstance().setStruggle(C.isStruggle(FightModel.getInstance().getPlayerParty(), FightModel.getInstance().getPlayerCurrent()));
		
		while(FightModel.getInstance().isPlayerTurn() == true && FightModel.getInstance().isPlayable() == true)
		{
			FV.Pause(10);
			//if move has been selected
			if(FightModel.getInstance().getSpeech() == true && FightModel.getInstance().getPokemonChanged() == false)
			{
				
				//make move choice
				if(FightModel.getInstance().getStruggle() == true)
				{
					FightModel.getInstance().setChoice(5);
				}
				else if(FightModel.getInstance().getxPos() == 7 && FightModel.getInstance().getyPos() == 76)
				{
					FightModel.getInstance().setChoice(1);
				}
				else if(FightModel.getInstance().getxPos() == 52 && FightModel.getInstance().getyPos() == 76)
				{
					FightModel.getInstance().setChoice(2);
				}
				else if(FightModel.getInstance().getxPos() == 7 && FightModel.getInstance().getyPos() == 86)
				{
					FightModel.getInstance().setChoice(3);
				}
				else if(FightModel.getInstance().getxPos() == 52 && FightModel.getInstance().getyPos() == 86)
				{
					FightModel.getInstance().setChoice(4);
				}
				
				//if sleeping
				System.out.println(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getSleeping());
				System.out.println(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getPoison());
				System.out.println(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getConfused());
				System.out.println(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getBurned());
				
				
				if(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getSleeping() == true)
				{
					System.out.println("Deciding whether asleep or not");
					//if there are decide whether they are removed
					int x = RM.GenerateNumber(5);
					if(x > 3)
					{
						//Player becomes free of status
						FightModel.getInstance().setSpoken("Player woke up!");
						System.out.println("Player woke up!");
						FV.Pause(1000);
						FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).setSleeping(false);
					}
					else
					{
						//player waits turn out
						FightModel.getInstance().setSpoken("Player is fast asleep");
						System.out.println("Player is fast asleep");
						FV.Pause(1000);
						FightModel.getInstance().setPlayerTurn(false);
					}
					
				}
				//if poisoned
				
				else if(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getPoison() == true)
				{
					System.out.println("Deciding whether Poisoned or not");
					//if there are decide whether they are removed
					int x = RM.GenerateNumber(5);
					if(x > 3)
					{
						//Player becomes free of status
						FightModel.getInstance().setSpoken("Player recovered!");
						System.out.println("Player recovered!");
						FV.Pause(1000);
						FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).setPoison(false);
					}
					else
					{
						//player waits turn out
						FightModel.getInstance().setSpoken("Player is Poisoned");
						System.out.println("Player is Poisoned");
						FV.Pause(1000);
					}
					
				}
				//if Confused
				
				else if(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getConfused() == true)
				{
					System.out.println("Deciding whether Confused or not");
					//if there are decide whether they are removed
					int x = RM.GenerateNumber(5);
					if(x > 3)
					{
						//Player becomes free of status
						FightModel.getInstance().setSpoken("Player recovered!");
						System.out.println("Player recovered!");
						FV.Pause(1000);
						FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).setConfused(false);
					}
					else
					{
						//can player play
						FightModel.getInstance().setSpoken("Player is Confused");
						System.out.println("Player is Confused");
						FV.Pause(1000);
						System.out.println("Deciding whether player can play or not");
						//if there are decide whether they are removed
						int y = RM.GenerateNumber(5);
						if(y > 3)
						{
							//player waits turn out
							FightModel.getInstance().setSpoken("Player hit self");
							System.out.println("Player hit self");
							FV.Pause(1000);
							FightModel.getInstance().setPlayerTurn(false);
						}
					}
				}
				
				//if Burned
				
				else if(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getBurned() == true)
				{
					System.out.println("Deciding whether Burnt");
					//if there are decide whether they are removed
					int x = RM.GenerateNumber(5);
					if(x > 3)
					{
						//Player becomes free of status
						FightModel.getInstance().setSpoken("Player recovered!");
						System.out.println("Player recovered!");
						FV.Pause(1000);
						FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).setBurned(false);
					}
					else
					{
						//player waits turn out
						FightModel.getInstance().setSpoken("Player is Burnt");
						System.out.println("Player is Burnt");
						FV.Pause(1000);
					}
					
				}	
				
				//if frozen
				else if(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getFrozen() == true)
				{
					System.out.println("Deciding whether frozen or not");
					//if there are decide whether they are removed
					int x = RM.GenerateNumber(5);
					System.out.println(x);
					if(x > 1)
					{
						//Player becomes free of status
						FightModel.getInstance().setSpoken("Player Broke Free!");
						System.out.println("Player Broke Free!");
						FV.Pause(1000);
						FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).setFrozen(false);
					}
					else
					{
						//player waits turn out
						FightModel.getInstance().setSpoken("Player is Frozen Solid");
						System.out.println("Player is Frozen Solid");
						FV.Pause(1000);
						FightModel.getInstance().setPlayerTurn(false);
					}
					
				}
				
				//if paralysed
				else if(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getParalysed() == true)
				{
					System.out.println("Deciding whether paralysed or not");
					//if there are decide whether they are removed
					int x = RM.GenerateNumber(5);
					if(x > 3)
					{
						//Player becomes free of status
						FightModel.getInstance().setSpoken("Player is paralysed No more!");
						System.out.println("Player is paralysed no more!");
						FV.Pause(1000);
						FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).setParalysed(false);
					}
					else
					{
						//player waits turn out
						FightModel.getInstance().setSpoken("Player is Paralysed");
						System.out.println("Player is Paralysed");
						FV.Pause(1000);
						System.out.println("Deciding whether player can play or not");
						//if there are decide whether they are removed
						int y = RM.GenerateNumber(5);
						if(y > 2)
						{
							//player waits turn out
							FightModel.getInstance().setSpoken("Player cannot move");
							System.out.println("Player cannot move");
							FV.Pause(1000);
							FightModel.getInstance().setPlayerTurn(false);
						}
					}
				}
				
				//if not sleeping 
				//if not frozen
				//dont need to include poisoned as this does not affect a players move
				//same with burned
				//confusion is worked out earlier
				//same with paralysis
				if(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getSleeping() == false &&
						FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getFrozen() == false &&
						FightModel.getInstance().isPlayerTurn() == true)
				{
					CH.choices();
				}
			}
			//if pokemon has been changed
			else if(FightModel.getInstance().getSpeech() == false && FightModel.getInstance().getPokemonChanged() == true)
			{
				FightModel.getInstance().setChange(false);
				FightModel.getInstance().setSpeech(true);
				FV.Pause(1000);
				FightModel.getInstance().setSpoken(FightModel.getInstance().getPlayerParty().get(FightModel.getInstance().getPlayerCurrent()).getName() + " I CHOOSE YOU!");
				FV.Pause(1000);
				FightModel.getInstance().setxPos(7);
				FightModel.getInstance().setyPos(76);
				FightModel.getInstance().setPokemonChanged(false);
				FightModel.getInstance().setPlayerTurn(false);
			}
		}
	}
}