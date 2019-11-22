package com.oops.parkinglot.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Parking level has multiple parking spots.
 *
 * Parking level has a levelID to identify itself.
 *
 * Parking level displays free and occupied capacity.
 *
 *
 *
 *
 *
 */

@Getter
@Setter
public class ParkingLevel {


    //Each parking level has a HashMap of parking spot type along with the priority queue of parking slot numbers
    //based on its capacity

    //the above map will look like
    // compact , Queue<1,2,3,4> // this is sorted in ascending order

    //parking level will maintain the capacity of each of each slot , along with the overall capacity


    //every level will have a new Parking Spot of each type getting created
    Map<String, PriorityQueue<Integer>> parkingSpots= new HashMap<>();

    public Map<String, PriorityQueue<Integer>> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(Map<String, PriorityQueue<Integer>> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    //based on spotType, check the  current occupied capacity
    private static int capacity(String spotType){

       return parkingSpots.get(spotType).size();
    }



    private int getNextAvailableParkingSlot(Vehicle vehicle ){

       // int parkingSlotNumber = parkingSpots.get()


        }




}
