import java.util.List;
import java.util.Scanner;

/**
 * Created by dorot on 2017-03-26.
 */
public class PhoneBookApplication {
    private static PhoneBookBusinessLogic phoneBookBusinessLogic;
    private static Scanner sc;

    public static void main(String[] args) {
        phoneBookBusinessLogic = new PhoneBookBusinessLogic();
        sc = new Scanner(System.in);

        System.out.println("Welcome in phone book.");
        do {
            System.out.println("Actions:\nget entry - g,\nadd entry - a,\nremove entry - r,\nlist all entries - l:");
            Actions action = getActions();
            selectAction(action);

            System.out.println("Can I help you more? Type y if yes");
        }
        while (isMoreAction(sc.nextLine()));
        System.exit(0);
    }

    private static Actions getActions() {
        String inputValue = sc.nextLine();
        Actions action;

        try {
            action = Actions.getEnumByName(inputValue);
        } catch (IllegalArgumentException e) {
            action = Actions.ERROR;
        }
        return action;
    }

    private static void selectAction(Actions action) {

        switch (action) {
            case GET:
                get();
                break;
            case ADD:
                add();
                break;
            case REMOVE:
                remove();
                break;
            case LIST:
                list();
                break;
            case ERROR:
            default:
                error();
        }
    }

    private static void add() {
        String name;
        boolean isNameValid = false;
        do {
            name = getName();

            try {
                phoneBookBusinessLogic.validateName(name);
                isNameValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!isNameValid);

        String phoneNumber;
        boolean isPhoneNameValid = false;

        do {
            phoneNumber = getPhoneNumber();

            try {
                phoneBookBusinessLogic.validatePhoneNumber(phoneNumber);
                isPhoneNameValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!isPhoneNameValid);

        phoneBookBusinessLogic.addEntry(name, phoneNumber);
    }

    private static void get() {
        System.out.println("Set name to get a phone number:");
        String name = sc.nextLine();
        try {
            String phoneNumber = phoneBookBusinessLogic.getNumberByName(name);
            System.out.println(phoneNumber);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getPhoneNumber() {
        System.out.println("Type phone number:");
        return sc.nextLine();
    }

    private static String getName() {
        System.out.println("Choose a name of entry. Name has to be unique:");
        return sc.nextLine();
    }

    private static void remove() {
        System.out.println("Choose a name of entry to remove");
        String name = sc.nextLine();
        if (phoneBookBusinessLogic.removeEntry(name)) {
            System.out.println("Entry " + name + " removed");
        } else {
            System.out.println("Entry not found");
        }
    }

    private static void list() {
        try {
            List<Entry> list = phoneBookBusinessLogic.listEntries();
            System.out.println("Your phone book: ");
            list.forEach(entry -> System.out.println(entry.getName() + " " + entry.phoneNumber));

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            addFirstEntry();
        }
    }

    private static void addFirstEntry() {
        System.out.print("Do you want to set your first empty? y - yes");
        String inputValue = sc.nextLine();
        if (isMoreAction(inputValue)) {
            add();
        }
    }

    private static void error() {
        System.out.println("Command not found.");
    }

    private static boolean isMoreAction(String value) {
        return value.toLowerCase().equals("y");
    }
}
