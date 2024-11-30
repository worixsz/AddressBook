package fileService;


import com.google.gson.*;
import model.Contact;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private static final String TAG_CONTACTS = "contacts";

    private static final String NAME = "name";

    private static final String SURNAME = "surname";

    private static final String address = "address";

    private static final String PHONE = "phone";

    public List<Contact> read() {
        List<Contact> contacts = new ArrayList<>();

        try (FileReader fileReader = new FileReader("contacts.json")) {
            JsonObject jsonObject = JsonParser.parseReader(fileReader).getAsJsonObject();

            JsonArray contactsArray = jsonObject.getAsJsonArray(TAG_CONTACTS);
            for (JsonElement item : contactsArray) {
                JsonObject contactsObject = item.getAsJsonObject();
                String nameOfContact = contactsObject.get(NAME).getAsString();
                String surnameOfContact = contactsObject.get(SURNAME).getAsString();
                String addressOfContact = contactsObject.get(address).getAsString();
                String phoneOfContact = contactsObject.get(PHONE).getAsString();
                Contact contact = new Contact(nameOfContact, surnameOfContact, addressOfContact, phoneOfContact);
                contacts.add(contact);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }

    public void write(List<Contact> contacts) {
        JsonArray contactsArray = new JsonArray();

        for (Contact contact : contacts) {
            JsonObject contactObject = new JsonObject();
            contactObject.add(NAME, new JsonPrimitive(contact.getName()));
            contactObject.add(SURNAME, new JsonPrimitive(contact.getSurname()));
            contactObject.add(address, new JsonPrimitive(contact.getAddress()));
            contactObject.add(PHONE, new JsonPrimitive(contact.getPhone()));
            contactsArray.add(contactObject);
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.add(TAG_CONTACTS, contactsArray);

        try (FileWriter fileWriter = new FileWriter("contacts.json")) {
            Gson gson = new Gson();
            gson.toJson(jsonObject, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


