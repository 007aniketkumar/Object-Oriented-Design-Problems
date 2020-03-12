package parkinglot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import parkinglot.controller.ValidationProcess;
import parkinglot.domain.ParkingLot;
import parkinglot.exception.ParkingLotErrorCodes;
import parkinglot.utils.ParkingLotConstants;


//String parkingCommands,String[] query,ParkingLot parkingLotInstance, ParkingLotErrorCodes errorCode
public class ValidationProcessTest {

	ParkingLotErrorCodes errorCodes ;
	ValidationProcess sut;
	ParkingLot parkingLot;
	
	@Before public void initialize() {
		
		errorCodes = new ParkingLotErrorCodes();
		errorCodes.initiliaseErrorCodeMapping();
		sut= new ValidationProcess();
		
	}
	
	
	
	@Test
	public void validateCreate_parking_lotTest() {
		String[] input = "create_parking_lot 6".split(" ");
		assertTrue(sut.validate("create_parking_lot",input,parkingLot,errorCodes));
	}
	
	
	@Test
	public void validateCreate_parking_lotInvalidTest() {
		String[] input = "create_parking_lot A".split(" ");
		assertFalse(sut.validate("create_parking_lot",input,parkingLot,errorCodes));
		assertEquals("3",errorCodes.getErrorCode());
	}
	
	
	//no number defined
	@Test
	public void validateCreate_parking_lot_NoSlotsTest() {
		String[] input = "create_parking_lot".split(" ");
		assertFalse(sut.validate("create_parking_lot",input,parkingLot,errorCodes));
		assertEquals("3",errorCodes.getErrorCode());
	}
	
	
	@Test
	public void validateleaveTest() {
		String[] input = "leave 6".split(" ");
		parkingLot = new ParkingLot(6);
		assertTrue(sut.validate("leave",input,parkingLot,errorCodes));
	}
	
	
	
	
	@Test
	public void validateleaveBeforeCreationTest() {
		String[] input = "leave 6".split(" ");
		assertFalse(sut.validate("leave",input,parkingLot,errorCodes));
		assertEquals("4",errorCodes.getErrorCode());

	}
	
	
	
	@Test
	public void validateleaveInvalidParamsTest() {
		String[] input = "leave A".split(" ");
		parkingLot = new ParkingLot(6);
		assertFalse(sut.validate("leave",input,parkingLot,errorCodes));
		assertEquals("3",errorCodes.getErrorCode());

	}
	
	
	@Test
	public void validateleaveLessParamsTest() {
		String[] input = "leave".split(" ");
		parkingLot = new ParkingLot(6);
		assertFalse(sut.validate("leave",input,parkingLot,errorCodes));
		assertEquals("3",errorCodes.getErrorCode());

	}
	
	
	@Test
	public void validateSearchTest() {
		String[] input = "registration_numbers_for_cars_with_colour White".split(" ");
		parkingLot = new ParkingLot(6);
		assertTrue(sut.validate("validateSearch",input,parkingLot,errorCodes));

	}
	
	
	@Test
	public void validateSearchInvalidParamTest() {
		String[] input = "registration_numbers_for_cars_with_colour".split(" ");
		parkingLot = new ParkingLot(6);
		assertFalse(sut.validate("validateSearch",input,parkingLot,errorCodes));
		//assertEquals("3",errorCodes.getErrorCode());


	}
}
