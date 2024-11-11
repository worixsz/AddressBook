package service;

import model.Contact;

import java.util.List;

public interface SearchAction {

    int searchContactByName(Contact[] contacts, String searchString);

    int searchContactBySurname(Contact[] contacts, String searchString);

    int searchContactByAddress(Contact[] contacts, String searchString);

    int searchContactByPhone(Contact[] contacts, String searchString);
}
