/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.manager;

import java.util.ArrayList;
import ville.Entite.Personnage.Joueur;
import ville.Entite.Personnage.Personnage;
import ville.Resource.Resource;
import ville.ui.Bulle;
import ville.ui.Fleche;

/**
 *
 * @author admin
 */
public class GameManager {

    public static int or = 0;
    public static int pv = 3;
    public static ArrayList<Bulle> bulles = new ArrayList<Bulle>();
    public static Joueur joueur = new Joueur(100, 100);
    public static ArrayList<Fleche> fleches = new ArrayList<>();

    public static Fleche getFleche() {

        if (fleches.isEmpty()) {
            fleches.add(new Fleche(Resource.getImage("up"), 38));
            fleches.add(new Fleche(Resource.getImage("down"), 40));
            fleches.add(new Fleche(Resource.getImage("left"), 37));
            fleches.add(new Fleche(Resource.getImage("right"), 39));
        }
        return fleches.get((int) (Math.random() * fleches.size()));
    }

    public static void addBulle(Personnage personnage, Fleche fleche) {
        bulles.add(new Bulle(fleche, personnage, personnage.x + (int) (Math.random() * 10), personnage.y - 50));
    }

    public static void gestionBulle() {
        ArrayList<Bulle> remove = new ArrayList<>();
        for (Bulle bulle : getBulles()) {
            for (Bulle b : getBulles()) {

                if (b != bulle && b.intersects(bulle)) {
                    b.x += bulle.x < b.x ? 3 : (-3);
                }
            }
            if (bulle.fini) {
                if (!bulle.accompli) {
                    GameManager.pv -= 1;
                }
                remove.add(bulle);
            }
        }

        bulles.removeAll(remove);
    }

    public static ArrayList<Bulle> getBulles() {
        return (ArrayList<Bulle>) bulles.clone();
    }
}
