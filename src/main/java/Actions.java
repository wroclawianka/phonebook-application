/**
 * Created by dorot on 2017-03-26.
 */
public enum Actions {

    GET("g"),
    ADD("a"),
    REMOVE("r"),
    LIST("l");

    private final String name;

    Actions(String value) {
        name = value;
    }

    public String getName() {
        return name;
    }
}
