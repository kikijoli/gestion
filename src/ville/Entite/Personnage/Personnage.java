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
import ville.Entite.animation.Animation;
import ville.Resource.Resource;
import ville.auto.AllerRetour;
import ville.interfaces.IAuto;
import ville.manager.EntiteManager;
import ville.manager.UI;
import ville.ui.Bulle;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public abstract class Personnage extends Entite implements IAuto {

    public int compteur;
    public String name;
    public int pv = 3;
    public IAuto currentAuto;
    public ArrayList<Case> path = new ArrayList<>();
    public Animation animation;

    public Personnage(Color color, int x, int y, int width, int height) {
        super(color, x, y, width, height);
        this.vitesse = 5;
    }

    public void setPath(ArrayList<Case> path) {
        this.path = path;
        this.currentAuto = new AllerRetour(this);
    }

    @Override
    public void draw(Graphics2D g) {
        compteur++;
        if (animation == null) {
            g.drawImage(Resource.getImage(name), x, y, width, height, null);
        } else {
            g.drawImage(animation.image, x, y, width, height, null);
            animation.compteur--;
            if (animation.compteur <= 0) {
                this.animation = null;
            }
        }

    }

    @Override
    public void auto() {
        if (this.currentAuto != null) {
            this.currentAuto.auto();
        }
    }

    public void onPvPerdu() {
        this.setAnim(Animation.getAnimation(Animation.PVPERDU));
        if (!(this instanceof Joueur)) {
            if (pv <= 0) {
                EntiteManager.remove(this);

            }
        }
    }

    private void setAnim(Animation animation) {
        this.animation = animation;
    }

    @Override
    public void onRemove() {
        for (Bulle bulle : UI.getBulles()) {
            if (bulle.personnage == this) {
                bulle.accompli = true;
            }
        }
    }

}
