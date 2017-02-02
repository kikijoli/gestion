/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Personnage;

import java.awt.Color;
import ville.interfaces.IAuto;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class Ennemi extends Personnage {


    public Ennemi(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
    }

    @Override
    public void onRemove(Case c) {
    }

}
