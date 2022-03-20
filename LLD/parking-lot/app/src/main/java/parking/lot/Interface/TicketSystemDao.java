package parking.lot.Interface;

import parking.lot.Domain.Enums.VehicleType;
import parking.lot.Domain.SpotEntity;
import parking.lot.Domain.TicketSystem;
import parking.lot.Exceptions.TicketSystemException;

public interface TicketSystemDao {
    TicketSystem createTicketSystem(String name, String location, String division) throws TicketSystemException;
    // update and delete ticket system

    // going to do
    SpotEntity bookSpotForVehicle(VehicleType vehicleType);
    void emptySpotForVehicle(VehicleType vehicleType);
    SpotEntity reserveSpotForVehicle(VehicleType vehicleType);
}
