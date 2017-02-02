/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Resource;

import java.awt.Image;
import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author troïmaclure
 */
public class Resource {

    public static Hashtable<String, Image> images = new Hashtable<>();

    public static Image getImage(String name) {
        if (!images.containsKey(name)) {
            try {
                images.put(name, ImageIO.read(Resource.class.getResource(name + ".png")));
            } catch (IOException ex) {
                Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return images.get(name);
    }
}
