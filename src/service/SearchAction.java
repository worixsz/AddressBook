package service;

import model.Contact;

import java.util.List;

public interface SearchAction {

    List<Contact> searchContactByName(List<Contact> contacts);

    List<Contact> searchContactBySurname(List<Contact> contacts);

    List<Contact> searchContactByAddress(List<Contact> contacts);

    List<Contact> searchContactByPhone(List<Contact> contacts);

    void findByNamePrefix(List<Contact> contacts, String namePrefix);

    void findBySurnamePrefix(List<Contact> contacts, String surnamePrefix);

    void findByAddressPrefix(List<Contact> contacts, String addressPrefix);

    void findByPhonePrefix(List<Contact> contacts, String phonePrefix);


}
