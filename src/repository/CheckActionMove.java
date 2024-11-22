package repository;

import model.Contact;
import service.CheckAction;

import java.util.InputMismatchException;
import java.util.List;

public class CheckActionMove implements CheckAction {


    public CheckActionMove() {

    }

    @Override
    public void showContact(List<Contact> contacts) {
        try {
            System.out.println("\n--- LIST OF ALL CONTACTS ---");
            if (contacts.isEmpty()) {
                System.out.println("❌ No contacts available.\n");
            } else {
                contacts.forEach(System.out::println);
            }
        } catch (NullPointerException e) {
            System.err.println("❌ There are no available contacts");

        }


    }

    @Override
    public void validateContact(Contact contact) throws InputMismatchException {


        String nameRegex = "^[A-Z][a-zA-Z '.-]*[A-Za-z]$";
        String surnameRegex = "^[A-Za-z]+([ '-][A-Za-z]+)*$";
        String phoneRegex = "^([+]?\\d{1,3}[-\\s]?\\(?\\d{3}\\)?[-\\s]?\\d{3}[-\\s]?\\d{3})$";
        String addressRegex = "^[\\w\\s,.-]+$";

        if (!contact.getName().matches(nameRegex)) {
            System.out.println("❌ Invalid name format");
            throw new InputMismatchException();
        }

        if (!contact.getSurname().matches(surnameRegex)) {
            System.out.println("❌ Invalid surname format");
            throw new InputMismatchException();
        }

        if (!contact.getAddress().matches(addressRegex)) {
            System.out.println("❌ Invalid address format");
            throw new InputMismatchException();
        }

        if (!contact.getPhone().matches(phoneRegex)) {
            System.out.println("❌ Invalid phone number format");
            throw new InputMismatchException();
        }
    }

    @Override
    public void checkStringForEmpty(String text) throws InputMismatchException {
        if (text.trim().isEmpty()) {
            throw new InputMismatchException("The input cannot be empty.");
        }
    }


}
