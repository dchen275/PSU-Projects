/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Player information format
 *
 * @author Phil
 */
public class Player {

    private String name;
    private int score;

    /**
     * To set the name
     *
     * @param name
     * @author David Chen (dkc5318@psu.edu)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * To set the score
     *
     * @param score
     * @author David Chen (dkc5318@psu.edu)
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * To get the name
     *
     * @return name
     * @author David Chen (dkc5318@psu.edu)
     */
    public String getName() {
        return name;
    }

    /**
     * To get the score
     *
     * @return score
     * @author David Chen (dkc5318@psu.edu)
     */
    public int getScore() {
        return score;
    }

}
