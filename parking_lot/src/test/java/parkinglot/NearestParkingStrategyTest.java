package parkinglot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.util.PriorityQueue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import parkinglot.domain.ParkingSlot;
import parkinglot.domain.ParkingSlotType;
import parkinglot.domain.Ticket;
import parkinglot.domain.Vehicle;
import parkinglot.exception.ParkingLotException;
import parkinglot.repository.ParkingLotRepository;
import parkinglot.strategy.BasicDataStrategy;
import parkinglot.strategy.DataScalingStrategy;
import parkinglot.strategy.NearestParkingStrategy;

public class NearestParkingStrategyTest {

	NearestParkingStrategy sut;
	DataScalingStrategy<ParkingSlot, Ticket> dataScalingStrategy;

	@Before public void initialise() throws ParkingLotException{
		dataScalingStrategy = new BasicDataStrategy();
		sut = new NearestParkingStrategy(dataScalingStrategy);
		ParkingLotRepository.getInstance().createParkingSlots(ParkingSlotType.valueOf("CAR"),2,1);

	}
	
	@After public void tearDown() {
		//clear the map
		ParkingLotRepository.getInstance().getParkingSpotsRepo().clear();
	}

	
	
	/*
	 * 
	 * Test that the parking slot is not created yet , but I am still trying to park a vehicle.
	 * Can this exception and then throw parking lot exception from the code , with the message that
	 * parking lot needs to be created first to park
	 * 
	 */
	@Test(expected=ParkingLotException.class)
	public void testParkParkingSlotSlotsNotCreated() throws ParkingLotException{
		ParkingLotRepository.getInstance().getParkingSpotsRepo().clear();

		sut.park(new Vehicle("KA-01-P-333", "White", "CAR"));
		PriorityQueue<ParkingSlot> parkingSlot = ParkingLotRepository.getInstance().getParkingSpotsRepo()
				.get(ParkingSlotType.valueOf("CAR"));
		assertEquals(1, parkingSlot.size());

	}
	
	
	@Test
	public void testPark() throws ParkingLotException{

		sut.park(new Vehicle("KA-01-P-333", "White", "CAR"));
		PriorityQueue<ParkingSlot> parkingSlot = ParkingLotRepository.getInstance().getParkingSpotsRepo()
				.get(ParkingSlotType.valueOf("CAR"));
		
		Ticket ticket = ParkingLotRepository.getInstance().getTicketRepo().get(1);
		assertEquals(1, parkingSlot.size());
		// one slot has been allocated from the total slots, to capacity decreases
											// by 1
		
		//check that the above White color vehicle is parked.
		assertEquals("White",ticket.getVehicle().getColor());
	}
	
	
	

	@Test
	public void testParkNoSpaceLeft() throws ParkingLotException{

		sut.park(new Vehicle("KA-01-P-333", "White", "CAR"));
		sut.park(new Vehicle("KA-01-P-111", "Black", "CAR"));
		PriorityQueue<ParkingSlot> parkingSlot = ParkingLotRepository.getInstance().getParkingSpotsRepo()
				.get(ParkingSlotType.valueOf("CAR"));
		assertEquals(0, parkingSlot.size());// one slot has been allocated from the total slots, to capacity decreases
											// by 1
	}

	/*
	 * 
	 * Handle the case of invalid Vechile type being parked
	 * 
	 */
	
	@Test(expected=ParkingLotException.class)
	public void testParkInvalidVehicleType() throws ParkingLotException{
		sut.park(new Vehicle("KA-01-P-333", "White", "TRAIN"));
		PriorityQueue<ParkingSlot> parkingSlot = ParkingLotRepository.getInstance().getParkingSpotsRepo()
				.get(ParkingSlotType.valueOf("TRAIN"));
		assertEquals(2, parkingSlot.size());// one slot has been allocated from the total slots, to capacity decreases

	}

	
	@Test 
	public void testStatus() throws ParkingLotException{
		sut.park(new Vehicle("KA-01-P-333", "White", "CAR"));
		sut.park(new Vehicle("KA-01-P-111", "Black", "CAR"));
		String registrationNumber1 = ParkingLotRepository.getInstance().getTicketRepo().get(1).getVehicle().getRegistrationNumber();
		String registrationNumber2 = ParkingLotRepository.getInstance().getTicketRepo().get(2).getVehicle().getRegistrationNumber();

		assertEquals("KA-01-P-333",registrationNumber1);
		assertEquals("KA-01-P-111",registrationNumber2);
	}
	
	
	@Test
	public void testLeaveBeforeInitialization() {
		ParkingLotRepository.getInstance().getParkingSpotsRepo().clear();
		assertFalse(sut.leave(5));

	}
	
}
	

