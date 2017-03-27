/**
 * Created by dorot on 2017-03-26.
 */
public class PhoneBookApplication {
    private static PhoneBookBusinessLogic phoneBookBusinessLogic;

    public static void main(String[] args) {
        phoneBookBusinessLogic = new PhoneBookBusinessLogic();

        System.out.println("Welcome in phone book.");
        do {
            phoneBookBusinessLogic.selectAction();
        }
        while (phoneBookBusinessLogic.ifMoreAction());
        System.exit(0);
    }
}
