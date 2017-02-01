/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Batiment;

import java.awt.Color;
import ville.manager.GrilleManager;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class Maison extends Batiment {

    public Maison(int x, int y) {
        super(Color.red, x, y, GrilleManager.getCellWidth(), GrilleManager.getCellHeight());
    }

    @Override
    public void onPlace(Case c) {

    }

    @Override
    public void onRemove(Case c) {
    }

    @Override
    public void onSelect() {
    }

}
