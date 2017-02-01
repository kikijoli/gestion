/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Personnage;

import java.awt.Color;
import ville.Entite.Batiment.Batiment;
import ville.manager.GrilleManager;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class Marchand extends Personnage {

    public Marchand(int x, int y, Batiment bat) {
        super(Color.BLUE, x, y, GrilleManager.getCellWidth() / 2, GrilleManager.getCellHeight() / 2, bat);
        this.maxPath = 12;
        this.vitesse = 2;
    }

    @Override
    public void onPlace(Case c) {
    }

    @Override
    public void onRemove(Case c) {
        this.currentAuto = null ; 
    }

}
