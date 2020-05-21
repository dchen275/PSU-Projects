/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.InitializePlayer;
import model.Puzzle;

/**
 *
 *
 * @author Phil, Chris Valko (cjv5110@psu.edu)
 */
public class Menu {

    private String _menuOption;
    private final List<MenuChoice> _choices = new ArrayList<>();
    private static final Scanner _keyboard = new Scanner(System.in);
    private Puzzle puzzle = new Puzzle();

    public Menu() {

    }

    /**
     * Constructor to add menuOption
     *
     * @author Chris Valko (cjv5110@psu.edu)
     * @param menuOption
     */
    public Menu(String menuOption) {

        _menuOption = menuOption;

    }

    /**
     * Displays title, puzzle (formatted), player info, menu choices and adds a
     * number before the choice
     *
     * @author Chris Valko (cjv5110@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     */
    private void display(InitializePlayer playerList) {
        System.out.println();
        System.out.println(_menuOption);
        System.out.println();


        Board board = new Board(puzzle);
        board.display();
        //testing purposes
        //System.out.println(puzzle.getPuzzleString());
        
        if (!board.formattedPuzzleString().contains("_")) {
            System.out.printf("You won $%d!", (playerList.getPlayers()).get(0).getScore());
            System.exit(0);
        }

        for (int i = 0; i < playerList.getPlayers().size() - 1; i++) {
            System.out.println("Player: " + (playerList.getPlayers()).get(i).getName());
            System.out.println("Winnings: $" + (playerList.getPlayers()).get(i).getScore());
            System.out.println();
        }

        for (int i = 0; i < _choices.size(); i++) {

            System.out.println(i + 1 + ") " + _choices.get(i).getText());
        }
    }

    /**
     * Displays the menu with the menu options and prompts the user to choose a
     * menu option. Also, the method checks for valid choices
     *
     * @author Chris Valko (cjv5110@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     * @param playerList
     * @return _choices
     */
    public MenuChoice displayAndChoose(InitializePlayer playerList) {
        boolean valid;
        int numericChoice = 0;
        do {
            display(playerList);
            System.out.println("");
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

        System.out.println("");
        return _choices.get(numericChoice - 1);

    }

    /**
     * Adds menu choices to the _choices ArrayList
     *
     * @author Chris Valko (cjv5110@psu.edu)
     * @param choiceOptions
     */
    public void addMenuChoice(MenuChoice choiceOptions) {
        _choices.add(choiceOptions);
    }

    /**
     * returns puzzle unformatted
     *
     * @return
     * @author David Chen (dkc5318@psu.edu)
     */
    public String getPuzzleString() {
        return this.puzzle.getPuzzleString();
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }
}
