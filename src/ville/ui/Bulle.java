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

    public String message;
    public Personnage personnage;
    public int compteur = 0;
    public int max = 3;
    public boolean disparait = false;
    public boolean fini = false;
    public float opacity = 1.0f;
    public int ocsille = 0;
    public Font font = new Font("Segoe UI", 1, 20);
    public boolean accompli = false;

    public Bulle(String message, Personnage entite, int x, int y) {
        super(x, y, 48, 48);
        this.message = message;
        this.personnage = entite;
    }

    @Override
    public void draw(Graphics2D g) {

        g.setFont(new Font("Segoe UI", 1, 20));
        opacity -= opacity > 0.1f ? 0.005f : 0;
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        fini = opacity < 0.3f;

        g.setColor(Color.white);
        g.fillOval(x, y, width, height);

        g.setStroke(new BasicStroke(3));
        g.setColor(accompli ? Color.decode("#127A16") : Color.black);
        g.drawOval(x, y, width, height);

        FontMetrics fontMetrics = g.getFontMetrics(font);
        g.setFont(font);
        int stringWidth = fontMetrics.stringWidth(message);
        compteur++;
        if (compteur == max) {
            y -= 1;
            compteur = 0;
        }

        g.drawString(message, x + width / 2 - stringWidth / 2, y + height / 2 + 7);
        if (accompli) {
            g.drawImage(Resource.getImage("Check"), x, y, width, height, null);
        }
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
        g.setStroke(new BasicStroke(1));
    }

}
