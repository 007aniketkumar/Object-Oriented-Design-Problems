/**
 * 
 */
package battleshipgame.utils;

import java.util.ArrayList;
import java.util.List;

import battleshipgame.entity.Coordinates;
import battleshipgame.entity.Player;


/**
 * 
 * 
 * @author aniket
 *
 * Has Utility methods to handle support utlity methods for string manipulation for
 * 
 * 
 */
public class BattleShipGameUtils {

	private static BattleShipGameUtils instance = null;
	
	private BattleShipGameUtils() {
		
	}
	
	public static BattleShipGameUtils getInstance() {
		if(instance==null) {
			instance = new BattleShipGameUtils();
			
		}
		return instance;
	}
	
	
	/**
	 * 
	 * Takes String in format A1 and return {@link Coordinates}
	 * 
	 */
	 public Coordinates fetchCoordinates(String location) {
		char[] locations = location.toCharArray();
		int y = locations[0] - 65;// fetch the Ascii coordinates - value of A is 65 , so we get 0 , in case input							// is A
		int x = locations[1] - 49; // fetch the Ascii coordinates- value of 1 is 49 so we get 0, in case input is
									// 1.
		Coordinates coordinates = new Coordinates(x, y, location);
		return coordinates;
	}
	
	 
	 
	 
	/**
	 * 
	 * Takes String in format  : A1 B2 B2 B3
	 * 
	 * @returns List of {@link Coordinates}
	 */
	 public List<Coordinates> fetchFiringCoordinates(String missiles) {
		List<Coordinates> missileCoordinate = new ArrayList<>();
		String[] missile = missiles.split(" ");
		for (String str : missile)
			missileCoordinate.add(fetchCoordinates(str));
		return missileCoordinate;

	}
	 
	 
	 /**
		 * 
		 * 
		 * Check if there are any missiles left. 
		 * Display message appropriately
		 * 
		 * @param player1
		 * @param player2
		 */
		  public boolean checkArsenal(Player player){
			  boolean anyleft = false;
			if (player.getHitMissiles().size() == 0) {
				System.out.print("Player "+ player.getPlayerID()+" has no misiles left \n");
			return anyleft;}
			return true;
			
		}
	
	
}
