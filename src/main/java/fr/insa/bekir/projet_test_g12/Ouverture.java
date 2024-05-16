/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bekir.projet_test_g12;

/**
 *
 * @author Helo
 */
public class Ouverture{
    static double hauteur; 
    static double largeur; 

    public Ouverture(double hauteur, double largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }
        
    public static double surfaceouverture (){
        return hauteur * largeur;
    }
}
