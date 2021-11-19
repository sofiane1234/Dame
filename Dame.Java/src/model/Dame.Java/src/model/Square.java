package model;

public class Square {
    public boolean blanc;
    public Pion pion;

    public Square() {
        this.blanc = false;
    }

    public void setBlanc() {
        this.blanc = true;
    }

    public boolean isBlanc() {
        return blanc;
    }

    public boolean isNoir() { return !blanc;}

    public void setPion(Pion pion) {
        this.pion = pion;
    }

    public boolean hasPion() {
        try {
            pion.getTypePion();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

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