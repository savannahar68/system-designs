package parking.lot.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class ParkingDivision {
    UUID id;
    Integer floor;
    Spot parkingSpot;
}
