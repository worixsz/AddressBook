public interface SearchAction {

    public void findContactIndexByName(String[] contacts, String searchString);


    public void findContactIndexBySurname(String[] contacts, String searchString);


    public void findContactIndexByAddress(String[] contacts, String searchString);

    public void findContactIndexByPhone(String[] contacts, String searchString);


}
