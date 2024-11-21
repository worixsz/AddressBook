package repository;

import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchActionMoveTest {

    private List<Contact> contactList;

    private SearchActionMove searchActionMove;

    @BeforeEach
    void setUp() {
        searchActionMove = new SearchActionMove();
        contactList = Arrays.asList(
                new Contact("Azidin", "Amankulov", "Japan", "996777777777"),
                new Contact("Aibek", "Mahronovich", "China", "9966666666"),
                new Contact("Azidin", "Mahronovich", "Japan", "996777777777"),
                new Contact("John", "Doe", "USA", "123456789"),
                new Contact("Jane", "Smith", "Canada", "987654321"),
                new Contact("Emily", "Johnson", "UK", "444555666"),
                new Contact("Michael", "Brown", "Australia", "555666777"),
                new Contact("Sophia", "Williams", "Germany", "888999000"),
                new Contact("Liam", "Miller", "France", "111222333"),
                new Contact("Olivia", "Davis", "Italy", "222333444")
        );

    }

    @Test
    @DisplayName("Test for checking valid contact by Name")
    public void searchContactByValidNameTest() {

        String validInput = "Azidin\n";
        System.setIn(new ByteArrayInputStream(validInput.getBytes()));
        searchActionMove.setScanner(new Scanner(System.in));
        List<Contact> foundContactsValid = searchActionMove.searchContactByName(contactList);
        assertEquals(2, foundContactsValid.size(), "Should find two contact");
        assertEquals("Azidin", foundContactsValid.get(1).getName(), "Name should match for valid input");

    }

    @Test
    @DisplayName("Test for checking invalid contact by Name")
    public void searchContactByInvalidNameTest() {

        String invalidInput = "Unknown\n";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));
        searchActionMove.setScanner(new Scanner(System.in));
        List<Contact> foundContactsInvalid = searchActionMove.searchContactByName(contactList);
        assertEquals(0, foundContactsInvalid.size(), "Should not find any contact for invalid input");

    }

    @Test
    @DisplayName("Test for checking valid contact by surname")
    public void searchContactByValidSurNameTest() {

        String validInput = "Mahronovich\n";
        System.setIn(new ByteArrayInputStream(validInput.getBytes()));
        searchActionMove.setScanner(new Scanner(System.in));
        List<Contact> foundContactsValid = searchActionMove.searchContactBySurname(contactList);
        assertEquals(2, foundContactsValid.size(), "Should find one contact");
        assertEquals("Mahronovich", foundContactsValid.get(1).getSurname(), "Surname should match for valid input");

    }

    @Test
    @DisplayName("Test for checking invalid contact by surname")
    public void searchContactByInvalidSurnameTest() {

        String invalidInput = "Unknown\n";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));
        searchActionMove.setScanner(new Scanner(System.in));
        List<Contact> foundContactsInvalid = searchActionMove.searchContactBySurname(contactList);
        assertEquals(0, foundContactsInvalid.size(), "Should not find any contact for invalid input");

    }


}
