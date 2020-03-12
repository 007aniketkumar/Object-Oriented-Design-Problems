/**
 * 
 */
package parkinglot.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import parkinglot.domain.ParkingSlot;
import parkinglot.domain.ParkingSlotType;
import parkinglot.domain.Ticket;
import parkinglot.domain.Vehicle;
import parkinglot.exception.ParkingLotException;
import parkinglot.repository.ParkingLotRepository;

/**
 * 
 * Ascending Priority Queue based approach, where the vehicles follow the nearest parking strategy.
 * {@link ParkingStrategy}
 * 
 * @author aniket
 *
 *         
 * 
 */


public class NearestParkingStrategy implements ParkingStrategy {

	public NearestParkingStrategy(DataScalingStrategy<ParkingSlot, Ticket> dataScalingStrategy) {
		super();
		this.dataScalingStrategy = dataScalingStrategy;
	}

	DataScalingStrategy<ParkingSlot,Ticket> dataScalingStrategy;


	/*
	 *  Generate a new immutable ticket at every allocated slot. In case no slot is found, print message 
	 *  appropriately.
	 *  
	 * 
	 * 
	 */
	
	public synchronized int  park(Vehicle vehicle) throws ParkingLotException{

		// call can park, to check if there is space in the parking lot.
		// allocate ticket if parking is possible.

		// is it COMPACT or CAR
		
		String vehicleType = vehicle.getVehicleType();
		ParkingSlot parkingSlot = canAllocate(vehicleType);

		if (parkingSlot == null) {
			return -1;
		} else {
			// create a new instance of ticket , add to the list of Tickets in the ticket
			// repository

			Ticket ticket = new Ticket(parkingSlot, vehicle);
			dataScalingStrategy.store(parkingSlot,ticket);
			return parkingSlot.getSlotID();

		}

	}

	/*
	 * 
	 * This function checks if the vehicle can be allocated in the current parking
	 * level, if not it allocates based on the next available level.
	 * 
	 * 
	 *
	 */

	private ParkingSlot canAllocate(String vehicleType) throws ParkingLotException {

		try {
		return ParkingLotRepository.getInstance().getParkingSpotsRepo().get(ParkingSlotType.valueOf(vehicleType)).poll();
		}catch(Exception e) {
			throw new ParkingLotException("1");
		}

	}

	/*
	 * Deallocate the parking spot.
	 * 
	 * 
	 * s
	 */

	public synchronized boolean leave(int slotID) {

		//if the slotID does not exists
		Ticket ticket = ParkingLotRepository.getInstance().getTicketRepo().remove(slotID);
		if(ticket!=null) {
		ParkingLotRepository.getInstance().getParkingSpotsRepo().get(ticket.getSlot().getParkingSlotType()).add(ticket.getSlot());
		return true;
		} 
		return false;

	}

	/*
	 * 
	 * Print Status in the defined format only.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

	public List<String> getStatus() {
		List<String> statusList = new ArrayList<>();
		Map<Integer,Ticket>ticketRepo = ParkingLotRepository.getInstance().getTicketRepo();
		for (Map.Entry<Integer, Ticket> entry : ticketRepo.entrySet()) {
			statusList.add(entry.getValue().getSlot().getSlotID()+"           "+
					entry.getValue().getVehicle().getRegistrationNumber()+"      "+
					entry.getValue().getVehicle().getColor()+"\n");
		}
		
		return statusList;
		

	}

	

}
