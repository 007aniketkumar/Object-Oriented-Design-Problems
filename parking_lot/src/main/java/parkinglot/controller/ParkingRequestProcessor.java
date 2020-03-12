/**
 * 
 */
package parkinglot.controller;

import java.util.List;
import java.util.stream.Collectors;
import parkinglot.domain.ParkingLot;
import parkinglot.domain.Vehicle;
import parkinglot.exception.ParkingLotErrorCodes;
import parkinglot.exception.ParkingLotException;
import parkinglot.utils.ParkingLotConstants;

/**
 * 
 * The ParkingRequestProcessor invokes an instance {@link ParkingLot} and performs various functions.
 * 
 * The input for each of the parking functions is validated by {@link ValidationProcess}, in case of failure 
 * necessary error is displayed.
 * 
 * This class also handles the  {@link ParkingLotException} 
 * 
 * 
 * @author aniket
 *
 */

public class ParkingRequestProcessor {

	static int parkingLevel = 1;
	static String vehicleType = "CAR";

	ParkingLot parkingLotInstance;

	public ParkingLot getParkingLotInstance() {
		return parkingLotInstance;
	}

	public void execute(String parkingInput) {

		ParkingLotErrorCodes errorCodes = new ParkingLotErrorCodes();

		ValidationProcess validation = new ValidationProcess();
		errorCodes.initiliaseErrorCodeMapping();
		String commandWithParam[] = parkingInput.split(" ");
		String parkingCommand = commandWithParam[0];//parking command
		try {
			switch (parkingCommand) {

			
			case ParkingLotConstants.create_parking_lot:
				if (validation.validate(ParkingLotConstants.create_parking_lot, commandWithParam, parkingLotInstance,
						errorCodes)) {
					parkingLotInstance = new ParkingLot(Integer.parseInt(commandWithParam[1]));
					parkingLotInstance.initializeParkingLot(vehicleType, parkingLevel);
					System.out.print("Created a parking lot with " + parkingLotInstance.getMaxCapacity() + " slots\n");
				} else {
					System.out.println(errorCodes.getErrorCodeToMessageMapping().get(errorCodes.getErrorCode()));

				}
				break;

				
				
			case ParkingLotConstants.leave:
				if (validation.validate(ParkingLotConstants.leave, commandWithParam, parkingLotInstance, errorCodes)) {

					if ((parkingLotInstance.leave(Integer.parseInt(commandWithParam[1])))) {
						System.out.print("Slot number " + commandWithParam[1] + " is free\n");
					} else {
						System.out.print("No Vechile found at slot No: " + commandWithParam[1]+"\n");

					}
				} else {
					System.out.println(errorCodes.getErrorCodeToMessageMapping().get(errorCodes.getErrorCode()));
				}
				break;

		
			case ParkingLotConstants.park:

				if (validation.validate(ParkingLotConstants.park, commandWithParam, parkingLotInstance, errorCodes)) {
					String registrationNumber = commandWithParam[1];
					String color = commandWithParam[2];
					int slotId = parkingLotInstance.park(new Vehicle(registrationNumber, color, vehicleType)); 
					if(slotId==-1){
						System.out.print("Sorry, parking lot is full"+"\n");

					}else {
						System.out.print("Allocated slot number: " + slotId+"\n");

					}
				} else {
					System.out.println(errorCodes.getErrorCodeToMessageMapping().get(errorCodes.getErrorCode()));
				}
				break;

				
			case ParkingLotConstants.status:
				if (validation.validate(ParkingLotConstants.status, commandWithParam, parkingLotInstance, errorCodes)) 
					printStatus(parkingLotInstance.status());
				break;

				
			case ParkingLotConstants.registration_numbers_for_cars_with_colour:
				if (validation.validate(ParkingLotConstants.validateSearch, commandWithParam, parkingLotInstance,
						errorCodes)) {

					List<String> registrationNumbers = parkingLotInstance
							.getRegistrationNumberFromColor(commandWithParam[1]);

					if (registrationNumbers != null && registrationNumbers.size() > 0)
						System.out.println(String.join(", ", registrationNumbers));
					else {
						System.out.print("Not found\n");
					}
				} else {
					System.out.println(errorCodes.getErrorCodeToMessageMapping().get(errorCodes.getErrorCode()));
				}
				break;

				
				
			case ParkingLotConstants.slot_number_for_registration_number:

				if (validation.validate(ParkingLotConstants.validateSearch, commandWithParam, parkingLotInstance,
						errorCodes)) {

					int slotID = parkingLotInstance.getSlotNumberFromRegistration(commandWithParam[1]);
					if (slotID == -1) {
						System.out.print("Not found\n");
					} else
						System.out.println(slotID);
				} else {
					System.out.println(errorCodes.getErrorCodeToMessageMapping().get(errorCodes.getErrorCode()));

				}
				break;

				
				
			case ParkingLotConstants.slot_numbers_for_cars_with_colour:

				if (validation.validate(ParkingLotConstants.validateSearch, commandWithParam, parkingLotInstance,
						errorCodes)) {

					List<Integer> slotNumbers = parkingLotInstance.getSlotNumbersFromColor(commandWithParam[1]);
					if (slotNumbers != null && slotNumbers.size() > 0)
						System.out.println(
								slotNumbers.stream().map(a -> String.valueOf(a)).collect(Collectors.joining(", ")));
					else {
						System.out.print("Not found\n");
					}
				} else {
					System.out.println(errorCodes.getErrorCodeToMessageMapping().get(errorCodes.getErrorCode()));

				}
				break;

				
				
			case ParkingLotConstants.exit:
				System.exit(0);

				
				
			default:
				System.out.println("Invalid entry! please try again");
			}

		} catch (ParkingLotException e) {
			e.printStackTrace();
			System.out.println("Error message is" + errorCodes.getErrorCodeToMessageMapping().get(e.toString()));
		}

	}
	
	
	private void printStatus(List<String> statusList) {
		System.out.print("Slot No."+"    "+"Registration No"+"    "+"Colour\n");
		if(statusList.size()==0) {
			System.out.println("No vechiles are present in the parking lot!");
		} else {
			for (String status : statusList)
			{
				System.out.print(status);
			}
		}
		
	}

}
