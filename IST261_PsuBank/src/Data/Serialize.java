package Data;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serialize {
    private static Logger _logger = Logger.getLogger("ist261");

    /**
     * writes the user's data to .xml file
     *
     * @author Jacob Hale (jwh6040@psu.edu)
     * @author
     */
    public void saveData(List<User> user, String filepath) {
        try {
            _logger.log(Level.INFO, "Attempting to save data");
            FileOutputStream fos = new FileOutputStream(filepath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(user);
            oos.close();
            fos.close();
        } catch (IOException ex) {
            _logger.log(Level.WARNING, "Failed to save data");
            System.out.println(ex.toString());
            System.out.println(filepath);
        }
    }

    /**
     * reads the user's data from an.xml file
     *
     * @author Jacob Hale (jwh6040@psu.edu)
     */
    public List<User> loadData(String filePath) {
        List<User> user = null;

        try {
            _logger.log(Level.INFO, "Attempting to save data");
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            user = (List<User>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            _logger.log(Level.WARNING, "Failed to load data");
            System.out.println(e.toString());
            System.out.println(filePath);
        }
        return user;
    }
}