import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static final String DELIMITER = "; ";

    static final Scanner SC = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        ContactActionMove actionMove = new ContactActionMove();
        String[] contacts = new String[3];
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

                    if (nextEmpty < contacts.length) {
                        contacts[nextEmpty] = name + DELIMITER + surname + DELIMITER + address + DELIMITER + phone;
                        nextEmpty++;
                        for (int i = 0; i < nextEmpty; i++) {
                            FileWriter writerAdd = new FileWriter("contact.txt", true);
                            writerAdd.write(contacts[i] + "\n");
                            writerAdd.close();

                        }
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
                            int d = actionMove.findContactIndexByName(contacts, searchOfName);
                            actionMove.checkContact(d, contacts);
                            break;
                        case 2:
                            System.out.print("Enter surname to search: ");
                            String searchOfSurname = SC.next();
                            int a = actionMove.findContactIndexBySurname(contacts, searchOfSurname);
                            actionMove.checkContact(a, contacts);
                            break;
                        case 3:
                            System.out.print("Enter address to search: ");
                            String searchOfAddress = SC.next();
                            int b = actionMove.findContactIndexByAddress(contacts, searchOfAddress);
                            actionMove.checkContact(b, contacts);
                            break;
                        case 4:
                            System.out.print("Enter phone number to search: ");
                            String searchOfNumber = SC.next();
                            int c = actionMove.findContactIndexByPhone(contacts, searchOfNumber);
                            actionMove.checkContact(c, contacts);
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
                        actionMove.showContact(nextEmpty, contacts);
                        System.out.print("Enter the index of the contact to delete (1 to " + nextEmpty + "): ");
                        int index = SC.nextInt() - 1;
                        for (int i = index; i < nextEmpty - 1; i++) {
                            contacts[i] = contacts[i + 1];
                        }
                        contacts[nextEmpty - 1] = null;
                        nextEmpty--;
                        System.out.println("🗑️ Contact deleted successfully.\n");
                    }
                    break;
                case 4:
                    actionMove.showContact(nextEmpty, contacts);
                    break;
                case 5:
                    System.out.println("Update Contact");
                    System.out.println("Enter phone to search: ");
                    String updatePhone = SC.next();
                    int updateIndex = actionMove.findContactIndexByPhone(contacts, updatePhone);
                    if (updateIndex != -1) {
                        System.out.println("Found contact: " + contacts[updateIndex]);
                    } else {
                        System.out.println("No contact with such phone number!");
                        break;
                    }
                    System.out.print("Name:");
                    String newName = SC.next();
                    System.out.print("Surname");
                    String newSurname = SC.next();
                    System.out.print("ADDRESS");
                    String newADDRESS = SC.next();
                    System.out.print("Phone");
                    String newPhone = SC.next();
                    contacts[updateIndex] = newName + DELIMITER + newSurname + DELIMITER + newADDRESS + DELIMITER + newPhone;
                    System.out.println("Contact Updated!");
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