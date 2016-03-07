package Driver;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import Controller.FightController;
import Model.FightModel;
import Model.PlayerCreate;
import Model.PokemonState;
import Sound.SoundDemo;
import View.FightView;

public class Driver extends Thread{

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException 
	{
		PlayerCreate PC = new PlayerCreate();
		final FightController FC = new FightController();
		FightView FV = new FightView();
		FightModel.getInstance().setxPos(7);
		FightModel.getInstance().setyPos(76);
		final SoundDemo SD = new SoundDemo();
		
		final ArrayList<PokemonState> currentPokemon = PC.createPlayer("Player1.xlsx");
		final ArrayList<PokemonState> enemyPokemon = PC.createPlayer("Enemy1.xlsx");
		
		
		JFrame jf = new JFrame();
		jf.setSize(FightModel.getInstance().getTotalWidth(), FightModel.getInstance().getTotalHeight());

		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(FV);
		jf.setVisible(true);
		
		
		//threading to play music and game together
		Thread music = new Thread() {
		    public void run() {
		        SD.playSound("battlemusic2.wav");
		    }
		};
		Thread music2 = new Thread() {
		    public void run() {
		        SD.playSound("battleend1.wav");
		    }
		};

		Thread game = new Thread() {
		    public void run() {
		    	FC.runBattle(currentPokemon, enemyPokemon);
		    }
		};
		// Start the music and the game.
		music.start();
		game.start();
		
		boolean x = true;
		//until game ends
		while(x == true)
		{
			if(game.getState() == Thread.State.TERMINATED)
			{
				music.stop();
				FV.Pause(300);
				music2.start();
				x = false;
			}
			
		}
	}	

}