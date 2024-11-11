import model.Contact;
import repository.CheckActionMove;
import repository.SearchActionMove;
import repository.UpdateActionMove;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    static final Scanner SC = new Scanner(System.in);


    public static void main(String[] args) {
        UpdateActionMove actionMove = new UpdateActionMove();
        SearchActionMove searchMove = new SearchActionMove();
        CheckActionMove checkMove = new CheckActionMove();
        List<Contact> contacts = new ArrayList<>();
        int nextEmpty = 0;
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
                    System.out.println("\n--- CREATE NEW CONTACT ---");
                    System.out.print("Enter your name: ");
                    String name = SC.next();
                    System.out.print("Enter your surname: ");
                    String surname = SC.next();
                    System.out.print("Enter your address: ");
                    String address = SC.next();
                    System.out.print("Enter your phone number: ");
                    String phone = SC.next();

                    if (nextEmpty < contacts.size()) {
                        Contact contact = new Contact(name, surname, address, phone);
                        contacts.add(contact);
                        new Contact(name, surname, address, phone);
                        nextEmpty++;
                        System.out.println("✅ Contact added successfully!\n");


                    } else {
                        System.err.println("❗Memory full. Cannot add more contacts.\n");
                    }
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
                            checkMove.checkContact(nextEmpty, contacts);

                            break;
                        case 2:
                            System.out.print("Enter surname to search: ");
                            String searchOfSurname = SC.next();
                            searchMove.searchContactBySurname(contacts, searchOfSurname);
                            checkMove.checkContact(nextEmpty, contacts);
                            break;
                        case 3:
                            System.out.print("Enter address to search: ");
                            String searchOfAddress = SC.next();
                            searchMove.searchContactByAddress(contacts, searchOfAddress);
                            checkMove.checkContact(nextEmpty, contacts);
                            break;
                        case 4:
                            System.out.print("Enter phone number to search: ");
                            String searchOfNumber = SC.next();
                            searchMove.searchContactByPhone(contacts, searchOfNumber);
                            checkMove.checkContact(nextEmpty, contacts);
                            break;
                        default:
                            System.err.println("❗ Invalid command. Please select a number between 1 and 4.\n");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("\n--- DELETE CONTACT ---");
                    if (nextEmpty == 0) {
                        System.out.println("❌ No contacts available to delete.\n");
                    } else {
                        checkMove.showContact(nextEmpty, contacts);
                        System.out.print("Enter the index of the contact to delete (1 to " + nextEmpty + "): ");
                        int index = SC.nextInt() - 1;
                        if (index >= 0 && index < nextEmpty) {
                            contacts.remove(index);
                            nextEmpty--;
                            System.out.println("🗑️ Contact deleted successfully.\n");
                        } else {
                            System.err.println("❗ Invalid index. Please enter a valid index between 1 and " + nextEmpty + ".\n");
                        }
                    }
                    break;

                case 4:
                    checkMove.showContact(nextEmpty, contacts);
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