package repository;

import model.Contact;
import service.CheckAction;

import java.util.List;
import java.util.Scanner;

public class CheckActionMove implements CheckAction {

    Scanner SC = new Scanner(System.in);

    public CheckActionMove() {

    }

    @Override
    public void showContact(List<Contact> contacts) {
        System.out.println("\n--- LIST OF ALL CONTACTS ---");
        if (contacts.isEmpty()) {
            System.out.println("❌ No contacts available.\n");
        } else {
            contacts.forEach(System.out::println);
        }


    }


}
