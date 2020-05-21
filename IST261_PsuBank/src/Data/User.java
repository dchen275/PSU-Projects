/*
 * Course: IST 261
 * Semester: Fall 2018
 * Instructor: Phil O'Connell (pxo4)
 * Student: Jacob Hale, David Chen, Brian Young, Andrew Kim
 * Email: jwh6040@psu.edu, dkc5318@psu.edu, bmy5076@psu.edu, ayk5533@psu.edu
 * Assignment: Banking Application
 */

package Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User implements Serializable {
    String _username;
    private String _password;
    private String _firstName;
    private String _middleName;
    private String _lastName;
    private double _checkingBalance;
    private double _savingsBalance;
    private double _vacationBalance;
    private double _totalBalance;
    private static Logger _logger = Logger.getLogger("ist261");

    static Scanner _keyboard = new Scanner(System.in);
    private SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy hh:mm:ss");
    String date = sdf.format(new Date());

// TODO SBI 03 + As a user, I want to have a checking, savings, and vacation account, so I can diversify

// TODO SBI 07 + As a user, I want to see the balance of all my accounts, so I know how much money I have

    /**
     * gets the total amount of money the user has in all of their accounts combined.
     *
     * @return returns total balance of all accounts added.
     * @author Jacob Hale (jwh6040@psu.edu)
     */
    public void getAllBalance() {
        _logger.log(Level.INFO, "Getting balances");
        _checkingBalance = Double.parseDouble(String.valueOf(CheckingAccount.getBalance()));
        _savingsBalance = Double.parseDouble(String.valueOf(SavingsAccount.getBalance()));
        _vacationBalance = Double.parseDouble(String.valueOf(VacationAccount.getBalance()));
        _totalBalance = _checkingBalance + _savingsBalance + _vacationBalance;
        ballAllDisplay();
    }

    /**
     * Displays the getBalance method's results.
     *
     * @return Displays graphically the balance in each account
     * @author Jacob Hale (jwh6040@psu.edu)
     */
    private void ballAllDisplay() {
        _logger.log(Level.INFO, "Displaying balances");
        System.out.println("|  Account  |  Balance  |");
        System.out.println("|-----------|-----------|");
        System.out.println("| Checking  |   " + _checkingBalance + " |");
        System.out.println("|  Savings  |   " + _savingsBalance + " |");
        System.out.println("| Vacation  |   " + _vacationBalance + " |");
        System.out.println("|-----------|-----------|");
        System.out.println("|  TOTAL    |   " + _totalBalance + " |");
    }

    /**
     * Set user's username to account.
     *
     * @param username user's username
     * @author David Chen (dkc5318@psu.edu)
     */
    void setUsername(String username) {
        _logger.log(Level.CONFIG, "Setting username");
        this._username = username;
    }

    /**
     * Set user's password to account.
     *
     * @param password user's password
     * @author David Chen (dkc5318@psu.edu)
     */
    void setPassword(String password) {
        _logger.log(Level.CONFIG, "Setting password");
        this._password = password;
    }

    /**
     * Set user's first name linked to account.
     *
     * @param firstName user's first name
     * @author David Chen (dkc5318@psu.edu)
     */
    void setFirstName(String firstName) {
        _logger.log(Level.CONFIG, "Setting first name");
        this._firstName = firstName;
    }

    /**
     * Set user's middle name linked to account.
     *
     * @param middleName user's middle name
     * @author David Chen (dkc5318@psu.edu)
     */
    void setMiddleName(String middleName) {
        _logger.log(Level.CONFIG, "Setting middle name");
        this._middleName = middleName;
    }

    /**
     * Set user's last name linked to account.
     *
     * @param lastName user's last name
     * @author David Chen (dkc5318@psu.edu)
     */
    void setLastName(String lastName) {
        _logger.log(Level.CONFIG, "Setting last name");
        this._lastName = lastName;
    }

    /**
     * Get user's first name linked to account.
     *
     * @author David Chen (dkc5318@psu.edu)
     */
    String getFirstName() {
        _logger.log(Level.CONFIG, "Getting first name");
        return this._firstName;
    }

    /**
     * Get user's last name linked to account.
     *
     * @author David Chen (dkc5318@psu.edu)
     */
    String getLastName() {
        _logger.log(Level.CONFIG, "Getting last name");
        return this._lastName;
    }

    /**
     * Get user's username linked to account.
     *
     * @author David Chen (dkc5318@psu.edu)
     */
    String getUsername() {
        _logger.log(Level.CONFIG, "Getting username");
        return this._username;
    }

    /**
     * Get user's password linked to account.
     *
     * @author David Chen (dkc5318@psu.edu)
     */
    String getPassword() {
        _logger.log(Level.CONFIG, "Getting password");
        return this._password;
    }
}