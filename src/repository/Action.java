package repository;

import model.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Action {

    static Scanner SC = new Scanner(System.in);

    public Action() {

    }


    public static void run() {
        List<Contact> contacts = new ArrayList<>();
        UpdateActionMove actionMove = new UpdateActionMove();
        SearchActionMove searchMove = new SearchActionMove();
        CheckActionMove checkMove = new CheckActionMove();
        DeleteActionMove deleteActionMove = new DeleteActionMove();
        CreateContactMove createMove = new CreateContactMove();

        int command;

        do {
            System.out.println("\n======= CONTACT MANAGEMENT SYSTEM =======");
            System.out.println("1. Create Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. List All Contacts");
            System.out.println("5. Update contact");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            command = SC.nextInt();

            switch (command) {
                case 1:
                    createMove.createContact(contacts);
                    break;
                case 2:
                    System.out.println("\n--- SEARCH CONTACT ---");
                    System.out.println("How would you like to search for a contact?");
                    System.out.println("1. By Name");
                    System.out.println("2. By Surname");
                    System.out.println("3. By Address");
                    System.out.println("4. By Phone number");
                    System.out.print("Please enter the corresponding number (1-4): ");
                    int enter = SC.nextInt();

                    switch (enter) {
                        case 1:
                            searchMove.searchContactByName(contacts);
                            break;
                        case 2:
                            searchMove.searchContactBySurname(contacts);
                            break;
                        case 3:
                            searchMove.searchContactByAddress(contacts);
                            break;
                        case 4:
                            searchMove.searchContactByPhone(contacts);
                            break;
                        default:
                            System.err.println("❗ Invalid command. Please select a number between 1 and 4.\n");
                            break;
                    }
                    break;
                case 3:
                    deleteActionMove.deleteContactByContact(contacts);
                    break;
                case 4:
                    checkMove.showContact(contacts);
                    break;
                case 5:
                    System.out.println("\n--- UPDATE CONTACT ---");
                    System.out.println("How would you like to search a contact for update?");
                    System.out.println("1. By Name");
                    System.out.println("2. By Surname");
                    System.out.println("3. By Address");
                    System.out.println("4. By Phone number");
                    System.out.print("Please enter the corresponding number (1-4): ");
                    int enterUpdate = SC.nextInt();
                    switch (enterUpdate) {
                        case 1:
                            actionMove.updateContactByName(contacts);
                            break;
                        case 2:
                            actionMove.updateContactBySurname(contacts);
                            break;
                        case 3:

                            actionMove.updateContactByAddress(contacts);
                            break;
                        case 4:
                            System.out.print("Enter phone number to search: ");
                            String searchOfNumber = SC.next();
                            actionMove.updateContactByPhone(searchOfNumber, contacts);
                            break;
                        default:
                            System.err.println("❗ Invalid command. Please select a number between 1 and 4.\n");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("👋 Exiting Contact Management System. Goodbye!");
                    break;
                default:
                    System.err.println("❗ Invalid command. Please select a number between 1 and 5.\n");
                    break;
            }
        } while (command != 6);
    }

}

