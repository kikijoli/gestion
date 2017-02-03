/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.util;

import java.util.ArrayList;
import ville.manager.GrilleManager;
import ville.ui.Case;

/**
 *
 * @author admin
 */
public class PathFinder {

    private Search fin = null;
    private Case target = null;
    private int compte = 0;
    private ArrayList<Search> indexes = new ArrayList<Search>();
    private int incremental = 0;
    private ArrayList<Search> good = new ArrayList<>();
    private Search debut = null;

    /**
     *
     * @param source
     * @param target
     * @return
     */
    public ArrayList<Search> getPathFor(Case source, Case target) {
        this.target = target;
        if (!target.state) {
            return null;
        }
        Search[][] searchs = new Search[GrilleManager.COLUMNCOUNT][GrilleManager.ROWCOUNT];
        Case[][] grille = (Case[][]) Util.deepClone(GrilleManager.grille);
//        if (target.row <= 0 || target.col <= 0 || source.row <= 0 || source.col <= 0) {
//            return null;
//        }
        debut = null;
        for (Case[] grille1 : grille) {
            for (Case g : grille1) {
                searchs[g.col][g.row] = new Search(g, 1000);
                if (source.col == g.col && source.row == g.row) {
                    debut = searchs[g.col][g.row];
                    debut.index = 0;
                }
            }
        }
        if (debut == null) {
            return null;
        }
        cherche(debut, searchs);
        if (fin == null) {

            return null;
        }
        constructPath(fin, searchs);

        while (incremental < GrilleManager.COLUMNCOUNT * GrilleManager.ROWCOUNT) {
            for (Search indexe : indexes) {
                if (indexe.index == 0) {
                    return getGoodPath(searchs, indexes);
                }
            }
            for (Search[] search : searchs) {
                for (Search search1 : search) {
                    if (search1.close) {
                        search1.index += 1;
                        search1.close = false;
                    }
                }
            }

            indexes.clear();
            incremental++;

            constructPath(fin, searchs);

        }

        return null;
    }

    /**
     *
     * @param current
     * @param searchs
     * @return
     */
    private ArrayList<Search> constructPath(Search current, Search[][] searchs) {

        current.close = true;
        indexes.add(current);
        ArrayList<Search> child = new ArrayList<>();
        getNext(current, searchs, child);
        child.stream().forEach((child1) -> {
            constructPath(child1, searchs);
        });

        return child;
    }

    /**
     *
     * @param current
     * @param searchs
     * @param childs
     * @return
     */
    private void getNext(Search current, Search[][] searchs, ArrayList<Search> childs) {
        if (current.c.col + 1 < GrilleManager.COLUMNCOUNT) {
            if (searchs[current.c.col + 1][current.c.row].index == current.index - 1 && !searchs[current.c.col + 1][current.c.row].close) {
                childs.add(searchs[current.c.col + 1][current.c.row]);
            }
        }
        if (current.c.col - 1 >= 0) {
            if (searchs[current.c.col - 1][current.c.row].index == current.index - 1 && !searchs[current.c.col - 1][current.c.row].close) {
                childs.add(searchs[current.c.col - 1][current.c.row]);
            }
        }
        if (current.c.row + 1 < GrilleManager.ROWCOUNT) {
            if (searchs[current.c.col][current.c.row + 1].index == current.index - 1 && !searchs[current.c.col][current.c.row + 1].close) {
                childs.add(searchs[current.c.col][current.c.row + 1]);
            }
        }

        if (current.c.row - 1 >= 0) {
            if (searchs[current.c.col][current.c.row - 1].index == current.index - 1 && !searchs[current.c.col][current.c.row - 1].close) {
                childs.add(searchs[current.c.col][current.c.row - 1]);
            }
        }
    }
//    private Index LookFor(int index, Search current) {
//
//    }

