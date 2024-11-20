package repository;

import model.Contact;
import service.SearchAction;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchActionMove implements SearchAction {


    Scanner SC = new Scanner(System.in);

    public SearchActionMove() {
    }

    @Override
    public List<Contact> searchContactByName(List<Contact> contacts) {
        System.out.print("Enter name to search: ");
        String next = SC.next();
        List<Contact> foundContacts = contacts.stream()
                .filter(contact -> contact.getName().equals(next))
                .collect(Collectors.toList());
        if (!foundContacts.isEmpty()) {

            foundContacts.forEach(contact -> System.out.println("🔍 Contact Found: " + contact));
        } else {
            System.out.println("❌ No contact found with the such name: " + next);
        }
        return foundContacts;
    }


    @Override
    public List<Contact> searchContactBySurname(List<Contact> contacts) {
        System.out.print("Enter surname to search: ");
        String next = SC.next();
        List<Contact> foundContacts = contacts.stream()
                .filter(contact -> contact.getSurname().equals(next))
                .collect(Collectors.toList());
        if (!foundContacts.isEmpty()) {

            foundContacts.forEach(contact -> System.out.println("🔍 Contact Found: " + contact));
        } else {
            System.out.println("❌ No contact found with the such surname: " + next);
        }
        return foundContacts;
    }

    @Override
    public List<Contact> searchContactByAddress(List<Contact> contacts) {
        System.out.print("Enter address to search: ");
        String next = SC.next();
        List<Contact> foundContacts = contacts.stream()
                .filter(contact -> contact.getAddress().equals(next))
                .collect(Collectors.toList());
        if (!foundContacts.isEmpty()) {

            foundContacts.forEach(contact -> System.out.println("🔍 Contact Found: " + contact));
        } else {
            System.out.println("❌ No contact found with the such address: " + next);
        }
        return foundContacts;
    }

    @Override
    public List<Contact> searchContactByPhone(List<Contact> contacts) {
        System.out.print("Enter phone number to search: ");
        String next = SC.next();
        List<Contact> foundContacts = contacts.stream()
                .filter(contact -> contact.getPhone().equals(next))
                .collect(Collectors.toList());
        if (!foundContacts.isEmpty()) {

            foundContacts.forEach(contact -> System.out.println("🔍 Contact Found: " + contact));
        } else {
            System.out.println("❌ No contact found with the such address: " + next);
        }
        return foundContacts;
    }

    @Override
    public void findByNamePrefix(List<Contact> contacts, String namePrefix) {

    }

    @Override
    public void findBySurnamePrefix(List<Contact> contacts, String surnamePrefix) {

    }

    @Override
    public void findByAddressPrefix(List<Contact> contacts, String addressPrefix) {

    }

    @Override
    public void findByPhonePrefix(List<Contact> contacts, String phonePrefix) {

    }
}
