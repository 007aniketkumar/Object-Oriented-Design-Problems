/**
 * 
 */
package battleshipgame.runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import battleshipgame.entity.BattleArea;
import battleshipgame.entity.BattleShip;
import battleshipgame.entity.Coordinates;
import battleshipgame.entity.Player;
import battleshipgame.entity.ShipType;
import battleshipgame.exception.BattleShipGameErrorCodes;
import battleshipgame.exception.BattleShipGameException;
import battleshipgame.utils.BattleShipConstants;
import battleshipgame.utils.BattleShipGameUtils;
import battleshipgame.utils.GameSetupValidation;
import lombok.Getter;

/**
 * @author aniket
 *
 *         Steps :
 *
 *         Read the input file . Set the missiles for each player Place the
 *         ships in their respective battle areas
 * 
 *         Emit relevant events , in case the coordinates are invalid
 * 
 *
 *
 *
 *
 *
 *         5 E 
 *         2 
 *         Q 1 1 A1 B2 
 *         P 2 1 D4 C3 
 *         A1 B2 B2 B3 
 *         A1 B2 B3 A1 D1 E1 D4 D4 D5
 *         
 * 
 */

@Getter
public class GameSetup {

	List<Player> players = new ArrayList<>();
	List<BattleArea> battleAreas = new ArrayList<>();
	int battleFieldWidht = 0;
	int battleFieldHeight = 0;
	int noOfships = 0;

	/**
	 * 
	 * This method accepts input from a file and initialises the game board and
	 * players
	 * 
	 * Places the ships in correct locations
	 * 
	 * 
	 * @param inputFile
	 * @throws FileNotFoundException
	 * @throws BattleShipGameException
	 */
	public void setupGame(File inputFile) throws FileNotFoundException, BattleShipGameException {
		Scanner sc = new Scanner(inputFile); // Even if the file is not found , the caller will handle the exception
		try {

			initializeBattleFieldAndPlayer(sc);
			// Check the number of ships
			sc.nextLine();
			noOfships = sc.nextInt();
			validateNumberofShips(noOfships);
			sc.nextLine();
			for (int j = 0; j < noOfships; j++) {
				String shipDetails = sc.nextLine();
				readShipDetails(shipDetails);
			}	
			setFiringCoordinates(sc);
			placeShipInBattleArea();
		} finally {
			sc.close();
		}
	}

	private void placeShipInBattleArea() {
		for (int i = 0; i < BattleShipConstants.TOTAL_PLAYERS; i++) {
			battleAreas.get(i).placeShips();
		}
	}

	/**
	 * 
	 * Sets the firing coordinates for each player. This takes scanner instance
	 * because it needs to iterate each line based on the number of players.
	 * 
	 * Input format is : A1 B2 C3 D4
	 * 
	 */
	private void setFiringCoordinates(Scanner sc) throws BattleShipGameException {

		try {
			// set firing coordinates for each player
			for (int i = 0; i < BattleShipConstants.TOTAL_PLAYERS; i++) {
				String missiles = sc.nextLine();
				players.get(i).getHitMissiles()
						.addAll(BattleShipGameUtils.getInstance().fetchFiringCoordinates(missiles));
				// print the hit coordinates of each player
				//System.out.println("Player:" + players.get(i).getPlayerID() + " Missile coordinate:");
				//players.get(i).getHitMissiles().forEach(" "+System.out::print);

			}
		} catch (Exception e) {
			throw new BattleShipGameException(BattleShipGameErrorCodes.errorCodeToMessageMapping.get("6"));
		}
	}
	

	/**
	 * 
	 * Creates an instance of List @link BattleArea and List @link players
	 * Each @link Player has a BattleArea Each Battle Area has BattleShips
	 * 
	 */
	private void initializeBattleFieldAndPlayer(Scanner sc) throws BattleShipGameException {

		try {
			battleFieldWidht = sc.nextInt();
			battleFieldHeight = sc.next().toUpperCase().charAt(0) - 64;
			if (!GameSetupValidation.getInstance().validateBattleField(battleFieldWidht, battleFieldHeight)) {
				throw new BattleShipGameException();

			}
			for (int i = 1; i <= BattleShipConstants.TOTAL_PLAYERS; i++) {
				BattleArea battleArea = new BattleArea(new ArrayList<BattleShip>(), battleFieldWidht, battleFieldHeight,
						i, new HashMap<Coordinates, Integer>());
				Player player = new Player(i, new ArrayList<Coordinates>(), battleArea);
				players.add(player);
				battleAreas.add(battleArea);
			}
		} catch (Exception e) {
			throw new BattleShipGameException(("1"));
		}
	}

	/**
	 * 
	 * The placement is as per the ships: Ship Q with width and height Followed by
	 * position on board 1 and position on board 2.
	 * 
	 *  Reads the input :
	 *  Q 1 1 A1 B2
	 *  
	 *  Places A1 in battle area 1 and places B2 in battle area 2
	 * 
	 */

	private void readShipDetails(String shipDetail) throws BattleShipGameException {

		try {
				int i=0;
				int j=0;
				String[] shipDetails = shipDetail.split("\\s");
				String typeOfShip = shipDetails[j];
				ShipType shiptype = ShipType.valueOf(typeOfShip);// handle the enum exception if case of not defined
																	// type
				int shipWidth = Integer.parseInt(shipDetails[++j]);
				int shipHeight = Integer.parseInt(shipDetails[++j]);
				if (!GameSetupValidation.getInstance().validateShipDimensions(shipWidth, shipHeight, battleFieldWidht,
						battleFieldHeight)) {
					throw new BattleShipGameException();
				}
				// The coordinates are passed in the input format
				// A1 B2 C3 D4 ... where A1 is for for player 1, B2 is for player 2 and so on

				//for (int i = 0; i < BattleShipConstants.TOTAL_PLAYERS; i++) {
				while(j<shipDetails.length-1) {
					Coordinates coordinates = BattleShipGameUtils.getInstance().fetchCoordinates(shipDetails[++j]);
					// prepare a ship , its type and coordinates and add it to the list of Ships in
					// a battle area.
					BattleShip ship = new BattleShip(shiptype, coordinates);
					battleAreas.get(i%BattleShipConstants.TOTAL_PLAYERS).getBattleShips().add(ship);// initially add the list of ships to the respectivr
																	// battle areas
				i++;}
			
		} catch (IllegalArgumentException e) {
			throw new BattleShipGameException("8");
		} catch (Exception e) {
			throw new BattleShipGameException(("2"));
		}
	}

	
	/**
	 * throws BattleShipGameException if the validation fails
	 * @see GameSetupValidation
	 * 
	 */
	private void validateNumberofShips(int noOfships) throws BattleShipGameException {
		try {
			if (!GameSetupValidation.getInstance().validateNumberOfShips(noOfships, battleFieldWidht,
					battleFieldHeight)) {
				throw new BattleShipGameException();
			}
		} catch (Exception e) {
			throw new BattleShipGameException(("3"));
		}
	}

}