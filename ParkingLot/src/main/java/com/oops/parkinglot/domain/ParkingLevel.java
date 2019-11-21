package com.oops.parkinglot.domain;

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
public class ParkingLevel {


    //Each parking level has a HashMap of parking spot type along with the priority queue of parking slot numbers
    //based on its capacity

    Map<String, PriorityQueue<Integer>>  parkingSpots= new HashMap<>();
//the above map will look like
    // compact , Queue<1,2,3,4> // this is sorted in ascending order

    //parking level will maintain the capacity of each of each slot , along with the overall capacity


    public Map<String, PriorityQueue<Integer>> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(Map<String, PriorityQueue<Integer>> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    //based on spotType, check the capacity
    public int capacity(String spotType){

       return parkingSpots.get(spotType).size();
    }







}
