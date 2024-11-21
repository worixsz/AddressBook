package repository;

import model.Contact;
import service.UpdateAction;

import java.util.List;
import java.util.Scanner;

public class UpdateActionMove implements UpdateAction {

    private final SearchActionMove search;

    private final CheckActionMove check;

    Scanner SC = new Scanner(System.in);

    public UpdateActionMove() {
        search = new SearchActionMove();
        check = new CheckActionMove();
    }

    @Override
    public void updateContactByName(List<Contact> contacts) {
        List<Contact> foundContacts = search.searchContactByName(contacts);
        if (!foundContacts.isEmpty()) {
            System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
            Scanner SC = new Scanner(System.in);
            int userIndex;
            int attemptCount = 0;
            do {
                userIndex = SC.nextInt() - 1;
                if (userIndex >= 0 && userIndex < foundContacts.size()) {
                    break;
                } else {
                    attemptCount++;
                    System.out.println("❗ Invalid index. Please try again.");
                    System.out.print("Enter the index of the contact: ");
                }
            } while (attemptCount < 5);

            int finalUserIndex = userIndex;
            foundContacts.stream()
                    .skip(finalUserIndex)
                    .findFirst()
                    .ifPresent(contact -> updateContact(contacts, contacts.indexOf(contact)));
        }
    }


    @Override
    public void updateContactBySurname(List<Contact> contacts) {
        List<Contact> foundContacts = search.searchContactBySurname(contacts);
        if (!foundContacts.isEmpty()) {
            System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
            int userIndex = check.checkLengthOfContact(foundContacts.size());

            foundContacts.stream()
                    .skip(userIndex)
                    .findFirst()
                    .ifPresent(_ -> updateContact(contacts, userIndex));
        }
    }

    @Override
    public void updateContactByAddress(List<Contact> contacts) {
        List<Contact> foundContacts = search.searchContactByAddress(contacts);
        if (!foundContacts.isEmpty()) {
            System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
            int userIndex = check.checkLengthOfContact(foundContacts.size());

            foundContacts.stream()
                    .skip(userIndex)
                    .findFirst()
                    .ifPresent(_ -> updateContact(contacts, userIndex));
        }
    }

    @Override
    public void updateContactByPhone(List<Contact> contacts) {
        List<Contact> foundContacts = search.searchContactByPhone(contacts);
        if (!foundContacts.isEmpty()) {
            System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
            int userIndex = check.checkLengthOfContact(foundContacts.size());

            foundContacts.stream()
                    .skip(userIndex)
                    .findFirst()
                    .ifPresent(_ -> updateContact(contacts, userIndex));
        }
    }


    @Override
    public void updateContact(List<Contact> contacts, int indexForSave) {
        Scanner SC = new Scanner(System.in);
        Contact contactToUpdate = contacts.get(indexForSave);
        System.out.print("Enter the new name: ");
        String newName = SC.next();
        System.out.print("Enter the new surname: ");
        String newSurname = SC.next();
        System.out.print("Enter the new address: ");
        String newAddress = SC.next();
        System.out.print("Enter the new phone number: ");
        String newPhone = SC.next();
        contactToUpdate.setName(newName);
        contactToUpdate.setSurname(newSurname);
        contactToUpdate.setAddress(newAddress);
        contactToUpdate.setPhone(newPhone);

        System.out.println("✅ Contact Updated!");
    }

    public void setScanner(Scanner scanner) {
        this.SC = scanner;
    }


}
