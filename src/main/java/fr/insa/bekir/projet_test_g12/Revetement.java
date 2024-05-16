/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bekir.projet_test_g12;

import java.io.*;


public class Revetement {
    
    protected int idRevetement; 
    protected double prix;
    Sol sol;

    public Revetement(int idRevetement) {
        this.idRevetement = idRevetement;
    }

    public int getIdRevetement() {
        return idRevetement;
    }

    public void setIdRevetement(int idRevetement) {
        this.idRevetement = idRevetement;
    }
    
    public double montant(){
        return (sol.surface() * prix);
    }
    
    public static String[][] lireFichier(String fileName) {
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
    
    String fileName = "revetements.txt";
    String[][] tableau = lireFichier(fileName);
    
    
    public double prixUni(int idRevetement){
        
        String fileName = "revetements.txt";
        String[][] tableau = lireFichier(fileName);
        double prixUni = Double.parseDouble(tableau[idRevetement-1][5]);
        
        return prixUni;
        
    }
        
    
}
