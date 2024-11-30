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
            checkActionMove.checkStringForEmpty(name);
            System.out.print("Enter your surname: ");
            String surname = SC.nextLine();
            checkActionMove.checkStringForEmpty(surname);

            System.out.print("Enter your address: ");
            String address = SC.nextLine();
            checkActionMove.checkStringForEmpty(address);

            System.out.print("Enter your phone number: +996 ");
            String phone = SC.nextLine();
            checkActionMove.checkStringForEmpty(phone);

            String validNumber = checkActionMove.formatPhoneNumber(phone);

            Contact contact = new Contact(name, surname, address, validNumber);
            checkActionMove.validateContact(contact);

            contacts.add(contact);
            System.out.println("✅ Contact added successfully!\n");
        } catch (InputMismatchException e) {
            System.err.println("\n❌ Error: " + e.getMessage() + " Contact not added.\n");
            System.err.print("Choose an option again: \n");
            e.printStackTrace();
        }
    }


    public void setScanner(Scanner scanner) {
        this.SC = scanner;
    }


}
