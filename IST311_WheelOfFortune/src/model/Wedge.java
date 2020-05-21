/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * POJO for Wedge class
 * @author christophervalko
 */
public class Wedge {

    private String wedge;

    /**
     * Constructor for Wedge class
     * @author Christopher Valko (cjv5110@psu.edu)
     * @param wedgeString 
     */
    public Wedge(String wedgeString) {
        this.wedge = wedgeString;
    }

    /**
     * @author Christopher Valko (cjv5110@psu.edu)
     * @return the wedgeString
     */
    public String getWedgeString() {
        return wedge;
    }

    /**
     * @author Christopher Valko (cjv5110@psu.edu)
     * @param wedgeString the wedgeString to set
     */
    public void setWedgeString(String wedgeString) {
        this.wedge = wedgeString;
    }

}
