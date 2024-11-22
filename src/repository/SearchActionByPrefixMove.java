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
                System.out.println("❗ No contacts found with the name prefix: " + namePrefix);
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
                System.out.println("❗ No contacts found with the surname prefix: " + surnamePrefix);
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
                System.out.println("❗ No contacts found with the address prefix: " + addressPrefix);
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
            List<Contact> filteredList = contacts.stream().filter(c -> c.getPhone().startsWith(phonePrefix)).toList();
            if (filteredList.isEmpty()) {
                System.out.println("❗ No contacts found with the phone prefix: " + phonePrefix);
            } else {
                filteredList.forEach(smContact -> System.out.println("🔍 Similar contact: " + smContact));
            }

        } catch (Exception e) {
            System.err.println("An error occurred while searching for contacts: " + e.getMessage());
        }

    }
}
