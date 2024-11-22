package repository;

import model.Contact;
import service.CreateAction;

import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class CreateContactMove implements CreateAction {

    Scanner SC = new Scanner(System.in);
    CheckActionMove checkActionMove;

    public CreateContactMove() {
        checkActionMove = new CheckActionMove();
    }

    @Override
    public void createContact(List<Contact> contacts) {
        System.out.println("\n--- CREATE NEW CONTACT ---");

        try {
            System.out.print("Enter your name: ");
            String name = SC.nextLine();
            if (name.trim().isEmpty()) {
                throw new InputMismatchException("Name cannot be empty.");
            }

            System.out.print("Enter your surname: ");
            String surname = SC.nextLine();
            if (surname.trim().isEmpty()) {
                throw new InputMismatchException("Surname cannot be empty.");
            }

            System.out.print("Enter your address: ");
            String address = SC.nextLine();
            if (address.trim().isEmpty()) {
                throw new InputMismatchException("Address cannot be empty.");
            }

            System.out.print("Enter your phone number: ");
            String phone = SC.nextLine();
            if (phone.trim().isEmpty()) {
                throw new InputMismatchException("Phone number cannot be empty.");
            }

            Contact c = new Contact(name, surname, address, phone);

            checkActionMove.validateContact(c);

            contacts.add(c);
            System.out.println("✅ Contact added successfully!\n");
        } catch (InputMismatchException e) {
            System.err.println("\n❌ Error: " + e.getMessage() + " Contact not added.\n");
            System.err.print("Choose an option again: \n");
        }
    }


    public void setScanner(Scanner scanner) {
        this.SC = scanner;
    }
}
