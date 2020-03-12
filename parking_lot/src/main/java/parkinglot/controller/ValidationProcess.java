/**
 * 
 */
package parkinglot.controller;

import parkinglot.domain.ParkingLot;
import parkinglot.exception.ParkingLotErrorCodes;
import parkinglot.utils.ParkingLotConstants;

/**
 * @author aniket
 * 
 * 
 *         This component performs basic validations on the inputs passed
 *         through the command line or input file and raises error codes
 *         accordingly if the validation fails.
 *
 */
public class ValidationProcess {

	public boolean validate(String parkingCommands, String[] query, ParkingLot parkingLotInstance,
			ParkingLotErrorCodes errorCode) {

		switch (parkingCommands) {

		case ParkingLotConstants.create_parking_lot:

			if (query.length != 2) {
				errorCode.setErrorCode("3");
				return false;
			}
			try {//Number of parking slots to be created should be an integer.
				Integer.parseInt(query[1]);
			} catch (NumberFormatException e) {
				errorCode.setErrorCode("3");

				return false;
			}
			return true;

		case ParkingLotConstants.leave:

			if (query.length != 2) {
				errorCode.setErrorCode("3");
				return false;
			}
			try {

				Integer.parseInt(query[1]);
				return isParkinglotCreated(parkingLotInstance, errorCode);
			} catch (NumberFormatException e) {
				errorCode.setErrorCode("3");

				return false;
			}

			// registration number color
		case ParkingLotConstants.park:
			if (query.length != 3) {
				errorCode.setErrorCode("3");
				return false;

			} else {
				return isParkinglotCreated(parkingLotInstance, errorCode);
			}

			
		case ParkingLotConstants.validateSearch:
			if (query.length != 2) {
				errorCode.setErrorCode("3");//in case only command is passed and the parameter to search is not passed.
				return false;

			} else {
				return isParkinglotCreated(parkingLotInstance, errorCode);

			}

		case ParkingLotConstants.status:
			if (query.length != 1) {
				errorCode.setErrorCode("3");//in case only command is passed and the parameter to search is not passed.
				return false;

			} else {
				return isParkinglotCreated(parkingLotInstance, errorCode);

			}
		default:
			return false;

		}
	}

	private boolean isParkinglotCreated(ParkingLot parkingLotInstance, ParkingLotErrorCodes errorCode) {
		if (parkingLotInstance == null) {
			errorCode.setErrorCode("4");
			return false;
		}
		return true;
	}
}
