/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.ui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import ville.Entite.Entite;
import ville.listener.PanneauComponentListener;
import ville.listener.PanneauMouseListener;
import ville.listener.PanneauMouseMotion;
import ville.manager.EntiteManager;
import ville.manager.GrilleManager;

/**
 *
 * @author admin
 */
public class Panneau extends JPanel {

    public static Rectangle selection = new Rectangle();

    public Panneau() {
        super(true);
        this.addMouseListener(new PanneauMouseListener());
        this.addComponentListener(new PanneauComponentListener());
        this.addMouseMotionListener(new PanneauMouseMotion());
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.green);
        g.fillRect(0, 0, getWidth(), getHeight());

        EntiteManager.getEntites().stream().forEach((entite) -> {
            entite.draw(g2);
        });
        g2.setColor(Color.GRAY);
        Case[][] grilles = GrilleManager.getGrille();
        if (grilles != null) {
            for (Case[] grille : grilles) {
                for (Case grille1 : grille) {
                    g2.draw(grille1);
                }
            }
        }
        drawPath(g2);
        drawCurrentEntity(g2);
        drawMenu(g2);
        drawPelle(g2);
        g2.dispose();
    }

    private void drawPath(Graphics2D g2) {
        int i = 0;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        if (GrilleManager.path != null) {
            for (Case path : (ArrayList<Case>) GrilleManager.path.clone()) {
                i++;
                g2.setColor(i > EntiteManager.entiteToPath.maxPath ? Color.RED : Color.CYAN);
                g2.fill(new Rectangle(path.x + path.width / 4, path.y + path.height / 4, path.width / 2, path.height / 2));
            }
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
    }

    private void drawCurrentEntity(Graphics2D g2) {
        if (EntiteManager.currentEntite != null) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            EntiteManager.currentEntite.draw(g2);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
            g2.setColor(EntiteManager.isBonEmplacement ? Color.BLUE : Color.RED);
            g2.draw(EntiteManager.currentEntite);
        }
    }

    private void drawPelle(Graphics2D g2) {
        if (EntiteManager.pelleMode) {
            g2.setFont(new Font("Segoe UI", 1, 20));
            g2.setColor(Color.red);
            g2.drawString("X", (int) Panneau.selection.getX(), (int) Panneau.selection.getY());
            Entite e = EntiteManager.getEntiteHover(Panneau.selection.getLocation());
            if (e != null) {
                g2.draw(e);
            }
        }
    }

    private void drawMenu(Graphics2D g2) {
        if (!EntiteManager.showMenu) {
            return;
        }
        if (EntiteManager.menu == null) {
            return;
        }
        EntiteManager.menu.draw(g2);
    }

}
