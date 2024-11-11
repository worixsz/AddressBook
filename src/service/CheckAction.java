package service;

import model.Contact;

import java.util.List;

public interface CheckAction {

    void showContact(int index, List<Contact> contacts);

    int checkLengthOfContact(String length, List<Contact> contacts);

    void checkContact(int index, List<Contact> contacts);
}
