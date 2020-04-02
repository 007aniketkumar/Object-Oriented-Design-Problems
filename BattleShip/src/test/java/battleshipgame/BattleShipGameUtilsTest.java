package battleshipgame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import battleshipgame.entity.Coordinates;
import battleshipgame.utils.BattleShipGameUtils;

public class BattleShipGameUtilsTest {

	BattleShipGameUtils sut;
	
	@Before
	public void initialize() {
		sut = BattleShipGameUtils.getInstance();
	}
	
	@Test
	public void fetchCoordinatesTest() {
		String location ="A1";
		Coordinates sample = sut.fetchCoordinates(location);
		assertEquals(0, sample.getXCoordinate());
		assertEquals(0,sample.getYCoordinate());
	}
	
	
	
	@Test
	public void fetchFiringCoordinateTest() {
		List<Coordinates> stub = new ArrayList<>();
		stub.add(new Coordinates(0,0));
		stub.add(new Coordinates(1,1));
		List<Coordinates> response =sut.fetchFiringCoordinates("A1 B2");
		assertSame(0, response.get(0).getXCoordinate());
		assertSame(0, response.get(0).getYCoordinate());
		assertSame(1, response.get(1).getXCoordinate());
		assertSame(1, response.get(1).getYCoordinate());





	}
	
	

}
