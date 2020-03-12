/**
 * 
 */
package parkinglot.strategy;

import java.util.List;

import parkinglot.domain.Vehicle;
import parkinglot.exception.ParkingLotException;

/**
 * 
 *  Contract to support multiple strategies of parking a vehicle in a parking lot
 * 
 * <p>Implementations {@link NearestParkingStrategy}</P>
 * 
 * 
 * 
 * @author aniket
 */


public interface ParkingStrategy {

	public int park(Vehicle vehicle) throws ParkingLotException; 
	public boolean leave(int slotID);
	public List<String> getStatus();

}
