package com.phone.Proxy;

import com.phone.Apis.ContactManager;
import com.phone.Domain.Contact;
import com.phone.Domain.SearchRequest;
import com.phone.Domain.SearchResponse;
import com.phone.Exceptions.ContactManagerException;

public class ContactManagerValidationProxy implements ContactManager {

    private ContactManager contactManager;

    public ContactManagerValidationProxy(ContactManager contactManager) {
        this.contactManager = contactManager;
    }

    @Override
    public boolean add(Contact contact) {
        // Do phone number validation as per E-164 format here and throw exception
        if (!validatePhoneNumber(contact.getPhoneNumber())) {
            throw new ContactManagerException("Invalid phone number");
        }
        return contactManager.add(contact);
    }

    @Override
    public boolean update(Contact contact) {
        // Do phone number validation as per E-164 format here and throw exception
        if (!validatePhoneNumber(contact.getPhoneNumber())) {
            throw new ContactManagerException("Invalid phone number");
        }
        return contactManager.update(contact);
    }

    @Override
    public SearchResponse search(SearchRequest searchRequest) {
        // Do validation on search fields here and throw exception if something is wrong
        return contactManager.search(searchRequest);
    }

    // validate phone number according to E-164 format
    private Boolean validatePhoneNumber(String phoneNumer) {
        return phoneNumer.matches("^\\+?[1-9]\\d{1,14}$");
    }
}
