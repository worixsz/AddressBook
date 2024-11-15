package service;

import model.Contact;

import java.util.List;

public interface CheckAction {

    void showContact(List<Contact> contacts);

    int checkLengthOfContact(int contactCount);

}
