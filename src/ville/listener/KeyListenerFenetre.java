/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import ville.manager.GameManager;
import ville.manager.UI;
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
        System.out.println(e.getKeyCode());
        switch (e.getKeyCode()) {
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
        char c = e.getKeyChar();

        for (Bulle bulle : UI.getBulles()) {
            char d = bulle.message.charAt(0);
            if (d == Character.toUpperCase(c) && !bulle.accompli) {
                bulle.accompli = true;
                bulle.personnage.pv -= 1;
                bulle.personnage.onPvPerdu();
                break;
            }
        }
    }
}
