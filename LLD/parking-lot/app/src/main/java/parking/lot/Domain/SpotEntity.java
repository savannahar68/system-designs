package parking.lot.Domain;

import parking.lot.Domain.Enums.ParkingSpotStatus;

import java.util.UUID;

public class SpotEntity {
    UUID id;
    String name;
    ParkingSpotStatus status;
}
