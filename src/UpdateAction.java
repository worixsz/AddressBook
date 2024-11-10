public interface UpdateAction {

    void updateContactByName(String index, String[] contacts);

    void updateContactBySurname(int index, String[] contacts);

    void updateContactByAddress(int index, String[] contacts);

    void updateContactByPhone(int index, String[] contacts);


}
