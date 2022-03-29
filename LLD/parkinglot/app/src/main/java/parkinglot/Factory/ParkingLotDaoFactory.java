package parkinglot.Factory;

import parkinglot.Domain.ParkingSlot;
import parkinglot.Interface.ParkingLotDao;
import parkinglot.Interface.ParkingLotStrategy;
import parkinglot.Interface.PricingStrategy;
import parkinglot.StorageAdapter.ParkingLotDaoImpl;
import parkinglot.Strategy.ParkingLotStrategyImpl;
import parkinglot.Strategy.PricingStrategyImpl;

import java.util.List;

public class ParkingLotDaoFactory {
    public static ParkingLotDao getParkingLotDao() {
        return ParkingLotDaoImpl.getParkingLotDao();
    }

    public static class StrategyFactory {
        public static PricingStrategy getPricingStrategy() {
            return new PricingStrategyImpl();
        }

        public static ParkingLotStrategy getParkingStrategy(List<ParkingSlot> parkingSlotList) {
            return new ParkingLotStrategyImpl(parkingSlotList);
        }
    }
}
