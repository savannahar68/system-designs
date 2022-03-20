package parking.lot.Interface;

import parking.lot.Domain.ParkingBooth;
import parking.lot.Domain.ParkingDivision;
import parking.lot.Domain.TicketSystem;

import java.util.UUID;

public interface ParkingBoothDao {
    ParkingBooth createParkingBooth(ParkingBooth parkingBooth);
    ParkingBooth updateParkingBooth(UUID id, ParkingBooth parkingBooth);
    void deleteParkingBooth(UUID id);

    ParkingDivision addParkingDivision(ParkingDivision parkingDivision);
    ParkingDivision updateParkingDivision(UUID id, ParkingDivision parkingDivision);
    void deleteParkingDivision(UUID id);

    TicketSystem addTicketSystem(TicketSystem ticketSystem);
    // update and delete ticket system
}
