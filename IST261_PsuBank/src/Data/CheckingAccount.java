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

public class CheckingAccount extends User {
    private static double _balance;
    private final List<Transaction> _checkingTrans;
    private static Logger _logger = Logger.getLogger("ist261");

    /**
     * Constructor for the list to accept values
     *
     * @param checkingTrans the person
     * @author Brian Young (bmy5076@psu.edu)
     */
    public CheckingAccount(List<Transaction> checkingTrans) {
        _logger.log(Level.CONFIG, "Creating checking transaction list");
        this._checkingTrans = checkingTrans;
        String transactionType = "Create";
        Transaction transaction = new Transaction();
        transaction.setDate(date);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(_balance);
        transaction.setBalance(_balance);
        _checkingTrans.add(transaction);
        transaction.setActype("Checking Account Transactions");
    }
    // TODO SBI 06 + As a user, I want to see the balance one account, so I know how much money is in there

    /**
     * checks the balance of the user's Checking Account                          (1)
     *
     * @author Jacob Hale (jwh6040@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     */
    public static void balanceCheck() {
        _logger.log(Level.INFO, "Checking account balance");
        System.out.println("Checking Account Balance: $" + _balance);
    }

    // TODO SBI 05 + As a user, I want to withdraw from my account, so I can spend my money

    /**
     * Allows user to withdraw money from Checking Account.                           (1)
     *
     * @return returns a confirmation if successful or a rejection depending on the amount of money in the account
     * @author Andrew Kim (ayk5533@psu.edu)
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void withdraw() {
        _logger.log(Level.INFO, "Attempting to withdraw");

        //Validation: Ensure only positive decimal numbers are allowed
        //Validation: Ensure the user has enough money to withdraw

        //if user withdraws with sufficient funds, withdrawn successfully
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
        } while (_balance < 0);
        if (amountToWithdraw < _balance) {
            _balance = _balance - amountToWithdraw;
            System.out.println("Withdrawn successfully");

            Transaction transaction = new Transaction();
            String transactionType = "Withdraw";
            transaction.setDate(date);
            transaction.setTransactionType(transactionType);
            transaction.setAmount(amountToWithdraw);
            transaction.setBalance(_balance);
            _checkingTrans.add(transaction);
        }
        else if  (amountToWithdraw > _balance){
            String _account = "Checking Account";
            _logger.log(Level.INFO, "Attempt to withdraw more than is in an account "+ _username + " " + _account + " " +_balance + " " + amountToWithdraw);
            System.out.println("Insufficient Funds");
        }
    }

    // TODO SBI 04 + As a user, I want to deposit to my account, so I can save my money

    /**
     * Allows user to deposit money into Checking account                           (1)
     *
     * @return returns a confirmation
     * @author Andrew Kim (ayk5533@psu.edu)
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void deposit() {
        _logger.log(Level.INFO, "Attempting to deposit");

        //Validation: Ensure only positive decimal numbers are allowed
        double amountToDeposit = 0.00; //Setting the amount to deposit to 0

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
        _checkingTrans.add(transaction);

        // TODO Redirect/return into Transaction class
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

        for (Transaction _checkingTran : _checkingTrans) {
            System.out.println(_checkingTran.output());
        }
    }

    /**
     * Getter for the User class getAllBalance
     *
     * @return the double balance in the account
     * @author Brian Young (bmy5076@psu.edu)
     */
    public static Double getBalance() {
        _logger.log(Level.CONFIG, "Getting balance");
        return _balance;
    }

}
