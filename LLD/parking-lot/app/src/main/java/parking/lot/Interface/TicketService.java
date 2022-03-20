package parking.lot.Interface;

import parking.lot.Domain.Enums.VehicleType;
import parking.lot.Domain.Payment;
import parking.lot.Domain.SpotEntity;
import parking.lot.Domain.Ticket;
import parking.lot.Domain.Vehicle;

import java.util.List;
import java.util.UUID;

public interface TicketService {
    SpotEntity getSpot(UUID id, VehicleType type);
    Ticket bookTicket(UUID id, Vehicle vehicle);
    Payment makePaymentForTicket(Ticket ticket);
    List<SpotEntity> remainingSpotForTicketSystem(UUID id);
    Integer totalSpotInParkingLot(UUID id);
    Boolean isParkingLotFull(UUID id, VehicleType type); // separate this API into more granular APIs
    Integer parkingLotStatusBasedOnType(UUID id, VehicleType type);
}
