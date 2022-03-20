package parking.lot.StorageAdapter;

import parking.lot.Domain.Admin;
import parking.lot.Domain.ParkingBooth;
import parking.lot.Interface.AdminDao;

import java.util.List;
import java.util.UUID;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin createAdmin(String name, List<ParkingBooth> parkingBoothList) {
        return null;
    }

    @Override
    public ParkingBooth getParkingBooth(UUID adminId, UUID parkingId) {
        return null;
    }

    @Override
    public void addParkingBooth(UUID adminId, ParkingBooth parkingBooth) {

    }

    @Override
    public void removeParkingBooth(UUID adminId, ParkingBooth parkingBooth) {

    }

    @Override
    public void updateParkingBooth(UUID adminId, UUID parkingId, ParkingBooth parkingBooth) {

    }
}
