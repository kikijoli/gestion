/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import ville.Ville;
import ville.manager.EntiteManager;

/**
 *
 * @author admin
 */
public class Repaint implements Runnable {

    @Override
    public void run() {
        while (true) {

            Ville.fenetre.panneau.repaint();
            EntiteManager.gestionAuto();
            try {
                Thread.sleep(26);
            } catch (InterruptedException ex) {
                Logger.getLogger(Repaint.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
