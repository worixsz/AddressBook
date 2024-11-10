public class SearchActionMove implements SearchAction {

    static final String DELIMITER = "; ";


    @Override
    public int searchContactByName(String[] contacts, String searchString) {
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
    public int searchContactBySurname(String[] contacts, String searchOfSurname) {
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
    public int searchContactByAddress(String[] contacts, String searchOfAddress) {
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
    public int searchContactByPhone(String[] contacts, String searchOfNumber) {

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
}
