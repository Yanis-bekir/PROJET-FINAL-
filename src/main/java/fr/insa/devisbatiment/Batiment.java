package fr.insa.devisbatiment;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ybekir01
 */
public class Batiment {
    String idBatiment;
    ArrayList listeNiveaux;

    Batiment(String id, ArrayList idNiveau) {
        this.idBatiment = id ;
        this.listeNiveaux = idNiveau ;
    }
    
    void afficher() {
        System.out.println("Identifiant : " + this.idBatiment+ " List : " + this.listeNiveaux);
    }
    
    void sauvegarder{
}
}
    
    
}
