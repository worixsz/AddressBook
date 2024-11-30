package repository;

import fileService.FileService;
import model.Contact;

import java.util.List;
import java.util.Scanner;

public class Action {

    Scanner SC = new Scanner(System.in);
    private final List<Contact> contacts;
    private final UpdateActionMove actionMove;
    private final SearchActionMove searchMove;
    private final CheckActionMove checkMove;
    private final DeleteActionMove deleteActionMove;
    private final CreateContactMove createMove;
    FileService fileService;

    public Action() {
        fileService = new FileService();
        this.contacts = fileService.read();
        actionMove = new UpdateActionMove();
        searchMove = new SearchActionMove();
        checkMove = new CheckActionMove();
        deleteActionMove = new DeleteActionMove();
        createMove = new CreateContactMove();
    }

    public void run() throws NumberFormatException {

        int command = 0;

        while (command != 6) {
            try {
                System.out.println("\n======= CONTACT MANAGEMENT SYSTEM =======");
                System.out.println("1. Create Contact");
                System.out.println("2. Search Contact");
                System.out.println("3. Delete Contact");
                System.out.println("4. List All Contacts");
                System.out.println("5. Update contact");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                command = Integer.parseInt(SC.nextLine());

                switch (command) {
                    case 1:
                        createMove.createContact(contacts);
                        fileService.write(contacts);
                        break;
                    case 2:
                        System.out.println("\n--- SEARCH CONTACT ---");
                        System.out.println("How would you like to search the contacts?");
                        System.out.println("1. By Name");
                        System.out.println("2. By Surname");
                        System.out.println("3. By Address");
                        System.out.println("4. By Phone number");
                        System.out.print("Please enter the corresponding number (1-4): ");
                        int enter = Integer.parseInt(SC.nextLine());

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
                                SC.nextLine();
                                break;
                        }
                        break;
                    case 3:
                        deleteActionMove.deleteContactByIndex(contacts);
                        fileService.write(contacts);
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
                        int enterUpdate = Integer.parseInt(SC.nextLine());
                        switch (enterUpdate) {
                            case 1:
                                actionMove.updateContactByName(contacts);
                                fileService.write(contacts);
                                break;
                            case 2:
                                actionMove.updateContactBySurname(contacts);
                                fileService.write(contacts);
                                break;
                            case 3:
                                actionMove.updateContactByAddress(contacts);
                                fileService.write(contacts);
                                break;
                            case 4:
                                actionMove.updateContactByPhone(contacts);
                                fileService.write(contacts);
                                break;
                            default:
                                System.err.println("❗ Invalid command. Please select a number between 1 and 4.\n");
                                SC.nextLine();
                                break;
                        }
                        break;
                    case 6:
                        System.out.println("👋 Exiting Contact Management System. Goodbye!");
                        break;
                    default:
                        System.err.println("❗ Invalid command. Please select a number between 1 and 6.\n");
                        SC.nextLine();
                        break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();

            }
        }
    }
}
