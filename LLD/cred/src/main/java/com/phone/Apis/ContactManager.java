package com.phone.Apis;

import com.phone.Domain.Contact;
import com.phone.Domain.SearchRequest;
import com.phone.Domain.SearchResponse;
import com.phone.Exceptions.ContactManagerException;

public interface ContactManager {
    boolean add(Contact contact) throws ContactManagerException;

    boolean update(Contact contact) throws ContactManagerException;

    SearchResponse search(SearchRequest searchRequest) throws ContactManagerException;
}
