/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static ville.Ville.fenetre;
import ville.manager.EntiteManager;
import ville.manager.GrilleManager;

/**
 *
 * @author admin
 */
public class KeyListenerFenetre implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
            case 49: //&
//               fenetre.routeBtn.doClick();
                break;
            case 50: //é
//                fenetre.maisonBtn.doClick();
                break;
            case 51: //"
//                fenetre.btn3.doClick();
                break;
            case 52: //'
//                fenetre.pelleBtn.doClick();
                break;
            case 27: //echap
//                EntiteManager.currentEntite = null;
                break;
            case 88: //X
//                GrilleManager.debut = GrilleManager.getCaseHover();
                break;
            case 67: //C
//                GrilleManager.debut = null;
                break;
        }
    }

}
