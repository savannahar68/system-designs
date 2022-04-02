package com.phone.Service;

import com.phone.Domain.Contact;
import com.phone.Domain.Enums.SearchType;
import com.phone.Domain.SearchRequest;

import java.util.ArrayList;
import java.util.List;

public class SearchContactUtil {

    private static List<Contact> searchContactByFirstName(String firstName, SearchType type, List<Contact> contacts) {
        if (type.equals(SearchType.PARTIAL)) {
            return contacts.parallelStream().filter(contact -> contact.getFirstName().contains(firstName)).collect(java.util.stream.Collectors.toList());
        } else if (type.equals(SearchType.COMPLETE)) {
            return contacts.parallelStream().filter(contact -> contact.getFirstName().equals(firstName)).collect(java.util.stream.Collectors.toList());
        }
        return new ArrayList<>();
    }

    private static List<Contact> searchContactByLastName(String lastName, SearchType type, List<Contact> contacts) {
        if (type.equals(SearchType.PARTIAL)) {
            return contacts.parallelStream().filter(contact -> contact.getLastName().contains(lastName)).collect(java.util.stream.Collectors.toList());
        } else if (type.equals(SearchType.COMPLETE)) {
            return contacts.parallelStream().filter(contact -> contact.getLastName().equals(lastName)).collect(java.util.stream.Collectors.toList());
        }
        return new ArrayList<>();
    }

    private static List<Contact> searchContactByPhoneNumber(String phoneNumber, SearchType type, List<Contact> contacts) {
        if (type.equals(SearchType.PARTIAL)) {
            return contacts.parallelStream().filter(contact -> contact.getPhoneNumber().contains(phoneNumber)).collect(java.util.stream.Collectors.toList());
        } else if (type.equals(SearchType.COMPLETE)) {
            return contacts.parallelStream().filter(contact -> contact.getPhoneNumber().equals(phoneNumber)).collect(java.util.stream.Collectors.toList());
        }
        return new ArrayList<>();
    }

    public static List<Contact> searchContact(SearchRequest searchRequest, List<Contact> contacts) {
        List<Contact> result = new ArrayList<>();
        switch (searchRequest.getSearchField()) {
            case FIRST_NAME:
                result = searchContactByFirstName(searchRequest.getInput(), searchRequest.getSearchType(), contacts);
                break;
            case LAST_NAME:
                result = searchContactByLastName(searchRequest.getInput(), searchRequest.getSearchType(), contacts);
                break;
            case PHONE:
                result = searchContactByPhoneNumber(searchRequest.getInput(), searchRequest.getSearchType(), contacts);
                break;
            default:
                break;
        }
        return result;
    }
}
