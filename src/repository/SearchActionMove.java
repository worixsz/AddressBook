package repository;

import model.Contact;
import service.SearchAction;

import java.util.List;
import java.util.Scanner;

public class SearchActionMove implements SearchAction {


    Scanner SC = new Scanner(System.in);

    public SearchActionMove() {
    }

    @Override
    public List<Contact> searchContactByName(List<Contact> contacts) {
        try {
            System.out.print("Enter name to search: ");
            String next = SC.next();
            List<Contact> foundContacts = contacts.stream()
                    .filter(contact -> contact.getName().equals(next))
                    .toList();
            if (!foundContacts.isEmpty()) {
                foundContacts.forEach(contact -> System.out.println("🔍 Contact Found: " + contact));
            } else {
                System.out.println("No contact found with the such name: " + next);
                System.out.println("Trying to find similar contacts by name...");
                findByNamePrefix(contacts, next);
            }

        } catch (Exception e) {
            e.addSuppressed(e.fillInStackTrace());
        }

        return contacts;
    }


    @Override
    public List<Contact> searchContactBySurname(List<Contact> contacts) {
        try {
            System.out.print("Enter surname to search: ");
            String next = SC.next();
            List<Contact> foundContacts = contacts.stream()
                    .filter(contact -> contact.getSurname().equals(next))
                    .toList();
            if (!foundContacts.isEmpty()) {

                foundContacts.forEach(contact -> System.out.println("🔍 Contact Found: " + contact));
            } else {
                System.out.println("No contact found with the such surname: " + next);
                System.out.println("Trying to find similar contacts by surname...");
                findBySurnamePrefix(contacts, next);
            }
        } catch (Exception e) {
            e.addSuppressed(e.fillInStackTrace());
        }

        return contacts;
    }

    @Override
    public List<Contact> searchContactByAddress(List<Contact> contacts) {
        try {
            System.out.print("Enter address to search: ");
            String next = SC.next();
            List<Contact> foundContacts = contacts.stream()
                    .filter(contact -> contact.getAddress().equals(next))
                    .toList();
            if (!foundContacts.isEmpty()) {

                foundContacts.forEach(contact -> System.out.println("🔍 Contact Found: " + contact));
            } else {
                System.out.println("No contact found with the such address: " + next);
                System.out.println("Trying to find similar contacts by address...");
                findByAddressPrefix(contacts, next);
            }

        } catch (Exception e) {
            e.addSuppressed(e.fillInStackTrace());
        }

        return contacts;
    }

    @Override
    public List<Contact> searchContactByPhone(List<Contact> contacts) {
        try {
            System.out.print("Enter phone number to search: ");
            String next = SC.next();
            List<Contact> foundContacts = contacts.stream()
                    .filter(contact -> contact.getPhone().equals(next))
                    .toList();
            if (!foundContacts.isEmpty()) {

                foundContacts.forEach(contact -> System.out.println("🔍 Contact Found: " + contact));
            } else {
                System.out.println("No contact found with the such phone number: " + next);
                System.out.println("Trying to find similar contacts by phone number...");
                findByPhonePrefix(contacts, next);
            }

        } catch (Exception e) {
            e.addSuppressed(e.fillInStackTrace());
        }

        return contacts;
    }


    public void setScanner(Scanner scanner) {
        this.SC = scanner;
    }
}
