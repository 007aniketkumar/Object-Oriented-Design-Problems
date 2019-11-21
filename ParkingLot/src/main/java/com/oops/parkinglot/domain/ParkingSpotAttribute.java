package com.oops.parkinglot.domain;


/**
 *
 * The parking spots can be of different types
 *
 *  Each parking spot will have a capacity, and specific attributes
 *
 *
 */


public enum ParkingSpotAttribute {

    COMPACT(1),
    CAR(2);




    int capacity;


    ParkingSpotAttribute(int capacity){
        this.capacity=capacity;
    }


    //Return the capacity of a parking spot when required.

    int parkingSpotCapacity(){
         return capacity;
    }




}
