/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bekir.projet_test_g12;

import static com.INSA.JulesC.projetS2.ProjetS2.lireDataPlan;
import static com.INSA.JulesC.projetS2.Revetement.lireFichier;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author jules
 */
public class Maison {
    
    private List<Piece> contient;
    private static int idMaison = 0;

    public List<Piece> getContient() {
        return contient;
    }

    public Maison(){
        this.idMaison = idMaison++;
        this.contient = new ArrayList<Piece>();
    }
    
    public void add(Piece P) {
        if (P.getMaison() != this) {
            if (P.getMaison() != null) {
                throw new Error("figure déja dans un autre groupe");
            }
            this.contient.add(P);
            P.setMaison(this);
        }
    }
    
    public void remove(Piece P) {
        if (P.getMaison() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.contient.remove(P);
        P.setMaison(this);
    }
    
    public int size() {
        return this.contient.size();
    }
   
    public void dessiner(GraphicsContext context){
        // pour chaque piece contenu dans la maison
        for(Piece p : this.contient){
            p.dessiner(context);
        }
    }
    
    
    public static Maison creaMaison(String fileName){
        
        Maison maison = new Maison();
        //String fileName = "plan.csv";
        String[][] dataPlan = lireDataPlan(fileName);
        
        int nbPiece = (dataPlan.length) - 1;
        // lit le nombre de lignes - 1 pour avoir le nombre de piece
        
        double[] prixPiece = new double[nbPiece];
        
        for (int i = 0; i < nbPiece; i++){
            
            // On cree dès le debut les revetements :
            Revetement RevM = new Revetement(Integer.parseInt(dataPlan[i+1][7]));
            Revetement RevSol = new Revetement(Integer.parseInt(dataPlan[i+1][8]));
            Revetement RevPl = new Revetement(Integer.parseInt(dataPlan[i+1][9]));
            
            int idRevM = RevM.getIdRevetement();
            int idRevSol = RevSol.getIdRevetement();
            int idRevPl = RevPl.getIdRevetement();

            // cree la matrice du fichier revetement :
            String fileName2 = "revetements.txt";
            String[][] tableauRevet = lireFichier(fileName2);
            //test
            System.out.println("test tableau :"+ tableauRevet[3][1]);
            
            // ici on verifie que le revet est compatible (meme chose 3 fois) :
            
            // regarde si le revetement est O ou 1 pour la surface dans le fichier des revetements
            int idRevMurOI = Integer.parseInt(tableauRevet[idRevM-1][2]);
            while (idRevMurOI != 1){
                System.out.println("Le revetement ne peut pas s'appliquer sur un mur, veuillez choisir un nouveau revetement :");
                idRevM = Lire.i();      //on lit le nouveau revet
                RevM.setIdRevetement(idRevM);
                idRevMurOI = Integer.parseInt(tableauRevet[idRevM-1][2]); // on actualise la variable pour voir s'il est compatible
            }
            
            int idRevSolOI = Integer.parseInt(tableauRevet[idRevSol-1][3]);
            while (idRevSolOI != 1){
                System.out.println("Le revetement ne peut pas s'appliquer sur un sol, veuillez choisir un nouveau revetement :");
                idRevSol = Lire.i();      //on lit le nouveau revet
                RevSol.setIdRevetement(idRevSol);
                idRevSolOI = Integer.parseInt(tableauRevet[idRevSol-1][3]); // on actualise la variable pour voir s'il est compatible
            }
            
            int idRevPlOI = Integer.parseInt(tableauRevet[idRevPl-1][4]);
            while (idRevPlOI != 1){
                System.out.println("Le revetement ne peut pas s'appliquer sur un plafond, veuillez choisir un nouveau revetement :");
                idRevPl = Lire.i();      //on lit le nouveau revet
                RevPl.setIdRevetement(idRevPl);
                idRevPlOI = Integer.parseInt(tableauRevet[idRevPl-1][4]); // on actualise la variable pour voir s'il est compatible
            }
            
            // On cree 3 coins :
            Coin coin1 = new Coin (1, Double.parseDouble(dataPlan[i+1][1]), Double.parseDouble(dataPlan[i+1][2]));
            Coin coin2 = new Coin (2, Double.parseDouble(dataPlan[i+1][3]), Double.parseDouble(dataPlan[i+1][4]));
            Coin coin3 = new Coin (3, Double.parseDouble(dataPlan[i+1][5]), Double.parseDouble(dataPlan[i+1][6]));
            
            
            //On récupère au préalable le nombre de portes et de fenêtres :
            int nbPorte = Integer.parseInt(dataPlan[i+1][11]);
            int nbFenetre = Integer.parseInt(dataPlan[i+1][12]);
            
            
            // On cree deux murs :
            Mur mur1 = new Mur(coin1,coin2,RevM,nbPorte, nbFenetre);
            Mur mur2 = new Mur(coin2,coin3,RevM,nbPorte, nbFenetre);
            //---!!--- test (a supprimer apres)
            System.out.println("le mur est de longueur "+ mur1.longueur());
            System.out.println("le mur est de longueur "+ mur2.longueur());
            
            // On cree le sol :
            Sol sol = new Sol(1,mur1,mur2,RevSol);
            // ---!!--- test ---------
            System.out.println("la surface de ce sol est de "+ sol.surface());
            
            //On cree le plafond :
            Plafond plafond = new Plafond(1,mur1,mur2,RevPl);
            //---!!--- test ---------
            System.out.println("la surface de ce plafond est de "+ plafond.surface());
            
            System.out.println("le prix de ce sol est de "+ sol.prixS());
            System.out.println("le prix de ce plafond est de "+ plafond.prixP());
            
            
            //On cree enfin la piece :
                            
            Piece piece = new Piece(sol, plafond, mur1, mur2, nbPorte, nbFenetre);
            System.out.println("Le devis est de "+piece.prixf(Double.parseDouble(dataPlan[i+1][10])));
            prixPiece[i] = piece.prixf(Double.parseDouble(dataPlan[i+1][10]));
            //on ajoute la piece a la maison
            maison.add(piece);
        }
        
        //Affichage
        try {
            BufferedWriter devis = new BufferedWriter(new FileWriter("Devis_du_Batiment.txt",true));
            double prixTot = 0;
            devis.write("DEVIS DE L'APPARTEMENT : \n");
            for (int i = 0; i < nbPiece; i++){
                devis.write("Le prix de la piece n°"+(i+1)+" est de "+prixPiece[i]+"€ \n");
                prixTot = prixTot + prixPiece[i];
            }
            devis.write("Le prix total est de "+Double.toString(prixTot)+"€ \n");  // la methode write ne peut pas ecrire de double on le converti donc en string
            devis.write("\n");
            devis.write("######################################################################### \n");
            devis.write("\n");
            devis.close();
        }
        catch (IOException message){
            System.out.println("Erreur :\n"+message);
        }
        return maison;
        
    }
}
