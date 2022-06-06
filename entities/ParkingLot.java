package org.example.LLD.ParkingLotDesign.entities;
import org.example.LLD.ParkingLotDesign.entities.vehicles.Car;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int id;

    private String name;
    private Address address;
    private Map<Integer, ParkingFloor> parkingFloorMap;
    private static ParkingLot parkingLot = null;

    public static ParkingLot getInstance(String name, int floorNum, int slotNum) {
        if (parkingLot == null) {
            parkingLot = new ParkingLot(name, floorNum, slotNum);
        }
        return parkingLot;
    }

    public ParkingLot(String name, int floorNum, int slotNum) {
        this.name = name;
        Map<Integer, ParkingFloor> floorMap = new HashMap<>();
        for (int i=0; i<floorNum ; i++) {
            ParkingFloor floor = new ParkingFloor(i+1, slotNum);
            floor.setId(i+1);
            floorMap.put(i+1, floor);
        }
        this.parkingFloorMap = floorMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Map<Integer, ParkingFloor> getParkingFloorMap() {
        return parkingFloorMap;
    }

    public void setParkingFloorMap(Map<Integer, ParkingFloor> parkingFloorMap) {
        this.parkingFloorMap = parkingFloorMap;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloorMap.put(parkingFloor.getNumber(), parkingFloor);
    }

    public boolean isFull() {
        for (Integer key : parkingFloorMap.keySet()) {
            if (!parkingFloorMap.get(key).isFull()) {
                return false;
            }
        }
        return true;
    }

    public long getFreeSlots(String vehicleType) {
        long count = 0;
        for (Map.Entry<Integer, ParkingFloor> parkingFloor : this.getParkingFloorMap().entrySet()) {
            count += parkingFloor.getValue().getFreeSlots(vehicleType);
        };
        return count;
    }

    public long getOccupiedSlots(String vehicleType) {
        int count =0;
        for (Map.Entry<Integer, ParkingFloor> floorEntry : this.getParkingFloorMap().entrySet()) {
            count += floorEntry.getValue().getOccupiedSlotsWithGivenVehicleType(vehicleType);
        }
        return count;
    }

    public String parkVehicle(String regNo, String color) throws Exception {
        ParkingTicket parkingTicket = new ParkingTicket();
        Car car = new Car(regNo,color, parkingTicket);
        for (Map.Entry<Integer, ParkingFloor> floorEntry : this.getParkingFloorMap().entrySet()) {
            ParkingFloor parkingFloor = floorEntry.getValue();
            parkingFloor.parkVehicle(car);
            return regNo;
        }
        throw new Exception("Failed to park vehicle");
    }
}
