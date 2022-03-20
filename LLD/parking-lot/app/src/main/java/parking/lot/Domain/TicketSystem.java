package parking.lot.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TicketSystem {
    UUID id;
    String name;
    String location;
    ParkingDivision division;
}
