package parkinglot.domain;

/**
 * 
 * 
 * This contains the basic dimension of each vehicle.
 * 
 * For example :
 * 
 * Vehicle type,its capacity, and cost of parking per hour.
 * 
 * 
 * @author aniket
 *
 */
public enum VehicleType {

	BIGVEHICLE(2,10), 
	CAR(1,5);

	int dimension;
	int rateAmount;

	private VehicleType( int dimension, int rateAmount) {
		this.dimension = dimension;
		this.rateAmount = rateAmount;

	}
	




	public int getDimension() {
		return dimension;
	}

	public int getRateAmount() {
		return rateAmount;
	}

}
