/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.ui;

import java.awt.Rectangle;
import ville.util.Action;

/**
 *
 * @author admin
 */
public class MenuItem extends Rectangle {

    public Action action;
    public boolean hover;

    public MenuItem( Action action, int x, int y, int width, int height) {
        super(x, y, width, height);
        
        this.action = action;

    }

  

}
