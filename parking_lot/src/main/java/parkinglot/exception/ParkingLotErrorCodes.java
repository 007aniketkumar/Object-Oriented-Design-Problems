package parkinglot.exception;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotErrorCodes {

	//Error code to error String mapping
	private  Map<String,String> errorCodeToMessageMapping;
	
	
	public Map<String, String> getErrorCodeToMessageMapping() {
		return errorCodeToMessageMapping;
	}

	public ParkingLotErrorCodes(){
		errorCodeToMessageMapping = new HashMap<>();
	}
	
	public void initiliaseErrorCodeMapping() {
		errorCodeToMessageMapping.put("1", "Invalid parking command passed, please check the options!");
		errorCodeToMessageMapping.put("2", "Vehicle type is Invalid");
		errorCodeToMessageMapping.put("3", "Parameters are not valid");
		errorCodeToMessageMapping.put("4", "Please create the parking lot first!");


	}
	


	private String errorCode;


	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
