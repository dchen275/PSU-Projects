/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Random;
import model.Wedge;

/**
 * Class for spinning the game wheel
 * @author Christopher Valko (cjv5110@psu.edu)
 */
public class Wheel {

    String[] wheelReturn = new String[]{"5000", "600", "500", "300", "500", "800", "550", "400", "300", "900", "300", "900",
        "BANKRUPT", "600", "400", "300", "LOSE A TURN", "800", "350", "450", "700", "300", "600"};

    /**
     * Empty constructor for wheel
     * @author Christopher Valko (cjv5110@psu.edu)
     */
    public Wheel() {
    }

    /**
     * Method to spin the wheel and returns a random wedge
     * @return Wedge
     * @author Christopher Valko (cjv5110@psu.edu)
     */
    public Wedge spin() {

        Random random = new Random();
        int index = random.nextInt(wheelReturn.length);

        return new Wedge(wheelReturn[index]);
    }
    public boolean isWedgeInList(String wedgeString){
        for (int i=0; i<wheelReturn.length; i++){
            if (wheelReturn[i].equals(wedgeString)){
                return true;
            }
        }
        return false;
    }
}
