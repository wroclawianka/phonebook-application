import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dorot on 2017-03-25.
 */
public class PhoneBookDataAccess {

    private static List<Entry> listOfEntries;

    public PhoneBookDataAccess() {
        this.listOfEntries = new ArrayList<>();
    }

    public void add(String name, String phoneNumber) {
        listOfEntries.add(new Entry(name, phoneNumber));
    }

    public void remove(String name) {
        get(name).remove(0);
    }

    public List<Entry> get() {
        return listOfEntries;
    }

    public List<Entry> get(String value) {
        return listOfEntries.stream().filter(entry -> entry.name.equals(value)).collect(Collectors.toList());
    }

    public Entry getEntry(String value) {
        List<Entry> entries = get(value);
        if (entries.size() == 1) {
            return entries.get(0);
        } else {
            return null;
        }
    }
}
