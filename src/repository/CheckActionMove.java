package repository;

import model.Contact;
import service.CheckAction;

import java.util.List;
import java.util.Scanner;

public class CheckActionMove implements CheckAction {


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

    @Override
    public int checkLengthOfContact(int contactCount) {
        Scanner SC = new Scanner(System.in);
        int index;

        while (true) {
            index = SC.nextInt() - 1;
            if (index >= 0 && index < contactCount) {
                return index;
            } else {
                System.out.println("❗ Invalid index. Please try again.");
                System.out.print("Enter the index of the contact: ");
            }
        }
    }

}
