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
    public boolean checkContact(int index, String[] contact) {

        if (index != -1) {
            System.out.println("🔍 Contact Found: " + contact[index]);
            return true;
        } else {
            System.out.println("❗No contact with such data!");
            return false;

        }
    }

}
