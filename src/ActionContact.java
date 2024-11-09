public interface ActionContact {

    public int findContactIndexByName(String[] contacts, String searchString);

    public int findContactIndexBySurname(String[] contacts, String searchString);

    public int findContactIndexByAddress(String[] contacts, String searchString);

    public int findContactIndexByPhone(String[] contacts, String searchString);

    public void checkContact(int index, String[] contact);

    public void showContact(int index, String[] contacts);


}
