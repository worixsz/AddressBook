package service;

import model.Contact;

import java.util.List;

public interface CheckAction {

    void showContact(List<Contact> contacts);

    void validateContact(Contact contact);

    void checkStringForEmpty(String text);

}
