import java.util.Scanner;

public class UpdateActionMove implements UpdateContact {

    static final String DELIMITER = "; ";

    static SearchActionMove searchAction;


    @Override
    public void updateContactIndexByName(String indexOfContact, String[] contacts) {
        Scanner SC = new Scanner(System.in);
        int updateIndex = searchAction.searchContactIndexByName(contacts, indexOfContact);
        if (updateIndex != -1) {
            updateIndex++;
            checkContact(updateIndex, contacts);
            System.out.print("Enter the index of the contact to update (1 to " + updateIndex + "): \n");
            int d = checkLengthOfContact(indexOfContact, contacts);
            System.out.print("Enter the new name:");
            String newName = SC.next();
            System.out.print("Enter the new surname:");
            String newSurname = SC.next();
            System.out.print("Enter the new address:");
            String newADDRESS = SC.next();
            System.out.print("Enter the new phone number:");
            String newPhone = SC.next();
            contacts[d] = newName + DELIMITER + newSurname + DELIMITER + newADDRESS + DELIMITER + newPhone;
            System.out.println("✅ Contact Updated!");
        } else {
            System.out.println("❗No contact with such name!");
        }
    }

    @Override
    public void updateContactIndexBySurname(int index, String[] contacts) {
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter surname to search: ");
        String updateBySurname = SC.next();
        int updateIndex = searchAction.searchContactIndexBySurname(contacts, updateBySurname);
        if (updateIndex != -1) {
            checkContact(index, contacts);
            System.out.print("Enter the new name: ");
            String newName = SC.next();
            System.out.print("Enter the new surname: ");
            String newSurname = SC.next();
            System.out.print("Enter the new address: ");
            String newADDRESS = SC.next();
            System.out.print("Enter the new phone number: ");
            String newPhone = SC.next();
            contacts[updateIndex] = newName + DELIMITER + newSurname + DELIMITER + newADDRESS + DELIMITER + newPhone;
            System.out.println("✅ Contact Updated!");
        } else {
            System.out.println("❗No contact with such name!");
        }

    }

    @Override
    public void updateContactIndexByAddress(int index, String[] contacts) {
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter address to search: ");
        String updateByAddress = SC.next();
        int updateIndex = searchAction.searchContactIndexByAddress(contacts, updateByAddress);
        if (updateIndex != -1) {
            System.out.println("🔍 Contact Found: " + contacts[updateIndex]);
            System.out.print("Enter the new name:");
            String newName = SC.next();
            System.out.print("Enter the new surname:");
            String newSurname = SC.next();
            System.out.print("Enter the new address:");
            String newADDRESS = SC.next();
            System.out.print("Enter the new phone number:");
            String newPhone = SC.next();
            contacts[updateIndex] = newName + DELIMITER + newSurname + DELIMITER + newADDRESS + DELIMITER + newPhone;
            System.out.println("✅ Contact Updated!");
        } else {
            System.out.println("❗No contact with such name!");
        }

    }

    @Override
    public void updateContactIndexByPhone(int index, String[] contacts) {
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter phone number to search: ");
        String updateByPhone = SC.next();
        int updateIndex = searchAction.searchContactIndexByName(contacts, updateByPhone);
        if (updateIndex != -1) {
            System.out.println("🔍 Contact Found: " + contacts[updateIndex]);
            System.out.print("Enter the new name:");
            String newName = SC.next();
            System.out.print("Enter the new surname:");
            String newSurname = SC.next();
            System.out.print("Enter the new address:");
            String newADDRESS = SC.next();
            System.out.print("Enter the new phone number:");
            String newPhone = SC.next();
            contacts[updateIndex] = newName + DELIMITER + newSurname + DELIMITER + newADDRESS + DELIMITER + newPhone;
            System.out.println("✅ Contact Updated!");
        } else {
            System.out.println("❗No contact with such name!");
        }
    }

    @Override
    public void checkContact(int index, String[] contact) {
        for (String contacts : contact) {
            if (contacts == null || contacts.trim().isEmpty()) {
                continue;
            }
            if (index != -1) {
                System.out.println("🔍 Contact Found: " + contacts);

            } else {
                System.out.println("❗No contact with such data!");
                break;
            }
        }
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

    public int checkLengthOfContact(String length, String[] contacts) {
        Scanner SC = new Scanner(System.in);
        int index = SC.nextInt() - 1;
        for (int i = index; i < length.length() - 1; i++) {
            contacts[i] = contacts[i + 1];
        }
        return index;
    }


}
