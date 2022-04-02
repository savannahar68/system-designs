package com.phone.Service;

import com.phone.Apis.ContactManager;
import com.phone.Apis.ContactStorageDao;
import com.phone.Domain.Contact;
import com.phone.Domain.SearchRequest;
import com.phone.Domain.SearchResponse;
import com.phone.Exceptions.ContactManagerException;

import java.util.List;
import java.util.Objects;

public class ContactManagerImpl implements ContactManager {

    ContactStorageDao storageDao;

    public ContactManagerImpl(ContactStorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public boolean add(Contact contact) {
        try {
            return Objects.nonNull(storageDao.addContact(contact));
        } catch (Exception e) {
            throw new ContactManagerException("Error while adding contact");
        }
    }

    @Override
    public boolean update(Contact contact) {
        try {
            return Objects.nonNull(storageDao.updateContact(contact));
        } catch (Exception e) {
            throw new ContactManagerException("Error while updating contact");
        }
    }

    @Override
    public SearchResponse search(SearchRequest searchRequest) {
        try {
            List<Contact> contacts = SearchContactUtil.searchContact(searchRequest, storageDao.getContact());
            return new SearchResponse(contacts.size(), contacts);
        } catch (Exception e) {
            throw new ContactManagerException("Error while searching contact");
        }
     }
}
