/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.auto;

import java.util.ArrayList;
import ville.Entite.Personnage.Personnage;
import ville.interfaces.IAuto;
import ville.manager.EntiteManager;
import ville.manager.GrilleManager;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class AllerPath implements IAuto {

    public Personnage personnage;
    public Case currentCase;
    public int iterator = 0;
    public int cooldown = 25;
    public int timer = 0;

    public AllerPath(Personnage entite) {
        this.personnage = entite;
    }

    @Override
    public void auto() {
        if (this.personnage.path == null) {
            return;
        }
        timer++;
        if (timer == cooldown) {

            ArrayList<Case> path = GrilleManager.getPath(GrilleManager.getCaseFor(personnage), getLast());
            personnage.path = path;
            timer = 0;
            iterator = 0;
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
                    personnage.currentAuto = null;
                } else {
                    currentCase = getNext();
                }
            }
        }
    }

    private Case getLast() {
        if (this.personnage.path.size() > 0) {
            return this.personnage.path.get(this.personnage.path.size() - 1);
        }
        return null;
    }

    private Case getNext() {
        if (this.personnage.path.size() > 0) {
            return this.personnage.path.get(iterator);
        }
        return null;
    }
}
