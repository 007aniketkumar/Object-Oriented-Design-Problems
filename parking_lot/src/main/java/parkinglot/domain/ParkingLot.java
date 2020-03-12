package parkinglot.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import parkinglot.exception.ParkingLotException;
import parkinglot.strategy.BasicDataStrategy;
import parkinglot.strategy.DataScalingStrategy;
import parkinglot.strategy.LargeDataStrategy;
import parkinglot.strategy.NearestParkingStrategy;
import parkinglot.strategy.ParkingStrategy;
import parkinglot.utils.ParkingLotConstants;

/**
 * 
 * This is a multilevel parking lot,where each level has parking spots
 * 
 * The parking spot itself can be of different types, and will have different
 * attributes.
 * 
 * A parking lot has parking levels, and parking levels have parking spots.
 * 
 * @author aniket
 *
 */

public class ParkingLot {

	
	private int maxCapacity;

//parking lot has a parking level Id and parking level


	public int getMaxCapacity() {
		return maxCapacity;
	}

	 private Map<Integer, ParkingLevel> parkingLot; 

	
	public Map<Integer, ParkingLevel> getParkingLot() {
		return parkingLot;
	}


	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	
	public ParkingLot(int maxCapacity){
		this.maxCapacity=maxCapacity;
		parkingLot = new HashMap<>();
	}
	
	DataScalingStrategy<ParkingSlot,Ticket> dataScalingStrategy;
	ParkingStrategy parkingStrategy;
	

	public void initializeParkingLot( String parkingSlotType, int totalLevels) throws ParkingLotException {
		// parking spot will have level and parking levelMapping
		// each parking level will have a mapping of parking spots
		initializeDataScalingStrategy();
		initializeParkingStrategy();
		setParkingLevels(maxCapacity,parkingSlotType,totalLevels);
		
		
	}
	
	
	
	
	public void setParkingLevels(int capacity, String parkingSlotType, int totalLevels) throws ParkingLotException {
		for (int i = 1; i <= totalLevels; i++) {
			ParkingLevel parkingLevel = new ParkingLevel();
			parkingLevel.setLevelID(i);
			parkingLevel.setParkingSpots(ParkingSlotType.valueOf(parkingSlotType), capacity,i);
			parkingLot.put(i, parkingLevel);
		}
	}

	public boolean leave(int slotId) {
		return parkingStrategy.leave(slotId);

	}

	public int park(Vehicle vechile) throws ParkingLotException{
		return parkingStrategy.park(vechile);

	}

	public List<String> status() {
		return parkingStrategy.getStatus();
	}

//decide on the strategy that you would like to adopt for searching vehicles in the parking lot
//

	public void  initializeDataScalingStrategy() {
		if (this.maxCapacity >= ParkingLotConstants.Optimum_capacity_of_Parking_lot) {
			// this implies that data set has increased and searching with take O(n),
			// so we will change our search strategy to RepositoryBasedSearch for quicker
			// retrieval, though we will have tradeoff with time
			dataScalingStrategy = new LargeDataStrategy();
		} else {
			dataScalingStrategy = new BasicDataStrategy();
		}
	
	}
	
	
	public void initializeParkingStrategy() {
		//default behavior, since there is no condition known or provided.
		parkingStrategy= new NearestParkingStrategy(dataScalingStrategy); 
	}
	
	//find registration number based on color
		public List<String> getRegistrationNumberFromColor(String query){
			return dataScalingStrategy.getRegistrationNumberFromColor(query);
		}
		
		
		//find slot numbers with a color
		public List<Integer> getSlotNumbersFromColor(String query){
			return dataScalingStrategy.getSlotNumbersFromColor(query);
		}
		
		//find slot number with registration number
		public int getSlotNumberFromRegistration(String query) {
			return dataScalingStrategy.getSlotNumberFromRegistration(query);
		}
		

}