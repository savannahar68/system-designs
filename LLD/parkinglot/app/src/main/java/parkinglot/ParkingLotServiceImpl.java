package parkinglot;

import parkinglot.Domain.ParkingFloor;
import parkinglot.Domain.ParkingSlot;
import parkinglot.Domain.ParkingTicket;
import parkinglot.Domain.Payment;
import parkinglot.Domain.Vehicles.Vehicle;
import parkinglot.Enums.VehicleType;
import parkinglot.Factory.ParkingLotDaoFactory;
import parkinglot.Interface.ParkingLotDao;
import parkinglot.Interface.ParkingLotService;
import parkinglot.Interface.ParkingLotStrategy;
import parkinglot.Interface.PricingStrategy;
import parkinglot.StorageAdapter.StrategyFactory;
import parkinglot.Utils.Pair;

import java.util.*;

public class ParkingLotServiceImpl implements ParkingLotService {

    ParkingLotDao parkingLotDao;
    Map<Integer, ParkingLotStrategy> perFloorParkingMapStratgy;
    Map<Vehicle, ParkingTicket> parkingTicketMap;
    PricingStrategy pricingStrategy;

    public ParkingLotServiceImpl() {
        parkingLotDao = ParkingLotDaoFactory.getParkingLotDao();
        pricingStrategy = StrategyFactory.getPricingStrategy();
        perFloorParkingMapStratgy = new HashMap<>();
        parkingTicketMap = new HashMap<>();
    }

    @Override
    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingLotDao.addParkingFloor(parkingFloor);
        perFloorParkingMapStratgy.put(parkingFloor.getLevel(), StrategyFactory.getParkingStrategy(parkingFloor.getParkingSlotList()));
    }

    @Override
    public ParkingTicket parkVehicle(Vehicle vehicle) {
        Pair<Integer, List<ParkingSlot>> parkAssignedPair = assignParkingToVehicle(vehicle);
        // perform checks and validation if we have slot or null etc ...
        vehicle.setParkingSlotList(parkAssignedPair.value);
        vehicle.setFloor(parkAssignedPair.key);
        parkAssignedPair.value.forEach(it -> parkingLotDao.addParkingSlotToFloor(parkAssignedPair.key, it));
        ParkingTicket ticket = new ParkingTicket(parkAssignedPair.value.get(0));
        parkingTicketMap.put(vehicle, ticket);
        return ticket;
    }

    @Override
    public Payment unparkVehicle(Vehicle vehicle) {
        Payment payment = new Payment(pricingStrategy.getPrice(parkingTicketMap.get(vehicle)), parkingTicketMap.get(vehicle));
        perFloorParkingMapStratgy.get(vehicle.getFloor()).removeParking(vehicle);
        return payment;
    }

    @Override
    public Payment unparkVehicle(ParkingTicket parkingTicket) {
        return null;
    }

    @Override
    public Integer getTotalAvailableSpot() {
        return null;
    }

    @Override
    public Integer getAvailableSpotByType(VehicleType vehicleType) {
        return null;
    }

    @Override
    public Integer totalSpotInParkingLot() {
        return null;
    }

    @Override
    public Boolean isSpotFullForVehicle(VehicleType vehicleType) {
        return null;
    }

    private Pair<Integer, List<ParkingSlot>> assignParkingToVehicle(Vehicle vehicle) {
        List<ParkingSlot> slotList = new ArrayList<>();
        Integer level = 0;
        for (int i = 0; i < perFloorParkingMapStratgy.size(); i++) {
            level = i;
            slotList = perFloorParkingMapStratgy.get(i).assignParking(vehicle);
            if (slotList.size() != 0) break;
        }
        return new Pair<Integer, List<ParkingSlot>>(slotList, level);
    }
}
