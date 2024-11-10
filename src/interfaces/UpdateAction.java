package interfaces;

public interface UpdateAction {

    void updateContactByName(String indexOfContact, String[] contacts);

    void updateContactBySurname(String indexOfContact, String[] contacts);

    void updateContactByAddress(String indexOfContact, String[] contacts);

    void updateContactByPhone(String indexOfContact, String[] contacts);

    void updateContact(String[] contacts, int indexForSave);


}
