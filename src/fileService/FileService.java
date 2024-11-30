package fileService;


import com.google.gson.*;
import model.Contact;

import java.io.FileReader;
import java.io.FileWriter;
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

    public void write(List<Contact> contacts) {
        JsonArray contactsArray = new JsonArray();

        for (Contact contact : contacts) {
            JsonObject contactObject = new JsonObject();
            contactObject.add(name, new JsonPrimitive(contact.getName()));
            contactObject.add(surname, new JsonPrimitive(contact.getSurname()));
            contactObject.add(address, new JsonPrimitive(contact.getAddress()));
            contactObject.add(phone, new JsonPrimitive(contact.getPhone()));
            contactsArray.add(contactObject);
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.add(tagContacts, contactsArray);

        try (FileWriter fileWriter = new FileWriter("contacts.json")) {
            Gson gson = new Gson();
            gson.toJson(jsonObject, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


