package service;

import model.Contact;

import java.util.List;

public interface DeleteAction {

    void deleteContactByContact(int index, List<Contact> contacts);


}
