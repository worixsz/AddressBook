package repository;

import model.Contact;
import service.SearchAction;

import java.util.List;
import java.util.Scanner;

public class SearchActionMove implements SearchAction {

    Scanner SC = new Scanner(System.in);

    public SearchActionMove() {

    }

    public List<Contact> searchContactByName(List<Contact> contacts) {

        System.out.print("Enter name to search: ");
        String searchOfName = SC.next();

        for (Contact contact : contacts) {
            if (contact != null) {
                if (contact.getName().equals(searchOfName)) {
                    System.out.println("🔍 Contact Found: " + contact);
                } else {
                    System.out.println("❌ No contact found with the such data: " + searchOfName);
                }
            }
        }
        return contacts;
    }

    @Override
    public List<Contact> searchContactBySurname(List<Contact> contacts) {
        System.out.print("Enter surname to search: ");
        String searchOfSurname = SC.next();

        for (Contact contact : contacts) {
            if (contact != null) {
                if (contact.getSurname().equals(searchOfSurname)) {
                    System.out.println("🔍 Contact Found: " + contact);
                } else {
                    System.out.println("❌ No contact found with the such data: " + searchOfSurname);
                }
            }
        }
        return contacts;
    }

    @Override
    public List<Contact> searchContactByAddress(List<Contact> contacts) {
        System.out.print("Enter address to search: ");
        String searchOfAddress = SC.next();
        for (Contact contact : contacts) {
            if (contact != null) {
                if (contact.getAddress().equals(searchOfAddress)) {
                    System.out.println("🔍 Contact Found: " + contact);
                } else {
                    System.out.println("❌ No contact found with the such data: " + searchOfAddress);
                }
            }
        }
        return contacts;
    }

    @Override
    public List<Contact> searchContactByPhone(List<Contact> contacts) {
        System.out.print("Enter phone number to search: ");
        String searchOfNumber = SC.next();

        for (Contact contact : contacts) {
            if (contact != null) {
                if (contact.getPhone().equals(searchOfNumber)) {
                    System.out.println("🔍 Contact Found: " + contact);
                } else {
                    System.out.println("❌ No contact found with the such data: " + searchOfNumber);
                }
            }
        }
        return contacts;
    }
}
