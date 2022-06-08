package atm.service;

import atm.api.AtmService;
import atm.exception.InsufficentBalance;
import atm.exception.InvalidUser;
import atm.models.Card;
import atm.models.Transaction;
import atm.models.User;
import atm.platform.StorageAdapter;

import java.util.List;

public class AtmSeriveImpl implements AtmService {

    StorageAdapter adapter;
    public AtmSeriveImpl(StorageAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Transaction withDrawCash(Double amount, User user, String authKey) throws InsufficentBalance {
        return null;
    }

    @Override
    public User getUser(Card card) throws InvalidUser {
        return null;
    }

    @Override
    public Boolean modifyAtmCardPin(User user, String pin) throws InvalidUser {
        return null;
    }

    @Override
    public Boolean createNewPinCard(User user, Card card, String uniqueCode) {
        return null;
    }

    @Override
    public List<Transaction> displayMiniStatement(User user) {
        return null;
    }

    @Override
    public Double showAccountBalance(User user) {
        return null;
    }

    @Override
    public Boolean cancelTrasnaciton(User user, Transaction txn) {
        return null;
    }
}
