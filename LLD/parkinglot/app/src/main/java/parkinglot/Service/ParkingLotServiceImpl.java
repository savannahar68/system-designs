package parkinglot.Service;

import parkinglot.Domain.ParkingFloor;
import parkinglot.Domain.ParkingSlot;
import parkinglot.Domain.ParkingTicket;
import parkinglot.Domain.Payment;
import parkinglot.Domain.Vehicles.Vehicle;
import parkinglot.Enums.ParkingStatus;
import parkinglot.Enums.VehicleType;
import parkinglot.Factory.ParkingLotDaoFactory;
import parkinglot.Interface.ParkingLotDao;
import parkinglot.Interface.ParkingLotService;
import parkinglot.Interface.ParkingLotStrategy;
import parkinglot.Interface.PricingStrategy;
import parkinglot.Utils.Pair;

import java.util.*;

public class ParkingLotServiceImpl implements ParkingLotService {

    ParkingLotDao parkingLotDao;
    Map<Integer, ParkingLotStrategy> perFloorParkingMapStratgy;
    Map<Vehicle, ParkingTicket> parkingTicketMap;
    PricingStrategy pricingStrategy;

    public ParkingLotServiceImpl() {
        parkingLotDao = ParkingLotDaoFactory.getParkingLotDao();
        pricingStrategy = ParkingLotDaoFactory.StrategyFactory.getPricingStrategy();
        perFloorParkingMapStratgy = new HashMap<>();
        parkingTicketMap = new HashMap<>();
    }

    @Override
    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingLotDao.addParkingFloor(parkingFloor);
        perFloorParkingMapStratgy.put(parkingFloor.getLevel(), ParkingLotDaoFactory.StrategyFactory.getParkingStrategy(parkingFloor.getParkingSlotList()));
    }

    @Override
    public ParkingTicket parkVehicle(Vehicle vehicle) {
        Pair<Integer, List<ParkingSlot>> parkAssignedPair = assignParkingToVehicle(vehicle);
        // perform checks and validation if we have slot or null etc ...
        setSlot(parkAssignedPair.value, ParkingStatus.RESERVED);
        vehicle.setParkingSlotList(parkAssignedPair.value);
        vehicle.setFloor(parkAssignedPair.key);
        ParkingTicket ticket = new ParkingTicket(parkAssignedPair.value.get(0));
        parkingTicketMap.put(vehicle, ticket);
        return ticket;
    }

    @Override
    public Payment unparkVehicle(Vehicle vehicle) {
        Payment payment = new Payment(pricingStrategy.getPrice(parkingTicketMap.get(vehicle)), parkingTicketMap.get(vehicle));
        perFloorParkingMapStratgy.get(vehicle.getFloor()).removeParking(vehicle);
        setSlot(vehicle.getParkingSlotList(), ParkingStatus.AVAILABLE);
        return payment;
    }

    @Override
    public Payment unparkVehicle(ParkingTicket parkingTicket) {
        Vehicle vehicle = parkingTicketMap.entrySet().stream().filter( it -> it.getValue().equals(parkingTicket)).findFirst().get().getKey();
        Payment payment = new Payment(pricingStrategy.getPrice(parkingTicketMap.get(vehicle)), parkingTicketMap.get(vehicle));
        perFloorParkingMapStratgy.get(vehicle.getFloor()).removeParking(vehicle);
        setSlot(vehicle.getParkingSlotList(), ParkingStatus.AVAILABLE);
        return payment;
    }

    @Override
    public Integer getTotalAvailableSpot() {
        return parkingLotDao.getTotalAvailableSlots();
    }

    @Override
    public Integer getAvailableSpotByType(VehicleType vehicleType) {
        return parkingLotDao.getAvailableSpotByType(vehicleType);
    }

    @Override
    public Integer totalSpotInParkingLot() {
        return parkingLotDao.totalSpotInParkingLot();
    }

    @Override
    public Boolean isSpotFullForVehicle(VehicleType vehicleType) {
        return getAvailableSpotByType(vehicleType) > 0;
    }

    private Pair<Integer, List<ParkingSlot>> assignParkingToVehicle(Vehicle vehicle) {
        List<ParkingSlot> slotList = new ArrayList<>();
        Integer level = 0;
        for (int i = 0; i < perFloorParkingMapStratgy.size(); i++) {
            level = i;
            slotList = perFloorParkingMapStratgy.get(i).assignParking(vehicle);
            if (slotList.size() != 0) break;
        }
        return new Pair<Integer, List<ParkingSlot>>(level, slotList);
    }

    private void setSlot(List<ParkingSlot> slotList, ParkingStatus status) {
        slotList.forEach(it -> it.setParkingStatus(status));
    }
}
