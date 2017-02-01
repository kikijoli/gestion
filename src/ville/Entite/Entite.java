/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import ville.interfaces.IDrawable;
import ville.interfaces.IPosable;
import ville.interfaces.IRemovable;

/**
 *
 * @author admin
 */
public abstract class Entite extends Rectangle implements IDrawable, IPosable, IRemovable {

    public boolean hover;
    public boolean select;
    public Color color;

    public Entite() {
    }

    public Entite(Color color, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fill(this);
        if (select) {
            g.setStroke(new BasicStroke(5.0f));
            g.setColor(Color.blue);
            g.draw(this);
            g.setStroke(new BasicStroke(1));
        } else if (hover) {
            g.setStroke(new BasicStroke(5.0f));
            g.setColor(Color.yellow);
            g.draw(this);
            g.setStroke(new BasicStroke(1));
        }
    }

}
