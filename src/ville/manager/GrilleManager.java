/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.manager;

import java.util.ArrayList;
import ville.Entite.Element.Piece;
import ville.Entite.Entite;
import static ville.Ville.fenetre;
import ville.ui.Case;
import ville.ui.Panneau;
import ville.util.PathFinder;
import ville.util.PathFinder.Search;

/**
 *
 * @author admin
 */
public class GrilleManager {

    public static Case[][] grille;
    public static int ROWCOUNT = 25;
    public static int COLUMNCOUNT = 25;
    public static Case debut;
    public static Case fin;
    public static ArrayList<Case> path = new ArrayList<>();

    public static void refreshGrille() {
        grille = new Case[COLUMNCOUNT][ROWCOUNT];
        int width = getCellWidth();
        int height = getCellHeight();

        for (int i = 0; i < COLUMNCOUNT; i++) {
            for (int j = 0; j < ROWCOUNT; j++) {
                grille[i][j] = (new Case(i, j, i * width, j * height, width, height));
            }
        }
        //<editor-fold defaultstate="collapsed" desc="murs">
        GrilleManager.grille[1][2].state = false;
        GrilleManager.grille[2][2].state = false;
        GrilleManager.grille[3][2].state = false;
        GrilleManager.grille[4][2].state = false;
        GrilleManager.grille[5][2].state = false;
        GrilleManager.grille[6][2].state = false;
        GrilleManager.grille[7][2].state = false;
        GrilleManager.grille[8][2].state = false;
        GrilleManager.grille[9][2].state = false;
        GrilleManager.grille[10][2].state = false;
        GrilleManager.grille[11][2].state = false;
        GrilleManager.grille[12][2].state = false;
        GrilleManager.grille[13][2].state = false;
        GrilleManager.grille[14][2].state = false;
        GrilleManager.grille[15][2].state = false;
        GrilleManager.grille[16][2].state = false;
        GrilleManager.grille[17][2].state = false;
        GrilleManager.grille[18][2].state = false;
        GrilleManager.grille[19][2].state = false;
        GrilleManager.grille[20][2].state = false;
        GrilleManager.grille[21][2].state = false;
        GrilleManager.grille[22][2].state = false;
        GrilleManager.grille[1][3].state = false;
        GrilleManager.grille[22][3].state = false;
        GrilleManager.grille[1][4].state = false;
        GrilleManager.grille[3][4].state = false;
        GrilleManager.grille[11][4].state = false;
        GrilleManager.grille[22][4].state = false;
        GrilleManager.grille[1][5].state = false;
        GrilleManager.grille[3][5].state = false;
        GrilleManager.grille[11][5].state = false;
        GrilleManager.grille[22][5].state = false;
        GrilleManager.grille[1][6].state = false;
        GrilleManager.grille[3][6].state = false;
        GrilleManager.grille[6][6].state = false;
        GrilleManager.grille[7][6].state = false;
        GrilleManager.grille[8][6].state = false;
        GrilleManager.grille[9][6].state = false;
        GrilleManager.grille[10][6].state = false;
        GrilleManager.grille[11][6].state = false;
        GrilleManager.grille[12][6].state = false;
        GrilleManager.grille[13][6].state = false;
        GrilleManager.grille[14][6].state = false;
        GrilleManager.grille[15][6].state = false;
        GrilleManager.grille[16][6].state = false;
        GrilleManager.grille[17][6].state = false;
        GrilleManager.grille[20][6].state = false;
        GrilleManager.grille[21][6].state = false;
        GrilleManager.grille[22][6].state = false;
        GrilleManager.grille[1][7].state = false;
        GrilleManager.grille[3][7].state = false;
        GrilleManager.grille[11][7].state = false;
        GrilleManager.grille[20][7].state = false;
        GrilleManager.grille[1][8].state = false;
        GrilleManager.grille[3][8].state = false;
        GrilleManager.grille[11][8].state = false;
        GrilleManager.grille[20][8].state = false;
        GrilleManager.grille[1][9].state = false;
        GrilleManager.grille[3][9].state = false;
        GrilleManager.grille[11][9].state = false;
        GrilleManager.grille[20][9].state = false;
        GrilleManager.grille[1][10].state = false;
        GrilleManager.grille[3][10].state = false;
        GrilleManager.grille[11][10].state = false;
        GrilleManager.grille[1][11].state = false;
        GrilleManager.grille[3][11].state = false;
        GrilleManager.grille[4][11].state = false;
        GrilleManager.grille[5][11].state = false;
        GrilleManager.grille[6][11].state = false;
        GrilleManager.grille[8][11].state = false;
        GrilleManager.grille[9][11].state = false;
        GrilleManager.grille[10][11].state = false;
        GrilleManager.grille[11][11].state = false;
        GrilleManager.grille[12][11].state = false;
        GrilleManager.grille[13][11].state = false;
        GrilleManager.grille[14][11].state = false;
        GrilleManager.grille[15][11].state = false;
        GrilleManager.grille[16][11].state = false;
        GrilleManager.grille[17][11].state = false;
        GrilleManager.grille[18][11].state = false;
        GrilleManager.grille[19][11].state = false;
        GrilleManager.grille[20][11].state = false;
        GrilleManager.grille[21][11].state = false;
        GrilleManager.grille[1][12].state = false;
        GrilleManager.grille[3][12].state = false;
        GrilleManager.grille[8][12].state = false;
        GrilleManager.grille[21][12].state = false;
        GrilleManager.grille[1][13].state = false;
        GrilleManager.grille[3][13].state = false;
        GrilleManager.grille[6][13].state = false;
        GrilleManager.grille[8][13].state = false;
        GrilleManager.grille[10][13].state = false;
        GrilleManager.grille[11][13].state = false;
        GrilleManager.grille[12][13].state = false;
        GrilleManager.grille[13][13].state = false;
        GrilleManager.grille[14][13].state = false;
        GrilleManager.grille[15][13].state = false;
        GrilleManager.grille[16][13].state = false;
        GrilleManager.grille[17][13].state = false;
        GrilleManager.grille[18][13].state = false;
        GrilleManager.grille[19][13].state = false;
        GrilleManager.grille[21][13].state = false;
        GrilleManager.grille[6][14].state = false;
        GrilleManager.grille[8][14].state = false;
        GrilleManager.grille[10][14].state = false;
        GrilleManager.grille[19][14].state = false;
        GrilleManager.grille[21][14].state = false;
        GrilleManager.grille[1][15].state = false;
        GrilleManager.grille[3][15].state = false;
        GrilleManager.grille[6][15].state = false;
        GrilleManager.grille[8][15].state = false;
        GrilleManager.grille[10][15].state = false;
        GrilleManager.grille[12][15].state = false;
        GrilleManager.grille[14][15].state = false;
        GrilleManager.grille[17][15].state = false;
        GrilleManager.grille[19][15].state = false;
        GrilleManager.grille[21][15].state = false;
        GrilleManager.grille[3][16].state = false;
        GrilleManager.grille[6][16].state = false;
        GrilleManager.grille[8][16].state = false;
        GrilleManager.grille[10][16].state = false;
        GrilleManager.grille[11][16].state = false;
        GrilleManager.grille[12][16].state = false;
        GrilleManager.grille[13][16].state = false;
        GrilleManager.grille[14][16].state = false;
        GrilleManager.grille[15][16].state = false;
        GrilleManager.grille[16][16].state = false;
        GrilleManager.grille[17][16].state = false;
        GrilleManager.grille[19][16].state = false;
        GrilleManager.grille[21][16].state = false;
        GrilleManager.grille[1][17].state = false;
        GrilleManager.grille[3][17].state = false;
        GrilleManager.grille[8][17].state = false;
        GrilleManager.grille[19][17].state = false;
        GrilleManager.grille[21][17].state = false;
        GrilleManager.grille[1][18].state = false;
        GrilleManager.grille[3][18].state = false;
        GrilleManager.grille[8][18].state = false;
        GrilleManager.grille[9][18].state = false;
        GrilleManager.grille[10][18].state = false;
        GrilleManager.grille[11][18].state = false;
        GrilleManager.grille[12][18].state = false;
        GrilleManager.grille[13][18].state = false;
        GrilleManager.grille[14][18].state = false;
        GrilleManager.grille[15][18].state = false;
        GrilleManager.grille[16][18].state = false;
        GrilleManager.grille[17][18].state = false;
        GrilleManager.grille[18][18].state = false;
        GrilleManager.grille[19][18].state = false;
        GrilleManager.grille[21][18].state = false;
        GrilleManager.grille[1][19].state = false;
        GrilleManager.grille[3][19].state = false;
        GrilleManager.grille[6][19].state = false;
        GrilleManager.grille[21][19].state = false;
        GrilleManager.grille[1][20].state = false;
        GrilleManager.grille[3][20].state = false;
        GrilleManager.grille[6][20].state = false;
        GrilleManager.grille[7][20].state = false;
        GrilleManager.grille[8][20].state = false;
        GrilleManager.grille[9][20].state = false;
        GrilleManager.grille[10][20].state = false;
        GrilleManager.grille[11][20].state = false;
        GrilleManager.grille[12][20].state = false;
        GrilleManager.grille[13][20].state = false;
        GrilleManager.grille[14][20].state = false;
        GrilleManager.grille[15][20].state = false;
        GrilleManager.grille[16][20].state = false;
        GrilleManager.grille[17][20].state = false;
        GrilleManager.grille[18][20].state = false;
        GrilleManager.grille[19][20].state = false;
        GrilleManager.grille[20][20].state = false;
        GrilleManager.grille[21][20].state = false;
        GrilleManager.grille[1][21].state = false;
        GrilleManager.grille[3][21].state = false;
        GrilleManager.grille[6][21].state = false;
        GrilleManager.grille[8][21].state = false;
        GrilleManager.grille[11][21].state = false;
        GrilleManager.grille[1][22].state = false;
        GrilleManager.grille[6][22].state = false;
        GrilleManager.grille[1][23].state = false;
        GrilleManager.grille[2][23].state = false;
        GrilleManager.grille[3][23].state = false;
        GrilleManager.grille[4][23].state = false;
        GrilleManager.grille[5][23].state = false;
        GrilleManager.grille[6][23].state = false;
        GrilleManager.grille[7][23].state = false;
        GrilleManager.grille[8][23].state = false;
        GrilleManager.grille[9][23].state = false;
        GrilleManager.grille[10][23].state = false;
        GrilleManager.grille[11][23].state = false;
        GrilleManager.grille[12][23].state = false;
        GrilleManager.grille[13][23].state = false;
        GrilleManager.grille[14][23].state = false;
        GrilleManager.grille[15][23].state = false;
        GrilleManager.grille[16][23].state = false;
        GrilleManager.grille[17][23].state = false;
        GrilleManager.grille[18][23].state = false;
        GrilleManager.grille[19][23].state = false;
        GrilleManager.grille[20][23].state = false;
        GrilleManager.grille[21][23].state = false;
        GrilleManager.grille[22][23].state = false;
        GrilleManager.grille[23][23].state = false;
        GrilleManager.grille[1][2].state = false;
        GrilleManager.grille[2][2].state = false;
        GrilleManager.grille[3][2].state = false;
        GrilleManager.grille[4][2].state = false;
        GrilleManager.grille[5][2].state = false;
        GrilleManager.grille[6][2].state = false;
        GrilleManager.grille[7][2].state = false;
        GrilleManager.grille[8][2].state = false;
        GrilleManager.grille[9][2].state = false;
        GrilleManager.grille[10][2].state = false;
        GrilleManager.grille[11][2].state = false;
        GrilleManager.grille[12][2].state = false;
        GrilleManager.grille[13][2].state = false;
        GrilleManager.grille[14][2].state = false;
        GrilleManager.grille[15][2].state = false;
        GrilleManager.grille[16][2].state = false;
        GrilleManager.grille[17][2].state = false;
        GrilleManager.grille[18][2].state = false;
        GrilleManager.grille[19][2].state = false;
        GrilleManager.grille[20][2].state = false;
        GrilleManager.grille[21][2].state = false;
        GrilleManager.grille[22][2].state = false;
        GrilleManager.grille[1][3].state = false;
        GrilleManager.grille[22][3].state = false;
        GrilleManager.grille[1][4].state = false;
        GrilleManager.grille[3][4].state = false;
        GrilleManager.grille[11][4].state = false;
        GrilleManager.grille[22][4].state = false;
        GrilleManager.grille[1][5].state = false;
        GrilleManager.grille[3][5].state = false;
        GrilleManager.grille[11][5].state = false;
        GrilleManager.grille[22][5].state = false;
        GrilleManager.grille[1][6].state = false;
        GrilleManager.grille[3][6].state = false;
        GrilleManager.grille[6][6].state = false;
        GrilleManager.grille[7][6].state = false;
        GrilleManager.grille[8][6].state = false;
        GrilleManager.grille[9][6].state = false;
        GrilleManager.grille[10][6].state = false;
        GrilleManager.grille[11][6].state = false;
        GrilleManager.grille[12][6].state = false;
        GrilleManager.grille[13][6].state = false;
        GrilleManager.grille[14][6].state = false;
        GrilleManager.grille[15][6].state = false;
        GrilleManager.grille[16][6].state = false;
        GrilleManager.grille[17][6].state = false;
        GrilleManager.grille[20][6].state = false;
        GrilleManager.grille[21][6].state = false;
        GrilleManager.grille[22][6].state = false;
        GrilleManager.grille[1][7].state = false;
        GrilleManager.grille[3][7].state = false;
        GrilleManager.grille[11][7].state = false;
        GrilleManager.grille[20][7].state = false;
        GrilleManager.grille[1][8].state = false;
        GrilleManager.grille[3][8].state = false;
        GrilleManager.grille[11][8].state = false;
        GrilleManager.grille[20][8].state = false;
        GrilleManager.grille[1][9].state = false;
        GrilleManager.grille[3][9].state = false;
        GrilleManager.grille[11][9].state = false;
        GrilleManager.grille[20][9].state = false;
        GrilleManager.grille[1][10].state = false;
        GrilleManager.grille[3][10].state = false;
        GrilleManager.grille[11][10].state = false;
        GrilleManager.grille[1][11].state = false;
        GrilleManager.grille[3][11].state = false;
        GrilleManager.grille[4][11].state = false;
        GrilleManager.grille[5][11].state = false;
        GrilleManager.grille[6][11].state = false;
        GrilleManager.grille[8][11].state = false;
        GrilleManager.grille[9][11].state = false;
        GrilleManager.grille[10][11].state = false;
        GrilleManager.grille[11][11].state = false;
        GrilleManager.grille[12][11].state = false;
        GrilleManager.grille[13][11].state = false;
        GrilleManager.grille[14][11].state = false;
        GrilleManager.grille[15][11].state = false;
        GrilleManager.grille[16][11].state = false;
        GrilleManager.grille[17][11].state = false;
        GrilleManager.grille[18][11].state = false;
        GrilleManager.grille[19][11].state = false;
        GrilleManager.grille[20][11].state = false;
        GrilleManager.grille[21][11].state = false;
        GrilleManager.grille[1][12].state = false;
        GrilleManager.grille[3][12].state = false;
        GrilleManager.grille[8][12].state = false;
        GrilleManager.grille[21][12].state = false;
        GrilleManager.grille[1][13].state = false;
        GrilleManager.grille[3][13].state = false;
        GrilleManager.grille[6][13].state = false;
        GrilleManager.grille[8][13].state = false;
        GrilleManager.grille[10][13].state = false;
        GrilleManager.grille[11][13].state = false;
        GrilleManager.grille[12][13].state = false;
        GrilleManager.grille[13][13].state = false;
        GrilleManager.grille[14][13].state = false;
        GrilleManager.grille[15][13].state = false;
        GrilleManager.grille[16][13].state = false;
        GrilleManager.grille[17][13].state = false;
        GrilleManager.grille[18][13].state = false;
        GrilleManager.grille[19][13].state = false;
        GrilleManager.grille[21][13].state = false;
        GrilleManager.grille[6][14].state = false;
        GrilleManager.grille[8][14].state = false;
        GrilleManager.grille[10][14].state = false;
        GrilleManager.grille[19][14].state = false;
        GrilleManager.grille[21][14].state = false;
        GrilleManager.grille[1][15].state = false;
        GrilleManager.grille[3][15].state = false;
        GrilleManager.grille[6][15].state = false;
        GrilleManager.grille[8][15].state = false;
        GrilleManager.grille[10][15].state = false;
        GrilleManager.grille[12][15].state = false;
        GrilleManager.grille[14][15].state = false;
        GrilleManager.grille[17][15].state = false;
        GrilleManager.grille[19][15].state = false;
        GrilleManager.grille[21][15].state = false;
        GrilleManager.grille[3][16].state = false;
        GrilleManager.grille[6][16].state = false;
        GrilleManager.grille[8][16].state = false;
        GrilleManager.grille[10][16].state = false;
        GrilleManager.grille[11][16].state = false;
        GrilleManager.grille[12][16].state = false;
        GrilleManager.grille[13][16].state = false;
        GrilleManager.grille[14][16].state = false;
        GrilleManager.grille[15][16].state = false;
        GrilleManager.grille[16][16].state = false;
        GrilleManager.grille[17][16].state = false;
        GrilleManager.grille[19][16].state = false;
        GrilleManager.grille[21][16].state = false;
        GrilleManager.grille[1][17].state = false;
        GrilleManager.grille[3][17].state = false;
        GrilleManager.grille[8][17].state = false;
        GrilleManager.grille[19][17].state = false;
        GrilleManager.grille[21][17].state = false;
        GrilleManager.grille[1][18].state = false;
        GrilleManager.grille[3][18].state = false;
        GrilleManager.grille[8][18].state = false;
        GrilleManager.grille[9][18].state = false;
        GrilleManager.grille[10][18].state = false;
        GrilleManager.grille[11][18].state = false;
        GrilleManager.grille[12][18].state = false;
        GrilleManager.grille[13][18].state = false;
        GrilleManager.grille[14][18].state = false;
        GrilleManager.grille[15][18].state = false;
        GrilleManager.grille[16][18].state = false;
        GrilleManager.grille[17][18].state = false;
        GrilleManager.grille[18][18].state = false;
        GrilleManager.grille[19][18].state = false;
        GrilleManager.grille[21][18].state = false;
        GrilleManager.grille[1][19].state = false;
        GrilleManager.grille[3][19].state = false;
        GrilleManager.grille[6][19].state = false;
        GrilleManager.grille[21][19].state = false;
        GrilleManager.grille[1][20].state = false;
        GrilleManager.grille[3][20].state = false;
        GrilleManager.grille[6][20].state = false;
        GrilleManager.grille[7][20].state = false;
        GrilleManager.grille[8][20].state = false;
        GrilleManager.grille[9][20].state = false;
        GrilleManager.grille[10][20].state = false;
        GrilleManager.grille[11][20].state = false;
        GrilleManager.grille[12][20].state = false;
        GrilleManager.grille[13][20].state = false;
        GrilleManager.grille[14][20].state = false;
        GrilleManager.grille[15][20].state = false;
        GrilleManager.grille[16][20].state = false;
        GrilleManager.grille[17][20].state = false;
        GrilleManager.grille[18][20].state = false;
        GrilleManager.grille[19][20].state = false;
        GrilleManager.grille[20][20].state = false;
        GrilleManager.grille[21][20].state = false;
        GrilleManager.grille[1][21].state = false;
        GrilleManager.grille[3][21].state = false;
        GrilleManager.grille[6][21].state = false;
        GrilleManager.grille[8][21].state = false;
        GrilleManager.grille[11][21].state = false;
        GrilleManager.grille[1][22].state = false;
        GrilleManager.grille[6][22].state = false;
        GrilleManager.grille[1][23].state = false;
        GrilleManager.grille[2][23].state = false;
        GrilleManager.grille[3][23].state = false;
        GrilleManager.grille[4][23].state = false;
        GrilleManager.grille[5][23].state = false;
        GrilleManager.grille[6][23].state = false;
        GrilleManager.grille[7][23].state = false;
        GrilleManager.grille[8][23].state = false;
        GrilleManager.grille[9][23].state = false;
        GrilleManager.grille[10][23].state = false;
        GrilleManager.grille[11][23].state = false;
        GrilleManager.grille[12][23].state = false;
        GrilleManager.grille[13][23].state = false;
        GrilleManager.grille[14][23].state = false;
        GrilleManager.grille[15][23].state = false;
        GrilleManager.grille[16][23].state = false;
        GrilleManager.grille[17][23].state = false;
        GrilleManager.grille[18][23].state = false;
        GrilleManager.grille[19][23].state = false;
        GrilleManager.grille[20][23].state = false;
        GrilleManager.grille[21][23].state = false;
        GrilleManager.grille[22][23].state = false;
        GrilleManager.grille[23][23].state = false;
//</editor-fold>

        EntiteManager.addEntite(new Piece(228, 504));
        EntiteManager.addEntite(new Piece(532, 756));
        EntiteManager.addEntite(new Piece(684, 756));
        EntiteManager.addEntite(new Piece(532, 756));
        EntiteManager.addEntite(new Piece(760, 756));
        EntiteManager.addEntite(new Piece(684, 684));
        EntiteManager.addEntite(new Piece(760, 684));
        EntiteManager.addEntite(new Piece(836, 684));
        EntiteManager.addEntite(new Piece(912, 684));
        EntiteManager.addEntite(new Piece(988, 684));
        EntiteManager.addEntite(new Piece(988, 540));
        EntiteManager.addEntite(new Piece(836, 540));
        EntiteManager.addEntite(new Piece(1140, 540));
        EntiteManager.addEntite(new Piece(1216, 540));
        EntiteManager.addEntite(new Piece(836, 432));
        EntiteManager.addEntite(new Piece(988, 432));
        EntiteManager.addEntite(new Piece(1140, 432));
        EntiteManager.addEntite(new Piece(1216, 432));
        EntiteManager.addEntite(new Piece(912, 324));
        EntiteManager.addEntite(new Piece(760, 324));
        EntiteManager.addEntite(new Piece(760, 144));
        EntiteManager.addEntite(new Piece(912, 144));
        EntiteManager.addEntite(new Piece(1596, 180));
        EntiteManager.addEntite(new Piece(1596, 108));
        EntiteManager.addEntite(new Piece(1748, 864));
        EntiteManager.addEntite(new Piece(912, 864));
        EntiteManager.addEntite(new Piece(152, 864));
        EntiteManager.addEntite(new Piece(76, 504));
        EntiteManager.addEntite(new Piece(76, 576));
        EntiteManager.addEntite(new Piece(1368, 36));
        EntiteManager.addEntite(new Piece(1672, 36));
        EntiteManager.addEntite(new Piece(912, 36));
        EntiteManager.addEntite(new Piece(532, 36));
        EntiteManager.addEntite(new Piece(152, 36));
        EntiteManager.addEntite(new Piece(228, 108));
    }

