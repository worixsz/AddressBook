import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
                    System.out.println("Enter your Name:");
                    String name = scanner.next();
                    System.out.println("Enter your Surname:");
                    String surname = scanner.next();
                    System.out.println("Enter your address:");
                    String address = scanner.next();
                    System.out.println("Enter your Phone:");
                    String phone = scanner.next();


                    if (nextEmpty != contacts.length) {
                        contacts[nextEmpty] = name + " " + surname + " " + address + " " + phone;
                        nextEmpty++;
                        System.out.println("You successfully added the note");
                    } else {
                        System.err.println("Memory Full");
                    }
                    break;
                case 2:
                    System.out.println("Search Contact");
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

    public void checkString(String name, String surname, String phone, String address) {

    }
}