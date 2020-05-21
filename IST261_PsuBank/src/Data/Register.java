/*
 * Course: IST 261
 * Semester: Fall 2018
 * Instructor: Phil O'Connell (pxo4)
 * Student: Jacob Hale, David Chen, Brian Young, Andrew Kim
 * Email: jwh6040@psu.edu, dkc5318@psu.edu, bmy5076@psu.edu, ayk5533@psu.edu
 * Assignment: Banking Application
 */

package Data;


import org.apache.commons.text.WordUtils;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Register {
    private static Logger _logger = Logger.getLogger("ist261");
    private List<User> _user;
    private static Scanner _keyboard = new Scanner(System.in);
    private int iUsername;

    // TODO SBI 01 + As a user, I want to register with the bank, so I can use the application

    /**
     * Constructor, accepting any initial values.
     *
     * @param user the person's account info
     * @author David Chen (dkc5318@psu.edu)
     */
    public Register(List<User> user) {
        _logger.log(Level.CONFIG, "Creating user list");
        this._user = user;
    }

    /**
     * sets the user to the list
     *
     * @author Jacob Hale (jwh6040@psu.edu)
     * @author David Chen (dkc5318@psu.edu
     */
    public void setList(List<User> list) {
        this._user = list;
    }

    /**
     * Allow the user to enter people into the list.
     *
     * @author David Chen (dkc5318@psu.edu)
     */
    public void enterUser() {
        _logger.log(Level.INFO, "Registering user");
        User user = new User();
        setUserInfo(user);
        _user.add(user);
        _logger.log(Level.INFO, "New user created");
    }

    /**
     * Prompts and adds user information for account into storage.
     *
     * @param user User class
     * @author David Chen (dkc5318@psu.edu)
     */
    private void setUserInfo(User user) {
        String firstName = WordUtils.capitalize(validateUserInput("your first name"));
        user.setFirstName(firstName);

        System.out.print("Enter your middle initial or name (optional): ");
        String middleName = WordUtils.capitalize(_keyboard.nextLine());
        user.setMiddleName(middleName);

        String lastName = WordUtils.capitalize(validateUserInput("your last name"));
        user.setLastName(lastName);

        String text = setUsername(firstName, middleName, lastName);
        user.setUsername(text);

        String password = validateUserInput("your password");
        user.setPassword(password);

        System.out.println("Thank you for registering\nYou may now log in\n");
    }

    /**
     * Validate a given input
     * <p>
     * Inputs are not allowed to be blank
     *
     * @param input the name to be validated
     * @return true if valid
     * @author Phil O'Connell (pxo4@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     */
    static boolean isBlank(String input) {
        return (input != null && !input.trim().equals(""));
    }

    /**
     * Checks if username is within list of accounts.
     *
     * @param username account username
     * @return true if valid
     * @author David Chen (dkc5318@psu.edu)
     */
    boolean isExistingUsername(String username) {
        for (iUsername = 0; iUsername < _user.size(); iUsername++) {
            if (username.equals(_user.get(iUsername).getUsername())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if password is valid under username.
     *
     * @param password account password
     * @return true if valid
     * @author David Chen (dkc5318@psu.edu)
     */
    boolean isExistingPassword(String password) {
        return password.equals(_user.get(iUsername).getPassword());
    }

    /**
     * Gets first name of account holder.
     *
     * @return first name of account holder
     * @author David Chen (dkc5318@psu.edu)
     */
    String getFirstName() {
        _logger.log(Level.CONFIG, "Getting First Name");
        return _user.get(iUsername).getFirstName();
    }

    /**
     * Gets first name of account holder.
     *
     * @return first name of account holder
     * @author David Chen (dkc5318@psu.edu)
     */
    String getLastName() {
        _logger.log(Level.CONFIG, "Getting Last Name");
        return _user.get(iUsername).getLastName();
    }

    /**
     * Prompt user for input, read it, and return it.
     *
     * @param subject what to ask of user
     * @return valid user input
     * @author David Chen (dkc5318@psu.edu)
     */
    private String validateUserInput(String subject) {
        System.out.print("Enter " + subject + ": ");
        String input = _keyboard.nextLine().trim();
        while (!isBlank(input)) {
            System.out.println("Error: Cannot be blank");
            System.out.print("Enter " + subject + ": ");
            input = _keyboard.nextLine().trim();
        }
        return input;
    }

    /**
     * Create's user's username for account
     *
     * @param firstName  manipulates user's first name
     * @param middleName manipulates user's middle name
     * @param lastName   manipulates user's last name
     * @return username
     * @author David Chen (dkc5318@psu.edu)
     */
    private String setUsername(String firstName, String middleName, String lastName) {
        String userFullName = WordUtils.uncapitalize(firstName) + " "
                + WordUtils.uncapitalize(middleName) + " "
                + WordUtils.uncapitalize(lastName);

        String text = WordUtils.initials(userFullName);

        System.out.println("Your username is: " + text);
        return text;
    }
}