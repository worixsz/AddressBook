package repository;

import model.Contact;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

public class DeleteActionMoveTest {

    private List<Contact> contactList;

    private DeleteActionMove deleteActionMove;

    @BeforeEach
    void setUp() {
        deleteActionMove = new DeleteActionMove();
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
}
