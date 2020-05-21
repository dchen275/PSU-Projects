/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dchen
 */
public class Letter {

    private String _letter = "";
    private boolean _isGuessed = false;
    private final List<String> _vowels = Arrays.asList("A", "E", "I", "O", "U");
    private final List<String> _vowelsGuessed = new ArrayList();

    /**
     * Goes through letters in puzzle and checks for guessed or not
     *
     * @param letter
     * @author David Chen (dkc5318@psu.edu)
     */
    public Letter(String letter) {
        _letter = letter;
        if (_letter.equals(" ")) {
            _isGuessed = true;
        } 
    }

    /**
     * Constructor
     */
    public Letter() {

    }

    /**
     * For other classes to know if a letter was guessed or not
     *
     * @return guessed t/f
     * @author David Chen (dkc5318@psu.edu)
     */
    public boolean getIsGuessed(List<String> guessedLetters) {
        if (_letter.equals(" ")) {
            return true;
        } else if (isVowelGuessed()) {
            return true;
        } else if (isConsonetGuessed(guessedLetters)) {
            return true;
        }
        return false;
    }

    /**
     * Gets the letter for other classes to use
     *
     * @return letter
     * @author David Chen (dkc5318@psu.edu)
     */
    public String getLetter() {
        return _letter;
    }

    /**
     * Adds vowel to _vowelsGuessed array
     *
     * @param vowelGuessed
     * @author Chris Valko (cjv5110@psu.edu)
     */
    public void addToVowelsGuessed(String vowelGuessed) {
        if (_vowels.contains(vowelGuessed.toUpperCase())) {
            this._vowelsGuessed.add(vowelGuessed);
        }
    }

    /**
     * Checks how many vowels the user guessed
     *
     * @return numberOfGuessedVowels() < 5
     * @author Chris Valko (cjv5110@psu.edu)
     */
    public boolean checkNumOfVowelsGuessed() {
        return numberOfGuessedVowels() < 5;
    }

    /**
     * Checked if input is a vowel in the _vowels array
     *
     * @param letter
     * @return _vowels.contains(letter.toUpperCase())
     * @author Chris Valko (cjv5110@psu.edu)
     */
    public boolean isVowel(String letter) {
        return _vowels.contains(letter.toUpperCase());
    }

    /**
     * Gets number of vowels in _vowelsGuessed array
     *
     * @return _vowelsGuessed.size()
     * @author Chris Valko (cjv5110@psu.edu)
     */
    public int numberOfGuessedVowels() {
        return this._vowelsGuessed.size();
    }

    /**
     * Returns _vowelsGuessed array
     *
     * @return the _vowelsGuessed
     * @author Chris Valko (cjv5110@psu.edu)
     */
    public List<String> getVowelsGuessed() {
        return this._vowelsGuessed;
    }

    public boolean isVowelGuessed() {
        for (String vowel : this._vowelsGuessed) {
            if (_letter.equalsIgnoreCase(vowel)) {
                return true;
            }
        }
        return false;
    }

    public boolean isConsonetGuessed(List<String> guessedLetters) {
        if (guessedLetters != null) {

            for (String consonet : guessedLetters) {
                if (_letter.equals(consonet)) {
                    return true;
                }
            }
        }
        return false;
    }
}
