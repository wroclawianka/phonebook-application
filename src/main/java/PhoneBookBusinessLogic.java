import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Collections.EMPTY_LIST;
import static java.util.Collections.emptyList;

/**
 * Created by dorot on 2017-03-27.
 */
public class PhoneBookBusinessLogic {

    private PhoneBookDataAccess phoneBook;
    private Scanner sc;

    public PhoneBookBusinessLogic() {
        this.phoneBook = new PhoneBookDataAccess();
        this.sc = new Scanner(System.in);
    }

    private String getAction() {
        System.out.println("Actions:\nget entry - g,\nadd entry - a,\nremove entry -r,\nlist all entries - l:");
        return sc.nextLine();
    }

    public boolean ifMoreAction() {
        System.out.println("Can I help you more? Type y if yes");
        return sc.nextLine().toLowerCase().equals("y");
    }

    public void selectAction() {
        String action = getAction();

        if (action.toLowerCase().equals(Actions.GET.getName())) {
            getNumberByName();

        } else if (action.toLowerCase().equals(Actions.ADD.getName())) {
            addEntry();

        } else if (action.toLowerCase().equals(Actions.REMOVE.getName())) {
            removeEntry();

        } else if (action.toLowerCase().equals(Actions.LIST.getName())) {
            listEntries();
        } else {
            System.out.println("Command not found.");
        }
    }

    public void getNumberByName() {
        System.out.println("Set name to get a phone number:");
        String name = sc.nextLine();

        Entry entry = phoneBook.getEntry(name);

        if (entry == null) {
            System.out.println("Entity not found");

        } else {
            System.out.println(entry.getPhoneNumber());
        }
    }

    public void addEntry() {
        String name;
        String phoneNumber;

        System.out.println("Choose a name of entry. Name has to be unique:");
        do {
            name = sc.nextLine();
        } while (!isNameValid(name));

        System.out.println("Type phone number:");
        do {
            phoneNumber = sc.nextLine();
        } while (!isNumberValid(phoneNumber));

        phoneBook.add(name, phoneNumber);
    }

    public void removeEntry() {
        System.out.println("Choose a name of entry to remove");
        String name = sc.nextLine();

        int foundEntries = phoneBook.get(name).size();
        if (foundEntries == 0) {
            System.out.println("Entry not found");

        } else if (foundEntries == 1) {
            phoneBook.remove(name);
            System.out.println("Entry " + name + " removed");
        }
    }

    public void listEntries() {
        List<Entry> list = phoneBook.get()
                .stream()
                .collect(Collectors.toList());

        if (list.equals(emptyList())) {
            System.out.println("Your phone book is empty. Do you want to set your first empty? y - yes");

            if (sc.nextLine().toLowerCase().equals("y")) {
                addEntry();
            }
        } else {
            System.out.println("Your phone book: ");
            list.forEach(entry -> System.out.println(entry.getName() + " " + entry.phoneNumber));
        }
    }

    private boolean isNameValid(String name) {
        if (phoneBook.get(name).equals(EMPTY_LIST)) {
            return isLengthOfNameValid(name);

        } else {
            System.out.println("Name already exist. Select another one:");
            return false;
        }
    }

    private boolean isNumberValid(String value) {
        if (isLengthValid(value, 15)) {
            return true;
        }
        System.out.println("Phone number could have 15 characters and cannot be empty. Type valid one:");
        return false;
    }

    private boolean isLengthValid(String value, int length) {
        return value.length() > 0 && value.length() <= length;
    }

    private boolean isLengthOfNameValid(String name) {
        if (isLengthValid(name, 50)) {
            return true;
        }
        System.out.println("Name could have 50 characters and cannot be empty. Select another one:");
        return false;
    }
}
