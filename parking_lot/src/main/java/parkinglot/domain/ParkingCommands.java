package parkinglot.domain;

public enum ParkingCommands {

	create_parking_lot("create_parking_lot "), 
	park("park"), 
	leave("leave"), 
	status("status"),
	registration_numbers_for_cars_with_colour("registration_numbers_for_cars_with_colour"),
	slot_numbers_for_cars_with_colour("slot_numbers_for_cars_with_colour"),
	slot_number_for_registration_number("slot_number_for_registration_number"), exit("exit");

	private String commands;

	 ParkingCommands(final String commands) {
		this.commands = commands;
	}

	public String getParkingCommands() {
		return commands;
	}

}
