/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.manager;

import java.awt.Rectangle;
import java.util.ArrayList;
import ville.Entite.Entite;
import static ville.Ville.fenetre;
import ville.ui.Case;
import ville.ui.Panneau;
import ville.util.PathFinder;
import ville.util.PathFinder.Search;

/**
 *
 * @author admin
 */
public class GrilleManager {

    public static Case[][] grille;
    public static int ROWCOUNT = 50;
    public static int COLUMNCOUNT = 50;
    public static Case debut;
    public static Case fin;
    public static ArrayList<Case> path = new ArrayList<>();

    public static void refreshGrille() {
        grille = new Case[COLUMNCOUNT][ROWCOUNT];
        int width = getCellWidth();
        int height = getCellHeight();

        for (int i = 0; i < COLUMNCOUNT; i++) {
            for (int j = 0; j < ROWCOUNT; j++) {
                grille[i][j] = (new Case(i, j, i * width, j * height, width, height));
            }
        }
    }

    public static Case[][] getGrille() {
        return (Case[][]) grille.clone();
    }

    static Case getCaseFor(Entite entite) {
        if (entite != null) {
            for (Case[] grille1 : grille) {
                for (Case g : grille1) {
                    if (g.intersects(entite)) {
                        return g;
                    }
                }

            }
        }
        return null;
    }

    public static int getCellWidth() {
        if (fenetre == null) {
            return 0;
        }
        if (fenetre.panneau == null) {
            return 0;
        }
        return fenetre.panneau.getWidth() / COLUMNCOUNT;
    }

    public static int getCellHeight() {
        if (fenetre == null) {
            return 0;
        }
        if (fenetre.panneau == null) {
            return 0;
        }

        return fenetre.panneau.getHeight() / ROWCOUNT;
    }

    public static Case getCaseHover() {
        for (Case[] grille1 : grille) {
            for (Case g : grille1) {
                if (g.contains(Panneau.selection)) {
                    return g;
                }
            }
        }
        return null;
    }

    public static ArrayList<Case> getPath(Case debut, Case fin) {
        try {
            if (debut == null || fin == null) {
                return new ArrayList<>();
            }
            ArrayList<Search> searchs = new PathFinder().getPathFor(debut, fin);
            ArrayList<Case> cases = new ArrayList<>();
            if (searchs != null) {
                searchs.stream().forEach((search) -> {
                    cases.add(search.c);
                });
            }
            return cases;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
