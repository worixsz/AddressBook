package repository;

import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchActionMoveTest {

    private List<Contact> contactList;

    private SearchActionMove searchActionMove;

    @BeforeEach
    void setUp() {
        searchActionMove = new SearchActionMove();
        Contact contactOne = new Contact("Azidin", "Amankulov", "Japan", "996777777777");
        Contact contactTwo = new Contact("Aibek", "Mahronovich", "China", "9966666666");
        Contact contactThree = new Contact("Azidin", "SA", "Japan", "996777777777");
        contactList = List.of(contactOne, contactTwo, contactThree);
    }

    @Test
    @DisplayName("Test for checking valid contact by Name")
    public void searchContactByValidNameTest() {

        String validInput = "Azidin\n";
        System.setIn(new ByteArrayInputStream(validInput.getBytes()));
        searchActionMove.setScanner(new Scanner(System.in));
        List<Contact> foundContactsValid = searchActionMove.searchContactByName(contactList);
        assertEquals(2, foundContactsValid.size(), "Should find twp contact");
        assertEquals("Azidin", foundContactsValid.get(1).getName(), "Name should match for valid input");


//        String invalidInput = "Unknown\n";
//        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));
//        searchActionMove.setScanner(new Scanner(System.in));
//        List<Contact> foundContactsInvalid = searchActionMove.searchContactByName(contactList);
//        assertEquals(0, foundContactsInvalid.size(), "Should not find any contact for invalid input");

    }


}
