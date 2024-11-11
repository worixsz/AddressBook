package service;

import model.Contact;

public interface CheckAction {

    void showContact(int index, Contact[] contacts);

    int checkLengthOfContact(String length, Contact[] contacts);

    void checkContact(int index, Contact[] contacts);
}
