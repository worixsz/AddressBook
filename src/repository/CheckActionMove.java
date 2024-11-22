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
        } catch (NullPointerException e){
            System.err.println("❌ There are no available contacts");

        }


    }

//    @Override
//    public void validateContact(List<Contact> contact) throws InputMismatchException {
//
//        for (Contact contact1 : contact) {
//            String nameRegex = "^[A-Z][a-zA-Z '.-]*[A-Za-z]$";
//            String phoneRegex = "^([+]?\\d{1,3}[-\\s]?|)\\d{3}[-\\s]?\\d{3}[-\\s]?\\d{3}$";
//            String addressRegex = "^(\\d{1,}) [a-zA-Z0-9\\s]+(,)? [a-zA-Z]+(,)? [A-Z]{2} [0-9]{5,6}$";
//            if (!contact1.getName().matches(nameRegex)) {
//                System.out.println("No correct type of name");
//                throw new InputMismatchException();
//            }
//            if (!contact1.getSurname().matches(nameRegex)) {
//                System.out.println("No correct type of surname");
//                throw new InputMismatchException();
//            }
//            if (!contact1.getAddress().matches(addressRegex)) {
//                System.out.println("No correct type of address");
//                throw new InputMismatchException();
//            }
//            if (!contact1.getPhone().matches(phoneRegex)) {
//                System.out.println("No correct type of phone");
//                throw new InputMismatchException();
//            }
//        }
//
//
//    }
}
