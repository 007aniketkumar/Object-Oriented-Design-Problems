/**
 * 
 */
package parkinglot;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import parkinglot.domain.ParkingLevel;
import parkinglot.domain.ParkingLot;
import parkinglot.domain.ParkingSlotType;
import parkinglot.domain.Vehicle;
import parkinglot.exception.ParkingLotException;

/**
 * @author aniket
 *
 */
public class ParkingLotBasicDataSetTest {

ParkingLot sut;

	

	@Before public void initialise() throws ParkingLotException{
		sut = new ParkingLot(2);
		sut.initializeParkingLot("CAR", 1);
		sut.park(new Vehicle("KA-01-P-333", "White", "CAR"));
		sut.park(new Vehicle("KA-01-HH-9999", "White", "CAR"));
	}

	@Test
	public void testLeaveMethod() {

		assertFalse("This case should return 'false'", sut.leave(4));// No parking lot is present at this slot
		assertTrue("This case should return 'true'", sut.leave(1));
	}

	@Test
	public void testGetRegistrationNumberFromColor() {
		List<String> registrationNumber = new ArrayList<>();
		registrationNumber.add("KA-01-P-333");
		registrationNumber.add("KA-01-HH-9999");
		assertArrayEquals(registrationNumber.toArray(), sut.getRegistrationNumberFromColor("White").toArray());

	}

	@Test
	public void testGetRegistrationNumberFromColorNotFound() {
		List<String> registrationNumber = new ArrayList<>();
		registrationNumber.add("KA-01-P-333");
		registrationNumber.add("KA-01-HH-0001");
		assertNotEquals(registrationNumber.size(), sut.getRegistrationNumberFromColor("BLACK").size());
	}

	@Test
	public void testGetSlotNumbersFromColor() {
		List<Integer> slotNumber = new ArrayList<>();
		slotNumber.add(1);
		slotNumber.add(2);
		assertArrayEquals(slotNumber.toArray(), sut.getSlotNumbersFromColor("White").toArray());
	}

	@Test
	public void testGetSlotNumbersFromColorNotFound() {
		List<Integer> slotNumber = new ArrayList<>();
		slotNumber.add(1);
		slotNumber.add(2);
		assertNotEquals(slotNumber.toArray(), sut.getSlotNumbersFromColor("RED").toArray());
		assertNotEquals(slotNumber.size(), sut.getSlotNumbersFromColor("RED").size());
	}
	
	@Test
	public void getSlotNumberFromRegistration() {
		assertEquals(1,sut.getSlotNumberFromRegistration("KA-01-P-333"));
	}	
	
	
	@Test
	public void getSlotNumberFromRegistrationNotFound() {
		assertEquals(-1,sut.getSlotNumberFromRegistration("KA-01-P-4333"));
	}
	
	
	@Test
	public void testsetParkingLevels() throws ParkingLotException{
		sut.setParkingLevels(5, "CAR", 1);
		ParkingLevel parkingLevel = sut.getParkingLot().get(1);
		assertEquals(1,parkingLevel.getLevelID());
		assertEquals(5,parkingLevel.getParkingSpots().get(ParkingSlotType.valueOf("CAR")).size());
		
	}

}
