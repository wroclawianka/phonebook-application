import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dorot on 2017-03-27.
 */
public class PhoneBookBusinessLogic {

    private PhoneBookDataAccess phoneBook;

    public PhoneBookBusinessLogic() {
        this.phoneBook = new PhoneBookDataAccess();
    }

    public String getNumberByName(String name) {
        Entry entry = phoneBook.getEntry(name);
        if (entry == null) {
            throw new NullPointerException("Entity not found");
        }
        return entry.getPhoneNumber();
    }

    public boolean removeEntry(String name) {
        int foundEntries = phoneBook.get(name).size();
        if (foundEntries == 1) {
            phoneBook.remove(name);
            return true;
        }
        return false;
    }

    public List<Entry> listEntries() {
        List<Entry> list = phoneBook.get()
                .stream()
                .collect(Collectors.toList());

        if (list.size() == 0) {
            throw new IndexOutOfBoundsException("Your phone book is empty.");
        }
        return list;
    }

    public void addEntry(String name, String phoneNumber) {
        phoneBook.add(name, phoneNumber);
    }

    public void validatePhoneNumber(String phoneNumber) {
        if (!isNumberValid(phoneNumber)) {
            throw new IllegalArgumentException("Phone number could have 15 characters and cannot be empty.");
        }
    }

    public void validateName(String name) {
        if (phoneBook.get(name).size() > 0) {
            throw new IllegalArgumentException("Name already in use");

        } else if (!isLengthOfNameValid(name)) {
            throw new IllegalArgumentException("Name could have 50 characters and cannot be empty.");
        }
    }

    private boolean isLengthValid(String value, int length) {
        return value.length() > 0 && value.length() <= length;
    }

    private boolean isLengthOfNameValid(String name) {
        return isLengthValid(name, 50);
    }

    private boolean isNumberValid(String value) {
        return isLengthValid(value, 15);
    }
}
