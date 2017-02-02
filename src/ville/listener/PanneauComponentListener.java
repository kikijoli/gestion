/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.listener;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import ville.Entite.Entite;
import ville.manager.EntiteManager;
import ville.manager.GrilleManager;

/**
 *
 * @author admin
 */
public class PanneauComponentListener extends ComponentAdapter {

    @Override
    public void componentResized(ComponentEvent e) {
        GrilleManager.refreshGrille();
  
        
    }

}
