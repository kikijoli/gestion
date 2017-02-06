/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Element;

import java.awt.Color;
import java.awt.Graphics2D;
import ville.Entite.Entite;
import ville.Resource.Resource;
import ville.manager.GrilleManager;

/**
 *
 * @author admin
 */
public class Piece extends Entite {

    public boolean statut;

    public Piece(int x, int y) {
        super(Color.YELLOW, x, y, 48, 48);
    }

    @Override
    public void onRemove() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(Resource.getImage("money"), x, y, GrilleManager.getCellWidth(), GrilleManager.getCellHeight(), null);
    }
}
