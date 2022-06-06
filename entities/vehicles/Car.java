package org.example.LLD.ParkingLotDesign.entities.vehicles;

import org.example.LLD.ParkingLotDesign.entities.ParkingTicket;
import org.example.LLD.ParkingLotDesign.enums.VehicleTypes;

public class Car extends Vehicle{
    public Car(String regNo, String color, ParkingTicket parkingTicket) {
        super(VehicleTypes.CAR, regNo, color, parkingTicket);
    }


}
