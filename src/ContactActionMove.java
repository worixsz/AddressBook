import java.util.Scanner;

public class ContactActionMove implements ActionContact {

    static final String DELIMITER = "; ";


    @Override
    public int findContactIndexByName(String[] contacts, String searchString) {
        int foundIndex = -1;

        for (int i = 0; i < contacts.length; i++) {
            String contact = contacts[i];
            if (contact != null) {
                String[] contactSplitted = contact.split(DELIMITER);
                if (contactSplitted[0].equals(searchString)) {
                    foundIndex = i;
                }
            }
        }
        return foundIndex;
    }

    @Override
    public int findContactIndexBySurname(String[] contacts, String searchOfSurname) {
        int foundIndex = -1;

        for (int i = 0; i < contacts.length; i++) {
            String contact = contacts[i];
            if (contact != null) {
                String[] contactSplitted = contact.split(DELIMITER);
                if (contactSplitted[1].equals(searchOfSurname)) {
                    foundIndex = i;
                }
            }
        }
        return foundIndex;
    }

    @Override
    public int findContactIndexByAddress(String[] contacts, String searchOfAddress) {
        int foundIndex = -1;

        for (int i = 0; i < contacts.length; i++) {
            String contact = contacts[i];
            if (contact != null) {
                String[] contactSplitted = contact.split(DELIMITER);
                if (contactSplitted[2].equals(searchOfAddress)) {
                    foundIndex = i;
                }
            }
        }

        return foundIndex;
    }

    @Override
    public int findContactIndexByPhone(String[] contacts, String searchOfNumber) {

        int foundIndex = -1;

        for (int i = 0; i < contacts.length; i++) {
            String contact = contacts[i];
            if (contact != null) {
                String[] contactSplitted = contact.split(DELIMITER);
                if (contactSplitted[3].equals(searchOfNumber)) {
                    foundIndex = i;
                }
            }
        }
        return foundIndex;
    }


    @Override
    public void updateContactIndexByName(String indexOfContact, String[] contacts) {
        Scanner SC = new Scanner(System.in);
        int updateIndex = findContactIndexByName(contacts, indexOfContact);
        updateIndex++;
        checkContact(updateIndex, contacts);
        System.out.print("Enter the index of the contact to update  (1 to" + updateIndex + "): \n");
        int index = SC.nextInt() - 1;
        for (int i = index; i < indexOfContact.length() - 1; i++) {
            contacts[i] = contacts[i + 1];
        }
        if (updateIndex != -1) {
            System.out.print("Enter the new name:");
            String newName = SC.next();
            System.out.print("Enter the new surname:");
            String newSurname = SC.next();
            System.out.print("Enter the new address:");
            String newADDRESS = SC.next();
            System.out.print("Enter the new phone number:");
            String newPhone = SC.next();
            contacts[index] = newName + DELIMITER + newSurname + DELIMITER + newADDRESS + DELIMITER + newPhone;
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
        int updateIndex = findContactIndexBySurname(contacts, updateBySurname);
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
        int updateIndex = findContactIndexByAddress(contacts, updateByAddress);
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
        int updateIndex = findContactIndexByName(contacts, updateByPhone);
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


}
