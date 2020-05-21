/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Phil
 * @author Iljaz Tabaku (ijt5038@psu.edu)
 */
public class Puzzle {

    private List<Letter> _letters = new ArrayList<>();
    private List<String> _guessedLetters = new ArrayList<>();
    //private String _puzzleText[] = {"PENN STATE ABINGTON", "ANOTHER PUZZLE", "I DONT UNDERSTAND"};
    //String pulling information from the derby database to populate it when called instead of the hard coded ones form before.
    private static List<String> _puzzleText = (Database.Database.getAllPuzzles());
    private static List<String> _vowels = Arrays.asList("A", "E", "I", "O", "U");

    private static String _puzzleString = "";

    /**
     * Sets random puzzle and changes string to an array
     */
    public Puzzle() {
        Random random = new Random();
        int puzzleIndex = random.nextInt(_puzzleText.size());
        _puzzleString = _puzzleText.get(puzzleIndex);
        for (char letter : _puzzleText.get(puzzleIndex).toCharArray()) {
            _letters.add(new Letter(Character.toString(Character.toUpperCase(letter))));
        }
    }

    /**
     * Gets letter for other classes to use
     *
     * @return letter
     */
    public List<Letter> getLetters() {
        return _letters;
    }

    public List<String> getGuessedLetters() {
        return _guessedLetters;
    }

    //Checks if the letter is in the puzzle or not.
    public static boolean isLetterInPuzzle(String letter) {
        return _puzzleString.toUpperCase().contains(letter);
    }

    /**
     * get the puzzle unformatted
     *
     * @return
     * @author David
     */
    public String getPuzzleString() {
        return this._puzzleString;
    }

    public String readLetter(Player player, String score, String letterType) {

        Scanner scan = new Scanner(System.in);

        String userInput = "";
        //While loop which checks if users input is more than 1 and contains a character between letters A to Z.
        //If it doesn't contain more than one character and contains a letter between A-Z then itll display that letter.

        if (letterType.equals("consonant")) {

            while (userInput.length() < 1 || !(userInput.matches("[A-Z]"))) {
                System.out.println("Please Enter a Letter: ");
                userInput = scan.nextLine().toUpperCase().trim();

                while (_vowels.contains(userInput)) {
                    System.out.println("That is a vowel. Try again");
                    userInput = scan.nextLine().toUpperCase().trim();
                }

                if (isLetterInPuzzle(userInput)) {
                    System.out.println("You got one");
                    player.setScore(player.getScore() + Integer.parseInt(score));
                    _guessedLetters.add(userInput);

                } else {
                    System.out.println("You guessed wrong");
                }
            }
        } else {
            while (userInput.length() < 1 || !(userInput.matches("[A-Z]"))) {
                System.out.println("Please Enter a Letter: ");
                userInput = scan.nextLine().toUpperCase().trim();

                while (!_vowels.contains(userInput)) {
                    System.out.println("That is not a vowel. Try again");
                    userInput = scan.nextLine().toUpperCase().trim();
                }

                if (isLetterInPuzzle(userInput)) {
                    System.out.println("You got one");
                    //player.setScore(player.getScore() + Integer.parseInt(score));
                    _guessedLetters.add(userInput);

                } else {
                    System.out.println("You guessed wrong");
                }
            }
        }
        System.out.println("The letter you guessed is: " + userInput);
        return userInput;
    }

}