    public static Case[][] getGrille() {
        return (Case[][]) grille.clone();
    }

    public static Case getCaseFor(Entite entite) {
        try {
            if (entite != null) {
                for (Case[] grille1 : grille) {
                    for (Case g : grille1) {
                        if (g.intersects(entite)) {
                            return g;
                        }
                    }

                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static int getCellWidth() {
        if (fenetre == null) {
            return 0;
        }
        if (fenetre.panneau == null) {
            return 0;
        }
        return fenetre.panneau.getWidth() / COLUMNCOUNT;
    }

    public static int getCellHeight() {
        if (fenetre == null) {
            return 0;
        }
        if (fenetre.panneau == null) {
            return 0;
        }

        return fenetre.panneau.getHeight() / ROWCOUNT;
    }

    public static Case getCaseHover() {
        for (Case[] grille1 : grille) {
            for (Case g : grille1) {
                if (g.contains(Panneau.selection)) {
                    return g;
                }
            }
        }
        return null;
    }

    public static ArrayList<Case> getPath(Case debut, Case fin) {
        try {
            if (debut == null || fin == null) {
                return new ArrayList<>();
            }
            ArrayList<Search> searchs = new PathFinder().getPathFor(debut, fin);
            ArrayList<Case> cases = new ArrayList<>();
            if (searchs != null) {
                searchs.stream().forEach((search) -> {
                    cases.add(search.c);
                });
            }
            return cases;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
