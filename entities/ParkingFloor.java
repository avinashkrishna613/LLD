package org.example.LLD.ParkingLotDesign.entities;

import org.example.LLD.ParkingLotDesign.entities.vehicles.Vehicle;
import org.example.LLD.ParkingLotDesign.enums.VehicleTypes;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    private int id;
    private String floorName;
    private Integer number;
    private HashMap<Integer, ParkingSlot> parkingSlotHashMap;
    private ParkingDisplayBoard parkingDisplayBoard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public HashMap<Integer, ParkingSlot> getParkingSlotHashMap() {
        return parkingSlotHashMap;
    }

    public void setParkingSlotHashMap(HashMap<Integer, ParkingSlot> parkingSlotHashMap) {
        this.parkingSlotHashMap = parkingSlotHashMap;
    }

    public ParkingDisplayBoard getParkingDisplayBoard() {
        return parkingDisplayBoard;
    }

    public void setParkingDisplayBoard(ParkingDisplayBoard parkingDisplayBoard) {
        this.parkingDisplayBoard = parkingDisplayBoard;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public boolean isFull() {
        for (Integer key : parkingSlotHashMap.keySet()) {
            if (!parkingSlotHashMap.get(key).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public ParkingFloor(String floorName) {
        this.floorName = floorName;
    }

    public void addSlotToFloor(ParkingSlot parkingSlot) {
        this.parkingSlotHashMap.put(parkingSlot.getNumber(), parkingSlot);
    }

    public long getFreeSlots(String slotType) {
        int count = 0;
        for (Map.Entry<Integer, ParkingSlot> slotEntry : this.parkingSlotHashMap.entrySet()) {
            ParkingSlot parkingSlot = slotEntry.getValue();
            if (parkingSlot.isEmpty() && parkingSlot.getSlotType().toLowerCase().equals(slotType.toLowerCase())) {
                count ++;
            }
        }
        return count;
    }

    public long getOccupiedSlotsWithGivenVehicleType(String slotType) {
        int count = 0;
        for (Map.Entry<Integer, ParkingSlot> slotEntry : this.parkingSlotHashMap.entrySet()) {
            ParkingSlot parkingSlot = slotEntry.getValue();
            if (!parkingSlot.isEmpty() && parkingSlot.getSlotType().toLowerCase().equals(slotType.toLowerCase())) {
                count ++;
            }
        }
        return count;
    }

    public void parkVehicle(Vehicle vehicle) throws Exception {
        boolean isParked = false;
        for (Map.Entry<Integer, ParkingSlot> slotEntry : this.parkingSlotHashMap.entrySet()) {
            ParkingSlot parkingSlot = slotEntry.getValue();
            if (parkingSlot.isEmpty() && parkingSlot.getSlotType().toLowerCase().equals(vehicle.getVehicleType().toString().toLowerCase())) {
                parkingSlot.parkVehicle(vehicle);
                isParked = true;
                return ;
            }
        }
        if (isParked == false)
            throw new Exception("Free slots not available for this vehicle type ");
    }

    public ParkingFloor() {
    }

    public ParkingFloor(int floorNum, int slotNum) {
        this.id = floorNum;
        this.number = floorNum;
        HashMap<Integer, ParkingSlot> slotMap = new HashMap<>();
        for (int i = 0; i<slotNum; i++) {
            ParkingSlot parkingSlot = new ParkingSlot(i+1, VehicleTypes.CAR.toString());
            slotMap.put(i+1, parkingSlot);
        }
        this.parkingSlotHashMap = slotMap;
    }
}
