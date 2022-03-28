package parkinglot.Strategy;

import parkinglot.Domain.ParkingSlot;
import parkinglot.Domain.Vehicles.Vehicle;
import parkinglot.Enums.ParkingSlotType;
import parkinglot.Enums.VehicleType;
import parkinglot.Interface.ParkingLotStrategy;

import java.util.*;


public class ParkingLotStrategyImpl implements ParkingLotStrategy {
    Map<ParkingSlotType, PriorityQueue<ParkingSlot>> parkingSlotTypePriorityQueueMap;

    public ParkingLotStrategyImpl(List<ParkingSlot> parkingLotList) {
        parkingSlotTypePriorityQueueMap = new HashMap<ParkingSlotType, PriorityQueue<ParkingSlot>>();
        Arrays.stream(ParkingSlotType.values()).parallel().forEach(type -> parkingSlotTypePriorityQueueMap.put(type, new PriorityQueue<ParkingSlot>()));
        parkingLotList.forEach( it -> parkingSlotTypePriorityQueueMap.get(it.getParkingSlotType()).add(it) );
    }

    @Override
    public List<ParkingSlot> assignParking(Vehicle vehicle) {
        List<ParkingSlot> slots = new ArrayList<>();
        ParkingSlot slot;
        if (vehicle.getVehicleType().equals(VehicleType.MOTORCYCLE)) {
            slot = parkingSlotTypePriorityQueueMap.get(ParkingSlotType.SMALL_SPOT).poll();
            if (slot == null) {
                slot = parkingSlotTypePriorityQueueMap.get(ParkingSlotType.COMAPCT_SPOT).poll();
                if (slot == null) {
                    slot = parkingSlotTypePriorityQueueMap.get(ParkingSlotType.LARGE_SPOT).poll();
                }
            }
            slots.add(slot);
        } else if (vehicle.getVehicleType().equals(VehicleType.CAR)) {
            slot = parkingSlotTypePriorityQueueMap.get(ParkingSlotType.COMAPCT_SPOT).poll();
            if (slot == null) {
                slot = parkingSlotTypePriorityQueueMap.get(ParkingSlotType.LARGE_SPOT).poll();
            }
            slots.add(slot);
        } else {
            slot = parkingSlotTypePriorityQueueMap.get(ParkingSlotType.LARGE_SPOT).poll();
            if (slot == null && parkingSlotTypePriorityQueueMap.get(ParkingSlotType.COMAPCT_SPOT).size() >= 3) {
                slots.add(parkingSlotTypePriorityQueueMap.get(ParkingSlotType.COMAPCT_SPOT).poll());
                slots.add(parkingSlotTypePriorityQueueMap.get(ParkingSlotType.COMAPCT_SPOT).poll());
                slots.add(parkingSlotTypePriorityQueueMap.get(ParkingSlotType.COMAPCT_SPOT).poll());
            }
        }

        return  slots;
    }

    @Override
    public void removeParking(Vehicle vehicle) {
        vehicle.getParkingSlotList().forEach( it -> parkingSlotTypePriorityQueueMap.get(it.getParkingSlotType()).add(it));
    }
}
