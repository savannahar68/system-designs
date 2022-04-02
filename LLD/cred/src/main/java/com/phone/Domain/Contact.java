package com.phone.Domain;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter // Only for testing
public class Contact {
    private String id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
