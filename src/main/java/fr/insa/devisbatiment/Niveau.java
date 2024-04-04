package fr.insa.devisbatiment;

import java.util.ArrayList;

public class Niveau extends Batiment {
   int idNiveau;
   double hauteurSousPlafond ;
   ArrayList ListeAppart ;

   Niveau(int id, double idhsp, ArrayList listappart){
        this.idNiveau = id ;
        this.hauteurSousPlafond = idhsp ;
        this.ListeAppart = listappart ;
    }
}