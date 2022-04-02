package com.phone;

import com.phone.Apis.ContactManager;
import com.phone.Domain.Contact;
import com.phone.Domain.Enums.SearchField;
import com.phone.Domain.Enums.SearchType;
import com.phone.Domain.SearchRequest;
import com.phone.Platform.ContactFactory;

public class MainApplication {
    public static void main(String[] args) {
        try {
            ContactManager contactManager = ContactFactory.getContectManager();
            Contact contact1 = new Contact("Savan", "Nahar", "+11234567890123");
            Contact contact2 = new Contact("Savan1", "Nah", "+919028333089");
            Contact contact3 = new Contact("Random", "SomethingElse", "+919028333089");
            contactManager.add(contact1);
            contactManager.add(contact2);
            contactManager.add(contact3);

            System.out.println(contactManager.search(new SearchRequest(SearchField.FIRST_NAME, SearchType.COMPLETE, "Savan")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
