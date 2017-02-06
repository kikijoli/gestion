/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ville.Entite.Element.Piece;
import ville.Entite.Entite;
import ville.manager.EntiteManager;
import ville.manager.GameManager;
import ville.ui.Bulle;

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
//
//        for (Entite entite : EntiteManager.getEntites()) {
//            if (entite instanceof Piece) {
//                System.out.println("EntiteManager.addEntite(new Piece(" + entite.x + " " + entite.y + "))");
//            }
//        }

//        for (Case[] c : GrilleManager.getGrille()) {
//            for (Case c1 : c) {
//                if (!c1.state) {
//                    System.out.println(c1.write());;
//                }
//            }
//        }
        System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {

            case 38://haut
                break;
            case 39://droite
                break;
            case 40://bas
                break;
            case 37://gauche
                break;
            case 90://Z
                break;
            case 81://Q
                break;
            case 83://S
                break;
            case 68://D
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {

            case 38://haut
            case 39://droite
            case 40://bas
            case 37://gauche
                testBulle(e.getKeyCode());
                break;
            case 90://Z
                break;
            case 81://Q
                break;
            case 83://S
                break;
            case 68://D
                break;
        }
    }

    private void testBulle(int keyCode) {
        for (Bulle bulle : GameManager.getBulles()) {
            if (bulle.accompli) {
                continue;
            }
            if (bulle.fleche.code == keyCode) {
                bulle.accompli = true;
            }
            return;
        }
    }
}
