/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.manager;

import ville.Entite.Personnage.Joueur;

/**
 *
 * @author admin
 */
public class GameManager {

    public static int or;
    public static int pv = 3;
    
    public static Joueur joueur = new Joueur(100, 100);
    public static String letters = "0123456789RFTGAE";

    public static String getLetter() {
        char c = letters.charAt((int) (Math.random() * letters.length()));
        return new Character(c).toString().toUpperCase();
    }
}
