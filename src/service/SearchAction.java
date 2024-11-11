package service;

import model.Contact;

import java.util.List;

public interface SearchAction {

    int searchContactByName(List<Contact> contacts, String searchString);

    int searchContactBySurname(List<Contact> contacts, String searchString);

    int searchContactByAddress(List<Contact> contacts, String searchString);

    int searchContactByPhone(List<Contact> contacts, String searchString);
}
