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
    public Arraylist listerevetement;
    
    
    Mur(int id, Coin coindebut, Coin coinfin, int nbrPortes, int nbrFenetre, Arraylist idRevetement) {
    this.idmur = id;
    this.coindebut = coindebut;
    this.coinfin = coinfin;
    this.nbrFenetre = nbrFenetre;
    this.nbrPortes = nbrPortes;
    }
    
    public void afficher(){
        
    }
    
    public void surface (double h, double l){
        
    }
    
    public void montantRevetement (double s, double p){
        double montant;
        montant=s*p;
    }
}
