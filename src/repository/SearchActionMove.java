package repository;

import model.Contact;
import service.SearchAction;

public class SearchActionMove implements SearchAction {

    static final String DELIMITER = "; ";

    public SearchActionMove() {
    }

    @Override
    public int searchContactByName(Contact[] contacts, String searchString) {
        int foundIndex = -1;

        for (int i = 0; i < contacts.length; i++) {
            Contact contact = contacts[i];
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
    public int searchContactBySurname(Contact[] contacts, String searchOfSurname) {
        int foundIndex = -1;

        for (int i = 0; i < contacts.length; i++) {
            Contact contact = contacts[i];
            if (contact != null) {
                if (contact.getSurname().equals(searchOfSurname)) {
                    System.out.println("🔍 Contact Found: " + contacts[i]);
                    foundIndex = i;
                }
            }
        }
        return foundIndex;
    }

    @Override
    public int searchContactByAddress(Contact[] contacts, String searchOfAddress) {
        int foundIndex = -1;

        for (int i = 0; i < contacts.length; i++) {
            Contact contact = contacts[i];
            if (contact != null) {
                if (contact.getAddress().equals(searchOfAddress)) {
                    System.out.println("🔍 Contact Found: " + contacts[i]);
                    foundIndex = i;
                }
            }
        }

        return foundIndex;
    }

    @Override
    public int searchContactByPhone(Contact[] contacts, String searchOfNumber) {

        int foundIndex = -1;

        for (int i = 0; i < contacts.length; i++) {
            Contact contact = contacts[i];
            if (contact != null) {
                if (contact.getPhone().equals(searchOfNumber)) {
                    System.out.println("🔍 Contact Found: " + contacts[i]);
                    foundIndex = i;
                }
            }
        }
        return foundIndex;
    }
}
