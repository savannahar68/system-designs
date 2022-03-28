package parkinglot.StorageAdapter;

import parkinglot.Domain.ParkingFloor;
import parkinglot.Domain.ParkingLot;
import parkinglot.Domain.ParkingSlot;
import parkinglot.Interface.ParkingLotDao;

import java.util.List;
import java.util.Objects;

public class ParkingLotDaoImpl implements ParkingLotDao {

    ParkingLot parkingLot;
    private static volatile ParkingLotDaoImpl INSTANCE;

    private ParkingLotDaoImpl() { this.parkingLot = new ParkingLot(); }

    public static ParkingLotDaoImpl getParkingLotDao() {
        if (INSTANCE == null) {
            synchronized (INSTANCE) {
                if (INSTANCE == null) INSTANCE = new ParkingLotDaoImpl();
            }
        }
        return INSTANCE;
    }

    @Override
    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingLot.addFloor(parkingFloor);
    }

    @Override
    public List<ParkingFloor> getAllParkingFloor() {
        return parkingLot.getParkingFloorList();
    }

    @Override
    public ParkingFloor getParkingFloor(Integer level) {
        return parkingLot.getParkingFloorList().stream().filter( it-> Objects.equals(it.getLevel(), level)).findFirst().get(); // first check if present or not...
    }

    @Override
    public Integer getNumberOfFloors() {
        return parkingLot.getNumberOfFloors();
    }

    @Override
    public List<ParkingSlot> getParkingSlotsByFloor(Integer level) {
        return getParkingFloor(level).getParkingSlotList();
    }

    @Override
    public void addParkingSlotToFloor(Integer level, ParkingSlot slot) {
        getParkingFloor(level).getParkingSlotList().add(slot);
    }

    @Override
    public void setParkingSlotListToFloor(Integer level, List<ParkingSlot> parkingSlotList) {
        getParkingFloor(level).setParkingSlotList(parkingSlotList);
    }
}
