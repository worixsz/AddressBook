import java.util.Scanner;

public class UpdateActionMove implements UpdateAction {

    static final String DELIMITER = "; ";

    static SearchActionMove search;

    static CheckActionMove check;


    @Override
    public void updateContactByName(String indexOfContact, String[] contacts) {
        Scanner SC = new Scanner(System.in);
        int updateIndex = search.searchContactByName(contacts, indexOfContact);
        if (updateIndex != -1) {
            updateIndex++;
            check.checkContact(updateIndex, contacts);
            System.out.print("Enter the index of the contact to update (1 to " + updateIndex + "): \n");
            int indexForSave = check.checkLengthOfContact(indexOfContact, contacts);
            System.out.print("Enter the new name:");
            String newName = SC.next();
            System.out.print("Enter the new surname:");
            String newSurname = SC.next();
            System.out.print("Enter the new address:");
            String newADDRESS = SC.next();
            System.out.print("Enter the new phone number:");
            String newPhone = SC.next();
            contacts[indexForSave] = newName + DELIMITER + newSurname + DELIMITER + newADDRESS + DELIMITER + newPhone;
            System.out.println("✅ Contact Updated!");
        } else {
            System.out.println("❗No contact with such name!");
        }
    }

    @Override
    public void updateContactBySurname(int index, String[] contacts) {
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter surname to search: ");
        String updateBySurname = SC.next();
        int updateIndex = search.searchContactBySurname(contacts, updateBySurname);
        if (updateIndex != -1) {
            check.checkContact(index, contacts);
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
    public void updateContactByAddress(int index, String[] contacts) {
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter address to search: ");
        String updateByAddress = SC.next();
        int updateIndex = search.searchContactByAddress(contacts, updateByAddress);
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
    public void updateContactByPhone(int index, String[] contacts) {
        Scanner SC = new Scanner(System.in);
        System.out.print("Enter phone number to search: ");
        String updateByPhone = SC.next();
        int updateIndex = search.searchContactByName(contacts, updateByPhone);
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





}
