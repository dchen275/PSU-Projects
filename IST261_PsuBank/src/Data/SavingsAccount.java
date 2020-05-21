/*
 * Course: IST 261
 * Semester: Fall 2018
 * Instructor: Phil O'Connell (pxo4)
 * Student: Jacob Hale, David Chen, Brian Young, Andrew Kim
 * Email: jwh6040@psu.edu, dkc5318@psu.edu, bmy5076@psu.edu, ayk5533@psu.edu
 * Assignment: Banking Application
 */

package Data;

import Display.Transaction;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SavingsAccount extends User {
    private static double _balance;
    private final List<Transaction> _savingsTrans;
    private static Logger _logger = Logger.getLogger("ist261");

    /**
     * Constructor for the list to accept values
     *
     * @param savingsTrans the person
     * @author Brian Young (bmy5076@psu.edu)
     */
    public SavingsAccount(List<Transaction> savingsTrans) {
        _logger.log(Level.CONFIG, "Creating savings transaction list");
        this._savingsTrans = savingsTrans;
        String transactionType = "Create";
        Transaction transaction = new Transaction();
        transaction.setDate(date);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(_balance);
        transaction.setBalance(_balance);
        _savingsTrans.add(transaction);
        transaction.setActype("Savings Account Transactions");
    }

    // TODO SBI 06 + As a user, I want to see the balance one account, so I know how much money is in there

    /**
     * Allows the user to check the balance of the Savings account.
     *
     * @author Jacob Hale (jwh6040@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     */
    public static void balanceCheck() {
        _logger.log(Level.INFO, "Checking account balance");
        System.out.println("Savings Account Balance: $" + _balance);
    }

    // TODO SBI 05 + As a user, I want to withdraw from my account, so I can spend my money

    /**
     * Allows user to withdraw money from Savings Account.
     *
     * @return returns success or failure depending on how much money is in the account.
     * @author Andrew Kim (ayk5533@psu.edu)
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void withdraw() {
        _logger.log(Level.INFO, "Attempting to withdraw");

        //Validation: Ensure only positive decimal numbers are allowed
        //Validation: Ensure the user has enough money to withdraw
        double amountToWithdraw = 0;
        do {
            System.out.println("Amount to withdraw: ");
            String lineIn = _keyboard.nextLine();
            try {
                amountToWithdraw = Double.parseDouble(lineIn);
            } catch (Exception e) {
                _logger.log(Level.WARNING, "Invalid input was given");
                System.out.println("Please enter valid amount");
                withdraw();
            }
            if (amountToWithdraw < 0) {
                _logger.log(Level.INFO, "Negative number was given");
                System.out.println("Please enter valid amount");
            }
        } while (amountToWithdraw < 0);
        if (amountToWithdraw < _balance) {
            _balance = _balance - amountToWithdraw;
            System.out.println("Withdrawn successfully");

            Transaction transaction = new Transaction();
            String transactionType = "Withdraw";
            transaction.setDate(date);
            transaction.setTransactionType(transactionType);
            transaction.setAmount(amountToWithdraw);
            transaction.setBalance(_balance);
            _savingsTrans.add(transaction);
        }
        else if  (amountToWithdraw > _balance) {
            String _account = "Savings Account";
            _logger.log(Level.INFO, "Attempt to withdraw more than is in an account "+ _username + " " + _account + " " +_balance + " " + amountToWithdraw);
            System.out.println("Insufficient Funds");
        }
    }

    // TODO SBI 04 + As a user, I want to deposit to my account, so I can save my money

    /**
     * Allows user to deposit money into Savings account.
     *
     * @return returns a confirmation.
     * @author Andrew Kim (ayk5533@psu.edu)
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void deposit() {
        _logger.log(Level.INFO, "Attempting to deposit");

        //Validation: Ensure only positive decimal numbers are allowed
        double amountToDeposit = 0; //Setting the amount to deposit to 0

        //Allowing the user to input the amount to deposit. If it is invalid, it will loop until valid.
        do {
            System.out.println("Amount to deposit: ");
            String lineIn = _keyboard.nextLine();
            try {
                amountToDeposit = Double.parseDouble(lineIn);
            } catch (Exception e) {
                _logger.log(Level.WARNING, "Invalid input was given");
                System.out.println("Please enter valid amount.");
                deposit();
            }
            if (amountToDeposit < 0) {
                _logger.log(Level.INFO, "Negative number was given");
                System.out.println("Please enter a valid amount.");
            }
        } while (amountToDeposit < 0);
        _balance = _balance + amountToDeposit;
        System.out.println("Deposited successfully");
        Transaction transaction = new Transaction();
        String transactionType = "Deposit";
        transaction.setDate(date);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(amountToDeposit);
        transaction.setBalance(_balance);
        _savingsTrans.add(transaction);
    }

    /**
     * Output a list of transactions
     *
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void outputTransactions() {
        _logger.log(Level.INFO, "Attempting to output transactions");
        System.out.println();
        System.out.println(Transaction.getActype());
        System.out.println("---------------------------- \n");
        System.out.println("| Date                | Type     | Amount | Balance |");

        for (Transaction _savingsTran : _savingsTrans) {
            System.out.println(_savingsTran.output());
        }
    }

    /**
     * Getter for the User class getAllBalance
     *
     * @return the double balance in the account
     * @author Brian Young (bmy5076@psu.edu)
     */
    static Double getBalance() {
        _logger.log(Level.CONFIG, "Getting balance");
        return _balance;
    }
}