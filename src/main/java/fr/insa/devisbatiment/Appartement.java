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
public class Appartement extends Niveau {
    int idAppartement ;
    int idNiveauAppartement ;
    ArrayList listePieces ;
    
    Appartement(int id, int idNiveau, ArrayList nbrpieces){
            this.idAppartement = id ; 
            this.idNiveauAppartement = idNiveau ;
            this.listePieces = nbrpieces ;
    }
}
