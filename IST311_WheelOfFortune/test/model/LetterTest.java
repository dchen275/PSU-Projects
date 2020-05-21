/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author christophervalko
 */
public class LetterTest {

    private Letter letter;

    @Before
    public void setUp() {
        letter = new Letter();
    }

    @Test
    public void numberOfGuessedVowels5() {
        letter.addToVowelsGuessed("A");
        letter.addToVowelsGuessed("E");
        letter.addToVowelsGuessed("O");
        letter.addToVowelsGuessed("U");
        letter.addToVowelsGuessed("I");
        assertEquals(letter.numberOfGuessedVowels(), 5);
    }

    @Test
    public void numberOfGuessedVowelsMoreThan5() {
        letter.addToVowelsGuessed("A");
        letter.addToVowelsGuessed("E");
        letter.addToVowelsGuessed("O");
        letter.addToVowelsGuessed("U");
        letter.addToVowelsGuessed("I");
        assertNotEquals(letter.numberOfGuessedVowels(), 6);
    }

    @Test
    public void addAnotherVowelAfterAllVowelsGuessed() {
        letter.addToVowelsGuessed("A");
        letter.addToVowelsGuessed("E");
        letter.addToVowelsGuessed("O");
        letter.addToVowelsGuessed("U");
        letter.addToVowelsGuessed("I");
        assertFalse(letter.checkNumOfVowelsGuessed());
    }
}
