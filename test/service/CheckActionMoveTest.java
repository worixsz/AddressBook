package service;


import model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.CheckActionMove;


import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CheckActionMoveTest {

    private CheckActionMove checkAction;
    private Contact contactOne;
    private Contact contactTwo;
    private List<Contact> contactList;

    @BeforeEach
    void setUp() {

        checkAction = new CheckActionMove();
        contactOne = new Contact("Azidin", "Amankulov", "Japan", "996777777777");
        contactTwo = new Contact("Aibek", "Mahronovich", "China", "9966666666");
        contactList = List.of(contactOne, contactTwo);
    }


    @Test
    @DisplayName("Tests to show exist contacts")
    public void showContactTest() {
        assertDoesNotThrow(() -> checkAction.showContact(contactList));
        List<Contact> emptyContacts = new ArrayList<>();
        assertDoesNotThrow(() -> checkAction.showContact(emptyContacts));
    }


    @Test
    @DisplayName("Test for valid index input")
    public void testValidIndex() {
        String inputString = "2\n";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));

        int index = checkAction.checkLengthOfContact(2);
        assertEquals(1, index, "Index should be valid");
    }


    @Test
    @DisplayName("Test for invalid index input")
    public void testInvalidIndex() {
        String inputString = "2\n2\n0\n1\n";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));

        int index = checkAction.checkLengthOfContact(1);
        assertEquals(0, index, "Index should be valid after invalid inputs");
    }





}
