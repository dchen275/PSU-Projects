package Data;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RegisterTest {
    static ArrayList<User> _user = new ArrayList<>();
    static Register register = new Register(_user);

    @BeforeClass
    public static void enterUser() {
        User user = new User();
        user.setFirstName("David");
        user.setMiddleName("");
        user.setLastName("Chen");
        user.setUsername("D");
        user.setPassword("C");
        _user.add(user);
    }

    @Test
    public void isExistingUsername__Pass_D__Returns_True() {
        assertTrue(register.isExistingUsername("D"));
    }

    @Test
    public void isExistingUsername__Pass_X__Returns_False() {
        assertFalse(register.isExistingUsername("X"));
    }

    @Test
    public void isBlank__Pass_SpaceSpaceD__Returns_True() {
        assertTrue(register.isBlank("  D"));
    }

    @Test
    public void isBlank__Pass_SpaceSpace__Returns_False() {
        assertFalse(register.isBlank("  "));
    }

    @Test
    public void isExistingPassword__Pass_C__Returns_True() {
        assertTrue(register.isExistingPassword("C"));
    }

    @Test
    public void isExistingPassword__Pass_D__Returns_False() {
        assertFalse(register.isExistingPassword("D"));
    }

    @Test
    public void getFirstName__String_David__Equals_FirstName() {
        assertEquals("David", register.getFirstName());
    }

    @Test
    public void getFirstName__String_X__NotEquals_FirstName() {
        assertNotEquals("X", register.getFirstName());
    }
}