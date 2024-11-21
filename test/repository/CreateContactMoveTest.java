package repository;

import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CreateContactMoveTest {

    CreateContactMove createContactMove;

    List<Contact> contactList;

    @BeforeEach
    void setUp() {

        createContactMove = new CreateContactMove();
        Contact contactOne = new Contact("Azidin", "Amankulov", "Japan", "996777777777");
        Contact contactTwo = new Contact("Aibek", "Mahronovich", "China", "9966666666");
        contactList = List.of(contactOne, contactTwo);
    }

    @Test
    @DisplayName("Tests to add contact to exist contacts")
    public void CreateContactTest() {

    }
}
