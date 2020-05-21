/*
 * Course: IST 261
 * Semester: Fall 2018
 * Instructor: Phil O'Connell (pxo4)
 * Student: Jacob Hale, David Chen, Brian Young, Andrew Kim
 * Email: jwh6040@psu.edu, dkc5318@psu.edu, bmy5076@psu.edu, ayk5533@psu.edu
 * Assignment: Banking Application
 */

package Display;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner _keyboard = new Scanner(System.in);
    private String _lineIn;
    private String _title;
    private ArrayList<MenuChoice> _choices = new ArrayList<>();

    /**
     * Constructor, accepting any initial values
     *
     * @param title Name of menu
     * @author Phil O'Connell (pxo4@psu.edu)
     * @author Brian Young (bmy5076@psu.edu)
     */
    public Menu(String title) {
        _title = title;
        _lineIn = _title.replaceAll(".", "-");
    }

    /**
     * Displays the menu choices, and returns the one chosen by the user
     *
     * @return the choice made by the user
     * @author Phil O'Connell (pxo4@psu.edu)
     * @author Brian Young (bmy5076@psu.edu)
     */

    public MenuChoice displayAndChoose() {
        boolean valid;
        int numericChoice = 0;
        do {
            display();
            System.out.print("Choice: ");
            String lineEntered = _keyboard.nextLine();

            try {
                numericChoice = Integer.parseInt(lineEntered);
                valid = (numericChoice >= 1) && (numericChoice <= (_choices.size()));
            } catch (Exception e) {
                valid = false;
            }

            if (!valid) {
                System.out.println("Invalid choice");
            }
        } while (!valid);
        return _choices.get(numericChoice - 1);
    }

    /**
     * Display the title and numbered choices
     *
     * @author Phil O'Connell (pxo4@psu.edu)
     * @author Brian Young (bmy5076@psu.edu)
     */
    private void display() {
        System.out.println();
        System.out.printf(".-%s-.%n", _lineIn);
        System.out.printf("| %s |%n", _title);
        System.out.printf("'-%s-'%n", _lineIn);

        int labeling = 0;
        for (MenuChoice choice : _choices) {
            labeling++;
            System.out.println(labeling + ") " + choice.getText());
        }
        System.out.println();
    }

    /**
     * Adds a menu choice to the menu
     *
     * @param menuChoice the menu choice to add
     * @author Phil O'Connell (pxo4@psu.edu)
     * @author Brian Young (bmy5076@psu.edu)
     */
    public void addMenuChoice(MenuChoice menuChoice) {
        _choices.add(menuChoice);
    }
}