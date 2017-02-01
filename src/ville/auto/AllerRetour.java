/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.auto;

import java.util.Collections;
import ville.Entite.Personnage.Personnage;
import ville.IAuto;
import ville.manager.EntiteManager;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class AllerRetour implements IAuto {

    public Personnage personnage;
    public Case currentCase;
    public int iterator = 0;

    public AllerRetour(Personnage personnage) {
        this.personnage = personnage;
    }

    @Override
    public void auto() {
        this.personnage.batiment.probleme = this.personnage.path == null;
        if (this.personnage.path == null) {
            return;
        }
        if (this.currentCase == null) {
            this.currentCase = this.personnage.path.get(0);
        }
        if (this.currentCase == null) {
            return;
        }

        if (EntiteManager.moveTo(personnage, currentCase)) {
            iterator++;
            if (currentCase == getLast()) {

                inverse();
            }
            currentCase = getNext();
        }
    }

    private Case getNext() {
        return this.personnage.path.get(iterator);
    }

    private Case getLast() {
        return this.personnage.path.get(this.personnage.path.size() - 1);
    }

    private void inverse() {
        iterator = 0;
        Collections.reverse(this.personnage.path);
    }

}
