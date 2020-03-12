/**
 * 
 */
package parkinglot.domain;

/**
 * 
 * This defines standard attributes of a vehicle. 
 * In case there are specific attributes, this class can be parent class for all the
 * extending classes of vehicles.
 * 
 * 
 * @author aniket
 *
 */
public class Vehicle {

	
	private String color;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	private String registrationNumber;
	
	
	
	public Vehicle(String registrationNumber,String color,String vehicleType) {
		this.registrationNumber=registrationNumber;
		this.color =color;
		this.vehicleType =vehicleType;
		
	}
	//get the vehicle type
	//compact, car
	private String vehicleType;

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

}
