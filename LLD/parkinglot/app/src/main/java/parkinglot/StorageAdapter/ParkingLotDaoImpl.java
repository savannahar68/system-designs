package parkinglot.StorageAdapter;

import parkinglot.Domain.ParkingFloor;
import parkinglot.Domain.ParkingLot;
import parkinglot.Domain.ParkingSlot;
import parkinglot.Enums.ParkingSlotType;
import parkinglot.Enums.ParkingStatus;
import parkinglot.Enums.VehicleType;
import parkinglot.Interface.ParkingLotDao;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class ParkingLotDaoImpl implements ParkingLotDao {

    ParkingLot parkingLot;
    private static volatile ParkingLotDaoImpl INSTANCE;

    private ParkingLotDaoImpl() { this.parkingLot = new ParkingLot(); }

    public static ParkingLotDaoImpl getParkingLotDao() {
        if (INSTANCE == null) {
            synchronized (ParkingLotDaoImpl.class) {
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

    @Override
    public Integer getTotalAvailableSlots() {
        AtomicReference<Integer> count = new AtomicReference<>(0);
        parkingLot.getParkingFloorList().forEach( it -> {
            it.getParkingSlotList().forEach( ij -> {
                if (ij.getParkingStatus().equals(ParkingStatus.AVAILABLE)) count.getAndSet(count.get() + 1);
            });
        });
        return count.get();
    }

    @Override
    public Integer totalSpotInParkingLot() {
        AtomicReference<Integer> count = new AtomicReference<>(0);
        parkingLot.getParkingFloorList().forEach( it -> {
            count.set(count.get() + it.getCapacity());
        });
        return count.get();
    }

    @Override
    public Integer getAvailableSpotByType(VehicleType vehicleType) {
        AtomicReference<Integer> count = new AtomicReference<>(0);
        ParkingSlotType slotType = mapVehicleTypeByParkingSlotType(vehicleType);
        parkingLot.getParkingFloorList().forEach( it -> {
            it.getParkingSlotList().forEach( ij -> {
                if(ij.getParkingStatus().equals(ParkingStatus.AVAILABLE) && ij.getParkingSlotType().equals(slotType)) count.getAndSet(count.get() + 1);
            });
        });
        // ignoring the complex condition of Van can fit into multiple Compact slots
        return count.get();
    }

    private ParkingSlotType mapVehicleTypeByParkingSlotType(VehicleType vehicleType) {
        if (vehicleType.equals(VehicleType.MOTORCYCLE)) return ParkingSlotType.SMALL_SPOT;
        if (vehicleType.equals(VehicleType.CAR)) return ParkingSlotType.COMAPCT_SPOT;
        if (vehicleType.equals(VehicleType.VAN)) return ParkingSlotType.LARGE_SPOT;
        return ParkingSlotType.UNKNOWN;
    }
}
