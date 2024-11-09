public interface SearchAction {

    public int findContactIndexByName(String[] contacts, String searchString);


    public int findContactIndexBySurname(String[] contacts, String searchString);


    public int findContactIndexByAddress(String[] contacts, String searchString);

    public int findContactIndexByPhone(String[] contacts, String searchString);


}
