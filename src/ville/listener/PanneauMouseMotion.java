/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.listener;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;
import javax.swing.SwingUtilities;
import ville.Entite.Entite;
import ville.manager.EntiteManager;
import ville.manager.GrilleManager;
import ville.ui.Case;
import ville.ui.MenuItem;
import ville.ui.Panneau;

/**
 *
 * @author admin
 */
public class PanneauMouseMotion implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            getMousePosition(e);
            EntiteManager.clickOrDrag();
        }
    }

    private void getMousePosition(MouseEvent e) {
        for (Case[] ca : GrilleManager.getGrille()) {
            for (Case rect : ca) {
                if (rect.contains(e.getPoint())) {
                    Panneau.selection = rect;
                }
            }

        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        getMousePosition(e);
        gestionPath();
        //si aucun menu hover
        if (!gestionHoverMenu()) {
            gestionHoverEntite();
        }

    }

    private void gestionPath() {
        if (GrilleManager.debut != null) {
            if (GrilleManager.fin == null || GrilleManager.getCaseHover() != GrilleManager.fin) {
                GrilleManager.fin = GrilleManager.getCaseHover();
                if (GrilleManager.fin != null) {
                    GrilleManager.path = GrilleManager.getPath(GrilleManager.debut, GrilleManager.fin);
                }
            }
        }
    }

    private void gestionHoverEntite() {
        for (Entite entite : EntiteManager.getEntites()) {
            entite.hover = entite.intersects(Panneau.selection);
        }
    }

    private boolean gestionHoverMenu() {
        boolean isOneItemHover = false;
        if (EntiteManager.menu != null && EntiteManager.showMenu) {
            for (MenuItem item : EntiteManager.menu.items) {
                item.hover = item.intersects(Panneau.selection);

                if (item.hover) {
                    isOneItemHover = true;
                }
            }
        }
        return isOneItemHover;
    }
}
