package parkinglot.domain;

import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * 
 * An immutable Ticket is issued whenever a parking slot is allocated. Ticket will have an
 * instance of  {@link Vehicle}.
 * A unique random ticketID ID and Entry time of the vehicle is stamped whenever a ticket is created.
 * 
 * 
 * 
 * 
 * 
 * @author aniket
 *
 */

public class Ticket {

	private final String parkingTicketId;
	private final ZonedDateTime entryTime;
	private final ParkingSlot slot;
	private final Vehicle vehicle;

	public Ticket(ParkingSlot slot, Vehicle vehicle) {
		super();
		this.slot = slot;
		this.vehicle = vehicle;
		this.entryTime = ZonedDateTime.now();
		this.parkingTicketId = UUID.randomUUID().toString();

	}

	public String getParkingTicketId() {
		return parkingTicketId;
	}

	public ZonedDateTime getEntryTime() {
		return entryTime;
	}

	public ParkingSlot getSlot() {
		return slot;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
	
	
	public void printDetails() {
		System.out.print(
				slot.getSlotID() +"           "+ vehicle.getRegistrationNumber()
						+"      "+ vehicle.getColor()+"\n");
	}

}
