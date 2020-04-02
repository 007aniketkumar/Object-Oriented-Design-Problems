/**
 * 
 */
package battleshipgame;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import battleshipgame.entity.BattleArea;
import battleshipgame.entity.Coordinates;
import battleshipgame.entity.Player;
import battleshipgame.utils.Response;

/**
 * @author aniket
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

	
	Player sut;
	
	@Mock
	BattleArea battleArea;
	
	@Mock
	BattleArea enemyArea;
	
	@Before
	public void intialize() {
		List<Coordinates> missiles = new ArrayList<>();
		int playerID = 1;
		sut= new Player(playerID,missiles,battleArea);
		
	}
	
	
	@Test
	public void testFireMissile() {
	Coordinates firingCoordinates = new Coordinates(0,0);
	Map<Coordinates,Integer> stubMap = new HashMap<>();
	stubMap.put(new Coordinates(0,0), 2);
	Mockito.when(enemyArea.getOccupied()).thenReturn(stubMap);
	Response response = sut.fireMissile(firingCoordinates,enemyArea);
	assertTrue(response.getResponse());
		
	}
	
	
	
	@Test
	public void testMissFireMissile() {
	Coordinates firingCoordinates = new Coordinates(1,1);
	Map<Coordinates,Integer> stubMap = new HashMap<>();
	stubMap.put(new Coordinates(0,0), 2);
	Mockito.when(enemyArea.getOccupied()).thenReturn(stubMap);
	Response response = sut.fireMissile(firingCoordinates,enemyArea);
	assertFalse(response.getResponse());
		
	}
	
	
	@Test
	public void testLosingStatus() {
		Map<Coordinates,Integer> stubMap = new HashMap<>();//empty map
		Mockito.when(battleArea.getOccupied()).thenReturn(stubMap);
		assertTrue(sut.losingStatus());
	}
	
	@Test
	public void testWinStatus() {
		Map<Coordinates,Integer> stubMap = new HashMap<>();//empty map
		stubMap.put(new Coordinates(0,0), 2);
		Mockito.when(battleArea.getOccupied()).thenReturn(stubMap);
		assertFalse(sut.losingStatus());
	}
}
