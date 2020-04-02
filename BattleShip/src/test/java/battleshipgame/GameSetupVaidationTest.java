package battleshipgame;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import battleshipgame.utils.GameSetupValidation;

public class GameSetupVaidationTest {

	GameSetupValidation sut;

	@Before
	public void initialise() {
		sut = GameSetupValidation.getInstance();
	}

	@Test
	public void validateInvalidShipDimensionsTest() {
		int widthofShip = 20;
		int heightofShip = 10;
		int battleFieldWidth = 1;
		int battleFieldHeight = 1;
		assertFalse(sut.validateShipDimensions(widthofShip, heightofShip, battleFieldWidth, battleFieldHeight));
	}

	@Test
	public void validateValidShipDimensionsTest() {
		int widthofShip = 2;
		int heightofShip = 1;
		int battleFieldWidth = 7;
		int battleFieldHeight = 6;
		assertTrue(sut.validateShipDimensions(widthofShip, heightofShip, battleFieldWidth, battleFieldHeight));
	}
	
	@Test
	public void validateInvalidNumberOfShipsTest() {
		int numOfShips=	0;
		int battleFieldWidth=3; 
		int battleFieldHeight=4;
		assertFalse(sut.validateNumberOfShips(numOfShips, battleFieldWidth, battleFieldHeight));
	}
	
	
	@Test
	public void validateValidNumberOfShipsTest() {
		int numOfShips=	10;
		int battleFieldWidth=3; 
		int battleFieldHeight=4;
		assertTrue(sut.validateNumberOfShips(numOfShips, battleFieldWidth, battleFieldHeight));
	}

	
	@Test
	public void validateInValidWidhBattleFieldTest() {
		int battleFieldWidth=50; 
		int battleFieldHeight=2;
		assertFalse(sut.validateBattleField(battleFieldWidth, battleFieldHeight));
	}
	
	
	@Test
	public void validateInValidHeightBattleFieldTest() {
		int battleFieldWidth=5; 
		int battleFieldHeight=26;
		assertFalse(sut.validateBattleField(battleFieldWidth, battleFieldHeight));
	}
	
	
	@Test
	public void validateValidBattleFieldTest() {
		int battleFieldWidth=5; 
		int battleFieldHeight=24;
		assertTrue(sut.validateBattleField(battleFieldWidth, battleFieldHeight));
	}
}
