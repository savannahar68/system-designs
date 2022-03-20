package parking.lot.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Timestamp;

@AllArgsConstructor
@Getter
public class Ticket {
    Vehicle vehicle;
    Timestamp time;
    SpotEntity spot;
}
