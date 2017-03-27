import org.junit.Assert;
import org.junit.Test;

/**
 * Created by dorot on 2017-03-27.
 */
public class TestClass {

    @Test
    public void WhenUserAsksAboutExistingEntry_ThenPhoneNumberIsGiven () {
        //Given entry exists
        String name ="Dorota";
        String phoneNumber = "+48783367813";
        PhoneBookBusinessLogic phoneBookBusinessLogic = new PhoneBookBusinessLogic();
        phoneBookBusinessLogic.addEntry(name, phoneNumber);

        //When user asks about entry by name
        String actualPhoneNumber = phoneBookBusinessLogic.getNumberByName(name);

        //Then phone number is given
        Assert.assertEquals(phoneNumber, actualPhoneNumber);
    }
}
