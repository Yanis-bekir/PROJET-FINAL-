/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.devisbatiment;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.IOException;
/**
 *
 * @author hbogas01
 */
public class main {
    public static void main (String[] args) throws Exception {
        
        System.out.println("Donnez le nom du projet");
	String projet = Lire.S(); 			// mets les texte qui précédes un / dans les case du tableau 
	File file = new File("Sauvegarde.txt"); 	//créer un fichier texte avec le nom de l'algorithme donné 
	FileWriter writer = new FileWriter(file);
        
        
        System.out.println("Quel est le nom de votre ouvrage ?");
        String nom= Lire.S();
        System.out.println("Combien d'étages a-t-il ?");


    }
}
