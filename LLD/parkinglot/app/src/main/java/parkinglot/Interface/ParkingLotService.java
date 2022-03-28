package parkinglot.Interface;

import parkinglot.Domain.ParkingFloor;
import parkinglot.Domain.ParkingTicket;
import parkinglot.Domain.Payment;
import parkinglot.Domain.Vehicles.Vehicle;
import parkinglot.Enums.VehicleType;

import java.util.List;
import java.util.UUID;

public interface ParkingLotService {
    void addParkingFloor(ParkingFloor parkingFloor);
    ParkingTicket parkVehicle(Vehicle vehicle);
    Payment unparkVehicle(Vehicle vehicle);
    Payment unparkVehicle(ParkingTicket parkingTicket);
    Integer getTotalAvailableSpot();
    Integer getAvailableSpotByType(VehicleType vehicleType);
    Integer totalSpotInParkingLot();
    Boolean isSpotFullForVehicle(VehicleType vehicleType);
}
