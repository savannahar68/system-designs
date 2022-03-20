package parking.lot.Service;

import lombok.AllArgsConstructor;
import parking.lot.Domain.*;
import parking.lot.Domain.Enums.VehicleType;
import parking.lot.Interface.ParkingBoothDao;
import parking.lot.Interface.TicketService;
import parking.lot.Interface.TicketSystemDao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class TicketSystemServiceImpl implements TicketService {
    // Ticket system is going to be a listener on Admin service update
    // So whenever there is a update there -- it'll call methods to update here

    Map<UUID, TicketSystem> ticketSystemMap;
    TicketSystemDao ticketSystemDao;
    ParkingBoothDao parkingBoothDao; // Comes form Adapter factory

    @Override
    public SpotEntity getSpot(UUID id, VehicleType type) {
        return null;
    }

    @Override
    public Ticket bookTicket(UUID id, Vehicle vehicle) {
        return null;
    }

    @Override
    public Payment makePaymentForTicket(Ticket ticket) {
        return null;
    }

    @Override
    public List<SpotEntity> remainingSpotForTicketSystem(UUID id) {
        return null;
    }

    @Override
    public Integer totalSpotInParkingLot(UUID id) {
        return null;
    }

    @Override
    public Boolean isParkingLotFull(UUID id, VehicleType type) {
        return null;
    }

    @Override
    public Integer parkingLotStatusBasedOnType(UUID id, VehicleType type) {
        return null;
    }
}
