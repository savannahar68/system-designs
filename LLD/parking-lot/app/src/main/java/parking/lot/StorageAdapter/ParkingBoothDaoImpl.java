package parking.lot.StorageAdapter;

import parking.lot.Domain.ParkingBooth;
import parking.lot.Domain.ParkingDivision;
import parking.lot.Domain.TicketSystem;
import parking.lot.Interface.ParkingBoothDao;

import java.util.UUID;

public class ParkingBoothDaoImpl implements ParkingBoothDao {
    @Override
    public ParkingBooth createParkingBooth(ParkingBooth parkingBooth) {
        return null;
    }

    @Override
    public ParkingBooth updateParkingBooth(UUID id, ParkingBooth parkingBooth) {
        return null;
    }

    @Override
    public void deleteParkingBooth(UUID id) {

    }

    @Override
    public ParkingDivision addParkingDivision(ParkingDivision parkingDivision) {
        return null;
    }

    @Override
    public ParkingDivision updateParkingDivision(UUID id, ParkingDivision parkingDivision) {
        return null;
    }

    @Override
    public void deleteParkingDivision(UUID id) {

    }

    @Override
    public TicketSystem addTicketSystem(TicketSystem ticketSystem) {
        return null;
    }
}
