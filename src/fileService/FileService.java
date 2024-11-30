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

    private static final String tagContacts = "contacts";

    private static final String name = "name";

    private static final String surname = "surname";

    private static final String address = "address";

    private static final String phone = "phone";

    public List<Contact> read() {
        List<Contact> contacts = new ArrayList<>();

        try (FileReader fileReader = new FileReader("contacts.json")) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();

            JsonArray contactsArray = jsonObject.getAsJsonArray(tagContacts);
            for (JsonElement item : contactsArray) {
                JsonObject contactsObject = item.getAsJsonObject();
                String nameOfContact = contactsObject.get(name).getAsString();
                String surnameOfContact = contactsObject.get(surname).getAsString();
                String addressOfContact = contactsObject.get(address).getAsString();
                String phoneOfContact = contactsObject.get(phone).getAsString();
                Contact contact = new Contact(nameOfContact, surnameOfContact, addressOfContact, phoneOfContact);
                contacts.add(contact);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }
}


