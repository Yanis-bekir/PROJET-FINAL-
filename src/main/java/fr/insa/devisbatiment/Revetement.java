/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.devisbatiment;

/**
 *
 * @author ybekir01
 */
public class Revetement {
   int idRevetement;
   String designation;
   boolean pourMur;
   boolean pourSol;
   boolean pourPlafond;
   double prixUnitaire;
   
   
    Revetement(int id, String designation, boolean Mur, boolean Sol, boolean Plafond, double prixUnitaire) {
    this.idRevetement = id;
    this.designation = designation;
    this.pourMur = Mur;
    this.pourSol = Sol;
    this.pourPlafond = Plafond;
    this.prixUnitaire = prixUnitaire;
    }
    
}
