/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.auto;

import ville.Entite.Personnage.Personnage;
import ville.interfaces.IAuto;
import ville.manager.EntiteManager;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class AllerPath implements IAuto {

    public Personnage personnage;
    public Case currentCase;
    public int iterator = 0;

    public AllerPath(Personnage entite) {
        this.personnage = entite;
    }

    @Override
    public void auto() {
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
            if (currentCase == getLast()) {
                personnage.currentAuto = null;
            } else {
                currentCase = getNext();

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
