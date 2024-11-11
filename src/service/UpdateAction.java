package service;

import model.Contact;

import java.util.List;

public interface UpdateAction {

    void updateContactByName(String indexOfContact, List<Contact> contacts);

    void updateContactBySurname(String indexOfContact, List<Contact> contacts);

    void updateContactByAddress(String indexOfContact, List<Contact> contacts);

    void updateContactByPhone(String indexOfContact, List<Contact> contacts);

    void updateContact(List<Contact> contacts, int indexForSave);


}
