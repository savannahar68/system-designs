package parking.lot.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class Payment {
    UUID id;
    Double amount;
    Ticket ticket;
}
