package battleshipgame.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import battleshipgame.exception.BattleShipGameErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  Each player a battle Area
 *  
 *  Battle area has ships. 
 * 
 * 
 */

@Getter
@AllArgsConstructor
public class BattleArea {



	// This is created per player . So a battle area will exist for both player A
	// and player B.
	private List<BattleShip> battleShips;
	private int width;
	private int height;
	private int battleId;

	// Map having valid coordinates along with the life at each coordinate
	 private Map<Coordinates,Integer> occupied;
	
	public boolean placeShips() {

		boolean placed=false;
		// place the ships one by one on the battle area , in case placement of any ship
		// fails returns false ,
		// with the total count of ships that
		// could not be placed. In case the total count is equal to the total number of
		// ships , return failure.

		for (BattleShip ship : battleShips) {
			int widthofShip = ship.getShiptype().getWidth();
			int heightOfShip = ship.getShiptype().getHeight();
			int xCoordinate = ship.getLocation().getXCoordinate();
			int yCoordinate = ship.getLocation().getYCoordinate();

			Coordinates desiredLocation = new Coordinates(xCoordinate,yCoordinate);
			
			int horizontalPosOfShip = xCoordinate + widthofShip;
			int verticalPosOfShip = yCoordinate + heightOfShip;

			if (!withIntheBattleField(horizontalPosOfShip, verticalPosOfShip)) {
				//System.out.println(BattleShipGameErrorCodes.errorCodeToMessageMapping.get("5") + ship.getShiptype() + " on location:" +ship.getLocation());
			}

			else if (isOccupied(desiredLocation)) {
				//System.out.println(BattleShipGameErrorCodes.errorCodeToMessageMapping.get("4") + ship.getShiptype() + " on location:" + ship.getLocation());
			}

			// place the ship in the respective coordinates
			else {
			if(placeShip(ship, xCoordinate, yCoordinate))
				placed =true;//even if once ship is successfully placed.
			}

		}

		return placed;}

	
	
	
	private boolean withIntheBattleField(int horizontalPosOfShip, int verticalPosOfShip) {
		return ((horizontalPosOfShip < this.width) || (verticalPosOfShip < this.height));
	}

	
	
	private boolean isOccupied(Coordinates position) {
		return (occupied.containsKey(position));
	}

	
	
	
	
	private boolean placeShip(BattleShip ship, int xCoordinate, int yCoordinate) {
		boolean placed =false;;
		int widthofShip = ship.getShiptype().getWidth();
		int heightOfShip = ship.getShiptype().getHeight();
		Map<Coordinates,Integer> temp = new HashMap<>();
		int shipLife =  ship.getShiptype().getLifePoints();
		
		for(int i=xCoordinate;i<xCoordinate+widthofShip;i++) {
			for(int j=yCoordinate;j<yCoordinate+heightOfShip;j++) {
				Coordinates point = new Coordinates(i,j);
				if (isOccupied(point)) {
					
					return placed; // in case its already occupied
				}
				
			//System.out.println("Ship :"+ship.getShiptype()+" placed at coordinates: "+ ship.getLocation());	
			temp.put(point,shipLife);
			placed=true;
			}
		}
		
		// finally add it back to the original set
		occupied.putAll(temp);
		return placed;
	}




	
}
