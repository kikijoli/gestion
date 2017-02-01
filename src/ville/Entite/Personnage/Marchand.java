/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Personnage;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import ville.Entite.Batiment.Batiment;
import ville.auto.AllerRetour;
import ville.manager.GrilleManager;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class Marchand extends Personnage {

    public Marchand(int x, int y, Batiment bat) {
        super(Color.CYAN, x, y, GrilleManager.getCellWidth() / 2, GrilleManager.getCellHeight() / 2, bat);
        this.maxPath = 12;
        this.vitesse = 1;
    }

    @Override
    public void onPlace(Case c) {

    }

    @Override
    public void onRemove(Case c) {
    }

    @Override
    public void setPath(ArrayList<Case> path) {
        this.path = path;
        this.currentAuto = new AllerRetour(this);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        if (batiment.select) {
            g.setColor(Color.ORANGE);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            if (this.path != null) {
                for (Case path : (ArrayList<Case>) this.path.clone()) {
                    g.fill(new Rectangle(path.x + path.width / 4, path.y + path.height / 4, path.width / 2, path.height / 2));
                }
            }
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        }
    }

}
