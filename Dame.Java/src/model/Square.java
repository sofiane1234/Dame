package model;

//Creation de la class Square pour oles cases
//La declaration de la variable pion se fait depuis le type Pion cree dans la classe du fichier Pion.java
public class Square {
    public boolean blanc;
    public Pion pion;
    
    //Constructeur de cases
    public Square() {
        this.blanc = false;
    }
    //Generation du setter de cases blanches
    public void setBlanc() {
        this.blanc = true;
    }
    
    //Methode pour retourner la valeur de blanc si la case est blanche 
    public boolean isBlanc() {
        return blanc;
    }
    //Methode pour retourner le contraire de blanc si la case est noir
    public boolean isNoir() { return !blanc;}

    //Generation du setter du pion depuis la classe Pion
    public void setPion(Pion pion) {
        this.pion = pion;
    }
    
    //Methode pour prendre le type du pion si la case contient un pion
    public boolean hasPion() {
        try {
            pion.getTypePion();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    //Methode toString pour convertir les coordones et les donnes de la class Pion en String
    public String toString() {
        try {
            this.pion.getX();
            return this.pion.toString();
        } catch (Exception e) {
            if (this.blanc)
                return "[]";
            else
                return " ";
        }
    }
}