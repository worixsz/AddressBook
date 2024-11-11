package repository;

import service.CheckAction;

import java.util.Scanner;

public class CheckActionMove implements CheckAction {
    static SearchActionMove searchActionMove = new SearchActionMove();

    public CheckActionMove() {

    }

    @Override
    public void showContact(int index, String[] contacts) {
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
    public int checkLengthOfContact(String length, String[] contacts) {
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
    public void checkContact(int index, String[] contacts) {
        if (index >= 0 && index < contacts.length) {
            String contact = contacts[index];
            if (contact == null || contact.trim().isEmpty()) {
                System.out.println("❗No contact with such data!");
            }
        }
    }


}
