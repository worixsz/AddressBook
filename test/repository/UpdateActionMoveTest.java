package repository;

import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateActionMoveTest {


    private List<Contact> contactList;

    private UpdateActionMove updateActionMove;

    private SearchActionMove searchActionMove;


    @BeforeEach
    void setUp() {
        updateActionMove = new UpdateActionMove();
        searchActionMove = new SearchActionMove();

        contactList = List.of(
                new Contact("Aibek", "Mahronovich", "China", "+996 666 666 666")
        );


    }

    @Test
    @DisplayName("Test for update valid contact by name")
    void updateValidContactByNameTest() {

        String simulatedInput = """
                Aibek
                1
                Michael
                Williams
                France 93A
                555 555 555
                """;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sharedScanner = new Scanner(System.in);

        updateActionMove.setScanner(sharedScanner);
        searchActionMove.setScanner(sharedScanner);

        updateActionMove.setSearch(searchActionMove);

        updateActionMove.updateContactByName(contactList);
        System.out.println(contactList);

        assertEquals("Michael", contactList.getFirst().getName());
        assertEquals("Williams", contactList.getFirst().getSurname());
        assertEquals("France 93A", contactList.getFirst().getAddress());
        assertEquals("+996 555 555 555", contactList.getFirst().getPhone());
    }

    @Test
    @DisplayName("Test for invalid input during update by 'name'")
    void updateInvalidContactByNameTest() {
        String simulatedInput = """
                Aibek
                invalidIndex
                """;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sharedScanner = new Scanner(System.in);

        updateActionMove.setScanner(sharedScanner);
        searchActionMove.setScanner(sharedScanner);

        updateActionMove.setSearch(searchActionMove);

        Contact originalContact = contactList.getFirst();
        updateActionMove.updateContactByName(contactList);

        assertEquals(originalContact.getName(), contactList.getFirst().getName());
        assertEquals(originalContact.getSurname(), contactList.getFirst().getSurname());
        assertEquals(originalContact.getAddress(), contactList.getFirst().getAddress());
        assertEquals(originalContact.getPhone(), contactList.getFirst().getPhone());

    }

    @Test
    @DisplayName("Test for update valid contact by surname")
    void updateValidContactBySurnameTest() {

        String simulatedInput = """
                Mahronovich
                1
                Michael
                Williams
                France 93A
                555 555 555
                """;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sharedScanner = new Scanner(System.in);

        updateActionMove.setScanner(sharedScanner);
        searchActionMove.setScanner(sharedScanner);

        updateActionMove.setSearch(searchActionMove);

        updateActionMove.updateContactBySurname(contactList);
        System.out.println(contactList);

        assertEquals("Michael", contactList.getFirst().getName());
        assertEquals("Williams", contactList.getFirst().getSurname());
        assertEquals("France 93A", contactList.getFirst().getAddress());
        assertEquals("+996 555 555 555", contactList.getFirst().getPhone());
    }

    @Test
    @DisplayName("Test for invalid input during update by 'surname'")
    void updateInvalidContactBySurnameTest() {
        String simulatedInput = """
                Aibek
                invalidIndex
                """;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sharedScanner = new Scanner(System.in);

        updateActionMove.setScanner(sharedScanner);
        searchActionMove.setScanner(sharedScanner);

        updateActionMove.setSearch(searchActionMove);

        Contact originalContact = contactList.getFirst();
        updateActionMove.updateContactBySurname(contactList);

        assertEquals(originalContact.getName(), contactList.getFirst().getName());
        assertEquals(originalContact.getSurname(), contactList.getFirst().getSurname());
        assertEquals(originalContact.getAddress(), contactList.getFirst().getAddress());
        assertEquals(originalContact.getPhone(), contactList.getFirst().getPhone());

    }

    @Test
    @DisplayName("Test for update valid contact by address")
    void updateValidContactByAddressTest() {

        String simulatedInput = """
                China
                1
                Michael
                Williams
                France 93A
                555 555 555
                """;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sharedScanner = new Scanner(System.in);

        updateActionMove.setScanner(sharedScanner);
        searchActionMove.setScanner(sharedScanner);

        updateActionMove.setSearch(searchActionMove);

        updateActionMove.updateContactByAddress(contactList);
        System.out.println(contactList);

        assertEquals("Michael", contactList.getFirst().getName());
        assertEquals("Williams", contactList.getFirst().getSurname());
        assertEquals("France 93A", contactList.getFirst().getAddress());
        assertEquals("+996 555 555 555", contactList.getFirst().getPhone());
    }

    @Test
    @DisplayName("Test for invalid input during update by 'address'")
    void updateInvalidContactByAddressTest() {
        String simulatedInput = """
                Aibek
                invalidIndex
                """;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sharedScanner = new Scanner(System.in);

        updateActionMove.setScanner(sharedScanner);
        searchActionMove.setScanner(sharedScanner);

        updateActionMove.setSearch(searchActionMove);

        Contact originalContact = contactList.getFirst();
        updateActionMove.updateContactByAddress(contactList);

        assertEquals(originalContact.getName(), contactList.getFirst().getName());
        assertEquals(originalContact.getSurname(), contactList.getFirst().getSurname());
        assertEquals(originalContact.getAddress(), contactList.getFirst().getAddress());
        assertEquals(originalContact.getPhone(), contactList.getFirst().getPhone());

    }

    @Test
    @DisplayName("Test for update valid contact by phone number")
    void updateValidContactByPhoneNumberTest() {

        String simulatedInput = """
                666666666
                1
                Michael
                Williams
                France 93A
                555 555 555
                """;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sharedScanner = new Scanner(System.in);

        updateActionMove.setScanner(sharedScanner);
        searchActionMove.setScanner(sharedScanner);

        updateActionMove.setSearch(searchActionMove);

        updateActionMove.updateContactByPhone(contactList);

        assertEquals("Michael", contactList.getFirst().getName());
        assertEquals("Williams", contactList.getFirst().getSurname());
        assertEquals("France 93A", contactList.getFirst().getAddress());
        assertEquals("+996 555 555 555", contactList.getFirst().getPhone());
    }

    @Test
    @DisplayName("Test for invalid input during update by 'phone number'")
    void updateInvalidContactByPhoneNumberTest() {
        String simulatedInput = """
                Aibek
                invalidIndex
                """;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        Scanner sharedScanner = new Scanner(System.in);

        updateActionMove.setScanner(sharedScanner);
        searchActionMove.setScanner(sharedScanner);

        updateActionMove.setSearch(searchActionMove);

        Contact originalContact = contactList.getFirst();
        updateActionMove.updateContactByPhone(contactList);

        assertEquals(originalContact.getName(), contactList.getFirst().getName());
        assertEquals(originalContact.getSurname(), contactList.getFirst().getSurname());
        assertEquals(originalContact.getAddress(), contactList.getFirst().getAddress());
        assertEquals(originalContact.getPhone(), contactList.getFirst().getPhone());

    }


}