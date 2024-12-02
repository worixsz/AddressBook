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

        if (contacts == null || contacts.isEmpty()) {
            System.out.println("❌ No contacts available.\n");
        } else {
            System.out.println("\n--- LIST OF ALL CONTACTS ---");
            contacts.forEach(System.out::println);
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
    public void checkPhoneNumber(String number) throws InputMismatchException {
        if (number.length() != 16) {
            throw new InputMismatchException("Incorrect number.");
        }
    }

    @Override
    public String formatPhoneNumber(String phone) {
        String formattedNumberKG = phone;
        try {
            String cleanPhone = phone.replaceAll("\\D", "");
            formattedNumberKG = "+996 " + cleanPhone.replaceAll("(.{3})(.{3})(.{3})", "$1 $2 $3");
            formattedNumberKG = formattedNumberKG.trim();
            checkPhoneNumber(formattedNumberKG);
            return formattedNumberKG;

        } catch (IllegalArgumentException e) {
            System.err.println("❌ TRY AGAIN.\n");
        }
        return formattedNumberKG;
    }

    @Override
    public void checkForValidName(String text) {
        String nameRegex = "^[A-Z][a-zA-Z '.-]*[A-Za-z]$";

        if (text.trim().isEmpty()) {
            throw new InputMismatchException("The input cannot be empty.");
        } else if (!text.matches(nameRegex)) {
            throw new InputMismatchException("Invalid format of name: " + text);
        }

    }

    @Override
    public void checkForValidSurname(String text) {
        String surnameRegex = "^[A-Za-z]+([ '-][A-Za-z]+)*$";

        if (text.trim().isEmpty()) {
            throw new InputMismatchException("The input cannot be empty.");
        } else if (!text.matches(surnameRegex)) {
            throw new InputMismatchException("Invalid format of surname: " + text);
        }


    }

    @Override
    public void checkForValidAddress(String text) {
        String addressRegex = "^[\\w\\s,.-]+$";
        if (text.trim().isEmpty()) {
            throw new InputMismatchException("The input cannot be empty.");
        } else if (!text.matches(addressRegex)) {
            throw new InputMismatchException("Invalid format of address: " + text);
        }

    }

    @Override
    public void checkForValidPhoneNumber(String text) {

        String phoneRegex = "^([+]?\\d{1,3}[\\s\\-]?\\(?\\d{1,4}\\)?[\\s\\-]?\\d{1,4}[\\s\\-]?\\d{1,4})$";
        if (text.trim().isEmpty()) {
            throw new InputMismatchException("The input cannot be empty.");
        } else if (!text.matches(phoneRegex)) {
            throw new InputMismatchException("Invalid format of address: " + text);
        }

    }
}

