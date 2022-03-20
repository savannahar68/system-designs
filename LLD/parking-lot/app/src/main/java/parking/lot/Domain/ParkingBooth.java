package parking.lot.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class ParkingBooth {
    UUID id;
    String name;
    String address; // have a object address with Pincode
    List<ParkingDivision> parkingDivision;
    List<TicketSystem> ticketSystems;
}
