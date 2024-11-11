package repository;

import model.Contact;
import service.DeleteAction;

import java.util.List;
import java.util.Scanner;

public class DeleteActionMove implements DeleteAction {

    private final CheckActionMove checkMove;

    public DeleteActionMove() {
        this.checkMove = new CheckActionMove();
    }

    @Override
    public void deleteContactByContact(int indexOF, List<Contact> contacts) {
        Scanner SC = new Scanner(System.in);
        System.out.println("\n--- DELETE CONTACT ---");
        if (indexOF == 0) {
            System.out.println("❌ No contacts available to delete.\n");
        } else {
            checkMove.showContact(indexOF, contacts);
            System.out.print("Enter the indexOF of the contact to delete (1 to " + indexOF + "): ");
            int index = SC.nextInt() - 1;
            if (index >= 0 && index < indexOF) {
                contacts.remove(index);
                indexOF--;
                System.out.println("🗑️ Contact deleted successfully.\n");
            } else {
                System.err.println("❗ Invalid indexOF. Please enter a valid indexOF between 1 and " + indexOF + ".\n");
            }
        }
    }
}
