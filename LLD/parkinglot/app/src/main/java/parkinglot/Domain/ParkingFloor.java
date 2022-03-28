package parkinglot.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ParkingFloor {
    List<ParkingSlot> parkingSlotList;
    Integer capacity;
    Integer level;

    public ParkingFloor(Integer level, Integer capacity) {
        this(level, new ArrayList<>(), capacity);
    }

    public ParkingFloor(Integer level, List<ParkingSlot> parkingSlotList) {
        this(level, parkingSlotList, parkingSlotList.size());
    }

    public ParkingFloor(Integer level, List<ParkingSlot> parkingSlotList, Integer capacity) {
        this.level = level;
        this.parkingSlotList = parkingSlotList;
        this.capacity = capacity;
    }

    public Integer getLevel() {
        return level;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    public void addParkingSlot(ParkingSlot slot) { this.parkingSlotList.add(slot); }

    public Integer getCapacity() { return this.capacity; }

    public Integer getAvailableCapacity() { return parkingSlotList.size(); }
}
