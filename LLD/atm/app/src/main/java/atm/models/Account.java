package atm.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Account {
    List<Card> cards;
    Double balance;
    Transaction transaction;
}
