/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Route;

import java.awt.Color;
import ville.Entite.Entite;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public abstract class Route extends Entite {

    public Route(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
    }

    @Override
    public void onPlace(Case c) {
        c.state = true;
    }

    @Override
    public void onRemove(Case c) {
        c.state = false;
    }

}
