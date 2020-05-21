/*
 * Course: IST 261
 * Semester: Fall 2018
 * Instructor: Phil O'Connell (pxo4)
 * Student: Jacob Hale, David Chen, Brian Young, Andrew Kim
 * Email: jwh6040@psu.edu, dkc5318@psu.edu, bmy5076@psu.edu, ayk5533@psu.edu
 * Assignment: Banking Application
 */

package Data;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {
    private static Logger _logger = Logger.getLogger("ist261");
    private static Scanner _keyboard = new Scanner(System.in);
// TODO SBI 02 + As a user, I want to log in, so I can access my accounts

    /**
     * Prompts the user to enter credentials.
     *
     * @param register to access the list in Register class
     * @author David Chen (dkc5318@psu.edu)
     */
    public void promptUser(Register register) {
        _logger.log(Level.INFO, "Logging in user");
        String username = readUsername();
        while (!register.isExistingUsername(username)) {
            System.out.println("No username found");
            username = readUsername();
        }

        String password = readPassword();
        while (!register.isExistingPassword(password)) {
            System.out.println("Incorrect password");
            password = readPassword();
        }

        System.out.println("Welcome, " + register.getFirstName() + " " + register.getLastName());
    }

    /**
     * Prompt and read username.
     *
     * @return returns username
     * @author David Chen (dkc5318@psu.edu)
     */
    static String readUsername() {
        _logger.log(Level.FINE, "Reading username");
        System.out.print("Username: ");
        String username = _keyboard.nextLine();
        return username;
    }

    /**
     * Prompt and read password.
     *
     * @return returns password
     * @author David Chen (dkc5318@psu.edu)
     */
    static String readPassword() {
        _logger.log(Level.FINE, "Reading password");
        System.out.print("Password: ");
        return _keyboard.nextLine();
    }
}