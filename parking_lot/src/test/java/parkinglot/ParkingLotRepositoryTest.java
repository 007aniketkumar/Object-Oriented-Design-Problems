package parkinglot;

import static org.junit.Assert.assertEquals;
import java.util.Map;
import java.util.PriorityQueue;
import org.junit.Before;
import org.junit.Test;
import parkinglot.domain.ParkingSlot;
import parkinglot.domain.ParkingSlotType;
import parkinglot.exception.ParkingLotException;
import parkinglot.repository.ParkingLotRepository;

public class ParkingLotRepositoryTest {
  
	ParkingLotRepository sut;
	
	
	@Before public void initialize() {
		sut = ParkingLotRepository.getInstance();
	}
	
	//Basic test to check if the parkingLot repo is able to create a parking slots.
	@Test
	public void testCreateParkingSlots() throws ParkingLotException{
		Map<ParkingSlotType, PriorityQueue<ParkingSlot>> parkingSlots = sut.createParkingSlots(ParkingSlotType.valueOf("CAR"), 5,1);
		assertEquals(5,parkingSlots.get(ParkingSlotType.valueOf("CAR")).size());
	}
	
	
	
}
