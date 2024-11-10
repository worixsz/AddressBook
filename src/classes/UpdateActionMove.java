package classes;

import interfaces.UpdateAction;

import java.util.Scanner;

public class UpdateActionMove implements UpdateAction {

    static final String DELIMITER = "; ";

    public UpdateActionMove() {
        search = new SearchActionMove();
        check = new CheckActionMove();
    }

    static SearchActionMove search;

    static CheckActionMove check;


    @Override
    public void updateContactByName(String indexOfContact, String[] contacts) {
        int updateIndex = search.searchContactByName(contacts, indexOfContact);
        if (updateIndex != -1) {
            System.out.print("Enter the index of the contact to update\n");
            int indexForSaving = check.checkLengthOfContact(indexOfContact, contacts);
            updateContact(contacts, indexForSaving);
        } else {
            System.out.println("❗No contact with such data!");
        }

    }

    @Override
    public void updateContactBySurname(String indexOfContact, String[] contacts) {
        int updateIndex = search.searchContactBySurname(contacts, indexOfContact);
        if (updateIndex != -1) {
            System.out.print("Enter the index of the contact to update\n");
            int indexForSaving = check.checkLengthOfContact(indexOfContact, contacts);
            updateContact(contacts, indexForSaving);
        } else {
            System.out.println("❗No contact with such data!");
        }

    }

    @Override
    public void updateContactByAddress(String indexOfContact, String[] contacts) {
        int updateIndex = search.searchContactByAddress(contacts, indexOfContact);
        if (updateIndex != -1) {
            System.out.print("Enter the index of the contact to update\n");
            int indexForSaving = check.checkLengthOfContact(indexOfContact, contacts);
            updateContact(contacts, indexForSaving);
        } else {
            System.out.println("❗No contact with such data!");
        }

    }

    @Override
    public void updateContactByPhone(String indexOfContact, String[] contacts) {

        int updateIndex = search.searchContactByPhone(contacts, indexOfContact);
        if (updateIndex != -1) {
            System.out.print("Enter the index of the contact to update\n");
            int indexForSaving = check.checkLengthOfContact(indexOfContact, contacts);
            updateContact(contacts, indexForSaving);
        } else {
            System.out.println("❗No contact with such data!");
        }
    }

    @Override
    public void updateContact(String[] contacts, int indexForSave) {
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter the new name:");
        String newName = SC.next();
        System.out.print("Enter the new surname:");
        String newSurname = SC.next();
        System.out.print("Enter the new address:");
        String newADDRESS = SC.next();
        System.out.print("Enter the new phone number:");
        String newPhone = SC.next();
        contacts[indexForSave] = newName + DELIMITER + newSurname + DELIMITER + newADDRESS + DELIMITER + newPhone;
        System.out.println("✅ Contact Updated!");
    }


}
