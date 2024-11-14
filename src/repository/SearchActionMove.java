package repository;

import model.Contact;
import service.SearchAction;

import java.util.List;

public class SearchActionMove implements SearchAction {

    public SearchActionMove() {
    }

    @Override
    public int searchContactByName(List<Contact> contacts, String searchString) {
        int foundIndex = -1;

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact != null) {
                if (contact.getName().equals(searchString)) {
                    foundIndex = i;
                    System.out.println("🔍 Contact Found: " + contact);

                }
            }
        }

        return foundIndex;
    }

    @Override
    public int searchContactBySurname(List<Contact> contacts, String searchOfSurname) {
        int foundIndex = -1;

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact != null) {
                if (contact.getSurname().equals(searchOfSurname)) {
                    System.out.println("🔍 Contact Found: " + contacts.get(i));
                    foundIndex = i;
                }
            }
        }
        return foundIndex;
    }

    @Override
    public int searchContactByAddress(List<Contact> contacts, String searchOfAddress) {
        int foundIndex = -1;

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact != null) {
                if (contact.getAddress().equals(searchOfAddress)) {
                    System.out.println("🔍 Contact Found: " + contacts.get(i));
                    foundIndex = i;
                }
            }
        }

        return foundIndex;
    }

    @Override
    public int searchContactByPhone(List<Contact> contacts, String searchOfNumber) {

        int foundIndex = -1;

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact != null) {
                if (contact.getPhone().equals(searchOfNumber)) {
                    System.out.println("🔍 Contact Found: " + contacts.get(i));
                    foundIndex = i;
                }
            }
        }
        return foundIndex;
    }
}
