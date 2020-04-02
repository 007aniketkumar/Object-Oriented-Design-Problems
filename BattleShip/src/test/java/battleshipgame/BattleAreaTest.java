package battleshipgame;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import battleshipgame.entity.BattleArea;
import battleshipgame.entity.BattleShip;
import battleshipgame.entity.Coordinates;
import battleshipgame.entity.ShipType;

public class BattleAreaTest {

	BattleArea sut;
	
	
	
	
	
	@Test
	public void placeShipTest() {
		List<BattleShip> battleShips= new ArrayList<>();
		 BattleShip battleShip = new BattleShip(ShipType.Q,new Coordinates(0,0));
		 int width=3;
		 int height=3;
		 battleShips.add(battleShip);
		 Coordinates shipCoordinates = new Coordinates(1,2);
		 Map<Coordinates,Integer> occupied = new HashMap<>();
		 occupied.put(shipCoordinates, 2);
		 sut = new BattleArea(battleShips,width,height,1,occupied);
		assertTrue(sut.placeShips());	
		}
	
	
	@Test
	public void placeShipOutsideTest() {
		List<BattleShip> battleShips= new ArrayList<>();
		 BattleShip battleShip = new BattleShip(ShipType.Q,new Coordinates(5,5));
		 int width=1;
		 int height=1;
		 battleShips.add(battleShip);
		 Coordinates shipCoordinates = new Coordinates(5,5);
		 Map<Coordinates,Integer> occupied = new HashMap<>();
		 occupied.put(shipCoordinates, 2);
		 sut = new BattleArea(battleShips,width,height,1,occupied);
		 assertFalse(sut.placeShips());
		}
	
	
	@Test
	public void placeShipOccupiedTest() {
		List<BattleShip> battleShips= new ArrayList<>();
		 BattleShip battleShip = new BattleShip(ShipType.Q,new Coordinates(1,1));
		 int width=3;
		 int height=3;
		 battleShips.add(battleShip);
		 Coordinates shipCoordinates = new Coordinates(1,1);
		 Map<Coordinates,Integer> occupied = new HashMap<>();
		 occupied.put(shipCoordinates, 2);
		 sut = new BattleArea(battleShips,width,height,1,occupied);
		 assertFalse(sut.placeShips());
		}
}
