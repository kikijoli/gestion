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
import ville.Entite.Entite;
import ville.auto.AllerRetour;
import ville.interfaces.IAuto;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public abstract class Personnage extends Entite implements IAuto {

    public Batiment batiment;
    public IAuto currentAuto;
    public ArrayList<Case> path = new ArrayList<>();
    public int maxPath;

    public Personnage(Color color, int x, int y, int width, int height, Batiment bat) {
        super(color, x, y, width, height);
        this.batiment = bat;
    }

    @Override
    public void auto() {
        if (this.currentAuto != null) {
            this.currentAuto.auto();
        }
    }

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
