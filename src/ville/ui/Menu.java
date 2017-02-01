/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.ui;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Menu extends Rectangle {

    public ArrayList<MenuItem> items = new ArrayList<>();

    public Menu(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

}
