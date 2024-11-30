package repository;

import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class DeleteActionMoveTest {


    private DeleteActionMove deleteActionMove;
    private List<Contact> contact;

    @BeforeEach
    void setUp() {
        deleteActionMove = new DeleteActionMove();
        contact = new ArrayList<>();
        contact.add(new Contact("Azidin", "Amankulov", "Japan", "996777777777"));

    }

    @Test
    @DisplayName("Test for valid index input to delete")
    public void deleteValidContactByContactTest() {
        String inputString = "1\n";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        deleteActionMove.setScanner(new Scanner(System.in));
        deleteActionMove.deleteContactByIndex(contact);
        assertEquals(0, contact.size(), "Contact should be deleted, list size should be 0 after deletion");
        assertFalse(contact.stream()
                        .anyMatch
                                (contact -> contact.getName().equals("Azidin")),
                "Contact 'Azidin' should have been deleted.");
    }


    @Test
    @DisplayName("Test for invalid index input to delete")
    public void deleteInvalidContactByContactTest() {
        String inputString = "5\n";
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        deleteActionMove.setScanner(new Scanner(System.in));

        deleteActionMove.deleteContactByIndex(contact);

        assertEquals(1, contact.size(), "List size should remain the same after invalid input");
        assertTrue(contact.stream()
                        .anyMatch(contact -> contact.getName().equals("Azidin")),
                "Contact 'Azidin' should still exist in the list.");
    }


}
