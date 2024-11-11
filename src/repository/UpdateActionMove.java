package repository;

import model.Contact;
import service.UpdateAction;

import java.util.List;
import java.util.Scanner;

public class UpdateActionMove implements UpdateAction {

    private final SearchActionMove search;

    private final CheckActionMove check;

    public UpdateActionMove() {
        search = new SearchActionMove();
        check = new CheckActionMove();
    }


    @Override
    public void updateContactByName(String indexOfContact, List<Contact> contacts) {
        int updateIndex = search.searchContactByName(contacts, indexOfContact);

        if (updateIndex != -1) {
            System.out.print("Enter the index of the contact to update: ");
            int indexForSaving = check.checkLengthOfContact(indexOfContact, contacts);
            if (indexForSaving == updateIndex) {
                updateContact(contacts, indexForSaving);
            } else {
                System.out.println("❗No contact with such data!");
            }
        } else {
            System.out.println("❗No contact with such data!");
        }
    }


    @Override
    public void updateContactBySurname(String indexOfContact, List<Contact> contacts) {
        int updateIndex = search.searchContactBySurname(contacts, indexOfContact);

        if (updateIndex != -1) {
            System.out.print("Enter the index of the contact to update: ");
            int indexForSaving = check.checkLengthOfContact(indexOfContact, contacts);
            if (indexForSaving == updateIndex) {
                updateContact(contacts, indexForSaving);
            } else {
                System.out.println("❗No contact with such data!");
            }
        } else {
            System.out.println("❗No contact with such data!");
        }
    }


    @Override
    public void updateContactByAddress(String indexOfContact, List<Contact> contacts) {
        int updateIndex = search.searchContactByAddress(contacts, indexOfContact);

        if (updateIndex != -1) {
            System.out.print("Enter the index of the contact to update: ");
            int indexForSaving = check.checkLengthOfContact(indexOfContact, contacts);
            if (indexForSaving == updateIndex) {
                updateContact(contacts, indexForSaving);
            } else {
                System.out.println("❗No contact with such data!");
            }
        } else {
            System.out.println("❗No contact with such data!");
        }

    }

    @Override
    public void updateContactByPhone(String indexOfContact, List<Contact> contacts) {
        int updateIndex = search.searchContactByPhone(contacts, indexOfContact);

        if (updateIndex != -1) {
            System.out.print("Enter the index of the contact to update: ");
            int indexForSaving = check.checkLengthOfContact(indexOfContact, contacts);
            if (indexForSaving == updateIndex) {
                updateContact(contacts, indexForSaving);
            } else {
                System.out.println("❗No contact with such data!");
            }
        } else {
            System.out.println("❗No contact with such data!");
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


}
