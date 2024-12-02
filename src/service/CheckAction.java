package service;

import model.Contact;

import java.util.List;

public interface CheckAction {

    void showContact(List<Contact> contacts);

    void checkPhoneNumber(String number);

    String formatPhoneNumber(String number);

    void checkForValidName(String text);

    void checkForValidSurname(String text);

    void checkForValidAddress(String text);

    void checkForValidPhoneNumber(String text);


}
