/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Personnage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import ville.Entite.Batiment.Batiment;
import ville.auto.AllerRetour;
import ville.manager.GrilleManager;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class Habitant extends Personnage {

    public Habitant(int x, int y, Batiment bat) {
        super(Color.RED, x, y, GrilleManager.getCellWidth() / 2, GrilleManager.getCellHeight() / 2, bat);
        this.maxPath = 30;
        this.vitesse = 1;
    }

    @Override
    public void onPlace(Case c) {

    }

    @Override
    public void onRemove(Case c) {
    }

}
