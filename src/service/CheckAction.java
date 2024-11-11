package service;

public interface CheckAction {

    void showContact(int index, String[] contacts);

    int checkLengthOfContact(String length, String[] contacts);

    void checkContact(int index, String[] contacts);
}
