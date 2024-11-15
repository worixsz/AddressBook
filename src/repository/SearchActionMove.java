package repository;

import model.Contact;
import service.SearchAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchActionMove implements SearchAction {


    Scanner SC = new Scanner(System.in);

    public SearchActionMove() {
    }

    public List<Contact> searchContactByName(List<Contact> contacts) {
        System.out.print("Enter name to search: ");
        String searchOfName = SC.next();
        List<Contact> foundContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getName().equals(searchOfName)) {
                System.out.println("🔍 Contact Found: " + contact);
                foundContacts.add(contact);
            } else {
                System.out.println("❌ No contact found with the such name: " + contact);
                break;
            }
        }
        return foundContacts;
    }

    @Override
    public List<Contact> searchContactBySurname(List<Contact> contacts) {
        System.out.print("Enter surname to search: ");
        String searchOfName = SC.next();
        List<Contact> foundContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getSurname().equals(searchOfName)) {
                System.out.println("🔍 Contact Found: " + contact);
                foundContacts.add(contact);
            } else {
                System.out.println("❌ No contact found with the such surname: " + contact);
                break;
            }
        }
        return foundContacts;
    }

    @Override
    public List<Contact> searchContactByAddress(List<Contact> contacts) {
        System.out.print("Enter address to search: ");
        String searchOfName = SC.next();
        List<Contact> foundContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getAddress().equals(searchOfName)) {
                System.out.println("🔍 Contact Found: " + contact);
                foundContacts.add(contact);
            } else {
                System.out.println("❌ No contact found with the such address: " + contact);
                break;
            }
        }
        return foundContacts;
    }

    @Override
    public List<Contact> searchContactByPhone(List<Contact> contacts) {
        System.out.print("Enter phone number to search: ");
        String searchOfName = SC.next();
        List<Contact> foundContacts = new ArrayList<>();

        for (Contact contact : contacts) {
            if (contact.getPhone().equals(searchOfName)) {
                System.out.println("🔍 Contact Found: " + contact);
                foundContacts.add(contact);
            } else {
                System.out.println("❌ No contact found with the such phone number: " + contact);
                break;
            }
        }
        return foundContacts;
    }
}
