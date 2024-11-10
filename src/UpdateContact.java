public interface UpdateContact {



    void checkContact(int index, String[] contact);

    void showContact(int index, String[] contacts);

    void updateContactIndexByName(String index, String[] contacts);

    void updateContactIndexBySurname(int index, String[] contacts);

    void updateContactIndexByAddress(int index, String[] contacts);

    void updateContactIndexByPhone(int index, String[] contacts);


}
