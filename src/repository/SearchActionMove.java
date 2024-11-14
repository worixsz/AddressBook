package repository;

import model.Contact;
import service.SearchAction;

import java.util.List;

public class SearchActionMove implements SearchAction {

    private int foundIndex = -1;

    public SearchActionMove() {
    }

    @Override
    public int searchContactByName(List<Contact> contacts, String searchString) {

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

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact != null) {
                if (contact.getSurname().equals(searchOfSurname)) {
                    foundIndex = i;
                    System.out.println("🔍 Contact Found: " + contacts.get(i));
                }
            }
        }
        return foundIndex;
    }

    @Override
    public int searchContactByAddress(List<Contact> contacts, String searchOfAddress) {

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact != null) {
                foundIndex = i;
                if (contact.getAddress().equals(searchOfAddress)) {
                    System.out.println("🔍 Contact Found: " + contacts.get(i));
                }
            }
        }

        return foundIndex;
    }

    @Override
    public int searchContactByPhone(List<Contact> contacts, String searchOfNumber) {

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact != null) {
                foundIndex = i;
                if (contact.getPhone().equals(searchOfNumber)) {
                    System.out.println("🔍 Contact Found: " + contacts.get(i));
                }
            }
        }
        return foundIndex;
    }
}
