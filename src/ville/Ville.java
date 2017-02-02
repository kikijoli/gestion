/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville;

import javax.swing.JFrame;
import ville.Entite.Personnage.Ennemi;
import ville.manager.EntiteManager;
import ville.thread.Pool;
import ville.thread.Repaint;
import ville.ui.Fenetre;

/**
 *
 * @author admin
 */
public class Ville {

    public static Fenetre fenetre;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        fenetre = new Fenetre();
        fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fenetre.setVisible(true);

        new Thread(new Repaint()).start();
        new Thread(new Pool()).start();

        EntiteManager.addEntite(new Ennemi(500, 500));
//        new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Ville.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                Case debut = GrilleManager.getGrille()[5][10];
//                Case fin = GrilleManager.getGrille()[15][15];
//                long time = System.currentTimeMillis();
//                new PathFinder().getPathFor(debut, fin);
//                System.out.println(System.currentTimeMillis() - time + " MS");
//
//            }
//        }).start();
    }

}
