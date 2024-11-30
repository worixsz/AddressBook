package fileService;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Contact;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileService {

    private static final JsonParser parser = new JsonParser();

    private static final String tagContacts = "contacts";

    private static final String name = "name";

    private static final String surname = "surname";

    private static final String address = "address";

    private static final String phone = "phone";

    public List<Contact> read() {
        List<Contact> contacts = new ArrayList<>();

        try (FileReader fileReader = new FileReader("contacts.json")) {
            JsonObject jsonObject = (JsonObject) parser.parse(fileReader);

            JsonArray contactsArray = (JsonArray) jsonObject.get(tagContacts);
            for (JsonElement item : contactsArray) {
                JsonObject contactsObjects = (JsonObject) item;
                String nameOfContact = contactsObjects.get(name).getAsString();
                String surnameOfContact = contactsObjects.get(surname).getAsString();
                String addressOfContact = contactsObjects.get(address).getAsString();
                String phoneOfContact = contactsObjects.get(phone).getAsString();
                Contact contact = new Contact(nameOfContact, surnameOfContact, addressOfContact, phoneOfContact);
                contacts.add(contact);

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }


}
