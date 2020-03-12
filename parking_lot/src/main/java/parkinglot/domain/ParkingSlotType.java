/**
 * 
 */
package parkinglot.domain;

/**
 * 
 * There can be parking spots of various kinds. Each ParkingSlot has a size defined.
 * @see {@link VehicleType}
 * 
 * 
 * 
 * 
 * @author aniket
 *
 */
public enum ParkingSlotType {

	BIGVEHICLE(2),
    CAR(1);




    int size;


    ParkingSlotType(int size){
        this.size=size;
    }


    //Return the capacity of a parking spot when required.

    int parkingSpotSize(){
         return size;
    }
}
