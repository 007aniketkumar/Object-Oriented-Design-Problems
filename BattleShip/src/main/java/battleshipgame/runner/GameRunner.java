package battleshipgame.runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import battleshipgame.entity.BattleArea;
import battleshipgame.entity.Player;
import battleshipgame.exception.BattleShipGameErrorCodes;
import battleshipgame.exception.BattleShipGameException;
import battleshipgame.strategy.DefaultPlayingStrategy;
import battleshipgame.strategy.PlayingStrategy;
import battleshipgame.utils.BattleShipGameUtils;

/**
 * 
 * 
 * This class accepts an input from a file //System run the game accordingly.
 * 
 * 5 E 
 * 2 
 * Q 1 1 A1 B2 
 * P 2 1 D4 C3 
 * A1 B2 B2 B3 
 * A1 B2 B3 A1 D1 E1 D4 D4 D5 D5
 * 
 * 
 * 
 * 
 * @author aniket
 *
 */

public class GameRunner {

	//Logger logger = new Logger(GameRunner.class);
	
	static GameRunner gameRunner = new GameRunner();

	public static void main(String[] args) {
		GameSetup gameSetup = new GameSetup();
		BattleShipGameErrorCodes.ErrorCodeMapping();
		try {
			File file = new File("samples/valid.txt");
			// provide the i/p file location
			gameSetup.setupGame(file);
		} catch (FileNotFoundException e) {
			 System.out.println(BattleShipGameErrorCodes.errorCodeToMessageMapping.get("7"));
			 terminateGame();

			
		} catch (BattleShipGameException e) {
			 String message =e.getMessage();
			 System.out.println(BattleShipGameErrorCodes.errorCodeToMessageMapping.get(message));
			 terminateGame();
			}
		List<Player> players = gameSetup.getPlayers();
		List<BattleArea> battleArea = gameSetup.getBattleAreas();
		//There is no identifier to differentiate a strategy, so we are taking a default strategy.
		//This ofcourse can be changed one there is an identifier passed, then a basic factory method can be written to 
		//identify the same
		PlayingStrategy playingStrategy = new DefaultPlayingStrategy();
		gameRunner.playGame(players, battleArea,playingStrategy);
	}
	
	
	/**
	 * 
	 * 
	 * 
	 * @param players
	 * @param battleArea
	 */
	public  void playGame(List<Player> players, List<BattleArea> battleArea,PlayingStrategy playingStrategy) {
		Player player1 = players.get(0);
		Player player2 = players.get(1);

		while (!player1.losingStatus() && !player2.losingStatus())
		{
			if (player1.getHitMissiles().size() == 0 && player2.getHitMissiles().size() == 0) {
				System.out.println("Game drawn");
				break;
			}
			for(Player player:players)
				BattleShipGameUtils.getInstance().checkArsenal(player);
			while (player1.getHitMissiles().size() > 0) {
				if( playingStrategy.playingStrategy(player1, player2)==0) {
					GameRunner.terminateGame();
				}break;//to change the  players
			}
			while (player2.getHitMissiles().size() > 0) {
				 if(playingStrategy.playingStrategy(player2, player1)==0) {
						GameRunner.terminateGame();

				 }break;
			}
			
				
		}
	}
	
	
	 

	
	
	  
	  /**
	   *  End the game 
	   * 
	   * 
	   */
	 static  void terminateGame() {
		  System.exit(0);
	  }
}
