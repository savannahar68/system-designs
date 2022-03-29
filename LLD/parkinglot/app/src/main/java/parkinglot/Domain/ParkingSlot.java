package parkinglot.Domain;

import parkinglot.Domain.Vehicles.Vehicle;
import parkinglot.Enums.ParkingSlotType;
import parkinglot.Enums.ParkingStatus;

import java.util.UUID;

public class ParkingSlot implements Comparable<ParkingSlot> {
    // Parking Id can come from the creator of this object
    UUID id;
    Vehicle vehicle;
    ParkingSlotType parkingSlotType;
    ParkingStatus parkingStatus;

    public ParkingSlot(ParkingSlotType parkingSlotType) {
        this.parkingSlotType = parkingSlotType;
        this.vehicle = null;
        this.parkingStatus = ParkingStatus.AVAILABLE;
        this.id = UUID.randomUUID();
    }

    public UUID getId() { return this.id; }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setParkingStatus(ParkingStatus status) { this.parkingStatus = status; }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    public ParkingStatus getParkingStatus() {
        return parkingStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public int compareTo(ParkingSlot o) {
        return this.id.compareTo(o.getId());
    }
}
