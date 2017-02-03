/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Personnage;

import java.awt.Color;
import java.awt.Graphics2D;
import ville.Resource.Resource;
import ville.auto.AllerVers;
import ville.manager.GameManager;

/**
 *
 * @author admin
 */
public class Ennemi extends Personnage {

    public Ennemi(int x, int y) {
        super(Color.red, x, y, 48, 48);
        this.currentAuto = new AllerVers(this, GameManager.joueur);
        this.name = "Angry";
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        for (int i = 0; i < pv; i++) {
            g.drawImage(Resource.getImage("Heart"), x - 12 + (20 * i), y - height * 2, 12, 12, null);

        }
    }

}
