package Data;

import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import static Data.RegisterTest._user;
//import static Data.User._password;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class UserTest {

    @BeforeClass
    public static void enterUser(){
        User user = new User();
        user.setFirstName("Jake");
        user.setUsername("Jakefre");
        user.setPassword("abcd");
        _user.add(user);
    }
    /*@Test
    public void getAllBalance__Pass_5_Equals_Return(){
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        System.setIn(in);

        assertSame(5, User._totalBalance);
    }*/

    /*@Test
    public void getFirstName__String_Jake__Equals_FirstName() {
        assertEquals("Jake", User._firstName);
    }

    @Test
    public void getUsername__String_Jakefre__Equals_UserName() {
        assertEquals("Jakefre", User._username);
    }

    @Test
    public void getPassword__String_abcd__Equals_Password() {
        assertEquals("abcd", _password);
    }*/
}