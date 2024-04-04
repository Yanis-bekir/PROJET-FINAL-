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
public class Pièce extends Niveau{
    int idPiece;
    int sol;
    int plafond;
    ArrayList listMurs;
    
    
   Pièce(int idNiveau, int id, int sol, int plafond, ArrayList idmurs){
        this.idNiveau = idNiveau ;
        this.idPiece = id ;
        this.sol = sol ; 
        this.plafond = plafond ; 
        this.listMurs = idmurs ;
}
