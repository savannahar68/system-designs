package com.phone.Apis;

import com.phone.Domain.Contact;
import com.phone.Domain.Enums.SearchType;
import com.phone.Exceptions.DaoException;

import java.util.List;

public interface ContactStorageDao {
    public Contact addContact(Contact contact) throws DaoException;
    public void removeContact(Contact contact) throws DaoException;
    public Contact updateContact(Contact contact) throws DaoException;
    public List<Contact> getContact() throws DaoException;
}
