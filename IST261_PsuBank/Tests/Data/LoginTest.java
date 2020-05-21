package Data;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class LoginTest {
    // Individual Tests Passes but Class Test Fails

    @Test
    // https://stackoverflow.com/a/6416179
    public void readUsername__Pass_David__Equals_Return() {
        ByteArrayInputStream in = new ByteArrayInputStream("David".getBytes());
        System.setIn(in);

        assertEquals("David", Login.readUsername());
    }

    @Test
    // https://stackoverflow.com/a/6416179
    public void readPassword__Pass_C__Equals_Return() {
        ByteArrayInputStream in = new ByteArrayInputStream("C".getBytes());
        System.setIn(in);

        assertEquals("C", Login.readPassword());
    }
}