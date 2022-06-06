package org.example.LLD.ParkingLotDesign;
import org.example.LLD.ParkingLotDesign.entities.ParkingLot;

import java.io.BufferedReader;

import java.io.InputStreamReader;
public class ParkingLotMain {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot = null;
        while (true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String input = bufferedReader.readLine();
            if (input.toLowerCase().equals("exit()")) return;
            String[] inputSplit = input.split(" ");
            switch (inputSplit[0].trim().toLowerCase()) {
                case "create_parking_lot" :
                    parkingLot = ParkingLot.getInstance(inputSplit[1], Integer.parseInt(inputSplit[2]), Integer.parseInt(inputSplit[3]));
                    System.out.println("Created parking lot successfully");
                    break;
                case "display":
                    switch (inputSplit[1]) {
                        case "free_count":
                        case "free_slots":
                            System.out.println("Free slots are : " + parkingLot.getFreeSlots(inputSplit[2]));
                            break;
                        case "occupied_slots":
                            System.out.println("Occupied slots are : " + parkingLot.getOccupiedSlots(inputSplit[2]));
                            break;
                    }
                    break;
                case "park_vehicle":
                    String reg = parkingLot.parkVehicle(inputSplit[2], inputSplit[3]);
                    System.out.println("Successfully parked : "+reg);
                    break;
                case "unpark_vehicle":


            }
        }
    }
}
