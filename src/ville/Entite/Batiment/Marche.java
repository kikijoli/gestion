/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Batiment;

import java.awt.Color;
import ville.Entite.Personnage.Marchand;
import ville.manager.EntiteManager;
import ville.manager.GrilleManager;
import ville.manager.UI;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class Marche extends Batiment {

    public Marchand marchand;

    public Marche(int x, int y) {
        super(Color.blue, x, y, GrilleManager.getCellWidth() * 2, GrilleManager.getCellHeight() * 2);

    }

    @Override
    public void onPlace(Case c) {
        if (this.marchand == null) {
            this.marchand = new Marchand(x, y, this);
            EntiteManager.entites.add(this.marchand);
        }
        UI.modePath = true;
        GrilleManager.debut = GrilleManager.getCaseHover();
        EntiteManager.entiteToPath = marchand;
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

    @Override
    public void onSelect() {
        if (select) {
            EntiteManager.showMenu(this);
        }
    }

}
