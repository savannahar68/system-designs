package parkinglot.Interface;

import parkinglot.Domain.ParkingSlot;
import parkinglot.Domain.Vehicles.Vehicle;

import java.util.List;

public interface ParkingLotStrategy {
    List<ParkingSlot> assignParking(Vehicle vehicle);
    void removeParking(Vehicle vehicle);
}
