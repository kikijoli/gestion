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
        g2.drawString("Or : " + GameManager.or, 20, 20);
    }

}
