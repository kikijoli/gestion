/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.ui;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import ville.Entite.Personnage.Personnage;
import ville.Resource.Resource;
import ville.interfaces.IDrawable;

/**
 *
 * @author troïmaclure
 */
public class Bulle extends Rectangle implements IDrawable {

    public Fleche fleche;
    public Personnage personnage;
    public int compteur = 0;
    public int max = 3;
    public boolean disparait = false;
    public boolean fini = false;
    public float opacity = 1.0f;
    public int ocsille = 0;
    public Font font = new Font("Segoe UI", 1, 20);
    public boolean accompli = false;

    public Bulle(Fleche fleche, Personnage entite, int x, int y) {
        super(x, y, 48, 48);
        this.fleche = fleche;
        this.personnage = entite;
    }

    @Override
    public void draw(Graphics2D g) {

        g.setFont(new Font("Segoe UI", 1, 20));
        opacity -= opacity > 0.1f ? 0.005f : 0;
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        fini = opacity < 0.3f;

        compteur++;
        if (compteur == max) {
            y -= 1;
            compteur = 0;
        }

        g.drawImage(fleche.image, x, y, width, height, null);
        if (accompli) {
            g.drawImage(Resource.getImage("Check"), x, y, width, height, null);
        }
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        g.setStroke(new BasicStroke(1));
    }

}
