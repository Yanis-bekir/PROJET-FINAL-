/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bekir.projet_test_g12;

/**
 *
 * @author jules
 */
public class Plafond_1 {
    int idPlafond;
    Mur l;
    Mur L;
    Revetement rev;

    public Plafond_1(int idPlafond, Mur Longueur, Mur largeur, Revetement rev) {
        this.idPlafond = idPlafond;
        this.l = largeur;
        this.L = Longueur;
        this.rev = rev;
    }

    
    public double surface(){
        return (this.l.longueur()/10) * (this.L.longueur()/10);
    }
    
    public double prixP(){
        double surface = surface();
        return rev.prixUni(rev.getIdRevetement()) * surface;
    }

    public int getRevPlafond() {
        return rev.getIdRevetement();
    }
    
}
