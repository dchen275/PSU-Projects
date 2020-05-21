/*
 * Course: IST 261
 * Semester: Fall 2018
 * Instructor: Phil O'Connell (pxo4)
 * Student: Jacob Hale, David Chen, Brian Young, Andrew Kim
 * Email: jwh6040@psu.edu, dkc5318@psu.edu, bmy5076@psu.edu, ayk5533@psu.edu
 * Assignment: Banking Application
 */

package Display;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuChoice {
    private String _text;
    private static Logger _logger = Logger.getLogger("ist261");

    /**
     * Constructor, accepting any initial values
     *
     * @param text choice text
     * @author Phil O'Connell (pxo4@psu.edu)
     * @author Brian Young (bmy5076@psu.edu)
     */
    public MenuChoice(String text) {
        _text = text;
    }

    /**
     * Getter for the choice's text
     *
     * @return Text to be shown on the menu
     * @author Phil O'Connell (pxo4@psu.edu)
     * @author Brian Young (bmy5076@psu.edu)
     */
    String getText() {
        _logger.log(Level.CONFIG, "Getting text");
        return _text;
    }
}