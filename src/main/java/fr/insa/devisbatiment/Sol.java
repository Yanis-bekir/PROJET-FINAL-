/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.devisbatiment;

import java.util.ArrayList;

public class Sol {
    //declaration des attributs de la classe Coin
    int idSol;
    ArrayList listeCoins = new ArrayList<Coin>();
    ArrayList ListeRevetements =new ArrayList<Revetement>();
    
    @Override
    public String afficher() {
        return "L'identifiant du sol est "+ idSol + ", la liste des coins est " + listeCoins + "et la liste des revetements est " + ListeRevetements  ;
    }

    @Override
    public String toString() {
        return "Sol{" + "idSol=" + idSol + ", listeCoins=" + listeCoins + ", ListeRevetements=" + ListeRevetements + '}';
    }
   
    public Double surface() {
       
    } 
    public Double montantRevetement() {
}
