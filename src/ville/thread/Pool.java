/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.thread;

import java.util.logging.Level;
import java.util.logging.Logger;
import ville.Entite.Personnage.Ennemi;
import ville.Ville;
import ville.manager.EntiteManager;
import ville.manager.UI;

/**
 *
 * @author admin
 */
public class Pool implements Runnable {

    @Override
    public void run() {
        while (true) {

            EntiteManager.entites.add(new Ennemi(600, 600)); 
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pool.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
