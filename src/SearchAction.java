public interface SearchAction {

    int searchContactIndexByName(String[] contacts, String searchString);

    int searchContactIndexBySurname(String[] contacts, String searchString);

    int searchContactIndexByAddress(String[] contacts, String searchString);

    int searchContactIndexByPhone(String[] contacts, String searchString);
}
