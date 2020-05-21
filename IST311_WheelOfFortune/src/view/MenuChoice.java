/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * MenuChoice POJO for Menu Choices
 * @author christophervalko
 */
public class MenuChoice {
    
    private String _text;
    
    /**
     * @author Chris Valko (cjv5110@psu.edu)
     * @param text 
     */
    public MenuChoice(String text){
        this._text = text;
    }
    /**
     * @author Chris Valko (cjv5110@psu.edu) "NetBeans"
     * @param _text the _text to set
     */
    public void setText(String _text) {
        this._text = _text;
    }

    /**
     * @author Chris Valko (cjv5110@psu.edu) "NetBeans"
     * @return the _text
     */
    public String getText() {
        return _text;
    }
    
}
