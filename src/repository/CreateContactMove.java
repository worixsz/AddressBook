package repository;

import model.Contact;
import service.CreateAction;

import java.util.List;
import java.util.Scanner;

public class CreateContactMove implements CreateAction {

    Scanner SC = new Scanner(System.in);

    public CreateContactMove() {
    }

    @Override
    public void createContact(List<Contact> contacts) {

        System.out.println("\n--- CREATE NEW CONTACT ---");
        System.out.print("Enter your name: ");
        String name = SC.next();
        System.out.print("Enter your surname: ");
        String surname = SC.next();
        System.out.print("Enter your address: ");
        String address = SC.next();
        System.out.print("Enter your phone number: ");
        String phone = SC.next();
        Contact c = new Contact(name, surname, address, phone);
        contacts.add(c);

        System.out.println("✅ Contact added successfully!\n");
    }

    public void setScanner(Scanner scanner) {
        this.SC = scanner;
    }
}
