/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fr.insa.bekir.projet_test_g12;

import static com.INSA.JulesC.projetS2.Revetement.lireFichier;
import java.io.*;


/**
 *
 * @author Helo
 */
public class ProjetS2 {
    
    
    private String idBatiment;                                                  
    private int nbNiveau;
    
    public String afficher (){
        return "id = "+idBatiment+", nombre de niveaux "+nbNiveau;
    }

    public ProjetS2() {
    }

    
    public static void main(String[] args) {
        
        Maison maison = new Maison();
        String fileName = "plan.csv";
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
            
            
             //On demande à l'utilisateur le nombre de porte qu'il y a par pièce : 
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
            System.out.println(piece.prixf(Double.parseDouble(dataPlan[i+1][10])));
            prixPiece[i] = piece.prixf(Double.parseDouble(dataPlan[i+1][10]));
            //on ajoute la piece a la maison
            maison.add(piece);
            
            
        }
        
        //affichage :
        try {
            BufferedWriter devis = new BufferedWriter(new FileWriter("Devis_du_Batiment.txt",false));
            double prixTot = 0;
            for (int i = 0; i < nbPiece; i++){
                devis.write("Le prix de la piece n°"+(i+1)+" est de "+prixPiece[i]+"€ \n");
                prixTot = prixTot + prixPiece[i];
            }
            devis.write("Le prix total est de "+Double.toString(prixTot)+"€ \n");  // la methode write ne peut pas ecrire de double on le converti donc en string
            devis.close();
        }
        catch (IOException message){
            System.out.println("Erreur :\n"+message);
        }
 
