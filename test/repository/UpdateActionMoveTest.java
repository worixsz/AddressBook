package repository;

import model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UpdateActionMoveTest {


    private List<Contact> contactList;

    private UpdateActionMove updateActionMove;

    @BeforeEach
    void setUp() {
        updateActionMove = new UpdateActionMove();
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
    @DisplayName("Test to check correct update by name")
    public void updateContactByNameTest() {

    }
}
