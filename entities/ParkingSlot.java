package org.example.LLD.ParkingLotDesign.entities;

import org.example.LLD.ParkingLotDesign.entities.vehicles.Vehicle;

public class ParkingSlot {
    private int number;
    private Vehicle vehicle;
    private String slotType;

    private boolean isEmpty = true;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isEmpty = false;
    }

    public boolean isEmpty() {
        return this.vehicle == null || this.isEmpty;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public ParkingSlot(int number, Vehicle vehicle, String slotType) {
        this.number = number;
        this.vehicle = vehicle;
        this.slotType = slotType;
        this.isEmpty = false;
    }

    public void freeSlot() {
        this.vehicle = null;
        this.isEmpty = true;
    }

    public ParkingSlot(int number, String slotType) {
        this.number = number;
        this.slotType = slotType;
    }
}
