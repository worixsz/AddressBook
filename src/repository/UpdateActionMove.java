package repository;

import model.Contact;
import service.UpdateAction;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UpdateActionMove implements UpdateAction {

    private final SearchActionMove search;

    private final CheckActionMove checkActionMove;


    Scanner SC = new Scanner(System.in);

    public UpdateActionMove() {
        search = new SearchActionMove();
        checkActionMove = new CheckActionMove();
    }

    @Override
    public void updateContactByName(List<Contact> contacts) {
        try {
            for (Contact _ : contacts) {
                List<Contact> foundContacts = search.searchContactByName(contacts);
                if (foundContacts.isEmpty()) {
                    return;
                } else {
                    System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
                    int userIndex = getValidIndex(foundContacts.size());
                    foundContacts.stream()
                            .skip(userIndex)
                            .findFirst()
                            .ifPresent(contact -> updateContact(contacts, contacts.indexOf(contact)));
                }
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    @Override
    public void updateContactBySurname(List<Contact> contacts) {
        try {
            for (Contact _ : contacts) {
                List<Contact> foundContacts = search.searchContactBySurname(contacts);
                if (foundContacts.isEmpty()) {
                    return;
                } else {
                    System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
                    int userIndex = getValidIndex(foundContacts.size());
                    foundContacts.stream()
                            .skip(userIndex)
                            .findFirst()
                            .ifPresent(contact -> updateContact(contacts, contacts.indexOf(contact)));
                }
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    @Override
    public void updateContactByAddress(List<Contact> contacts) {
        try {
            for (Contact _ : contacts) {
                List<Contact> foundContacts = search.searchContactByAddress(contacts);
                if (foundContacts.isEmpty()) {
                    return;
                } else {
                    System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
                    int userIndex = getValidIndex(foundContacts.size());
                    foundContacts.stream()
                            .skip(userIndex)
                            .findFirst()
                            .ifPresent(contact -> updateContact(contacts, contacts.indexOf(contact)));
                }
            }

        } catch (Exception e) {
            e.fillInStackTrace();
        }


    }

    @Override
    public void updateContactByPhone(List<Contact> contacts) {
        try {
            for (Contact _ : contacts) {
                List<Contact> foundContacts = search.searchContactByPhone(contacts);
                if (foundContacts.isEmpty()) {
                    return;
                } else {
                    System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
                    int userIndex = getValidIndex(foundContacts.size());
                    foundContacts.stream()
                            .skip(userIndex)
                            .findFirst()
                            .ifPresent(contact -> updateContact(contacts, contacts.indexOf(contact)));
                }
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }


    @Override
    public int getValidIndex(int size) {
        Scanner SC = new Scanner(System.in);
        int attempts = 0;
        while (attempts <= 5) {
            try {
                int index = SC.nextInt() - 1;
                if (index >= 0 && index < size) {
                    return index;
                }
                System.out.print("❗ Invalid index. Please try again: ");
            } catch (Exception e) {
                System.out.print("❗ Invalid input. Please enter a number: ");
                SC.nextLine();
            }
            attempts++;
        }
        return size;
    }


    @Override
    public void updateContact(List<Contact> contacts, int indexForSave) {
        Scanner SC = new Scanner(System.in);
        Contact contactToUpdate = contacts.get(indexForSave);

        try {
            System.out.print("Enter the new name: ");
            String newName = SC.nextLine();
            checkActionMove.checkStringForEmpty(newName);

            System.out.print("Enter the new surname: ");
            String newSurname = SC.nextLine();
            checkActionMove.checkStringForEmpty(newSurname);

            System.out.print("Enter the new address: ");
            String newAddress = SC.nextLine();
            checkActionMove.checkStringForEmpty(newAddress);

            System.out.print("Enter the new phone number: ");
            String newPhone = SC.nextLine();
            checkActionMove.checkStringForEmpty(newPhone);

            checkActionMove.validateContact(contactToUpdate);

            contactToUpdate.setName(newName);
            contactToUpdate.setSurname(newSurname);
            contactToUpdate.setAddress(newAddress);
            contactToUpdate.setPhone(newPhone);

            System.out.println("✅ Contact Updated!");

        } catch (InputMismatchException e) {
            System.err.println("\n❌ Error: " + e.getMessage() + " Contact not updated.\n");
            System.err.print("Choose an option again: \n");
        }
    }


    public void setScanner(Scanner scanner) {
        this.SC = scanner;
    }


}
