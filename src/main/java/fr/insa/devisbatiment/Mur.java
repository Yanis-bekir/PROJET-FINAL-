/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.devisbatiment;
import java.util.ArrayList;

/**
 *
 * @author ybekir01
 */
public class Mur { 
    
    public int idmur;
    public Coin coindebut;
    public Coin coinfin;
    public int nbrPortes;
    public int nbrFenetre;
    ArrayList ListeRevetements =new ArrayList<Revetement>();
    
    
    Mur(int id, Coin coindebut, Coin coinfin, int nbrPortes, int nbrFenetre, ArrayList idRevetement) {
    this.idmur = id;
    this.coindebut = coindebut;
    this.coinfin = coinfin;
    this.nbrFenetre = nbrFenetre;
    this.nbrPortes = nbrPortes;
    this.ListeRevetements = idRevetement;
    }
    
    public void afficher(){
        
        
    }

  
    @Override
    public String toString() {
        return "Mur{" + "idmur=" + idmur + ", coindebut=" + coindebut + ", coinfin=" + coinfin + ", nbrPortes=" + nbrPortes + ", nbrFenetre=" + nbrFenetre + ", ListeRevetements=" + ListeRevetements + '}';
    }
    
    public double surface (double h, double l){
       double surface = h*l;
       return surface;
    }
    
    public double montantRevetement (double s, double p){
        double montant;
        montant=s*p;
        return montant; 
    }
}
