/**
 * 
 */
package parkinglot.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import parkinglot.domain.ParkingSlot;
import parkinglot.domain.Ticket;
import parkinglot.repository.ParkingLotRepository;

/**
 * 
 * This strategy is defined keeping large data sets, where space is not a constraint. This strategy
 * is adopted , when the queries are frequent and the result can be retrieved in O(1) time.
 * 
 * In case space is constraint , {@link BasicDataStrategy} should be checked.
 * <a>The strategy can be changed by { Optimum_capacity_of_Parking_lot} in {@link ParkingLotConstants}
 * 
 * 
 * @author aniket
 *
 */
public class LargeDataStrategy implements DataScalingStrategy<ParkingSlot,Ticket>{

	public Map<String, List<String>> colorToRegistrationMapping= new HashMap<>(); 
	public Map<String, List<Integer>> colorToSlotNumbersMapping = new HashMap<>();
	public Map<String, Integer> slotNumberToRegistrationMapping= new HashMap<>();
	
	
	
	@Override
	public List<String> getRegistrationNumberFromColor(String query) {
		return colorToRegistrationMapping.get(query);	}

	@Override
	public List<Integer> getSlotNumbersFromColor(String query) {
		return colorToSlotNumbersMapping.get(query);	}

	@Override
	public int getSlotNumberFromRegistration(String query) {
		return  slotNumberToRegistrationMapping.getOrDefault(query, -1);
	}

	
	
	@Override
	public void store(ParkingSlot slot, Ticket ticket) {
		ParkingLotRepository.getInstance().getTicketRepo().put(slot.getSlotID(), ticket);

		// setRegistrationNumberToColor
		List<String> registrationNumber = colorToRegistrationMapping.getOrDefault(ticket.getVehicle().getColor(),new ArrayList<>());
		registrationNumber.add(ticket.getVehicle().getRegistrationNumber());
		colorToRegistrationMapping.put(ticket.getVehicle().getColor(), registrationNumber);

		// setSlotNumbersToColor
		List<Integer> slotNumbers = colorToSlotNumbersMapping.getOrDefault(ticket.getVehicle().getColor(),new ArrayList<>());
		slotNumbers.add(slot.getSlotID());
		colorToSlotNumbersMapping.put(ticket.getVehicle().getColor(), slotNumbers);

		// setSlotNumberFromRegistration
		slotNumberToRegistrationMapping.put(ticket.getVehicle().getRegistrationNumber(), slot.getSlotID());
	}

}
