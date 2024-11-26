package repository;
import model.Contact;
import service.SearchActionByPrefix;
import java.util.List;

public class SearchActionByPrefixMove implements SearchActionByPrefix {

    @Override
    public void findByNamePrefix(List<Contact> contacts, String namePrefix) {
        try {
            List<Contact> filteredList = contacts.stream()
                    .filter(c -> c.getName().startsWith(namePrefix))
                    .toList();
            if (filteredList.isEmpty()) {
                System.out.println("❗ The are not similar contacts: " + namePrefix);
            } else {
                filteredList.forEach(smContact -> System.out.println("🔍 Similar contact: " + smContact));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while searching for contacts: " + e.getMessage());
        }


    }

    @Override
    public void findBySurnamePrefix(List<Contact> contacts, String surnamePrefix) {
        try {
            List<Contact> filteredList = contacts.stream().filter(c -> c.getSurname().startsWith(surnamePrefix)).toList();
            if (filteredList.isEmpty()) {
                System.out.println("❗ The are not similar contacts: " + surnamePrefix);
            } else {
                filteredList.forEach(smContact -> System.out.println("🔍 Similar contact: " + smContact));
            }
        } catch (Exception e) {
            System.err.println("An error occurred while searching for contacts: " + e.getMessage());
        }

    }

    @Override
    public void findByAddressPrefix(List<Contact> contacts, String addressPrefix) {
        try {
            List<Contact> filteredList = contacts.stream().filter(c -> c.getAddress().startsWith(addressPrefix)).toList();
            if (filteredList.isEmpty()) {
                System.out.println("❗ The are not similar contacts: " + addressPrefix);
            } else {
                filteredList.forEach(smContact -> System.out.println("🔍 Similar contact: " + smContact));
            }

        } catch (Exception e) {
            System.err.println("An error occurred while searching for contacts: " + e.getMessage());
        }

    }

    @Override
    public void findByPhonePrefix(List<Contact> contacts, String phonePrefix) {
        try {
            List<Contact> filteredList = contacts.stream().filter(c -> c.getPhone().startsWith( "+996 " + phonePrefix)).toList();
            if (filteredList.isEmpty()) {
                System.out.println("❗ The are not similar contacts: +996 " + phonePrefix);
            } else {
                filteredList.forEach(smContact -> System.out.println("🔍 Similar contact: " + smContact));
            }

        } catch (Exception e) {
            System.err.println("An error occurred while searching for contacts: " + e.getMessage());
        }

    }
}
