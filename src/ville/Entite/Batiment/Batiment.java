/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Batiment;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import ville.Entite.Entite;
import ville.interfaces.ISelectable;
import ville.util.Util;

/**
 *
 * @author admin
 */
public abstract class Batiment extends Entite implements ISelectable {

    public boolean probleme;

    public Batiment(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        if (probleme) {
            g.setStroke(new BasicStroke(10.0f));
            g.setColor(Color.red);
            g.draw(this);
            g.setStroke(new BasicStroke(1));
        }

    }

}
