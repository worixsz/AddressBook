package repository;

import model.Contact;
import service.CheckAction;

import java.util.Scanner;

public class CheckActionMove implements CheckAction {


    public CheckActionMove() {

    }

    @Override
    public void showContact(int index, Contact[] contacts) {
        System.out.println("\n--- LIST OF ALL CONTACTS ---");
        if (index == 0) {
            System.out.println("❌ No contacts available.\n");
        } else {
            for (int i = 0; i < index; i++) {
                System.out.println((i + 1) + ". " + contacts[i]);

            }
        }
    }

    @Override
    public int checkLengthOfContact(String length, Contact[] contacts) {
        int contactCount = contacts.length;

        Scanner SC = new Scanner(System.in);
        int index = -1;

        while (true) {
            index = SC.nextInt();

            if (index >= 1 && index <= contactCount) {
                return index - 1;
            } else {
                System.out.println("❗ Invalid index. Please try again.");
            }
        }
    }


    @Override
    public void checkContact(int index, Contact[] contacts) {
        if (index >= 0 && index < contacts.length) {
            Contact contact = contacts[index];
            if (contact == null) {
                System.out.println("❗No contact with such data!");
            }
        }
    }


}
