/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.animation;

import java.awt.Image;
import java.util.Hashtable;
import ville.Resource.Resource;

/**
 *
 * @author troïmaclure
 */
public class Animation {

    public static String PVPERDU = "Worried";
    public static Hashtable<String, Image> animations = new Hashtable<>();

    public static Animation getAnimation(String name) {
        if (!animations.containsKey(name)) {
            animations.put(name, Resource.getImage(name));
        }
        return new Animation(animations.get(name), name, 20);
    }

    public Image image;
    public String name;
    public int compteur;

    public Animation(Image image, String name, int compteur) {
        this.image = image;
        this.name = name;
        this.compteur = compteur;
    }

}
