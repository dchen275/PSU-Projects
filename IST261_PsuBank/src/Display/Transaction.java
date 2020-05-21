/*
 * Course: IST 261
 * Semester: Fall 2018
 * Instructor: Phil O'Connell (pxo4)
 * Student: Jacob Hale, David Chen, Brian Young, Andrew Kim
 * Email: jwh6040@psu.edu, dkc5318@psu.edu, bmy5076@psu.edu, ayk5533@psu.edu
 * Assignment: Banking Application
 */

package Display;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transaction {
    private static String _actype;
    private String _transactionType;
    private double _amount;
    private double _balance;
    private SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy hh:mm:ss");
    private String _date = sdf.format(new Date());
    private static Logger _logger = Logger.getLogger("ist261");

// TODO SBI 08 + As a user, I want to see a report of transactions for an account, so I know when I deposited/withdrew

    /**
     * Sets the account type
     *
     * @param actype account type
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void setActype(String actype) {
        _logger.log(Level.CONFIG, "Setting account type");
        _actype = actype;
    }

    /**
     * Gets the account type
     *
     * @author Brian Young (bmy5076@psu.edu)
     */
    public static String getActype() {
        _logger.log(Level.CONFIG, "Getting account type");
        return _actype;
    }

    /**
     * Sets the transaction type
     *
     * @param transactionType Transaction type
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void setTransactionType(String transactionType) {
        _logger.log(Level.CONFIG, "Setting transaction type");
        this._transactionType = transactionType;
    }

    /**
     * Sets the amount made during the transaction
     *
     * @param amount amount added or taken
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void setAmount(double amount) {
        _logger.log(Level.CONFIG, "Setting amount");
        this._amount = amount;
    }

    /**
     * Sets the balance of the account
     *
     * @param balance total balance
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void setBalance(double balance) {
        _logger.log(Level.CONFIG, "Setting balance");
        this._balance = balance;
    }

    /**
     * Sets the date of the last transaction
     *
     * @param date The date
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void setDate(String date) {
        _logger.log(Level.CONFIG, "Setting the date");
        this._date = date;
    }

    /**
     * outputs a list of transactions.
     *
     * @return formatted information on the transactions made
     * @author Brian Young (bmy5076@psu.edu)
     */
    public String output() {
        _logger.log(Level.INFO, "Returning transaction output");
        return "| " + this._date + " | " + this._transactionType + " | " + this._amount + " | " + this._balance + " | ";
    }
}