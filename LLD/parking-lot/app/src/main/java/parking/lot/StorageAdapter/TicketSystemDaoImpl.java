package parking.lot.StorageAdapter;

import parking.lot.Domain.Enums.VehicleType;
import parking.lot.Domain.SpotEntity;
import parking.lot.Domain.TicketSystem;
import parking.lot.Exceptions.TicketSystemException;

public class TicketSystemDaoImpl implements parking.lot.Interface.TicketSystemDao {
    @Override
    public TicketSystem createTicketSystem(String name, String location, String division) throws TicketSystemException {
        return null;
    }

    @Override
    public SpotEntity bookSpotForVehicle(VehicleType vehicleType) {
        return null;
    }

    @Override
    public void emptySpotForVehicle(VehicleType vehicleType) {

    }

    @Override
    public SpotEntity reserveSpotForVehicle(VehicleType vehicleType) {
        return null;
    }
}
