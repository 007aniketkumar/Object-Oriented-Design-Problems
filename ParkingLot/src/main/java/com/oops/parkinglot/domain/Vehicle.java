package com.oops.parkinglot.domain;


import lombok.Getter;
import lombok.Setter;

/**
 *
 * basic attributes of a vehicle , like color,
 * registration number
 *
 * The unique attribute whether it is a 2 wheeler, 4 wheeler can be derived from @link VehicleAttributes
 *
 */

@Getter
@Setter
public class Vehicle {

    String vehicleType; //what type of vehicle is this , 2 wheeler, 4 wheeler etc
    private String color;
    private String registrationNumber;

}
