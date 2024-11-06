import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String[] contacts = new String[3];
        int nextEmpty = 0;
        int command;

        do {
            System.out.println("\n======= CONTACT MANAGEMENT SYSTEM =======");
            System.out.println("1. Create Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. List All Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            command = scanner.nextInt();

            switch (command) {
                case 1:
                    System.out.println("\n--- CREATE NEW CONTACT ---");
                    System.out.print("Enter your name: ");
                    String name = scanner.next();
                    System.out.print("Enter your surname: ");
                    String surname = scanner.next();
                    System.out.print("Enter your address: ");
                    String address = scanner.next();
                    System.out.print("Enter your phone: ");
                    String phone = scanner.next();

                    if (nextEmpty < contacts.length) {
                        contacts[nextEmpty] = " | Name: " + name + " | Surname: " + surname + " | Address: " + address + " | Phone: " + phone;
                        nextEmpty++;
                        System.out.println("Contact added successfully!\n");
                    } else {
                        System.err.println("Memory full. Cannot add more contacts.\n");
                    }
                    break;

                case 2:
                    System.out.println("\n--- SEARCH CONTACT ---");
                    System.out.print("Search Contact by phone: ");
                    String search = scanner.next();
                    boolean contactFound = false;
                    for (String contact : contacts) {
                        if (contact != null) {
                            String[] contactSplitted = contact.split(" ");
                            if (contactSplitted[9].startsWith(search)) {
                                System.out.println("Contact Found: " + contact);
                                contactFound = true;
                            }
                        }
                    }
                    if (!contactFound) {
                        System.out.println("No contact with such phone number!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- DELETE CONTACT ---");
                    if (nextEmpty == 0) {
                        System.out.println("No contacts available to delete.\n");
                    } else {
                        System.out.println("\n--- LIST OF ALL CONTACTS ---");
                        for (int i = 0; i < nextEmpty; i++) {
                            System.out.println((i + 1) + ". " + contacts[i]);
                        }

                        System.out.print("Enter the index of the contact to delete (1 to " + nextEmpty + "): ");
                        int index = scanner.nextInt() - 1;

                        if (index < 0 || index >= nextEmpty) {
                            System.out.println("Invalid index. Please try again.\n");
                        } else {
                            for (int i = index; i < nextEmpty - 1; i++) {
                                contacts[i] = contacts[i + 1];
                            }
                            contacts[nextEmpty - 1] = null;
                            nextEmpty--;
                            System.out.println("Contact deleted successfully.\n");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- LIST OF ALL CONTACTS ---");
                    if (nextEmpty == 0) {
                        System.out.println("No contacts available.\n");
                    } else {
                        for (int i = 0; i < nextEmpty; i++) {
                            System.out.println((i + 1) + ". " + contacts[i]);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Contact Management System. Goodbye!");
                    break;

                default:
                    System.err.println("Invalid command. Please select a number between 1 and 5.\n");
                    break;
            }
        } while (command != 5);
    }


}
