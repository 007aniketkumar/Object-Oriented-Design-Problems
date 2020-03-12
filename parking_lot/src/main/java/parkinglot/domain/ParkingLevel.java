package parkinglot.domain;

import java.util.Map;
import java.util.PriorityQueue;
import parkinglot.exception.ParkingLotException;
import parkinglot.repository.ParkingLotRepository;

/**
 * 
 * 
 * Each Parking level has parking spots of varying type and capacity.
 * @see {@link ParkingLotRepository}, {@link ParkingSlotType}
 * 
 * 
 * @author aniket
 *
 */

public class ParkingLevel {

	int levelID;
	public int getLevelID() {
		return levelID;
	}


	public void setLevelID(int levelID) {
		this.levelID = levelID;
	}


	Map<ParkingSlotType, PriorityQueue<ParkingSlot>> parkingSpots;
	
	
	public Map<ParkingSlotType, PriorityQueue<ParkingSlot>> getParkingSpots() {
		return parkingSpots;
	}


	public Map<ParkingSlotType, PriorityQueue<ParkingSlot>>  setParkingSpots(ParkingSlotType parkingSpotType,int capacity,int level) throws ParkingLotException{
		 
		parkingSpots=  ParkingLotRepository.getInstance().createParkingSlots(parkingSpotType,capacity,level);
		return parkingSpots;
	}
	
	
	
}
