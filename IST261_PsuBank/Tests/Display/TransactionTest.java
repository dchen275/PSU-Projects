package Display;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import Display.Transaction;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

public class TransactionTest {
    private static List<Transaction> _trans = new ArrayList<>();
    private static SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy hh:mm:ss");
    private static String date = sdf.format(new Date());

    @Before
    public void transactionTest() {
        Transaction transaction = new Transaction();
        transaction.setActype("Checking Account Transactions");
        String transactionType = "Deposit";
        transaction.setDate(date);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(100);
        transaction.setBalance(200);
        _trans.add(transaction);
    }

    @Test
    public void getActype__pass_actype__return_True() {
        assertEquals(Transaction.getActype(), ("Checking Account Transactions"));
    }


    @Test
    public void output__pass_transactionTest__return_True() {
        assertEquals(_trans.get(0).output(), "| " + date + " | Deposit | 100.0 | 200.0 | ");
    }
}