/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.manager;

import java.awt.Point;
import java.util.ArrayList;
import ville.Entite.Personnage.Personnage;
import ville.ui.Bulle;

/**
 *
 * @author admin
 */
public class UI {

    public static Point cursor = new Point(0, 0);
    public static boolean modePath = false;
    public static ArrayList<Bulle> bulles = new ArrayList<Bulle>();

    public static void addBulle(Personnage personnage, String letter) {
        bulles.add(new Bulle(letter, personnage, personnage.x + (int) (Math.random() * 10), personnage.y - 50));
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
