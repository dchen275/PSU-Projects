package Data;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class VacationAccountTest {

    @Test
    public void getBalance__Pass_0_Equals_Balance() {
        ByteArrayInputStream in = new ByteArrayInputStream("0.00".getBytes());
        System.setIn(in);
        assertEquals(0.00, VacationAccount.getBalance(), 0.0001);
    }

}