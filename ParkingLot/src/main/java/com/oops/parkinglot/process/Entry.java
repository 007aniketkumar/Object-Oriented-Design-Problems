package com.oops.parkinglot.process;


import com.oops.parkinglot.domain.Ticket;
import com.oops.parkinglot.domain.Vehicle;
import com.oops.parkinglot.domain.VehicleAttributes;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * This class will have some specific attributes and task to perform.
 *
 * For example :
 * Entry will return Ticket object
 *
 *
 *  Same as exit ,
 *
 * Figure out the right level , for the parking to be allocated.
 * For the given level , allocate the parking spot
 * mark the parking spot flag as occupied, based on the type of the vehicle you are allocating.
 *
 * Decrease the total capacity
 * Decrease the capacity of the parking level spot
 *
 * update the statics
 *
 * total vehicles:
 *
 * kind of vehicle at each level etc
 *
 *
 */


public class Entry {



    /*
        This will return the ticket object

     */
    public Ticket allowEntry(Vehicle vehicle) {

        Ticket parkingTicket = new Ticket();
        parkingTicket.setEntryTime(System.currentTimeMillis());
        parkingTicket.setParkingLevelID();//check the capacity if the current level and then allow accordingly.

        //from the vehicle take the type of vehicle to find the static and dynamic contexts

        String vehicleType = vehicle.getVehicleType();

        if(VehicleAttributes.)

    }

}
