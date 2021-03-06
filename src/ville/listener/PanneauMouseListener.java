/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.listener;

import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import ville.manager.EntiteManager;
import ville.manager.UI;
import ville.ui.MenuItem;

/**
 *
 * @author admin
 */
public class PanneauMouseListener implements java.awt.event.MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            EntiteManager.currentEntite = null;
            EntiteManager.pelleMode = false;
        } else if (SwingUtilities.isLeftMouseButton(e)) {
            //si pas d'interaction avec le menu
            if (!gestionMenuClick()) {
                EntiteManager.clickOrDrag();
                if (UI.modePath) {
                    EntiteManager.clickPath();
                }
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private boolean gestionMenuClick() {
        boolean action = false;

        if (EntiteManager.menu != null && EntiteManager.showMenu && !EntiteManager.pelleMode) {
            for (MenuItem item : EntiteManager.menu.items) {
                if (item.hover) {
                    item.action.action();
                    EntiteManager.showMenu = false;
                    action = true;
                    break;
                }
            }

        }
        return action;
    }

}
