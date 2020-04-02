/**
 * 
 */
package battleshipgame;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import battleshipgame.exception.BattleShipGameException;
import battleshipgame.runner.GameSetup;

/**
 * @author aniket
 *
 */
public class GameSetupTest {

	GameSetup sut;
	File file;
	int battleFieldWidht =10;
	int battleFieldHeight =10;
	@Before
	public void initialize() {
		sut= new GameSetup();
		//file = new File("input2.txt");
	}
	
	
	@Test(expected=BattleShipGameException.class)
	public void readInvalidBattleFieldTest() throws FileNotFoundException, BattleShipGameException{
		File invalidFile = new File(this.getClass().getResource("/InvalidBattleFieldDimension").getFile());
		sut.setupGame(invalidFile);
	}
	
	
	@Test(expected=FileNotFoundException.class)
	public void readMissingFileTest() throws FileNotFoundException, BattleShipGameException{
		File fileNotPresent = new File(("/InvalidFile"));
		sut.setupGame(fileNotPresent);
	}
	
	
	
	@Test(expected=BattleShipGameException.class)
	public void readInvalidNumberofShipsTest() throws FileNotFoundException, BattleShipGameException{
		File invalidShips = new File(this.getClass().getResource("/InvalidNumberofShips").getFile());
		sut.setupGame(invalidShips);
	}
	
	
	@Test(expected=BattleShipGameException.class)
	public void readInvalidShipDimensionsTest() throws FileNotFoundException, BattleShipGameException{
		File invalidShipDimensions = new File(this.getClass().getResource("/InvalidShipDimensions").getFile());
		sut.setupGame(invalidShipDimensions);
	}
	
	
	@Test(expected=BattleShipGameException.class)
	public void readInvalidFiringCoordinatesTest() throws FileNotFoundException, BattleShipGameException{
		File invalidFiringCoordinates = new File(this.getClass().getResource("/InvalidFiringCoordinates").getFile());
		sut.setupGame(invalidFiringCoordinates);
	}
	
	
	@Test(expected=BattleShipGameException.class)
	public void readMissingFiringCoordinatesTest() throws FileNotFoundException, BattleShipGameException{
		File missingFiringCoordinates = new File(this.getClass().getResource("/MissingFiringCoordinates").getFile());
		sut.setupGame(missingFiringCoordinates);
	}
	
	
	
	
	
	@Test
	public void readValidInputTest() throws FileNotFoundException, BattleShipGameException {
		File missingFiringCoordinates = new File(this.getClass().getResource("/validFile").getFile());
		sut.setupGame(missingFiringCoordinates);

	}
	
	
	
	
	
	
}
