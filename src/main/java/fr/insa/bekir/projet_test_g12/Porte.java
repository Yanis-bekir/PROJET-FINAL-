/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bekir.projet_test_g12;

/**
 *
 * @author Helo
 */
public class Porte extends Ouverture {

    public Porte(double hauteur, double largeur) {
        super(hauteur, largeur);
    }
   
    public  static double surfaceporte (){
       hauteur = 2.1;
       largeur = 0.9;
       return hauteur*largeur;
    }

}
