/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import ville.interfaces.IDrawable;
import ville.manager.EntiteManager;

/**
 *
 * @author admin
 */
public class Menu extends Rectangle implements IDrawable {

    public ArrayList<MenuItem> items = new ArrayList<>();
    public int count = 20;

    public Menu(int x, int y, int width, int height) {
        super(x, y, width, height);

    }

    @Override
    public void draw(Graphics2D g) {

        if (count > 0) {
            count -= 3;
            y -= 3;
            for (MenuItem item : items) {
                item.y -= 3;

            }
        }
        g.setColor(Color.WHITE);
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Float(EntiteManager.menu.x, EntiteManager.menu.y, EntiteManager.menu.width, EntiteManager.menu.height, 10, 10);
        g.fill(roundedRectangle);
        for (MenuItem menu : EntiteManager.menu.items) {
            g.setColor(menu.hover ? Color.CYAN : Color.WHITE);
            g.fill(menu);
            g.setColor(Color.BLACK);
            g.drawString(menu.action.nom, menu.x, menu.y + menu.height / 2);
        }
    }

}
