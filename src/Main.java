import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        run();


    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String[] contacts = new String[3];
        int nextEmpty = 0;
        int command = 4;
        do {
            System.out.println("1.Create Contact\n2.Search Contact\n3.Delete Contact\n4.List All Contacts\n5.Exit\n");
            command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Create Contact");
                    System.out.println("Enter your name:");
                    String name = scanner.next();
                    System.out.println("Enter your surname:");
                    String surname = scanner.next();
                    System.out.println("Enter your address:");
                    String address = scanner.next();
                    System.out.println("Enter your phone:");
                    String phone = scanner.next();
                    if (nextEmpty != contacts.length) {
                        contacts[nextEmpty] = name + " " + surname + " " + address + " " + phone;
                        nextEmpty++;
                        System.out.println("You successfully added the contact");
                    } else {
                        System.err.println("Memory Full");
                    }
                    break;
                case 2:
                    System.out.println("You can search contact by: 'name' 'surname' 'address 'phone".toUpperCase());
                    System.out.println("Enter the contact:");
                    String keyword = scanner.next();

                    String[] result = Arrays.stream(contacts)
                            .filter(line -> line != null && line.contains(keyword))
                            .toArray(String[]::new);

                    if (result.length == 0) {
                        System.out.println("The contact not found");
                    } else {
                        for (String line : result) {
                            System.out.println(line);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Delete Contact");
                    break;
                case 4:
                    for (String contact : contacts) {
                        System.out.println(contact);
                    }
                    break;
                default:
                    System.err.println("Invalid command, Command should be in range 1,2,3,4");
                    break;
            }
        } while (command != 5);
    }
}


