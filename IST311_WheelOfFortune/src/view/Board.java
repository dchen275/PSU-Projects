/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import model.Letter;
import model.Puzzle;

/**
 *
 * @author David Chen (dkc5318@psu.edu)
 */
public class Board {

    StringBuilder sb = new StringBuilder();
    List<Letter> letters;
    List<String> guessedLetters;
    /**
     * Gets puzzle set from puzzle class and formats
     *
     * @param puzzle from puzzle class
     * @author David Chen (dkc5318@psu.edu)
     */
    public Board(Puzzle puzzle) {
        letters = puzzle.getLetters();
        guessedLetters = puzzle.getGuessedLetters();
        for (Letter l : letters) {

            // If true then proceed else : set
            String letter = l.getIsGuessed(guessedLetters) ? l.getLetter() : "_";

            this.sb.append(letter + " ");
        }
    }

    /**
     * Formats puzzle to display
     *
     * @author David Chen (dkc5318@psu.edu)
     */
    public void display() {
        System.out.println(this.sb.toString());
        System.out.println();
    }
    
    public String formattedPuzzleString() {
        return this.sb.toString();
    }
}
