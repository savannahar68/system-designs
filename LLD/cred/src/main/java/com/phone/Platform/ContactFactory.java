package com.phone.Platform;

import com.phone.Apis.ContactManager;
import com.phone.Apis.ContactStorageDao;
import com.phone.Exceptions.FactoryException;
import com.phone.Proxy.ContactManagerValidationProxy;
import com.phone.Service.ContactManagerImpl;

public interface ContactFactory {
    static ContactManager getContectManager() throws FactoryException {
        // TODO: ideally this comes from application.properties and based on that contact manager impl is selected
        ContactManager contactManager = new ContactManagerImpl(DaoFactory.getContactStorageDao());
        // TODO: decide what proxies to use from application.properties
        return new ContactManagerValidationProxy(contactManager);
    }
}