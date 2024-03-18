/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.devisbatiment;

/**
 *
 * @author hbogas01
 */
public class Coin {
    //declaration des attributs de la classe Coin
    int idCoin;
    double cx;
    double cy;
    
    // Declaration du constructeur
    Coin(int id, double x,double y){
        this.idCoin=id;
        this.cx=x;
        this.cy=y;
    }
    
    void afficher(){
        System.out.println("identifiant du coin : " + this.idCoin+" Abcisse : "+ this.cx+" Ordonnée : "+ this.cy);
    }

    @Override
    public String toString() {
        return "Coin{" + "idCoin=" + idCoin + ", cx=" + cx + ", cy=" + cy + '}';
    }

}

