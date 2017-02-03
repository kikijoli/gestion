/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.auto;

import java.util.ArrayList;
import ville.Entite.Entite;
import ville.Entite.Personnage.Personnage;
import ville.interfaces.IAuto;
import ville.manager.EntiteManager;
import ville.manager.GrilleManager;
import ville.ui.Case;

/**
 *
 * @author troïmaclure
 */
public class AllerVers implements IAuto {

    public Case currentCase;
    public int iterator = 0;
    public int cooldown = 25;
    public int timer = 0;
    public Personnage personnage;
    public Entite target;

    public AllerVers(Personnage source, Entite target) {
        this.personnage = source;
        this.target = target;
    }

    @Override
    public void auto() {
        if (personnage.intersects(target)) {
            personnage.currentAuto = new Attaque(personnage, target);

            return;
        }

        timer++;
        if (timer == cooldown) {

            ArrayList<Case> path = GrilleManager.getPath(GrilleManager.getCaseFor(personnage), GrilleManager.getCaseFor(target));
            personnage.path = path;
            timer = 0;
            iterator = 0;
        }
        if (this.personnage.path == null) {
            return;
        }
        if (this.currentCase == null) {
            if (this.personnage.path.size() > 0) {
                this.currentCase = this.personnage.path.get(0);
            }
        }
        if (this.currentCase == null) {
            return;
        }

        if (EntiteManager.moveTo(personnage, currentCase)) {
            iterator++;

            if (this.personnage.path.size() > 0) {
                if (currentCase == getLast()) {

                } else {
                    currentCase = getNext();
                }
            }
        }
    }

    private Case getLast() {
        return this.personnage.path.get(this.personnage.path.size() - 1);
    }

    private Case getNext() {
        return this.personnage.path.get(iterator);
    }

}
