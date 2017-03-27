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

    public static Actions getEnumByString(String value) {
        for (Actions a : Actions.values()) {
            if (value.equals(a.name)) {
                return a;
            }
        }
        throw new IllegalArgumentException();
    }
}
