/**
 * 
 */
package parkinglot.strategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import parkinglot.domain.ParkingSlot;
import parkinglot.domain.Ticket;
import parkinglot.repository.ParkingLotRepository;

/**
 * 
 * This strategy is defined for small data set. The idea is to iterate over a
 * list and fetch results. In case the data set increases ,
 * {@link LargeDataStrategy} can be referred, to avoid O(n) time complexity.
 * 
 * <a>The strategy can be changed by { Optimum_capacity_of_Parking_lot} in {@link ParkingLotConstants}
 * 
 * 
 * @author aniket
 *
 */
public class BasicDataStrategy implements DataScalingStrategy<ParkingSlot, Ticket> {

	/*
	 * 
	 * Return an empty list if color is not found, else return of Registration Numbers.
	 * 
	 * 
	 * 
	 */

	@Override
	public List<String> getRegistrationNumberFromColor(String query) {

		Collection<Ticket> tickets = ParkingLotRepository.getInstance().getTicketRepo().values();
		List<String> registrationNumbers = new ArrayList<>();
		// iterate over each slot , and search for the vehicle color as requested
		// if found add it to the list of final registration numbers

		for (Ticket ticket : tickets) {

			if (ticket.getVehicle().getColor().equalsIgnoreCase(query)) {
				// match found
				registrationNumbers.add(ticket.getVehicle().getRegistrationNumber());
			}
		}
		return registrationNumbers;

	}
	
	

	/*
	 * 
	 * Return an empty list if slot is not found.
	 * 
	 * 
	 */

	@Override
	public List<Integer> getSlotNumbersFromColor(String query) {
		Collection<Ticket> tickets = ParkingLotRepository.getInstance().getTicketRepo().values();
		List<Integer> slotNumbers = new ArrayList<>();
		for (Ticket ticket : tickets) {
			if (ticket.getVehicle().getColor().equalsIgnoreCase(query)) {
				// match found
				slotNumbers.add(ticket.getSlot().getSlotID());
			}
		}
		return slotNumbers;
	}
	

	/*
	 * 
	 * No slot exists return -1 , else return slotNumber.
	 * 
	 * 
	 * 
	 */

	@Override
	public int getSlotNumberFromRegistration(String query) {
		Collection<Ticket> tickets = ParkingLotRepository.getInstance().getTicketRepo().values();
		int slotNumber = -1;// assuming that no slot exists

		// iterate over each slot , and search for the vehicle color as requested

		for (Ticket ticket : tickets) {

			if (ticket.getVehicle().getRegistrationNumber().equalsIgnoreCase(query)) {
				// match found
				return ticket.getSlot().getSlotID();
			}
		}

		return slotNumber;// not found scenario;
	}
	
	

	/*
	 * 
	 *  Store as the map of SlotID to Ticket
	 * 
	 * 
	 */
	
	@Override
	public void store(ParkingSlot slot, Ticket ticket) {

		ParkingLotRepository.getInstance().getTicketRepo().put(slot.getSlotID(), ticket);

	}

}
