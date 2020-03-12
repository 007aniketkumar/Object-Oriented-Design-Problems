
package parkinglot.domain;

/**
 * 
 * Each ParkingSlot has a unique slotID, parkingLevelID  {@link ParkingLevel} and parkingSlot type  {@link ParkingSlotType}
 * 
 * @author aniket
 *
 *
 *
 */
public class ParkingSlot implements Comparable<ParkingSlot> {

	public ParkingSlot(int slotID, int parkingLevelID, ParkingSlotType parkingSlotType) {
		super();
		this.slotID = slotID;
		this.parkingLevelID = parkingLevelID;
		this.parkingSlotType = parkingSlotType;
	}

	private int slotID;
	private int parkingLevelID;
	private ParkingSlotType parkingSlotType;

	public ParkingSlotType getParkingSlotType() {
		return parkingSlotType;
	}

	public void setParkingSlotType(ParkingSlotType parkingSlotType) {
		this.parkingSlotType = parkingSlotType;
	}

	public int getSlotID() {
		return slotID;
	}

	public void setSlotID(int slotID) {
		this.slotID = slotID;
	}

	public int getParkingLevelID() {
		return parkingLevelID;
	}

	public void setParkingLevelID(int parkingLevelID) {
		this.parkingLevelID = parkingLevelID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + parkingLevelID;
		result = prime * result + slotID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingSlot other = (ParkingSlot) obj;
		if (parkingLevelID != other.parkingLevelID)
			return false;
		if (slotID != other.slotID)
			return false;
	
		return true;
	}

	@Override
	public int compareTo(ParkingSlot p) {
		if (p == null)
			return 1;
		return this.getSlotID() - p.getSlotID();
	}

}
