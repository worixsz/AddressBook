import model.Contact;
import repository.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    static final Scanner SC = new Scanner(System.in);


    public static void main(String[] args) {
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
                            System.out.print("Enter name to search: ");
                            String searchOfName = SC.next();
                            searchMove.searchContactByName(contacts, searchOfName);
                            checkMove.checkContact(searchOfName, contacts);

                            break;
                        case 2:
                            System.out.print("Enter surname to search: ");
                            String searchOfSurname = SC.next();
                            searchMove.searchContactBySurname(contacts, searchOfSurname);
                            checkMove.checkContact(searchOfSurname, contacts);
                            break;
                        case 3:
                            System.out.print("Enter address to search: ");
                            String searchOfAddress = SC.next();
                            searchMove.searchContactByAddress(contacts, searchOfAddress);
                            checkMove.checkContact(searchOfAddress, contacts);
                            break;
                        case 4:
                            System.out.print("Enter phone number to search: ");
                            String searchOfNumber = SC.next();
                            searchMove.searchContactByPhone(contacts, searchOfNumber);
                            checkMove.checkContact(searchOfNumber, contacts);
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
                            System.out.print("Enter name to search: ");
                            String searchOfName = SC.next();
                            actionMove.updateContactByName(searchOfName, contacts);
                            break;
                        case 2:
                            System.out.print("Enter surname to search: ");
                            String searchOfSurname = SC.next();
                            actionMove.updateContactBySurname(searchOfSurname, contacts);
                            break;
                        case 3:
                            System.out.print("Enter address to search: ");
                            String searchOfAddress = SC.next();
                            actionMove.updateContactByAddress(searchOfAddress, contacts);
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