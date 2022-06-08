package atm.api;

import atm.exception.InsufficentBalance;
import atm.exception.InvalidUser;
import atm.models.Card;
import atm.models.Transaction;
import atm.models.User;

import java.util.List;

public interface AtmService {
    // Auth key everywhere
    Transaction withDrawCash(Double amount, User user, String authKey) throws InsufficentBalance;
    User getUser(Card card) throws InvalidUser;
    Boolean modifyAtmCardPin(User user, String pin) throws InvalidUser;
    Boolean createNewPinCard(User user, Card card, String uniqueCode);
    List<Transaction> displayMiniStatement(User user, int count, int token);
    Double showAccountBalance(User user);
    Boolean cancelTrasnaciton(User user, Transaction txn);
}
