/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bekir.projet_test_g12;
import java.lang.Math;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 *
 * @author Helo
 */
public class Mur {
    int idMur;
    Coin debut;
    Coin fin; 
    Revetement rev;
    static int NextId=0;
    int NbreFenetre, NbrePorte;
    
    
    

    public Mur(Coin debut, Coin fin, Revetement rev, int NbrePorte, int NbreFenetre) {
        this.idMur = NextId++;   //Générationa automatique de l'identifiant
        this.debut = debut;
        this.fin = fin;
        this.rev = rev;
        this.NbreFenetre=NbreFenetre;
        this.NbrePorte=NbrePorte;
        
    }

    @Override
    public String toString() {
        return "Mur{" + "idMur = " + idMur + ", debut = " + debut + ", fin = " + fin + "}";
    }
    
    public double longueur (){
        return Math.sqrt(Math.pow(this.fin.getX() - this.debut.getX(),2) + Math.pow(this.fin.getY() - this.debut.getY(),2));
    }
    
    public double surface(double hsp,int NbrePorte, int NbreFenetre){
        return hsp * (this.longueur()/10)-((NbrePorte*Porte.surfaceporte()+NbreFenetre*Fenetre.surfacefenetre())/4);
        //Nous divisons par 4 car le nombre de portes et de fenetres correspond 
        //au nombre de portes et de fenetres d'une pièce et non d'un mur
    
    }
    
    public double prixM(double hsp){
        double surface = surface(hsp, NbrePorte, NbreFenetre);
        return this.rev.prixUni(this.rev.getIdRevetement()) * surface;
    }
    
    public void dessiner(GraphicsContext context){
        context.setStroke(Color.BLACK);
        context.strokeLine(this.debut.getX(), this.debut.getY(), this.fin.getX(), this.fin.getY());   
    }

}
