package repository;

import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateContactMoveTest {

    CreateContactMove createContactMove;
    List<Contact> contact;


    @BeforeEach
    void setUp() {
        contact = new ArrayList<>();

        createContactMove = new CreateContactMove();
    }

    @Test
    @DisplayName("Tests to create contact")
    public void createContactTest() {

        String name = "Azidin\n";
        String surname = "Amankulov\n";
        String address = "Japan\n";
        String number = "777 777 777\n";


        String input = name + surname + address + number;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        createContactMove.setScanner(new Scanner(System.in));
        createContactMove.createContact(contact);


        assertEquals(1, contact.size(), "List size should be 1 after creating a contact");
        assertEquals("Azidin", contact.getFirst().getName(), "Contact name should be 'Azidin'");
        assertEquals("Amankulov", contact.getFirst().getSurname(), "Contact last name should be 'Amankulov'");
        assertEquals("Japan", contact.getFirst().getAddress(), "Contact address should be 'Japan'");
        assertEquals("+996 777 777 777", contact.getFirst().getPhone(), "Contact phone should be '996777777777'");
    }


}
