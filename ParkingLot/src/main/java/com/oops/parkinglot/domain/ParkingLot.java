package com.oops.parkinglot.domain;


import com.oops.parkinglot.process.Entry;
import com.oops.parkinglot.process.Exit;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * The basic idea is :
 *
 *  A parking lot has parking levels.
 *
 *  Each parking level has parking spots.
 *
 *  The key attributes of a parking lot are :
 *  Each parking lot has an @link Entry and @link Exit
 *
 *  The parking lot also displays the
 *  total occupied and free capacity at each parking levels,
 *  capacity at individual levels,
 *  number of type of vehicles,
 *
 *  The parking levels are allocated once the current level has crossed the capacity of 80%.
 *
 *
 *
 */

//This is the starter class.

@Getter
@Setter
public class ParkingLot {


    public Map<Integer, ParkingLevel> getParkingLevels() {
        return parkingLevels;
    }

    public void setParkingLevels(Map<Integer, ParkingLevel> parkingLevels) {
        this.parkingLevels = parkingLevels;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public Exit getExit() {
        return exit;
    }

    public void setExit(Exit exit) {
        this.exit = exit;
    }

    public static ParkingLevel getCurrentParkingLevel() {
        return currentParkingLevel;
    }

    public  void setCurrentParkingLevel(ParkingLevel currentParkingLevel) {
        ParkingLot.currentParkingLevel = currentParkingLevel;
    }

    public  void setTotalCapacityOfParkingLot(int totalCapacityOfParkingLot) {
        ParkingLot.totalCapacityOfParkingLot = totalCapacityOfParkingLot;
    }

    private Map<Integer,ParkingLevel> parkingLevels;

    //Parking lot can have multiple entry and exit points
    private Entry entry;

    private Exit exit;

    private static ParkingLevel currentParkingLevel;


    //this will be defined in the beginining , when constructing the parking level and parking spots
    private  int totalCapacityOfParkingLot;

    //Functions that parking lot supports
    //when vehicle comes: below are the operations that the parking lot will perform
    //if total capacity is full : Display the message that parking lot is full.
    //if above is false, then  return the parking level, by checking the vehicle type,
    // current capacity of the parking level
    //

    public int getTotalCapacityOfParkingLot() {
        return totalCapacityOfParkingLot;
    }


    public ParkingLevel getFreeParkingSpace(Vehicle vehicle){

        //first compare against the total capacity

        if(totalCapacityOfParkingLot-vehicle.getCapacity()<0){
            //No space left
            return null;//this needs to be handled by the caller, if null then translate this to no space left

            //check  if there is space left in the current level

        } else if(currentParkingLevel){
        }
    }


    static ParkingLot getInstance(){
        return new ParkingLot();
    }


}
