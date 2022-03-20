package parking.lot.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import parking.lot.Domain.Enums.VehicleType;

@AllArgsConstructor
@Getter
public class Vehicle {
    VehicleType vechileType;
    String vechileNumber;
}
