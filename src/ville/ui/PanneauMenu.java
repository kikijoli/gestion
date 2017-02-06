/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import ville.Resource.Resource;
import ville.manager.GameManager;

/**
 *
 * @author admin
 */
public class PanneauMenu extends JPanel {

    public PanneauMenu() {
        super(true);
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.darkGray);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.yellow);
        g2.setFont(new Font("Segoe UI", 1, 20));
        g2.drawString("Or : " + GameManager.or, getWidth() - 150, 20);
        for (int i = 0; i < GameManager.pv; i++) {
            g2.drawImage(Resource.getImage("Heart"), 50 * i, 0, 48, 48, this);
        }
        int index = 0;
        for (Bulle bulle : GameManager.getBulles()) {
            if (bulle.accompli) {
                continue;
            }
            g2.drawImage(bulle.fleche.image, index * 50, 50, 48, 48, this);
            index++;
        }
    }
}
