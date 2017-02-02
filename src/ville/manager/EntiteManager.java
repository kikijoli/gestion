/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.manager;

import java.awt.Point;
import java.util.ArrayList;
import ville.Entite.Entite;
import ville.Entite.Personnage.Personnage;
import ville.auto.AllerRetour;
import ville.auto.AllerPath;
import ville.ui.Case;
import ville.ui.Menu;

/**
 *
 * @author admin
 */
public class EntiteManager {

    public final static ArrayList<Entite> entites = new ArrayList<>();
    public static boolean showMenu;
    public static Menu menu;

    static {
        entites.add(GameManager.joueur);
    }

    public static ArrayList<Entite> getEntites() {
        return (ArrayList<Entite>) entites.clone();
    }

    public static void gestionAuto() {

        for (Entite entite : getEntites()) {
            if (entite instanceof Personnage) {
                ((Personnage) entite).auto();
            }
        }
    }

    public static void addEntite(Entite entite) {

        Case c = GrilleManager.getCaseFor(entite);
        EntiteManager.entites.add(entite);
    }

    public static boolean isIntersectSomething(Entite currentEntite) {
        return getEntites().stream().anyMatch((entite) -> (entite != currentEntite && currentEntite.intersects(entite)));
    }

    public static Entite getEntiteHover(Point p) {
        for (Entite entite : getEntites()) {
            if (entite.contains(p)) {
                return entite;
            }
        }
        return null;
    }

    public static boolean moveTo(Entite e, Case c) {
        for (int i = 0; i < e.vitesse; i++) {
            e.x += e.x < c.x + c.width / 2 ? 1 : e.x == c.x + c.width / 2 ? 0 : (-1);
            e.y += e.y < c.y + c.height / 2 ? 1 : e.y == c.y + c.height / 2 ? 0 : (-1);
        }
        return e.intersects(c);
    }

    public static void remove(Entite entite) {
        if (entite == null) {
            return;
        }
        EntiteManager.entites.remove(entite);
        entite.onRemove();

    }

    public static void clickOrDrag() {
        GameManager.joueur.path = GrilleManager.getPath(GrilleManager.getCaseFor(GameManager.joueur), GrilleManager.getCaseHover());
        if (GameManager.joueur.path != null) {
            GameManager.joueur.currentAuto = new AllerPath(GameManager.joueur);
        }
    }

    public static void showMenu(Entite e) {

//        menu = new Menu(e.getLocation().x, e.getLocation().y, 150, 20);
//        if (e instanceof Batiment) {
//            EntiteManager.showMenu = true;
//            menu.items.add(new MenuItem(new Action("Changer le chemin") {
//                @Override
//                public void action() {
//                    ((Batiment) e).onPlace(GrilleManager.getCaseFor(e));
//
//                }
//            }, e.getLocation().x, e.getLocation().y, 150, 20));
//        }
    }

}
