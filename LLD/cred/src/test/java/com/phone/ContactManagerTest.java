package com.phone;

import com.phone.Apis.ContactManager;
import com.phone.Domain.Contact;
import com.phone.Domain.Enums.SearchField;
import com.phone.Domain.Enums.SearchType;
import com.phone.Domain.SearchRequest;
import com.phone.Domain.SearchResponse;
import com.phone.Exceptions.ContactManagerException;
import com.phone.Exceptions.FactoryException;
import com.phone.Platform.ContactFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ContactManagerTest {
    public ContactManager contactManager;

    @BeforeEach
    public void init() throws FactoryException {
        contactManager = ContactFactory.getContectManager();
    }

    @Test
    void test() {
        System.out.println("No test cases added");
    }

    @Test
    void testAddContact() {
        Contact contact = new Contact("Savan", "Nahar", "+919090909090");
        Assertions.assertTrue(contactManager.add(contact));
    }

    @Test
    void testAddMultipleContacts() {
        Contact contact1 = new Contact("Savan1", "Nahar1", "+919090909090");
        Contact contact2 = new Contact("Savan2", "Nahar2", "+919090909091");
        Contact contact3 = new Contact("Savan3", "Nahar3", "+919090909092");
        Assertions.assertTrue(contactManager.add(contact1));
        Assertions.assertTrue(contactManager.add(contact2));
        Assertions.assertTrue(contactManager.add(contact3));
    }

    @Test
    void testUpdateContact() {
        Contact contact = new Contact("Savan", "Nahar", "+919090909090");
        Assertions.assertTrue(contactManager.add(contact));
        contact.setFirstName("Savan1");
        Assertions.assertTrue(contactManager.update(contact));
    }

    @Test
    void testUpdateException() throws ContactManagerException {
        Contact contact = new Contact("Savan", "Nahar", "+919090909090");
        contact.setFirstName("Savan1");
        Assertions.assertThrows(ContactManagerException.class, () -> contactManager.update(contact));
    }

    @Test
    void testSearchByFirstName() {
        Contact contact = new Contact("Savan", "Nahar", "+919090909090");
        contactManager.add(contact);
        Assertions.assertEquals(contactManager.search(new SearchRequest(SearchField.FIRST_NAME, SearchType.COMPLETE, "Savan")), new SearchResponse(1, Arrays.asList(contact)));
    }
}