        /*
        System.out.println("Quel est l'id du revetement de votre sol ?");
        int idrevsol = Lire.i();
        System.out.println("Quel est l'id du revetement de votre plafond ?");
        int idrevpl = Lire.i();
        
        
        Revetement RevSol = new Revetement(idrevsol);
        Revetement RevPl = new Revetement(idrevpl);
        Coin C1 = new Coin(1,0,0);
        Coin C2 = new Coin(2,1,0);
        Coin C3 = new Coin(3,1,1);
        Coin C4 = new Coin(4,0,1);
        Mur M1 = new Mur(1,C1,C2);
        Mur M2 = new Mur(2,C2,C3);
        Sol S1 = new Sol(1,M1,M2,RevSol);
        Plafond Pl1 = new Plafond(1,M1,M2,RevPl);
        Piece P1 = new Piece(1,M1,M2,S1,Pl1, RevSol,RevPl);
        System.out.println("le mur est de longueur "+M1.longueur());
        System.out.println("le mur est de longueur "+M2.longueur());
        System.out.println("la surface de ce mur est de "+M1.surface());
        System.out.println("la surface de ce sol est de "+S1.surface());
        System.out.println("le prix de ce sol est de "+S1.prixS(idrevsol));
        System.out.println("le prix de ce plafond est de "+Pl1.prixP(idrevsol));
        System.out.println("le prix de cette piece est de "+P1.prixf());
        
// creation des coins : 
        // tous les coins ont le meme nom (cA), pour les differencier au lieu de les appeler Coin1
        // on les appelera Coin[1]
 
        
        System.out.println("Combien as-tu de coins à placer ?");
        int nbcoin = Lire.i();
        Coin[] coin = new Coin[nbcoin];
                       
        for (int i = 0; i < nbcoin; i++){
            System.out.println("Entrez les coordonnées du coin "+(i+1)+" : ");
            System.out.println("x = ");
            double x = Lire.d();
            System.out.println("y = ");
            double y = Lire.d();
            Coin cA = new Coin (i+1, x, y);
            coin[i] = cA; 
            System.out.println(cA.afficher());
        }
        
        System.out.println("Le tableau des coins :");
        for (int i = 0; i < nbcoin; i++){
            System.out.println(coin[i].toString());
        }
        
        
// creation des murs :
        
        System.out.println("Combien as-tu de murs ?");
        int nbmur = Lire.i();
        Mur[] mur = new Mur[nbmur];
        
        for (int i = 0; i < nbmur; i++){
            System.out.println("De quels coins est composé le mur n°"+(i+1)+ " ? Entrez leurs id :");
            int id1 = Lire.i();
            int id2 = Lire.i();
            Mur mA = new Mur(i+1, coin[id1-1], coin[id2-1]);  // !!!! a verifier s'il faut pas faire id-1 ou id+1
            mur[i] = mA; 
        }
        
        System.out.println("Le tableau des murs :");
        for (int i = 0; i < nbmur; i++){
            System.out.println(mur[i].toString());
        }
        
// creation des sols et plafonds :

        System.out.println("Combien as-tu de sols ?");
        int nbsol = Lire.i();
        Sol[] sol = new Sol[nbsol];
        int[] idrevetsol = new int[nbsol];
        Plafond[] plafond = new Plafond[nbsol];
        int[] idrevetpl = new int[nbsol];
        
        for (int i = 0; i < nbsol; i++){
            System.out.println("Quel est l'id du revetement de votre plafond n°"+(i+1)+" ?");
            int idrevpl = Lire.i();
            idrevetpl[i] = idrevpl;
        }
        
        for (int i = 0; i < nbsol; i++){
            System.out.println("Quel est l'id du mur qui peut etre considere comme la longueur de la piece ?");
            int idL = Lire.i();
            System.out.println("Quel est l'id du mur qui peut etre considere comme la largeur de la piece ?");
            int idl = Lire.i();
            System.out.println("Quel est l'id du revetement de votre sol ?");
            int idrevsol = Lire.i(); 
            idrevetsol[i] = idrevsol;
            Revetement RevSol = new Revetement(idrevsol);
            Sol sA = new Sol(i+1, mur[idL-1], mur[idl-1], RevSol);
            Revetement RevPl = new Revetement(idrevetpl[i]);
            Plafond plA = new Plafond (i+1, mur[idL-1], mur[idl-1], RevPl);
            plafond[i] = plA;
            sol[i] = sA;
        }
        
        System.out.println("Le tableau des sols :");
        for (int i = 0; i < nbsol; i++){
            System.out.println(sol[i].toString());           
        }

// creation des pieces :         
        
        Piece[] piece = new Piece[nbsol];
        for (int i = 0; i < nbsol; i++){
            Piece pA = new Piece(i+1, sol[i], plafond[i]);
            piece[i] = pA;
        } 

        
// affichage final :

        // longueur mur :
        for (int i = 0; i < nbmur; i++){
            System.out.println("Le mur "+(i+1)+" est de longueur "+mur[i].longueur());
        }
        // surface mur :
        for (int i = 0; i < nbmur; i++){
            System.out.println("Le mur "+(i+1)+" est de surface "+mur[i].surface());
        }

        // surface sol :
        for (int i = 0; i < nbsol; i++){
            System.out.println("Le sol "+(i+1)+" est de surface "+sol[i].surface());
        }
        
        // prix sol :
        for (int i = 0; i < nbsol; i++){
            System.out.println("Le prix du sol n°"+(i+1)+" est de "+sol[i].prixS());
        }
        
        // prix plafond :
        for (int i = 0; i < nbsol; i++){
            System.out.println("Le prix du plafond n°"+(i+1)+" est de "+plafond[i].prixP());
        }

        // prix piece (final) :
        for (int i = 0; i < nbsol; i++){
            System.out.println("Le prix de la piece n°"+(i+1)+" est de "+piece[i].prixf());
        }
        
        
        try {
            BufferedWriter devis = new BufferedWriter(new FileWriter("Devis_du_Batiment.txt",false));
            // longueur mur :
            for (int i = 0; i < nbmur; i++){
                devis.write("Le mur "+(i+1)+" est de longueur "+mur[i].longueur()+"\n");
            }
            // surface mur :
            for (int i = 0; i < nbmur; i++){
                devis.write("Le mur "+(i+1)+" est de surface "+mur[i].surface()+"\n");
            }

            // surface sol :
            for (int i = 0; i < nbsol; i++){
                devis.write("Le sol "+(i+1)+" est de surface "+sol[i].surface()+"\n");
            }

            // prix sol :
            for (int i = 0; i < nbsol; i++){
                devis.write("Le prix du sol n°"+(i+1)+" est de "+sol[i].prixS()+"\n");
            }

            // prix plafond :
            for (int i = 0; i < nbsol; i++){
                devis.write("Le prix du plafond n°"+(i+1)+" est de "+plafond[i].prixP()+"\n");
            }

            // prix piece (final) :
            for (int i = 0; i < nbsol; i++){
                devis.write("Le prix de la piece n°"+(i+1)+" est de "+piece[i].prixf()+"€ \n");
            }
            devis.close();
        }
        catch (IOException message){
            System.out.println("Erreur :\n"+message);
        }*/

    }
    
    // cree une matrice avec les donnees du tableau excel transforme en .csv
    
    public static String[][] lireDataPlan(String fileName) {
        String[][] tableau = null;
        try (BufferedReader revet = new BufferedReader(new FileReader(fileName))) {
            String ligne;
            int nbLignes = 0;
            // cette premiere boucle sert a connaitre le nb de lignes (utile si la taille du fichier change)
            while ((ligne = revet.readLine()) != null) {
                nbLignes++;
            }
            tableau = new String[nbLignes][];
            revet.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader revet = new BufferedReader(new FileReader(fileName))) {
            String ligne;
            int i = 0;
            while ((ligne = revet.readLine()) != null) {
                String[] valeurs = ligne.split(";");
                tableau[i] = valeurs;
                // tableau dans tableau <==> matrice
                //Cette ligne signifie que nous stockons toutes les valeurs de la ligne actuelle 
                //(stockées dans le tableau uni-dimensionnel valeurs) dans la i-ème ligne du tableau à deux dimensions tableau.
                i++;
            }
            revet.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableau;
    }
}

/*
        int a = Lire.i();
        double b = Lire.d();
        double c = Lire.d();
        
        Coin c1 =new Coin(a,b,c);
        
        Coin c5 = new Coin (100,10.0,20.0);
        Coin c2 = new Coin (101,30.0,50.0);
        System.out.println(c1.toString());
        System.out.println(c2.getX());
        
        Mur m1 = new Mur (1000,c1,c2);
        System.out.println("le mur est de longueur "+m1.longueur());
        System.out.println("la surface de ce mur est de "+m1.surface());
        */
        
        // création d'une pièce
        //Revetement R1 = new Revetement (3);

// partie ou l'utilisateur entre les donnees (coordonnees des coins, murs, etc...)
        /*int again = 1;
        int i = 0;
        while (again == 1){
            System.out.println("Entrez les coordonnées d'un coin : ");
            System.out.println("x = ");
            double x = Lire.d();
            System.out.println("y = ");
            double y = Lire.d();
            Coin cA = new Coin (i, x, y);
            i++;
            System.out.println("Voulez vous rentrez un nouveau coin ? Si oui : 1, sinon 0");
            again = Lire.i();
            System.out.println(cA.afficher());
            mapCoin.put(i,cA);
            
        }
        
        
        
        List<Coin> ListCoin = new ArrayList<Coin>();
        System.out.println(R1.montant());
        */