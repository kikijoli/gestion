package ville.auto;

import ville.Entite.Entite;
import ville.Entite.Personnage.Personnage;
import ville.interfaces.IAuto;
import ville.manager.GameManager;
import ville.manager.UI;

/**
 *
 * @author troïmaclure
 */
class Attaque implements IAuto {

    public Personnage personnage;
    public Entite target;
    int cooldown = 50;

    public Attaque(Personnage personnage, Entite target) {
        this.personnage = personnage;
        this.target = target;
    }

    @Override
    public void auto() {
        if (!personnage.intersects(target)) {
            personnage.currentAuto = new AllerVers(personnage, target);
            return;
        }

        if (personnage.compteur > cooldown) {
            GameManager.addBulle(personnage, GameManager.getFleche());
            personnage.compteur = 0;
        }
    }

}
