package repository;


import model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheckActionMoveTest {

    private CheckActionMove checkAction;
    private List<Contact> contactList;

    @BeforeEach
    void setUp() {

        checkAction = new CheckActionMove();
        Contact contactOne = new Contact("Azidin", "Amankulov", "Japan", "996777777777");
        Contact contactTwo = new Contact("Aibek", "Mahronovich", "China", "9966666666");
        contactList = List.of(contactOne, contactTwo);
    }


    @Test
    @DisplayName("Tests to show exist contacts")
    public void showContactTest() {
        assertDoesNotThrow(() -> checkAction.showContact(contactList));
        List<Contact> emptyContacts = new ArrayList<>();
        assertDoesNotThrow(() -> checkAction.showContact(emptyContacts));
    }



}
