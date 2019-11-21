package com.oops.parkinglot.process;

import com.oops.parkinglot.domain.ParkingLevel;
import com.oops.parkinglot.domain.ParkingLot;
import com.oops.parkinglot.domain.Ticket;
import com.oops.parkinglot.domain.Vehicle;

import java.util.Date;

public class Exit {


    //this will return back the capacity to the appropriate parking level


    public void freeSlot(Ticket ticket) {

        long entryTime = ticket.getEntryTime();
        int parkingSpotID = ticket.getParkingspotID();
        String vehicleType = ticket.getVehicleType();//for computing the payment , based on the static rates
        int parkingLevelID = ticket.getParkingLevelID();
        String parkingSlotType = ticket.getParkingSlotType();

        //the free slot needs to be returned back to appropriate parking level
        //current total capacity will increase
        //level capacity will increase
        //capacity pertaining to the slot type will increase,

        ParkingLevel parkingLevel = ParkingLot.getInstance().getParkingLevels().get(parkingLevelID);

        //Return the free slot to the parking level

        parkingLevel.getParkingSpots().get(parkingSlotType).add(parkingSpotID);//this will automatically update the capacity of the level
        //update the total capacity of parking lot

        ParkingLot.getInstance().setTotalCapacityOfParkingLot(ParkingLot.getInstance().
                getTotalCapacityOfParkingLot() + 1);

        //make the parkingSpot available
        //change the flag to true




        computeParkingAmount(entryTime, vehicleType);

    }


    /**The basic idea is pretty straight forward, maintain a static rate Enum for each vehicle , call that
    and fetch the details



     */
    private static int computeParkingAmount(long entryTime, String vehicleType) {

        //call the rate card for the appropriate vehicle type and update the amount

        int totalTime = (int) (System.currentTimeMillis() - entryTime);
        return (Vehicle.valueOf(vehicleType).getRateAmount() * (totalTime));

    }
}
