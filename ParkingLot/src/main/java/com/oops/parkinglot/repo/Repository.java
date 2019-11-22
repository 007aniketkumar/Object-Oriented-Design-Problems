package com.oops.parkinglot.repo;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * In case there is a DB , this class will hold information about the data structures,
 * capacity etc
 *
 *
 */
public class Repository {


    //static contents:

    static final int TOTAL_NUMBER_OF_PARKING_LEVELS=10;
    static final int TOTAL_NUMBER_OF_MOTOR_SPOTS_PER_LEVEL=20;//This is same as the initalize capacity of the priority queue for Motors
    static final int TOTAL_NUMBER_OF_CAR_SPOTS_PER_LEVEL=10;//This is same as the initial capacity of the priority queue

     //Initially
       static int Free_Motor_Spots= TOTAL_NUMBER_OF_MOTOR_SPOTS_PER_LEVEL;
        static int Free_Car_Spots= TOTAL_NUMBER_OF_CAR_SPOTS_PER_LEVEL;

        static int Current_Parking_level=0;//assuming that the levels start from 1





    //stats repo
    //this will store
    // a.) total number of vehicles in the parking lot,
    //b.)  should return total vehicles by type, attributes,
    //c.)

}
