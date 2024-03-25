package fr.insa.devisbatiment;

import java.util.ArrayList;

public class Sol {
    //declaration des attributs de la classe Coin
    int idSol;
    ArrayList listeCoins;
    ArrayList ListeRevetements;

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
    
}