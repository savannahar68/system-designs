package parkinglot.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingLot {
    UUID id;
    List<ParkingFloor> parkingFloorList;
    Integer numberOfFloors;

    public ParkingLot() {
        this(0, new ArrayList<>());
    }

    public ParkingLot(Integer numberOfFloors, List<ParkingFloor> parkingFloorLis) {
        this.id = UUID.randomUUID();
        this.numberOfFloors = numberOfFloors;
        this.parkingFloorList = parkingFloorLis;
    }

    public UUID getId() {
        return id;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
        this.numberOfFloors = parkingFloorList.size();
    }

    public void addFloor(ParkingFloor parkingFloor) {
        this.parkingFloorList.add(parkingFloor);
        this.numberOfFloors++;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }
}
