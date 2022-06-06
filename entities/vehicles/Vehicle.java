package org.example.LLD.ParkingLotDesign.entities.vehicles;

import org.example.LLD.ParkingLotDesign.entities.ParkingTicket;
import org.example.LLD.ParkingLotDesign.enums.VehicleTypes;

public class Vehicle {
    private VehicleTypes vehicleType;
    private String registrationNo;
    private String color;
    private ParkingTicket parkingTicket;
    public Vehicle(VehicleTypes vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void assignTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public VehicleTypes getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypes vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public Vehicle(VehicleTypes vehicleType, String registrationNo, String color, ParkingTicket parkingTicket) {
        this.vehicleType = vehicleType;
        this.registrationNo = registrationNo;
        this.color = color;
        this.parkingTicket = parkingTicket;
    }
}
