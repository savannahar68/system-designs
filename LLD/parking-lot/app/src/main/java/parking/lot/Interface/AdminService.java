package parking.lot.Interface;

import parking.lot.Domain.Admin;
import parking.lot.Domain.ParkingBooth;

import java.util.List;
import java.util.UUID;

interface AdminService {
    Admin createAdmin(String name, List<ParkingBooth> parkingBoothList);
    void addParkingBooth(ParkingBooth parkingBooth);
    void removeParkingBooth(UUID id);
    // have a update as well
}
