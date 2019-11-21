package com.oops.parkinglot.domain;


/**
 *  Each vehicle has a capacity, which can help determine if a parking spot exists.
 *
 * There can also be other attributes about the vehicle, like registration number, color
 *
 */

public enum VehicleAttributes {

    MOTOR(1,"Motor",10),
    CAR(3,"Car",5);

    int capacity;
    String vehicleType;
    int rateAmount;

    private VehicleAttributes(int capacity,String vehicleType,int rateAmount){
    this.capacity = capacity;
    this.vehicleType=vehicleType;
    this.rateAmount =rateAmount;

    }


    public String getVehicleType(){
        return vehicleType;
    }

   public int getCapacity(){
        return capacity;
    }

    public int getRateAmount(){
        return rateAmount;
    }

}
