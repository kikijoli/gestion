/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Route;

import java.awt.Color;
import ville.manager.GrilleManager;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class Chemin extends Route {

    public Chemin(int x, int y) {
        super(Color.gray, x, y, GrilleManager.getCellWidth(), GrilleManager.getCellHeight());
    }

    @Override
    public void onPlace(Case c) {
        super.onPlace(c);
    }

    @Override
    public void onRemove(Case c) {
        super.onPlace(c);
    }

}
