/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ville.util;

/**
 *
 * @author admin
 */
public abstract class Action {

    public String nom;

    public Action(String nom) {
        this.nom = nom;
    }

    public abstract void action();
}
