package parkinglot.Interface;

import parkinglot.Domain.ParkingFloor;
import parkinglot.Domain.ParkingSlot;
import parkinglot.Domain.Vehicles.Vehicle;
import parkinglot.Enums.VehicleType;

import java.util.List;
import java.util.UUID;

public interface ParkingLotDao {
    void addParkingFloor(ParkingFloor parkingFloor);
    List<ParkingFloor> getAllParkingFloor();
    ParkingFloor getParkingFloor(Integer level);
    Integer getNumberOfFloors();
    List<ParkingSlot> getParkingSlotsByFloor(Integer level);
    void addParkingSlotToFloor(Integer level, ParkingSlot slot);
    void setParkingSlotListToFloor(Integer level, List<ParkingSlot> parkingSlotList);
    Integer getTotalAvailableSlots();
    Integer totalSpotInParkingLot();
    Integer getAvailableSpotByType(VehicleType vehicleType);
}
