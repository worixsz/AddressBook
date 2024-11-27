package repository;

import model.Contact;
import service.UpdateAction;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
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
            List<Contact> foundContacts = search.searchContactByName(contacts);
            if (foundContacts.isEmpty()) {
                throw new NoSuchElementException("❗The are not contacts");
            }

            System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
            if (!SC.hasNextInt()) {
                SC.nextLine();
                throw new InputMismatchException("❗Invalid input of contact to update.");
            }

            int userIndex = SC.nextInt() - 1;
            if (userIndex < 0 || userIndex >= foundContacts.size()) {
                throw new IndexOutOfBoundsException("❗Invalid index of contact to update.");
            }

            foundContacts.stream()
                    .skip(userIndex)
                    .findFirst()
                    .ifPresent(contact -> updateContact(contacts, contacts.indexOf(contact)));

        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("❗An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    public void updateContactBySurname(List<Contact> contacts) {
        try {
            List<Contact> foundContacts = search.searchContactBySurname(contacts);
            if (foundContacts.isEmpty()) {
                throw new NoSuchElementException("❗The are not contacts");
            }

            System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
            if (!SC.hasNextInt()) {
                SC.nextLine();
                throw new InputMismatchException("❗Invalid input of contact to update.");
            }

            int userIndex = SC.nextInt() - 1;
            if (userIndex < 0 || userIndex >= foundContacts.size()) {
                throw new IndexOutOfBoundsException("❗Invalid index of contact to update.");
            }

            foundContacts.stream()
                    .skip(userIndex)
                    .findFirst()
                    .ifPresent(contact -> updateContact(contacts, contacts.indexOf(contact)));

        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("❗An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
//
//    @Override
//    public void updateContactByAddress(List<Contact> contacts) {
//        try {
//            for (Contact _ : contacts) {
//                List<Contact> foundContacts = search.searchContactByAddress(contacts);
//                if (foundContacts.isEmpty()) {
//                    return;
//                } else {
//                    System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
//                    int userIndex = getValidIndex(foundContacts.size());
//                    foundContacts.stream()
//                            .skip(userIndex)
//                            .findFirst()
//                            .ifPresent(contact -> updateContact(contacts, contacts.indexOf(contact)));
//                }
//            }
//
//        } catch (Exception e) {
//            e.fillInStackTrace();
//        }
//
//
//    }
//
//    @Override
//    public void updateContactByPhone(List<Contact> contacts) {
//        try {
//            for (Contact _ : contacts) {
//                List<Contact> foundContacts = search.searchContactByPhone(contacts);
//                if (foundContacts.isEmpty()) {
//                    return;
//                } else {
//                    System.out.print("Enter the index of the contact to update (1 to " + foundContacts.size() + "): ");
//                    int userIndex = getValidIndex(foundContacts.size());
//                    foundContacts.stream()
//                            .skip(userIndex)
//                            .findFirst()
//                            .ifPresent(contact -> updateContact(contacts, contacts.indexOf(contact)));
//                }
//            }
//        } catch (Exception e) {
//            e.fillInStackTrace();
//        }
//    }


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

            System.out.print("Enter the new phone number: +996 ");
            String newPhone = SC.nextLine();
            checkActionMove.checkStringForEmpty(newPhone);
            String validNumber = checkActionMove.checkPhoneNumberForValid(newPhone);
            checkActionMove.validateContact(contactToUpdate);
            contactToUpdate.setName(newName);
            contactToUpdate.setSurname(newSurname);
            contactToUpdate.setAddress(newAddress);
            contactToUpdate.setPhone(validNumber);

        } catch (InputMismatchException e) {
            System.err.println("\n❌ Error: " + e.getMessage() + " Contact not updated.\n");
            System.err.print("Choose an option again: \n");
            e.printStackTrace();
        }
    }


    public void setScanner(Scanner scanner) {
        this.SC = scanner;
    }


}
