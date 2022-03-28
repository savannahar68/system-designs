package parkinglot.Factory;

import parkinglot.Interface.ParkingLotDao;
import parkinglot.StorageAdapter.ParkingLotDaoImpl;

public class ParkingLotDaoFactory {
    public static ParkingLotDao getParkingLotDao() {
        return ParkingLotDaoImpl.getParkingLotDao();
    }
}
