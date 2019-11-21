package com.oops.parkinglot.domain;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Ticket {


    private String vehicleType;
    private int ticketID;

    private int parkingspotID;
    private long entryTime;


    private String parkingSlotType;


    private int parkingLevelID;


}
