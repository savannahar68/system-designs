package parkinglot.StorageAdapter;

import parkinglot.Domain.ParkingSlot;
import parkinglot.Interface.ParkingLotStrategy;
import parkinglot.Interface.PricingStrategy;
import parkinglot.Strategy.ParkingLotStrategyImpl;
import parkinglot.Strategy.PricingStrategyImpl;

import java.util.List;

public class StrategyFactory {
    public static PricingStrategy getPricingStrategy() {
        return new PricingStrategyImpl();
    }

    public static ParkingLotStrategy getParkingStrategy(List<ParkingSlot> parkingSlotList) {
        return new ParkingLotStrategyImpl(parkingSlotList);
    }
}
