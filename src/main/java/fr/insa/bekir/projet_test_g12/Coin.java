/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bekir.projet_test_g12;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Helo
 */
public class Coin {
    
    public static int rayon = 5;
    
    private int idCoin;
    private double x;
    private double y;
    
    public Coin (int idCoin, double x, double y){
        this.idCoin = idCoin; 
        this.x = x;
        this.y = y;
    }
    
    public String afficher (){
        return "id = "+idCoin+", x = "+x+", y = "+y;
    }

    @Override
    public String toString() {
        return "Coin{" + "idCoin = " + idCoin + ", x = " + x + ", y = " + y + '}';
    }

    public double getX() {
        return x;
    }

    public int getIdCoin() {
        return idCoin;
    }

    public double getY() {
        return y;
    }

    public void setIdCoin(int idCoin) {
        this.idCoin = idCoin;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public void dessiner(GraphicsContext context){
        context.setFill(Color.RED);
        context.fillOval(this.x-rayon , this.y-rayon, 2*rayon, 2*rayon );   
    }
    
}
