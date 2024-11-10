import java.util.Scanner;

public class CheckActionMove implements CheckAction {


    @Override
    public void checkContact(int index, String[] contact) {
        for (String contacts : contact) {
            if (contacts == null || contacts.trim().isEmpty()) {
                continue;
            }
            if (index != -1) {
                System.out.println("🔍 Contact Found: " + contacts);

            } else {
                System.out.println("❗No contact with such data!");
                break;
            }
        }
    }

    @Override
    public void showContact(int index, String[] contacts) {
        System.out.println("\n--- LIST OF ALL CONTACTS ---");
        if (index == 0) {
            System.out.println("❌ No contacts available.\n");
        } else {
            for (int i = 0; i < index; i++) {
                System.out.println((i + 1) + ". " + contacts[i]);

            }
        }
    }

    @Override
    public int checkLengthOfContact(String length, String[] contacts) {
        Scanner SC = new Scanner(System.in);
        int index = SC.nextInt() - 1;
        for (int i = index; i < length.length() - 1; i++) {
            contacts[i] = contacts[i + 1];
        }
        return index;
    }
}
