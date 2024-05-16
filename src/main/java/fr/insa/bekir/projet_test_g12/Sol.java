/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bekir.projet_test_g12;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Helo
 */
public class Sol {
    int idSol;
    Mur l;
    Mur L;
    Revetement rev;

    public Sol(int idSol, Mur Longueur, Mur largeur, Revetement rev) {
        this.idSol = idSol;
        this.l = largeur;
        this.L = Longueur;
        this.rev = rev;
    }

    @Override
    public String toString() {
        return "Sol{" + "idSol = " + idSol + ", l = " + l + ", L = " + L + ", rev = " + rev + '}';
    }

    public double surface(){
        //les dimensions sont en decimetre donc on divise par 10
        return (this.l.longueur()/10) * (this.L.longueur()/10);
    }
    
    public double prixS(){
        double surface = surface();
        return rev.prixUni(rev.getIdRevetement()) * surface;
    }

    public int getRevSol() {
        return rev.getIdRevetement();
    }

    public void dessiner(GraphicsContext context){
        // (x,y,longueur,largeur) 
        // x,y etant les coordonnees du point en haut a gauche
        context.strokeRect(this.L.debut.getX(), this.L.debut.getY(), this.L.longueur(), this.l.longueur());
        /*this.L.debut.dessiner(context);
        this.L.fin.dessiner(context);
        this.l.debut.dessiner(context);
        this.l.fin.dessiner(context);
        */
    }
    
}
