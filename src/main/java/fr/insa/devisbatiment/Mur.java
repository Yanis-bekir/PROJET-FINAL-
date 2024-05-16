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
        System.out.println("identifiant du mur : " + this.idmur+" Coin debut : "+ this.coindebut +" Coin fin : "+ this.coinfin + " Nombre de fenêtres : " + this.nbrFenetre + " Nombre de portes" + this.nbrPortes + " id revetement : " + this.ListeRevetements);
    }

  
    @Override
    public String toString() {
        return "Mur{" + "idmur=" + idmur + ", coindebut=" + coindebut + ", coinfin=" + coinfin + ", nbrPortes=" + nbrPortes + ", nbrFenetre=" + nbrFenetre + ", ListeRevetements=" + ListeRevetements + '}';
    }
    
    public double surface (double h, double l){
       double s = 
       return s;
    }
    
    public double montantRevetement (double s, double p){
        double montant;
        montant=s*p;
        return montant; 
    }
}
