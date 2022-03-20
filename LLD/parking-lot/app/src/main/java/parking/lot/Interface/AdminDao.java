package parking.lot.Interface;

import parking.lot.Domain.Admin;
import parking.lot.Domain.ParkingBooth;

import java.util.List;
import java.util.UUID;

public interface AdminDao {
    // admin DAO essentially stores map of Admin to list of Parking booth IDs
    Admin createAdmin(String name, List<ParkingBooth> parkingBoothList);
    ParkingBooth getParkingBooth(UUID adminId, UUID parkingId);
    void addParkingBooth(UUID adminId, ParkingBooth parkingBooth);
    void removeParkingBooth(UUID adminId, ParkingBooth parkingBooth); // we can only take ID
    void updateParkingBooth(UUID adminId, UUID parkingId, ParkingBooth parkingBooth);
}
