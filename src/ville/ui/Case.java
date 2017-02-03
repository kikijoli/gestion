/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.ui;

import java.awt.Rectangle;

/**
 *
 * @author admin
 */
public class Case extends Rectangle {

    public int row, col;
    public boolean state = true;

    public Case(int row, int col, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.row = row;
        this.col = col;
    }

    public String write() {
        return "GrilleManager.grille[" + this.col + "][" + this.row + "].state = false; ";
    }
}
