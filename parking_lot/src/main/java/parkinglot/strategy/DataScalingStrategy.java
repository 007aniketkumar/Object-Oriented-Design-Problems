/**
 * 
 */
package parkinglot.strategy;

import java.util.List;

/**
 * 
 * Contract to fetch and store vehicles based on different. This is a generic function
 * which allows to store in any slot and any Vehicle type
 * 
 * <p>Implementations {@link BasicDataStrategy}, {@link LargeDataStrategy}</P>
 * 
 * 
 * @author aniket
 *
 */

public interface DataScalingStrategy<T, K> {

	// find registration number based on color
	public List<String> getRegistrationNumberFromColor(String query);

	// find slot numbers with a color
	public List<Integer> getSlotNumbersFromColor(String query);

	// find slot number with registration number
	public int getSlotNumberFromRegistration(String query);

	
	//ParkingSlot,VehicleType
	public void store(T type, K variable);

}
