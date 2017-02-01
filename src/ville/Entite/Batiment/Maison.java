/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Batiment;

import java.awt.Color;
import ville.Entite.Personnage.Habitant;
import ville.Entite.Personnage.Marchand;
import ville.manager.EntiteManager;
import ville.manager.GrilleManager;
import ville.manager.UI;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class Maison extends Batiment {

    public Habitant habitant;

    public Maison(int x, int y) {
        super(Color.red, x, y, GrilleManager.getCellWidth(), GrilleManager.getCellHeight());
    }

    @Override
    public void onPlace(Case c) {
        if (this.habitant == null) {
            this.habitant = new Habitant(x, y, this);
            EntiteManager.entites.add(this.habitant);
        }
        UI.modePath = true;
        GrilleManager.debut = c;
        EntiteManager.entiteToPath = habitant;
        for (Case[] grille : GrilleManager.getGrille()) {
            for (Case grille1 : grille) {
                if (grille1.intersects(this)) {
                    grille1.state = true;
                }
            }
        }
    }

    @Override
    public void onRemove(Case c) {
    }

}
