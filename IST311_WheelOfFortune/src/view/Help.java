/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author christophervalko
 */
public class Help {

    
    /**
     * Read 
     * 
     * @author Christopher Valko (cjv5110@psu.edu) 
     * @throws FileNotFoundException 
     */
    public static void readHelpInstructionsFromFile() throws FileNotFoundException {
        String currentDir = System.getProperty("user.dir");
        File file = new File(currentDir + "/src/Utility/helpfile.txt");
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\Z");
        System.out.println(sc.next());
    }
}
