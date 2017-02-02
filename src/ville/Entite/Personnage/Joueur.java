/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Personnage;

import java.awt.Color;
import ville.manager.GrilleManager;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class Joueur extends Personnage {

    public Joueur(int x, int y) {
        super(Color.BLUE, x, y, GrilleManager.getCellWidth(), GrilleManager.getCellHeight());
    }

    @Override
    public void onRemove(Case c) {
    }
}
