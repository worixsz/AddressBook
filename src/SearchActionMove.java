public class SearchActionMove implements SearchAction {

    static final String DELIMITER = "; ";


    @Override
    public int findContactIndexByName(String[] contacts, String searchString) {
        int foundIndex = -1;

        for (int i = 0; i < contacts.length; i++) {
            String contact = contacts[i];
            if (contact != null) {
                String[] contactSplitted = contact.split(DELIMITER);
                if (contactSplitted[0].equals(searchString)) {
                    System.out.println("🔍 Contact Found: " + contact);
                    foundIndex = i;
                    break;
                }
            } else {
                System.out.println("❗No contact with such surname!");
                break;
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
                    System.out.println("🔍 Contact Found: " + contact);
                    foundIndex = i;
                    break;
                }
            } else {
                System.out.println("❗No contact with such surname!");
                break;
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
                    System.out.println("🔍 Contact Found: " + contact);
                    foundIndex = i;
                    break;
                }
            } else {
                System.out.println("❗No contact with such address!");
                break;
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
                    System.out.println("🔍 Contact Found: " + contact);
                    foundIndex = i;
                    break;
                }
            } else {
                System.out.println("❗No contact with such phone number!");
                break;
            }
        }

        return foundIndex;

    }
}
