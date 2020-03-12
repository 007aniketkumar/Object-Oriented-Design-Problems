/**
 * 
 */
package parkinglot.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import parkinglot.domain.ParkingSlot;
import parkinglot.domain.ParkingSlotType;
import parkinglot.domain.Ticket;
import parkinglot.exception.ParkingLotException;

/**
 * 
 * Defines an in-memory storage of parkinglot.
 * 
 * 
 * 
 * 
 * 
 * @author aniket
 *
 */
public class ParkingLotRepository {

	// Manage the parking spot of various kinds.
	// Below defines the mapping of a given type of parking spot and the associated
	// parking spot.
	// The priority queue is chosen because it offers the immediate slot in O(1)
	// time.
	// Below is a min heap/ascending priority queue
	
	
	private Map<ParkingSlotType, PriorityQueue<ParkingSlot>> parkingSpotsRepo;

	public Map<ParkingSlotType, PriorityQueue<ParkingSlot>> getParkingSpotsRepo() {
		return parkingSpotsRepo;
	}

	
	// Parking SlotId to ticket mapping
	public Map<Integer, Ticket> ticketRepo;

	public Map<Integer, Ticket> getTicketRepo() {
		return ticketRepo;
	}

	public void setTicketRepo(TreeMap<Integer, Ticket> ticketRepo) {
		this.ticketRepo = ticketRepo;
	}

	private static ParkingLotRepository instance = null;

	// create singleton
	private ParkingLotRepository() {
		parkingSpotsRepo = new HashMap<>();
		ticketRepo = new TreeMap<>();
	}

	public static synchronized ParkingLotRepository getInstance() {

		if (instance == null) {
			// get a single instance
			instance = new ParkingLotRepository();
		}
		return instance;
	}

	
	/*
	 * 
	 * 
	 * The below generic function will initialize each parking slot type {@code ParkingSlotType} to a 
	 * PriorityQueue of @code ParkingSlot instance
	 * 
	 * 
	 * 
	 */
	public Map<ParkingSlotType, PriorityQueue<ParkingSlot>> createParkingSlots(ParkingSlotType parkingSlotType,
			int capacity, int parkingLevel) throws ParkingLotException {
		
			PriorityQueue<ParkingSlot> pq = new PriorityQueue<>();
			for (int i = 1; i <= capacity; i++) {
				pq.add(new ParkingSlot(i, parkingLevel, parkingSlotType));
				parkingSpotsRepo.put(parkingSlotType, pq);

			}
		
		return parkingSpotsRepo;

	}

}
