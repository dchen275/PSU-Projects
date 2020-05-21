package controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.parser.TokenType;
import model.InitializePlayer;
import model.Letter;
import model.Player;
import model.Puzzle;
import model.Wedge;
import view.Help;
import view.MenuChoice;
import view.Menu;

/**
 *
 * @author christophervalko
 */
public class Game {

    /**
     * Adds menu choices to the menu. Then, it loops through the users choices
     * and returns the choice the user made :)
     *
     * @author Chris Valko (cjv5110@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     *
     */
    List<Player> players = new ArrayList<>();
    InitializePlayer playerList = new InitializePlayer(players);
    Scanner input = new Scanner(System.in);
    Menu menu;

    /**
     * The game is played with this method. It builds the menu and displays it
     * to the user.
     *
     * @author Chris Valko (cjv5110)
     */
    public void play() {

        playerList.enterPlayer();

        menu = new Menu("        -= Wheel Of Fortune =-");

        MenuChoice choiceSpinWheel = new MenuChoice("Spin the wheel");
        MenuChoice choiceBuyVowel = new MenuChoice("Buy a vowel");
        MenuChoice choiceSolvePuzzle = new MenuChoice("Solve the puzzle");
        MenuChoice choiceHelp = new MenuChoice("Help");
        MenuChoice choiceQuit = new MenuChoice("Quit");

        menu.addMenuChoice(choiceSpinWheel);
        menu.addMenuChoice(choiceBuyVowel);
        menu.addMenuChoice(choiceSolvePuzzle);
        menu.addMenuChoice(choiceHelp);
        menu.addMenuChoice(choiceQuit);

        Letter letter = new Letter();
        Puzzle puzzle = menu.getPuzzle();
        MenuChoice option = null;
        String score = "";

        while (option != choiceQuit) {
            option = menu.displayAndChoose(playerList);
            if (option == choiceSpinWheel) {
                score = playerChoseSpinWheel(choiceSpinWheel);
                if (score.equals("Lose a turn")) {

                } else if (score.equals("Bankrupt")) {
                    getPlayer().setScore(0);
                } else {

                    puzzle.readLetter(playerList.getPlayers().get(0), score, "consonant");
                }

            } else if (option == choiceBuyVowel) {
                System.out.println("You chose " + choiceBuyVowel.getText());

                playerChoseBuyVowel(letter, puzzle, score);

            } else if (option == choiceSolvePuzzle) {
                System.out.println("You chose " + choiceSolvePuzzle.getText());
                playerChoseSolve();
            } else if (option == choiceHelp) {
                playerChoseHelp();
            }

        }
        System.out.println("You chose Quit");
    }

    /**
     * Player spins the wheel
     *
     * @param choiceSpinWheel
     * @author Chris Valko (cjv5110)
     */
    private String playerChoseSpinWheel(MenuChoice choiceSpinWheel) {
        System.out.println("You chose " + choiceSpinWheel.getText());
        //return random wedge from wedge class
        Wheel wheel = new Wheel();
        Wedge wheelObject = wheel.spin();

        if (wheelObject.getWedgeString().equals("LOSE A TURN")) {

            System.out.println("You have lost a turn LOSER");
            return "Lose a turn";

        } else if (wheelObject.getWedgeString().equals("BANKRUPT")) {

            System.out.println("BANKRUPT");
            getPlayer().setScore(0);
            return "Bankrupt";

        } else {
            System.out.println("You landed on $" + wheelObject.getWedgeString());
            return wheelObject.getWedgeString();

        }

    }

    /**
     * Player buys a vowel
     *
     * @param letter
     * @author Chris Valko (cjv5110)
     */
    private void playerChoseBuyVowel(Letter letter, Puzzle puzzle, String score) {

        if (letter.checkNumOfVowelsGuessed() == true) {

            if (playerScore() >= 0) {

                getPlayer().setScore(playerScore() - 250);
                //guessVowel = userVowelInput(guessVowel, letter);
                puzzle.readLetter(playerList.getPlayers().get(0), score, "vowel");

            } else {
                System.out.println("You don't have enough money to buy a vowel");
            }
        }
    }

    private String userVowelInput(String guessVowel, Letter letter) {
        boolean isVowel;
        do {

            System.out.println("Guess a Vowel");
            guessVowel = input.nextLine();
            isVowel = letter.isVowel(guessVowel);

        } while (letter.getVowelsGuessed().contains(guessVowel) || isVowel == false);
        return guessVowel;
    }

    /**
     * Player chooses help
     *
     * @author Chris Valko (cjv5110)
     */
    private void playerChoseHelp() {
        try {
            Help.readHelpInstructionsFromFile();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * handles the option of solving the puzzle
     *
     * @author David Chen (dkc5318@psu.edu)
     */
    private void playerChoseSolve() {
        System.out.print("Solve the puzzle: ");
        if (menu.getPuzzleString().equalsIgnoreCase(input.nextLine())) {
            System.out.printf("You are correct!\n"
                    + "You won $%d!", playerScore());
        } else {
            System.out.printf("You are incorrect!\n"
                    + "The puzzle was:  %s\n"
                    + "So you get NOTHING!"
                    + "  You LOSE!  Good DAY, sir!", menu.getPuzzleString());
        }
        System.exit(0);
    }

    /**
     * Returns the player score
     *
     * @return playerList.getPlayers().get(0).getScore()
     * @author Chris Valko (cjv5110)
     */
    private int playerScore() {
        return playerList.getPlayers().get(0).getScore();
    }

    /**
     * Returns player score plus what they have won in their turn
     *
     * @param wheelObject
     * @return getPlayer().getScore() +
     * Integer.parseInt(wheelObject.getWedgeString())
     * @throws NumberFormatException
     * @author Chris Valko (cjv5110)
     */
    private int addWedgeToPlayerScore(Wedge wheelObject) throws NumberFormatException {
        return getPlayer().getScore() + Integer.parseInt(wheelObject.getWedgeString());
    }

    /**
     * Gets the player
     *
     * @return playerList.getPlayers().get(0)
     * @author Chris Valko (cjv5110)
     */
    private Player getPlayer() {
        return playerList.getPlayers().get(0);
    }

}
