package repository;

import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CheckActionMoveTest {

    private CheckActionMove validator;
    private List<Contact> contactList;

    @BeforeEach
    void setUp() {
        validator = new CheckActionMove();
        Contact contactOne = new Contact("Azidin", "Amankulov", "123 Street", "996 777 777 777");
        Contact contactTwo = new Contact("Aibek", "Mahronovich", "113 Street", "99 663 667 669");
        contactList = List.of(contactOne, contactTwo);
    }


    @Test
    @DisplayName("Tests to show exist contacts")
    public void showContactTest() {
        assertDoesNotThrow(() -> validator.showContact(contactList));
        List<Contact> emptyContacts = new ArrayList<>();
        assertDoesNotThrow(() -> validator.showContact(emptyContacts));
    }

    @Test
    public void testValidName() {
        Contact contact = new Contact("John", "Doe", "123 Street", "+1-234-567-890");
        assertDoesNotThrow(() -> validator.validateContact(contact));
    }

    @Test
    public void testInvalidName() {
        Contact contact = new Contact("john", "Doe", "123 Street", "+1-234-567-890");
        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> validator.validateContact(contact));
        assertEquals("Invalid name format: john", thrown.getMessage());
    }

    @Test
    public void testValidSurname() {
        Contact contact = new Contact("John", "O'Connor", "123 Street", "+1-234-567-890");
        assertDoesNotThrow(() -> validator.validateContact(contact));
    }

    @Test
    public void testInvalidSurname() {
        Contact contact = new Contact("John", "O'Connor123", "123 Street", "+1-234-567-890");
        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> validator.validateContact(contact));
        assertEquals("Invalid surname format: O'Connor123", thrown.getMessage());
    }

    @Test
    public void testValidPhone() {
        Contact contact = new Contact("John", "Doe", "123 Street", "+1-234-567-890");
        assertDoesNotThrow(() -> validator.validateContact(contact));
    }

    @Test
    public void testInvalidPhone() {
        Contact contact = new Contact("John", "Doe", "123 Street", "996::::4433434");
        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> validator.validateContact(contact));
        assertEquals("Invalid phone number format: 996::::4433434", thrown.getMessage());
    }

    @Test
    public void testValidAddress() {
        Contact contact = new Contact("John", "Doe", "123 Street, Apt 4B", "+1-234-567-890");
        assertDoesNotThrow(() -> validator.validateContact(contact));
    }

    @Test
    public void testInvalidAddress() {
        Contact contact = new Contact("John", "Doe", "123@Street!", "+1-234-567-890");
        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> validator.validateContact(contact));
        assertEquals("Invalid address format: 123@Street!", thrown.getMessage());
    }

    @Test
    public void testEmptyName() {
        Contact contact = new Contact("", "Doe", "123 Street", "+1-234-567-890");
        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> validator.validateContact(contact));
        assertEquals("Invalid name format: ", thrown.getMessage());
    }

    @Test
    public void testEmptySurname() {
        Contact contact = new Contact("John", "", "123 Street", "+1-234-567-890");
        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> validator.validateContact(contact));
        assertEquals("Invalid surname format: ", thrown.getMessage());
    }

    @Test
    public void testEmptyAddress() {
        Contact contact = new Contact("John", "Doe", "", "+1-234-567-890");
        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> validator.validateContact(contact));
        assertEquals("Invalid address format: ", thrown.getMessage());
    }

    @Test
    public void testEmptyPhone() {
        Contact contact = new Contact("John", "Doe", "123 Street", "");
        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> validator.validateContact(contact));
        assertEquals("Invalid phone number format: ", thrown.getMessage());
    }

    @Test
    public void testEmptyString() {
        InputMismatchException thrown = assertThrows(InputMismatchException.class, () -> validator.checkStringForEmpty("  "));
        assertEquals("The input cannot be empty.", thrown.getMessage());
    }


    @Test
    public void checkPhoneNumberTest() {

        String validPhone = "+996 500 919 055";
        assertDoesNotThrow(() -> validator.checkPhoneNumber(validPhone));

        // Номер телефона с некорректной длиной
        String invalidPhone = "+996 500 919";
        InputMismatchException thrown = assertThrows(InputMismatchException.class,
                () -> validator.checkPhoneNumber(invalidPhone));
        assertEquals("Incorrect number.", thrown.getMessage());

        // Номер с недопустимыми символами
    }


}

