/**
 * 
 */
package parkinglot;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import parkinglot.domain.ParkingLot;
import parkinglot.domain.Vehicle;
import parkinglot.exception.ParkingLotException;

/**
 * @author aniket
 *
 */
public class ParkingLotLargeDataSetTest {

	ParkingLot sut;

	

	@Before public void initialise() throws ParkingLotException{
		sut = new ParkingLot(10);
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
		assertNull(sut.getRegistrationNumberFromColor("BLACK"));
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
		assertNull(sut.getSlotNumbersFromColor("RED"));
		
	}
	
	@Test
	public void getSlotNumberFromRegistration() {
		assertEquals(1,sut.getSlotNumberFromRegistration("KA-01-P-333"));
	}
	
	
	@Test
	public void getSlotNumberFromRegistrationNotFound() {
		assertEquals(-1,sut.getSlotNumberFromRegistration("KA-01-P-4333"));
	}

}
