package service;

import model.Contact;

public interface UpdateAction {

    void updateContactByName(String indexOfContact, Contact[] contacts);

    void updateContactBySurname(String indexOfContact, Contact[] contacts);

    void updateContactByAddress(String indexOfContact, Contact[] contacts);

    void updateContactByPhone(String indexOfContact, Contact[] contacts);

    void updateContact(Contact[] contacts, int indexForSave);


}
