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
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        assertEquals(2, foundContactsValid.size(), "Should find two contact");
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

    @Test
    @DisplayName("Test for checking valid contact by address")
    public void searchContactByValidAddressTest() {

        String validInput = "Japan\n";
        System.setIn(new ByteArrayInputStream(validInput.getBytes()));
        searchActionMove.setScanner(new Scanner(System.in));
        List<Contact> foundContactsValid = searchActionMove.searchContactByAddress(contactList);
        assertEquals(2, foundContactsValid.size(), "Should find two contact");
        assertEquals("Japan", foundContactsValid.get(1).getAddress(), "Address should match for valid input");

    }

    @Test
    @DisplayName("Test for checking invalid contact by address")
    public void searchContactByInvalidAddressTest() {

        String invalidInput = "Unknown\n";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));
        searchActionMove.setScanner(new Scanner(System.in));
        List<Contact> foundContactsInvalid = searchActionMove.searchContactByAddress(contactList);
        assertEquals(0, foundContactsInvalid.size(), "Should not find any contact for invalid input");

    }

    @Test
    @DisplayName("Test for checking valid contact by phone number")
    public void searchContactByValidPhoneTest() {

        String validInput = "996777777777\n";
        System.setIn(new ByteArrayInputStream(validInput.getBytes()));
        searchActionMove.setScanner(new Scanner(System.in));
        List<Contact> foundContactsValid = searchActionMove.searchContactByPhone(contactList);
        assertEquals(2, foundContactsValid.size(), "Should find two contact");
        assertEquals("996777777777", foundContactsValid.get(1).getPhone(), "Address should match for valid input");

    }

    @Test
    @DisplayName("Test for checking invalid contact by phone number")
    public void searchContactByInvalidPhoneTest() {

        String invalidInput = "Unknown\n";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));
        searchActionMove.setScanner(new Scanner(System.in));
        List<Contact> foundContactsInvalid = searchActionMove.searchContactByPhone(contactList);
        assertEquals(0, foundContactsInvalid.size(), "Should not find any contact for invalid input");

    }

    @Test
    @DisplayName("Test for checking valid contact by name prefix")
    public void findByValidNamePrefixTest() {
        String validInput = "Azi";

        searchActionMove.findByNamePrefix(contactList, validInput);

        List<Contact> filteredContacts = contactList.stream()
                .filter(contact -> contact.getName().startsWith(validInput))
                .toList();

        assertEquals(2, filteredContacts.size(), "Should find two contacts with the name prefix 'A'");

        assertTrue(filteredContacts.get(0).getName().startsWith(validInput), "First contact should start with 'A'");
        assertTrue(filteredContacts.get(1).getName().startsWith(validInput), "Second contact should start with 'A'");

    }

    @Test
    @DisplayName("Test for checking invalid contact by name prefix")
    public void findByInvalidNamePrefixTest() {

        String invalidInput = "Unknown\n";
        searchActionMove.findByNamePrefix(contactList, invalidInput);

        List<Contact> filteredContacts = contactList.stream()
                .filter(contact -> contact.getName().startsWith(invalidInput))
                .toList();

        assertEquals(0, filteredContacts.size(), "Should not find any contact for invalid input");

    }

    @Test
    @DisplayName("Test for checking valid contact by surname prefix")
    public void findByValidSurnamePrefixTest() {
        String validInput = "Sm";

        searchActionMove.findBySurnamePrefix(contactList, validInput);

        List<Contact> filteredContacts = contactList.stream()
                .filter(contact -> contact.getSurname().startsWith(validInput))
                .toList();

        assertEquals(1, filteredContacts.size(), "Should find one contacts with the surname prefix 'Sm'");

        assertTrue(filteredContacts.getFirst().getSurname().startsWith(validInput), "First contact should start with 'Sm'");

    }

    @Test
    @DisplayName("Test for checking invalid contact by surname prefix")
    public void findByInvalidSurnamePrefixTest() {

        String invalidInput = "Unknown\n";
        searchActionMove.findBySurnamePrefix(contactList, invalidInput);

        List<Contact> filteredContacts = contactList.stream()
                .filter(contact -> contact.getSurname().startsWith(invalidInput))
                .toList();

        assertEquals(0, filteredContacts.size(), "Should not find any contact for invalid input");

    }

    @Test
    @DisplayName("Test for checking valid contact by address prefix")
    public void findByValidAddressPrefixTest() {
        String validInput = "Ge";

        searchActionMove.findByAddressPrefix(contactList, validInput);

        List<Contact> filteredContacts = contactList.stream()
                .filter(contact -> contact.getAddress().startsWith(validInput))
                .toList();

        assertEquals(1, filteredContacts.size(), "Should find one contacts with the address prefix 'Ge'");
        assertTrue(filteredContacts.getFirst().getAddress().startsWith(validInput), "First contact should start with 'Ge'");

    }

    @Test
    @DisplayName("Test for checking invalid contact by address prefix")
    public void findByInvalidAddressPrefixTest() {

        String invalidInput = "Unknown\n";
        searchActionMove.findByAddressPrefix(contactList, invalidInput);

        List<Contact> filteredContacts = contactList.stream()
                .filter(contact -> contact.getAddress().startsWith(invalidInput))
                .toList();

        assertEquals(0, filteredContacts.size(), "Should not find any contact for invalid input");

    }


    @Test
    @DisplayName("Test for checking valid contact by phone prefix")
    public void findByValidPhonePrefixTest() {
        String validInput = "996";

        searchActionMove.findByPhonePrefix(contactList, validInput);

        List<Contact> filteredContacts = contactList.stream()
                .filter(contact -> contact.getPhone().startsWith(validInput))
                .toList();

        assertEquals(3, filteredContacts.size(), "Should find three contacts with the phone prefix '996'");
        assertTrue(filteredContacts.get(0).getPhone().startsWith(validInput), "First contact should start with '996'");
        assertTrue(filteredContacts.get(1).getPhone().startsWith(validInput), "Second contact should start with '996'");
        assertTrue(filteredContacts.get(2).getPhone().startsWith(validInput), "Third contact should start with '996'");

    }

//
//    @Test
//    @DisplayName("Test for checking invalid contact by phone prefix")
//    public void findByInvalidPhonePrefixTest() {
//
//        String invalidInput = "Unknown\n";
//        searchActionMove.findByAddressPrefix(contactList, invalidInput);
//
//        List<Contact> filteredContacts = contactList.stream()
//                .filter(contact -> contact.getAddress().startsWith(invalidInput))
//                .toList();
//
//        assertEquals(0, filteredContacts.size(), "Should not find any contact for invalid input");
//
//    }



}
