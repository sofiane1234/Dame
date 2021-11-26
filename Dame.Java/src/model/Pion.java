package model;

//Creation de la class Pion avec toutes les variable necessaires
public class Pion {
    private int coordX;
    private int coordY;
    public String typePion;
    public boolean blanc;
    public boolean select;
   
    //Construction des pions en utilisant les variables necessaires
    public Pion(int coordX, int coordY, String typePion, boolean blanc) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.typePion = typePion;
        this.blanc = blanc;
        this.select = false;
    }

    //Generation des getters des coordones x et y
    public int getX() {
        return coordX;
    }

    public int getY() {
        return coordY;
    }
    //Generation du getter du type des pions
    public String getTypePion() {
        return typePion;
    }
    
    //Generation du setter du type des pions
    public void setTypePion(String typePion) {
        this.typePion = typePion;
    }
    
    //Construction du mouvement avec la methode bouge
    public boolean bouge(int[] newpos) {
        boolean bouge = false;
        if (this.typePion.equals("pion") && (this.blanc == true && (newpos[0] >= (this.coordX - 1) && newpos[0] <= (this.coordX + 1)) && (newpos[1] >= this.coordY && newpos[1] < (this.coordY + 2)))) {
            this.coordX = newpos[0];
            this.coordY = newpos[1];
            this.select = false;
            bouge = true;
        } else {
            if (this.typePion.equals("pion") && (this.blanc == false && (newpos[0] >= (this.coordX - 1) && newpos[0] <= (this.coordX + 1)) && (newpos[1] <= this.coordY && newpos[1] < (this.coordY + 2)))) {
                this.coordX = newpos[0];
                this.coordY = newpos[1];
                this.select = false;
                bouge = true;
            }
        }
        if (typePion.equals("dame") && ((newpos[0] != this.coordX) && newpos[1] != this.coordY)) { 
            this.coordX = newpos[0];
            this.coordY = newpos[1];
            this.select = false;
            bouge = true;
        }

        if (bouge && (this.typePion.equals("pion") && ((this.blanc && this.coordY == 9) || (!this.blanc && this.coordY == 0)))) { 
            this.typePion = "dame";
            System.out.println("Un pion se transforme en dame !");
            return true;
        } else {
            return bouge;
        }
    }
    
    public boolean mange(Pion target, Damier damier) {
        this.select = false;
        int[] posApresManger = this.getPosManger(target);
        int[] oldPos = getPos();
        if(!target.isInvicible() && damier.isEmpty(posApresManger) && this.blanc != target.blanc
                && distanceValide(distanceAvec(target))) {
            setPos(target.getPos());

            if(this.bouge(posApresManger)) { 
                target.manger();
                return true;
            }
            else {
                setPos(oldPos);
                System.out.println("Erreur: impossible de manger vers cette case");
                return false;}
        } else {
           
            return false;
        }
    }
    public String toString() {
        if (System.getProperty("os.name").equals("Windows")) {
            if (this.select) {
                return "@";
            } else {
                if (this.typePion.equals("pion")) {
                    if (!blanc)
                        return "◯";
                    else
                        return "◉";
                } else {
                    if (this.typePion.equals("dame")) {
                        if (!blanc)
                            return "▢";
                        else
                            return "▣";
                    } else return "x";
                }
            }
        } else {
            if (this.select) {
                return "@";
            } else {
                if (this.typePion.equals("pion")) {
                    if (blanc)
                        return "b";
                    else
                        return "n";
                } else {
                    if (this.typePion.equals("dame")) {
                        if (blanc)
                            return "B";
                        else
                            return "N";
                    } else return "x";
                }
            }
        }
    }
    
    //Methode pour bouger d'une case de plus en avant ou d'une case de moins en arrière en mangeant un pion 
    public int[] getPosManger(Pion cible){
        int[] mangerpos = new int[2];
        int k = 0;
        int j = 0;
        if(this.coordX <= cible.coordX) {
            k = 1;
        else
            k = -1; 
        if(this.coordY <= cible.coordY)
            j = -1; 
        else
            j = 1; 

        if(k == 1)
            mangerpos[0] = (cible.coordX + 1);
        else
            mangerpos[0] = (cible.coordX-1);
        if(j == 1)
            mangerpos[1] = (cible.coordY-1);
        else
            mangerpos[1] = (cible.coordY+1);
        
        return mangerpos;
    }
     //retourner la position du pion
    public int[] getPlace() {
        int[] pos = new int[2];
        pos[0] = this.coordX;
        pos[1] = this.coordY;
        return pos;
    }
    //Selection du pion a bouger
    public void selectionner() { 
        this.select = true;
    }
    
    
    public void unselect() {
        this.select = false;
    }
    public boolean isVivant() {
        return !typePion.equals("mort");
    }
    public boolean isDame() {
        return typePion.equals("dame");
    }
    public boolean isPion() {
        return typePion.equals("pion");
    }
    public void manger() {
        if(!isVivant())
            System.out.println("Un pion mort a été tué !!!");
        this.typePion = "mort";
    }
    public void setPos(int[] pos){
        if(pos.length == 2){
            coordX = pos[0];
            coordY = pos[1];
        }
        else
            System.out.println("Erreur: il faut une composante X et Y");
    }
    public int distanceAvec(Pion cible) {
        return (int)Math.sqrt(
                Math.pow(Math.abs(this.coordX-cible.coordX), 2) + Math.pow(Math.abs(this.coordY-cible.coordY),2));
    }

    public boolean distanceValide(int distance) {
        return this.isDame() || distance == 1;     
        }
    public boolean isInvicible() {
        return (coordX == 0 || coordX == 9 || coordY == 0 || coordY == 9);
    }

    public boolean equals(Pion pion) {
        if(pion.blanc == this.blanc)
            return true; 
        else {
        	return false;
    }
}