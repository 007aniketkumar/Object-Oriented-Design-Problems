package parkinglot.utils;

public class ParkingLotConstants {

	
	//standard parking lot instructions provided.
	public final static String create_parking_lot = "create_parking_lot"; 
	public final static String park= "park"; 
	public final static String leave = "leave"; 
	public final static String status= "status";
	public final static String registration_numbers_for_cars_with_colour = "registration_numbers_for_cars_with_colour";
	public final static String slot_numbers_for_cars_with_colour="slot_numbers_for_cars_with_colour";
	public final static String slot_number_for_registration_number="slot_number_for_registration_number"; 
	public final static String exit ="exit";
	
	
	//used for validation
	public final static String validateSearch = "validateSearch";
	
	//This is defined to select a strategy of storage and search. In a real work scenario, this will be 
	//injected from a configuration server.
	public final static int Optimum_capacity_of_Parking_lot = 4;


	
}
