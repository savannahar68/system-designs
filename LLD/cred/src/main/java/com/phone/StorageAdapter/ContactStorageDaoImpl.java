package com.phone.StorageAdapter;

import com.phone.Apis.ContactStorageDao;
import com.phone.Domain.Contact;
import com.phone.Exceptions.DaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContactStorageDaoImpl implements ContactStorageDao {
    Map<String, Contact> idContactMap;

    public ContactStorageDaoImpl() {
        this.idContactMap = new ConcurrentHashMap<>();
    }

    @Override
    public Contact addContact(Contact contact) {;
        try {
            addOrUpdateContact(contact);
            return contact;
        } catch (Exception e) {
            throw new DaoException("Error while adding contact");
        }
    }

    @Override
    public void removeContact(Contact contact) {
        try {
            if (idContactMap.containsKey(contact.getId())) {
                idContactMap.remove(contact.getId());
            } else {
                throw new DaoException("Contact not found");
            }
        } catch (Exception e) {
            throw new DaoException("Error while removing contact");
        }
    }

    @Override
    public Contact updateContact(Contact contact) {
        try {
            if (idContactMap.containsKey(contact.getId())) {
                addOrUpdateContact(contact);
                return contact;
            } else {
                throw new DaoException("Contact not found");
            }
        } catch (Exception e) {
            throw new DaoException("Error while updating contact");
        }
    }

    @Override
    public List<Contact> getContact() throws DaoException {
        return new ArrayList<>(idContactMap.values());
    }

    private void addOrUpdateContact(Contact contact) {
        idContactMap.put(contact.getId(), contact);
    }
}
