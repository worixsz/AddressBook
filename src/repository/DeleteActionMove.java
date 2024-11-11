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
    public void deleteContactByContact(List<Contact> contacts) {
        Scanner SC = new Scanner(System.in);
        System.out.println("\n--- DELETE CONTACT ---");

        if (contacts.isEmpty()) {
            System.out.println("❌ No contacts available to delete.\n");
        } else {
            // Показываем все контакты
            checkMove.showContact(contacts);

            // Печатаем номер контакта для удаления
            System.out.print("Enter the index of the contact to delete (1 to " + contacts.size() + "): ");
            int index = SC.nextInt() - 1;

            // Проверяем, что введенный индекс действителен
            if (index >= 0 && index < contacts.size()) {
                // Удаляем контакт
                contacts.remove(index);
                System.out.println("🗑️ Contact deleted successfully.\n");
            } else {
                System.err.println("❗ Invalid index. Please enter a valid index between 1 and " + contacts.size() + ".\n");
            }
        }
    }

}
