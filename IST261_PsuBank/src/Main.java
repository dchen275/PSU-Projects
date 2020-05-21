/*
 * Course: IST 261
 * Semester: Fall 2018
 * Instructor: Phil O'Connell (pxo4)
 * Student: Jacob Hale, David Chen, Brian Young, Andrew Kim
 * Email: jwh6040@psu.edu, dkc5318@psu.edu, bmy5076@psu.edu, ayk5533@psu.edu
 * Assignment: Banking Application
 */

import Data.*;
import Display.Menu;
import Display.MenuChoice;
import Display.Transaction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    //System.property("user.home")
    private static String filepath = System.getProperty("user.home");
    private static String saveFilePath = filepath + "\\banksaves.txt";
    private static User newUser = new User();
    private static File directory = new File(filepath + "\\banklog");


    private static List<User> _user = new ArrayList<>();
    private static Register _register = new Register(_user);
    private static Login _login = new Login();
    private static Serialize _serializer = new Serialize();
    private static Logger _logger = Logger.getLogger("ist261");

    public static void main(String[] args) {
        initLogger();
        _logger.log(Level.FINE, "Program Started");

        //First thing:  output the team number and members
        // TODO 00 + Change X to your team number.
        System.out.println("Team #5");
        // TODO 01 + List your team here.  Delete the example
        System.out.println("Jacob Hale (jwh6040@psu.edu) Github: jwh6040");
        System.out.println("David Chen (dkc5318@psu.edu) Github: dchen275");
        System.out.println("Brian Young (bmy5076@psu.edu) Github: BrianMYoung95");
        System.out.println("Andrew Kim (ayk5533@psu.edu) Github: ayk5533");
        System.out.println();
        System.out.println("Welcome to PSU Bank!");
        System.out.println();
        System.out.println("[The log filepath is " + directory + "\\bank_log.txt]");
        System.out.println();

        mainMenu();
    }

    /**
     * Method that displays the main menu
     *
     * @author Brian Young (bmy5076@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     * @authot Jacob Hale (jwh6040@psu.edu)
     */
    private static void mainMenu() {
        _logger.log(Level.INFO, "Creation of the menu display");
        Menu mainMenu = new Menu("Main Menu");

        MenuChoice choiceRegister = new MenuChoice("Register");
        MenuChoice choiceLogin = new MenuChoice("Login");
        MenuChoice choiceSave = new MenuChoice("Save Data");
        MenuChoice choiceLoad = new MenuChoice("Load Data");
        MenuChoice choiceQuit = new MenuChoice("Quit");
        MenuChoice choice;

        mainMenu.addMenuChoice(choiceRegister);
        mainMenu.addMenuChoice(choiceLogin);
        mainMenu.addMenuChoice(choiceSave);
        mainMenu.addMenuChoice(choiceLoad);
        mainMenu.addMenuChoice(choiceQuit);

        do {
            choice = mainMenu.displayAndChoose();

            // Decide what to do with the choice made
            if (choice == choiceRegister) {
                _logger.log(Level.FINE, "User entered choice to register");
                _register.enterUser();
            } else if (choice == choiceLogin) {
                _logger.log(Level.FINE, "User entered choice to login");
                _login.promptUser(_register);
                accountMenu();
                // Once logged in, display account menu
            } else if (choice == choiceQuit) {
                _logger.log(Level.FINE, "User entered choice to register");
                System.out.println("Goodbye");
                _logger.log(Level.FINE, "Program ended");
                System.exit(0);
            } else if (choice == choiceSave) {
                _logger.log(Level.INFO, "User is saving data");
                _serializer.saveData(_user, saveFilePath);
            } else if (choice == choiceLoad) {
                _logger.log(Level.INFO, "User is loading data");
                _register.setList(_serializer.loadData(saveFilePath));
//                System.out.println(_register.getFirstName());
            }
        } while (choice != choiceQuit);
    }

    /**
     * Method that displays the account menu
     *
     * @author Brian Young (bmy5076@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     */
    private static void accountMenu() {
        _logger.log(Level.INFO, "Creation of the account menu display");
        Menu accountMenu = new Menu("Account Menu");

        MenuChoice choiceAllBalances = new MenuChoice("All Balances");
        MenuChoice choiceChecking = new MenuChoice("Checking");
        MenuChoice choiceSavings = new MenuChoice("Savings");
        MenuChoice choiceVacation = new MenuChoice("Vacation");
        MenuChoice choiceExit = new MenuChoice("Exit");
        MenuChoice choice;

        accountMenu.addMenuChoice(choiceAllBalances);
        accountMenu.addMenuChoice(choiceChecking);
        accountMenu.addMenuChoice(choiceSavings);
        accountMenu.addMenuChoice(choiceVacation);
        accountMenu.addMenuChoice(choiceExit);

        do {
            choice = accountMenu.displayAndChoose();

            // Decide what to do with the choice made
            if (choice == choiceAllBalances) {
                _logger.log(Level.FINE, "User entered choice to check all balances");
                newUser.getAllBalance();
            } else if (choice == choiceChecking) {
                _logger.log(Level.FINE, "User entered choice to access checking account");
                checkingAccount();
            } else if (choice == choiceSavings) {
                _logger.log(Level.FINE, "User entered choice to access savings account");
                savingsAccount();
            } else if (choice == choiceVacation) {
                _logger.log(Level.FINE, "User entered choice to access vacation account");
                vacationAccount();
            } else if (choice == choiceExit) {
                _logger.log(Level.FINE, "User entered choice to exit");
                mainMenu();
            }
        } while (choice != choiceExit);
    }

    /**
     * Method that displays the checking menu
     *
     * @author Brian Young (bmy5076@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     */
    private static void checkingAccount() {
        _logger.log(Level.INFO, "Creation of the checking menu display");
        Menu savingMenu = new Menu("Checking Account");

        MenuChoice choiceBalance = new MenuChoice("Balance");
        MenuChoice choiceDeposit = new MenuChoice("Deposit");
        MenuChoice choiceWithdraw = new MenuChoice("Withdraw");
        MenuChoice choiceTransactions = new MenuChoice("Transactions");
        MenuChoice choiceExit = new MenuChoice("Exit");
        MenuChoice choice;

        savingMenu.addMenuChoice(choiceBalance);
        savingMenu.addMenuChoice(choiceDeposit);
        savingMenu.addMenuChoice(choiceWithdraw);
        savingMenu.addMenuChoice(choiceTransactions);
        savingMenu.addMenuChoice(choiceExit);

        List<Transaction> transaction = new ArrayList<>();
        CheckingAccount checkingAccount = new CheckingAccount(transaction);
        do {
            choice = savingMenu.displayAndChoose();

            // Decide what to do with the choice made
            if (choice == choiceBalance) {
                _logger.log(Level.FINE, "User entered choice to check balance");
                checkingAccount.balanceCheck();
            } else if (choice == choiceDeposit) {
                _logger.log(Level.FINE, "User entered choice to deposit");
                checkingAccount.deposit();
            } else if (choice == choiceWithdraw) {
                _logger.log(Level.FINE, "User entered choice to withdraw");
                checkingAccount.withdraw();
            } else if (choice == choiceTransactions) {
                _logger.log(Level.FINE, "User entered choice to check transactions");
                checkingAccount.outputTransactions();
            } else if (choice == choiceExit) {
                _logger.log(Level.FINE, "User entered choice to exit the account");
                accountMenu();
            }
        } while (choice != choiceExit);
    }

    /**
     * Method that displays the savings menu
     *
     * @author Brian Young (bmy5076@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     */
    private static void savingsAccount() {
        _logger.log(Level.INFO, "Creation of the savings menu display");
        Menu savingMenu = new Menu("Savings Account");

        MenuChoice choiceBalance = new MenuChoice("Balance");
        MenuChoice choiceDeposit = new MenuChoice("Deposit");
        MenuChoice choiceWithdraw = new MenuChoice("Withdraw");
        MenuChoice choiceTransactions = new MenuChoice("Transactions");
        MenuChoice choiceExit = new MenuChoice("Exit");
        MenuChoice choice;

        savingMenu.addMenuChoice(choiceBalance);
        savingMenu.addMenuChoice(choiceDeposit);
        savingMenu.addMenuChoice(choiceWithdraw);
        savingMenu.addMenuChoice(choiceTransactions);
        savingMenu.addMenuChoice(choiceExit);

        List<Transaction> transaction = new ArrayList<>();
        SavingsAccount savingsAccount = new SavingsAccount(transaction);
        do {
            choice = savingMenu.displayAndChoose();

            // Decide what to do with the choice made
            if (choice == choiceBalance) {
                _logger.log(Level.FINE, "User entered choice to check balance");
                savingsAccount.balanceCheck();
            } else if (choice == choiceDeposit) {
                _logger.log(Level.FINE, "User entered choice to deposit");
                savingsAccount.deposit();
            } else if (choice == choiceWithdraw) {
                _logger.log(Level.FINE, "User entered choice to withdraw");
                savingsAccount.withdraw();
            } else if (choice == choiceTransactions) {
                _logger.log(Level.FINE, "User entered choice to check transactions");
                savingsAccount.outputTransactions();
            } else if (choice == choiceExit) {
                _logger.log(Level.FINE, "User entered choice to exit the account");
                accountMenu();
            }
        } while (choice != choiceExit);
    }

    /**
     * Method that displays the vacation menu
     *
     * @author Brian Young (bmy5076@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     */
    private static void vacationAccount() {
        _logger.log(Level.INFO, "Creation of the vacation menu display");
        Menu savingMenu = new Menu("Vacation Account");

        MenuChoice choiceBalance = new MenuChoice("Balance");
        MenuChoice choiceDeposit = new MenuChoice("Deposit");
        MenuChoice choiceWithdraw = new MenuChoice("Withdraw");
        MenuChoice choiceTransactions = new MenuChoice("Transactions");
        MenuChoice choiceExit = new MenuChoice("Exit");
        MenuChoice choice;

        savingMenu.addMenuChoice(choiceBalance);
        savingMenu.addMenuChoice(choiceDeposit);
        savingMenu.addMenuChoice(choiceWithdraw);
        savingMenu.addMenuChoice(choiceTransactions);
        savingMenu.addMenuChoice(choiceExit);

        List<Transaction> transaction = new ArrayList<>();
        VacationAccount vacationAccount = new VacationAccount(transaction);

        do {
            choice = savingMenu.displayAndChoose();

            // Decide what to do with the choice made
            if (choice == choiceBalance) {
                _logger.log(Level.FINE, "User entered choice to check balance");
                vacationAccount.balanceCheck();
            } else if (choice == choiceDeposit) {
                _logger.log(Level.FINE, "User entered choice to deposit");
                vacationAccount.deposit();
            } else if (choice == choiceWithdraw) {
                _logger.log(Level.FINE, "User entered choice to withdraw");
                vacationAccount.withdraw();
            } else if (choice == choiceTransactions) {
                _logger.log(Level.FINE, "User entered choice to check transactions");
                vacationAccount.outputTransactions();
            } else if (choice == choiceExit) {
                _logger.log(Level.FINE, "User entered choice to exit the account");
                accountMenu();
            }
        } while (choice != choiceExit);
    }

    /**
     * Method for Logging
     *
     * @author Andrew Kim (ayk5533@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     */
    private static void initLogger() {
        String propName = "java.util.logging.SimpleFormatter.format";
        String propValue = "[%1$tF %1$tT] [%4$-7s] %5$s %n";
        System.setProperty(propName, propValue);

        FileHandler fh = null;

        if (!directory.exists())
            directory.mkdir();

        try {
            fh = new FileHandler(directory + "\\bank_log.txt", true);
        } catch
                (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        fh.setFormatter(new SimpleFormatter());

        _logger.addHandler(fh);
        _logger.setUseParentHandlers(false);
        _logger.setLevel(Level.ALL);
    }
}