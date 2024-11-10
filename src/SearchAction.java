public interface SearchAction {

    int searchContactByName(String[] contacts, String searchString);

    int searchContactBySurname(String[] contacts, String searchString);

    int searchContactByAddress(String[] contacts, String searchString);

    int searchContactByPhone(String[] contacts, String searchString);
}
