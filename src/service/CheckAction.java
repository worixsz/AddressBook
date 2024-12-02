package service;

import model.Contact;

import java.util.List;

public interface CheckAction {

    void showContact(List<Contact> contacts);

    void validateContact(Contact contact);

    void checkStringForEmpty(String text);

    void checkPhoneNumber(String number);

    String formatPhoneNumber(String number);

    void checkForValidNameAndSurname(String text);

    void checkForValidAddress(String text);

    void checkForValidPhoneNumber(String text);


}
