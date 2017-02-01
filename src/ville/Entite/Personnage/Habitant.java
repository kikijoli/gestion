/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Personnage;

import java.awt.Color;
import java.util.ArrayList;
import ville.Entite.Batiment.Batiment;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class Habitant extends Personnage {

    public Habitant(Color color, int x, int y, int width, int height, Batiment bat) {
        super(color, x, y, width, height, bat);
        this.maxPath = 30;
        this.vitesse = 1;
    }

    @Override
    public void onPlace(Case c) {
    }

    @Override
    public void onRemove(Case c) {
    }

    @Override
    public void auto() {
        if (currentAuto == null) {
            return;
        }
        currentAuto.auto();
    }

    @Override
    public void setPath(ArrayList<Case> path) {
    }

}
