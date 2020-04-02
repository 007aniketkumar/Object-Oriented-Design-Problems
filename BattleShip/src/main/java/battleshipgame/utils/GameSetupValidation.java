package battleshipgame.utils;

/**
 * 
 * 
 * Validation methods of performing the initial checks of the battle field.
 * 
 * @author aniket
 *
 */

public class GameSetupValidation {

//set a thread safe singleton instance

	private static GameSetupValidation validator;
	
	private GameSetupValidation() {
		
	}

	public static GameSetupValidation getInstance() {
		if (validator == null) {
			validator = new GameSetupValidation();
		}
		return validator;
	}

	/*
	 * 
	 *  1<=ShipWidht<=battleFieldWidth
	 *  1<=ShipHeight<=heightofShip
	 * 
	 */
	
	public boolean validateShipDimensions(int widthofShip, int heightofShip, int battleFieldWidth,
			int battleFieldHeight) {
		return (widthofShip >= 1) && (widthofShip <= battleFieldWidth) && (heightofShip >= 1)
				&& (heightofShip <= battleFieldHeight);
	}

	/*
	 * 
	 * 1<=numOfShips<=battleFieldWidth*battleFieldHeight
	 * 
	 */
	
	public boolean validateNumberOfShips(int numOfShips, int battleFieldWidth, int battleFieldHeight) {
		return (numOfShips >= 1) && (numOfShips <= battleFieldWidth * battleFieldHeight);
	}

	
	/*
	 * 
	 * 
	 * 
	 */
	public boolean validateBattleField(int battleFieldWidth, int battleFieldHeight) {
		
		return ((battleFieldWidth >= BattleShipConstants.MIN_ALLOWED_WIDTH)
				&& (battleFieldWidth <= BattleShipConstants.MAX_ALLOWED_WIDTH)
				&& (battleFieldHeight >= BattleShipConstants.MIN_ALLOWED_HEIGHT)
				&& (battleFieldHeight <= BattleShipConstants.MAX_ALLOWED_HEIGHT));
	}
}
