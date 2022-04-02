package com.phone.Platform;

import com.phone.Apis.ContactStorageDao;
import com.phone.Exceptions.FactoryException;
import com.phone.StorageAdapter.ContactStorageDaoImpl;

public class DaoFactory {
    static ContactStorageDao getContactStorageDao() throws FactoryException {
        // TODO: ideally this comes from config file and based on that storage is selected
        return new ContactStorageDaoImpl();
    }
}
