/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Scanner;

/**
 * Deals with player information
 *
 * @author David Chen (dkc5318@psu.edu)
 */
public class InitializePlayer {

    private final List<Player> players;
    private static Scanner keyboard = new Scanner(System.in);

    /**
     * Constructor, accepting any initial values.
     *
     * @author David Chen (dkc5318@psu.edu)
     * @param players list of players
     */
    public InitializePlayer(List<Player> players) {
        this.players = players;
    }

    /**
     * Allow the user to enter their name into the list.
     *
     * @author David Chen (dkc5318@psu.edu)
     */
    public void enterPlayer() {
        Player player = new Player();
        setPlayerInfo(player);
        this.players.add(player);
    }

    /**
     * Prompts and adds user information for account into storage.
     *
     * @param player player class
     * @author David Chen (dkc5318@psu.edu)
     */
    private void setPlayerInfo(Player player) {
        String name = validateUserInput("your name");
        player.setName(name);
        player.setScore(1000);
        this.players.add(player);

        System.out.println("Thank you for registering");
    }

    /**
     * Prompt user for input, read it, and return it.
     *
     * @param subject what to ask of user
     * @return valid user input
     * @author David Chen (dkc5318@psu.edu)
     */
    private String validateUserInput(String subject) {
        System.out.print("Enter " + subject + ": ");
        String input = this.keyboard.nextLine().trim();
        while (!isBlank(input)) {
            System.out.println("Error: Cannot be blank");
            System.out.print("Enter " + subject + ": ");
            input = this.keyboard.nextLine().trim();
        }
        return input;
    }

    /**
     * Validate a given input
     * <p>
     * Inputs are not allowed to be blank
     *
     * @param input the name to be validated
     * @return true if valid
     * @author Phil O'Connell (pxo4@psu.edu)
     * @author David Chen (dkc5318@psu.edu)
     */
    static boolean isBlank(String input) {
        return (input != null && !input.trim().equals(""));
    }

    /**
     * For other classes to get the list
     *
     * @return players existing list
     * @author David Chen (dkc5318@psu.edu)
     */
    public List<Player> getPlayers() {
        return this.players;
    }

}
