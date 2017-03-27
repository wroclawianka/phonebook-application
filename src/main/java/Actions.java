/**
 * Created by dorot on 2017-03-26.
 */
public enum Actions {

    GET("g"),
    ADD("a"),
    REMOVE("r"),
    LIST("l"),
    ERROR("e");

    public final String name;

    Actions(String value) {
        name = value;
    }

    public String getName() {
        return name;
    }

    public static Actions getEnumByName(String name) {
        for (Actions a : Actions.values()) {
            if (name.equals(a.name)) {
                return a;
            }
        }
        throw new IllegalArgumentException();
    }
}