    /**
     *
     * @param current
     * @param grille
     */
    public void cherche(Search current, Search[][] grille) {

        //au dessus
        if (current.c.row + compte < GrilleManager.ROWCOUNT) {
            if (grille[current.c.col][current.c.row + compte].c.state) {
                grille[current.c.col][current.c.row + compte].index = compte;
            }
            complete(current.c.row + compte, current.c.col, compte, grille);
        }
        //ne dessous
        if (current.c.row - compte >= 0) {
            if (grille[current.c.col][current.c.row - compte].c.state) {
                grille[current.c.col][current.c.row - compte].index = compte;
            }
            complete(current.c.row - compte, current.c.col, compte, grille);
        }
        if (compte < GrilleManager.COLUMNCOUNT) {
            compte += 1;
            cherche(current, grille);
        }
    }

    /**
     *
     * @param search
     */
    private void checkifFin(Search search) {
        if (search.c.col == this.target.col && search.c.row == this.target.row) {
            this.fin = search;
        }
    }

    /**
     *
     * @param y
     * @param x
     * @param index
     * @param grille
     */
    private void complete(int y, int x, int index, Search[][] grille) {
        int number = 1;
        int increm = index;
        if (target.col == x && target.row == y) {
            fin = grille[x][y];
        }
        while (x + number < GrilleManager.COLUMNCOUNT) {
            ++increm;
            if (grille[x + number][y].c.state) {
                grille[x + number][y].index = increm;
            }

            if (target.col == (x + number) && target.row == y) {
                fin = grille[x + number][y];
            }
            number++;

        }
        number = 1;
        increm = index;
        while (x - number >= 0) {

            ++increm;
            if (grille[x - number][y].c.state) {
                grille[x - number][y].index = increm;
            }
            if (target.col == (x - number) && target.row == y) {
                fin = grille[x - number][y];
            }
            number++;

        }
    }

    /**
     *
     * @param searchs
     */
    private void print(Search[][] searchs) {
        for (Search[] search : searchs) {
            for (Search search1 : search) {
                if (fin.c.col == search1.c.col && fin.c.row == search1.c.row) {
                }
            }
        }
    }

    /**
     *
     * @param searchs
     * @param indexes
     */
    private void print(Search[][] searchs, ArrayList<Search> indexes) {
        for (Search[] search : searchs) {
            for (Search search1 : search) {
                for (Search i : indexes) {
                    if (i == search1) {
                    }
                }
                if (fin.c.col == search1.c.col && fin.c.row == search1.c.row) {
                }
            }
        }
    }

    private ArrayList<Search> getGoodPath(Search[][] searchs, ArrayList<Search> indexes) {
        int count = 0;
        good.add(debut);
        Search current = debut;
        boolean finOk = false;
        while (!finOk) {
            if (current != null) {
                current = getNextGood(current, searchs, indexes);
                good.add(current);
                if (current == fin) {
                    finOk = true;
                }
            } else {
//                print(searchs, indexes);
//                print(searchs, good);
                return new ArrayList<>();
            }
            count++;
        }
        return good;
    }

    private Search getNextGood(Search current, Search[][] searchs, ArrayList<Search> indexes) {
        if (current.c.col + 1 < GrilleManager.COLUMNCOUNT) {
            if (searchs[current.c.col + 1][current.c.row].index == current.index + 1 && indexes.contains(searchs[current.c.col + 1][current.c.row])) {
                return (searchs[current.c.col + 1][current.c.row]);
            }
        }
        if (current.c.col - 1 >= 0) {
            if (searchs[current.c.col - 1][current.c.row].index == current.index + 1 && indexes.contains(searchs[current.c.col - 1][current.c.row])) {
                return (searchs[current.c.col - 1][current.c.row]);
            }
        }
        if (current.c.row + 1 < GrilleManager.ROWCOUNT) {
            if (searchs[current.c.col][current.c.row + 1].index == current.index + 1 && indexes.contains(searchs[current.c.col][current.c.row + 1])) {
                return (searchs[current.c.col][current.c.row + 1]);
            }
        }
        if (current.c.row - 1 >= 0) {
            if (searchs[current.c.col][current.c.row - 1].index == current.index + 1 && indexes.contains(searchs[current.c.col][current.c.row - 1])) {
                return (searchs[current.c.col][current.c.row - 1]);
            }
        }
        return null;
    }

    public class Search {

        public Case c;
        public int index;
        public boolean close = false;

        /**
         *
         * @param c
         * @param index
         */
        public Search(Case c, int index) {
            this.c = c;
            this.index = index;
        }

    }

}
