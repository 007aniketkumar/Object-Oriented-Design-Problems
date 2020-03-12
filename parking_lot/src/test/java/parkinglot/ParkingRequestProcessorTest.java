package parkinglot;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import parkinglot.controller.ParkingRequestProcessor;
import parkinglot.domain.ParkingSlotType;
import parkinglot.repository.ParkingLotRepository;

public class ParkingRequestProcessorTest {

	ParkingRequestProcessor sut;
	ParkingLotRepository repository = ParkingLotRepository.getInstance();

	@Before
	public void initialise() {

		sut = new ParkingRequestProcessor();

	}

	@After
	public void tearDown() {
		repository.getParkingSpotsRepo().clear();
	}

	@Test
	public void testExecuteforCreatingParkingLot() {

		sut.execute("create_parking_lot 3");
		assertEquals(3, repository.getParkingSpotsRepo().get(ParkingSlotType.valueOf("CAR")).size());
	}

	@Test
	public void testExecuteInvalidInputEntryOnCreation() {

		sut.execute("create_parking_lot A");
		assertEquals(0, repository.getParkingSpotsRepo().size());// no entry created
	}

	@Test
	public void testExecuteLeaveParkingLot() {
		sut.execute("create_parking_lot 3");
		sut.execute("leave 40");// this slot does not exit, so nothing will get freed and will not change impact
								// the parking slots size
		assertEquals(3, repository.getParkingSpotsRepo().get(ParkingSlotType.valueOf("CAR")).size());
	}

	@Test
	public void testExecuteLeaveBeforeCreation() {

		sut.execute("leave 1");
		assertEquals(0, repository.getParkingSpotsRepo().size());// no entry created

	}
	
	@Test
	public void testExecuteLeave() {
		sut.execute("create_parking_lot 3");
		sut.execute("park KA-01-P-333 White");
		sut.execute("leave 1");
		assertEquals(3, repository.getParkingSpotsRepo().get(ParkingSlotType.valueOf("CAR")).size());//number of free entries back to 3

	}
	
	
	@Test 
	public void testExecutePark() {
		sut.execute("create_parking_lot 3");
		sut.execute("park KA-01-P-333 White");
		assertEquals(2, repository.getParkingSpotsRepo().get(ParkingSlotType.valueOf("CAR")).size());// one entry occpied, so number of free entries is reduced by 1
	}

	
	@Test 
	public void testExecuteParkBeforeCreation() { //handling null pointers
		sut.execute("park KA-01-P-333 White");
		assertEquals(0, repository.getParkingSpotsRepo().size());// no entry created
	}
	
	
	
	@Test 
	public void testExecuteParkInvalidParams() {
		//handling invalid params and exceptions
		sut.execute("create_parking_lot 3");
		sut.execute("park White");
		assertEquals(3, repository.getParkingSpotsRepo().get(ParkingSlotType.valueOf("CAR")).size());// No vehicle was parked , so all the entries are still free
	}
	
	
	
}
