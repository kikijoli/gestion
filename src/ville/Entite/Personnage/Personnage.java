/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.Entite.Personnage;

import java.awt.Color;
import java.util.ArrayList;
import ville.Entite.Batiment.Batiment;
import ville.Entite.Entite;
import ville.IAuto;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public abstract class Personnage extends Entite implements IAuto {

    public Batiment batiment;
    public IAuto currentAuto;
    public int vitesse;
    public ArrayList<Case> path = new ArrayList<>();
    public int maxPath;

    public Personnage(Color color, int x, int y, int width, int height, Batiment bat) {
        super(color, x, y, width, height);
        this.batiment = bat;
    }

    @Override
    public void auto() {
        if (this.currentAuto != null) {
            this.currentAuto.auto();
        }
    }

    public abstract void setPath(ArrayList<Case> path);

}
