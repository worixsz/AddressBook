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
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i) + "\n");
            }
        }
    }


    @Override
    public int checkLengthOfContact(String length, List<Contact> contacts) {
        int contactCount = contacts.size();

        Scanner SC = new Scanner(System.in);
        int index = -1;

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


    @Override
    public void checkContact(String searchNameList, List<Contact> contacts) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(searchNameList)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ No contact found with the name: " + searchNameList);
        }
    }


}
