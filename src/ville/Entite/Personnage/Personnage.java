/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Personnage;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import ville.Entite.Entite;
import ville.auto.AllerRetour;
import ville.interfaces.IAuto;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public abstract class Personnage extends Entite implements IAuto {

    public IAuto currentAuto;
    public ArrayList<Case> path = new ArrayList<>();

    public Personnage(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
        this.vitesse = 1;
    }

    public void setPath(ArrayList<Case> path) {
        this.path = path;
        this.currentAuto = new AllerRetour(this);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);

    }

    @Override
    public void auto() {
        if (this.currentAuto != null) {
            this.currentAuto.auto();
        }
    }

}
