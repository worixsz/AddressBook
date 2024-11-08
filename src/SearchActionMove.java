public class SearchActionMove implements SearchAction {

    static final String DELIMITER = "; ";


    @Override
    public void findContactIndexByName(String[] contacts, String searchName) {
        boolean contactOfNameFound = false;

        for (String contact : contacts) {
            if (contact != null) {
                String[] contactSplitted = contact.split(DELIMITER);
                if (contactSplitted[0].startsWith(searchName)) {
                    System.out.println("🔍 Contact Found: " + contact);
                    contactOfNameFound = true;
                }
            }
        }
        if (!contactOfNameFound) {
            System.out.println("❗No contact with such name!");
        }
    }

    @Override
    public void findContactIndexBySurname(String[] contacts, String searchOfSurname) {

        boolean contactOfSurnameFound = false;

        for (String contact : contacts) {
            if (contact != null) {
                String[] contactSplitted = contact.split(DELIMITER);
                if (contactSplitted[1].startsWith(searchOfSurname)) {
                    System.out.println("🔍 Contact Found: " + contact);
                    contactOfSurnameFound = true;
                }
            }
        }
        if (!contactOfSurnameFound) {
            System.out.println("❗No contact with such surname!");
        }

    }

    @Override
    public void findContactIndexByAddress(String[] contacts, String searchOfAddress) {

        boolean contactOfAddressFound = false;

        for (String contact : contacts) {
            if (contact != null) {
                String[] contactSplitted = contact.split(DELIMITER);
                if (contactSplitted[2].startsWith(searchOfAddress)) {
                    System.out.println("🔍 Contact Found: " + contact);
                    contactOfAddressFound = true;
                }
            }
        }
        if (!contactOfAddressFound) {
            System.out.println("❗No contact with such address!");
        }

    }

    @Override
    public void findContactIndexByPhone(String[] contacts, String searchOfNumber) {

        boolean contactOfAddressFound = false;

        for (String contact : contacts) {
            if (contact != null) {
                String[] contactSplitted = contact.split(DELIMITER);
                if (contactSplitted[3].startsWith(searchOfNumber)) {
                    System.out.println("🔍 Contact Found: " + contact);
                    contactOfAddressFound = true;
                }
            }
        }
        if (!contactOfAddressFound) {
            System.out.println("❗No contact with such number!");
        }

    }
}
