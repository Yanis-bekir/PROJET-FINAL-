    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bekir.projet_test_g12;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Helo
 */
public class Piece {
    
    private static int idPiece =  0; 
    Mur l;
    Mur L;
    Sol sol;
    Plafond plafond;
    Revetement revS;
    Revetement revPl;
    private Maison maison;
    private int nbPorte; 
    private int nbFenetre;
    
    

    public Piece(Sol sol, Plafond plafond, Mur L, Mur l, int nbPorte, int nbFenetre) {
        this.idPiece = idPiece++;
        this.sol = sol;
        this.plafond = plafond;
        this.L = L;
        this.l = l;
        this.nbPorte = nbPorte;
        this.nbFenetre = nbFenetre; 
    }

    public double surface(){
        return sol.surface();
    }
    
    // prix de la piece :
    public double prixf(double hsp){        
        return sol.prixS() + plafond.prixP() + (2 * l.prixM(hsp)) + (2 * L.prixM(hsp));
    }

    /**
     * @return the maison
     */
    public Maison getMaison() {
        return maison;
    }

    /**
     * @param maison the maison to set
     */
    public void setMaison(Maison maison) {
        this.maison = maison;
    }
 
    public void dessiner(GraphicsContext context){
        this.sol.dessiner(context);
    }
}
