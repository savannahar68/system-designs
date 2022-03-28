package parkinglot.Domain.Vehicles;

import parkinglot.Domain.ParkingSlot;
import parkinglot.Enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    String registrionNumber;
    VehicleType vehicleType;
    List<ParkingSlot> parkingSlotList;
    Integer floor;

    public Vehicle(String registrionNumber, VehicleType vehicleType) {
        this.registrionNumber = registrionNumber;
        this.vehicleType = vehicleType;
        parkingSlotList = new ArrayList<>();
    }

    public VehicleType getVehicleType() { return this.vehicleType; }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) { this.parkingSlotList = parkingSlotList; }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getFloor() {
        return floor;
    }
}
