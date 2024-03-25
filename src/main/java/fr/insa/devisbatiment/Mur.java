/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.devisbatiment;

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
    public List listerevetement;
    
    
    Mur(int id, Coin coindebut, Coin coinfin) {
    this.idmur = id;
    this.coindebut = coindebut;
    this.coinfin = coinfin;
    }
}
