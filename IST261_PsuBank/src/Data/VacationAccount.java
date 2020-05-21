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

public class VacationAccount extends User {
    private static double _balance;
    private final List<Transaction> _vacationTrans;
    private static Logger _logger = Logger.getLogger("ist261");

    /**
     * Constructor for the list to accept values
     *
     * @param vacationTrans the person
     * @author Brian Young (bmy5076@psu.edu)
     */
    public VacationAccount(List<Transaction> vacationTrans) {
        _logger.log(Level.CONFIG, "Creating vacation transaction list");
        this._vacationTrans = vacationTrans;
        String transactionType = "Create";
        Transaction transaction = new Transaction();
        transaction.setDate(this.date);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(this._balance);
        transaction.setBalance(this._balance);
        this._vacationTrans.add(transaction);
    }

    // TODO SBI 06 + As a user, I want to see the balance one account, so I know how much money is in there

    /**
     * Allows user to check balance of the Vacation account.
     *
     * @author Jacob Hale (jwh6040@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     */
    public void balanceCheck() {
        _logger.log(Level.INFO, "Checking account balance");
        System.out.println("Vacation Account Balance: $" + _balance);
    }

    // TODO SBI 05 + As a user, I want to withdraw from my account, so I can spend my money

    /**
     * Allows user to withdraw money from the Vacation Account.
     *
     * @return returns a success or failure depending on how much money is in the account.
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
            _vacationTrans.add(transaction);
            transaction.setActype("Vacation Account Transactions");
        }
        else if  (amountToWithdraw > _balance) {
            String _account = "Vacation Account";
            _logger.log(Level.INFO, "Attempt to withdraw more than is in an account "+ _username + " " + _account + " " +_balance + " " + amountToWithdraw);
            System.out.println("Insufficient Funds");
        }
    }
    // TODO SBI 04 + As a user, I want to deposit to my account, so I can save my money

    /**
     * Allows user to deposit money into the Vacation account.
     *
     * @return returns a success.
     * @author Andrew Kim (ayk5533@psu.edu)
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void deposit() {
        _logger.log(Level.INFO, "Attempting to deposit");

        double amountToDeposit = 0;
        //Validation: Ensure only positive decimal numbers are allowed
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
        this._balance = this._balance + amountToDeposit;

        System.out.println("Deposited successfully");
        Transaction transaction = new Transaction();
        String transactionType = "Deposit";
        transaction.setDate(date);
        transaction.setTransactionType(transactionType);
        transaction.setAmount(amountToDeposit);
        transaction.setBalance(_balance);
        _vacationTrans.add(transaction);

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

        for (Transaction _vacationTran : _vacationTrans) {
            System.out.println(_vacationTran.output());
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