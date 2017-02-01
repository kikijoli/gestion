/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.manager;

import ville.util.Util;
import java.awt.Point;
import java.util.ArrayList;
import ville.Entite.Batiment.Batiment;
import ville.Entite.Entite;
import ville.Entite.Personnage.Personnage;
import ville.Entite.Route.Route;
import ville.ui.Case;
import ville.ui.Menu;
import ville.ui.MenuItem;
import ville.ui.Panneau;
import ville.util.Action;

/**
 *
 * @author admin
 */
public class EntiteManager {

    public static ArrayList<Entite> entites = new ArrayList<>();
    public static Entite currentEntite;
    public static boolean isBonEmplacement = false;
    public static boolean pelleMode = false;
    public static Personnage entiteToPath;
    public static boolean showMenu;
    public static Menu menu;

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
        if (!isIntersectSomething(entite)) {
            Case c = GrilleManager.getCaseFor(entite);
            EntiteManager.entites.add(entite);
            entite.onPlace(c);
            if (!(entite instanceof Route)) {
                currentEntite = null;
            }
        }
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
        e.x += e.x < c.x ? 1 : (-1);
        e.y += e.y < c.y ? 1 : (-1);
        return e.intersects(c);
    }

    public static void activePelle() {
        EntiteManager.currentEntite = null;
        EntiteManager.pelleMode = true;
    }

    public static void remove(Entite entite) {
        if (entite == null) {
            return;
        }
        EntiteManager.entites.remove(entite);
        Case c = GrilleManager.getCaseFor(entite);
        entite.onRemove(c);
        if (entite instanceof Route) {
            EntiteManager.validatePath(entite);
        }
    }

    public static void setCurrentEntite(Entite entite) {
        currentEntite = entite;
        pelleMode = false;
    }

    public static void clickOrDrag() {
        if (EntiteManager.currentEntite != null) {
            EntiteManager.addEntite((Entite) Util.deepClone(EntiteManager.currentEntite));
        } else if (EntiteManager.currentEntite == null) {

            for (Entite entite : getEntites()) {
                entite.select = entite.hover;
                if (entite instanceof Batiment && entite.select) {
                    showMenu = true;
                    ((Batiment) entite).onSelect();
                }

            }

        } else if (EntiteManager.pelleMode) {
            Entite entite = EntiteManager.getEntiteHover(Panneau.selection.getLocation());
            EntiteManager.remove(entite);
        }
    }

    public static void validatePath(Entite entite) {
        if (entite == null) {
            return;
        }
        for (Entite en : getEntites()) {
            boolean pathValide = true;
            if (en instanceof Personnage) {
                if (((Personnage) en).path == null) {
                    continue;
                }
                for (Case path : ((Personnage) en).path) {
                    if (path.intersects(entite)) {
                        pathValide = false;
                        break;
                    }
                }
                if (!pathValide) {
                    ((Personnage) en).path = null;
                    en.setLocation(((Personnage) en).batiment.getLocation());
                }
            }

        }
    }

    public static void clickPath() {
        if (GrilleManager.path == null || GrilleManager.path.isEmpty()) {
            return;
        }
        if (EntiteManager.entiteToPath != null && GrilleManager.fin != null) {
            GrilleManager.debut = null;
            GrilleManager.fin = null;
            ArrayList<Case> newPath = new ArrayList<>();
            if (GrilleManager.path.size() > entiteToPath.maxPath) {
                GrilleManager.path.subList(0, entiteToPath.maxPath).stream().forEach((c) -> {
                    newPath.add(c);
                });
            } else {
                newPath.addAll(GrilleManager.path);
            }
            EntiteManager.entiteToPath.setPath(newPath);
            GrilleManager.path = null;

        }
    }

    private static Personnage getEntiteFromBatiment(Batiment bat) {
        for (Entite entite : getEntites()) {
            if (entite instanceof Personnage) {
                if (((Personnage) entite).batiment == bat) {

                    return (Personnage) entite;
                }
            }
        }
        return null;
    }

    public static void showMenu(Entite e) {

        menu = new Menu(e.getLocation().x, e.getLocation().y, 200, 50);
        if (e instanceof Batiment) {
            EntiteManager.showMenu = true;
            menu.items.add(new MenuItem(new Action("Changer le chemin") {
                @Override
                public void action() {
                    ((Batiment) e).onPlace(GrilleManager.getCaseHover());
                }
            }, e.getLocation().x, e.getLocation().y, 200, 50));
        }
    }

}
