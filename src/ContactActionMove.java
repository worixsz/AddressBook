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
                    break;
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
                    break;
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
                    break;
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
                    break;
                }
            }
        }
        return foundIndex;
    }

    @Override
    public void checkContact(int index, String[] contact) {
        if (index != -1) {
            System.out.println("🔍 Contact Found: " + contact[index]);
        } else {
            System.out.println("❗No contact with such data!");
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
