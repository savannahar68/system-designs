package parking.lot.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import parking.lot.Domain.Enums.ParkingSpot;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class Spot {
    Map<ParkingSpot, List<SpotEntity>> spots;
}
