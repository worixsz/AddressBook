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
        String phoneRegex = "^([+]?\\d{1,3}[\\s\\-]?\\(?\\d{1,4}\\)?[\\s\\-]?\\d{1,4}[\\s\\-]?\\d{1,4})$";
        String addressRegex = "^[\\w\\s,.-]+$";

        if (!contact.getName().matches(nameRegex)) {
            throw new InputMismatchException("Invalid name format: " + contact.getName());
        }

        if (!contact.getSurname().matches(surnameRegex)) {
            throw new InputMismatchException("Invalid surname format: " + contact.getSurname());
        }

        if (!contact.getAddress().matches(addressRegex)) {
            throw new InputMismatchException("Invalid address format: " + contact.getAddress());
        }

        if (!contact.getPhone().matches(phoneRegex)) {
            throw new InputMismatchException("Invalid phone number format: " + contact.getPhone());
        }
    }


    @Override
    public void checkStringForEmpty(String text) throws InputMismatchException {
        if (text.trim().isEmpty()) {
            throw new InputMismatchException("The input cannot be empty.");
        }
    }

    @Override
    public void checkPhoneNumber(String number) throws InputMismatchException{
        if (number.length() > 12){
            throw new InputMismatchException("Incorrect number.");
        } else {
            System.out.println("Correct format");
        }
    }


}
