package game;
import java.awt.GridLayout;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Damier extends JPanel {

	
	private static final int size = 9;

	private Square thisSquare;

	private boolean tourNoir;
	
	//Constructeur avec un int representant la taille du damier
	public Damier(int size){
		//Determination du tour des pions noirs qui ne commencent pas la partie en premier avec le boolean false
		tourNoir = false;
		//setter de la grille
		setLayout(new GridLayout(size, size));
		//Boucle pour remplir les case de deux couleurs differentes
		//Quand le resultat est pair colorons la case suivante d'une autre couleur
		for(int x = 0; x < size; x++){
			for(int y = 0; y < size; y++){
				if((y % 2 == 0 && x % 2 == 0) || (y % 2 != 0 && x % 2 != 0)){
					addSquare(Couleur.NOIR);
				}
				else{
					addSquare(Couleur.BLANC);
				}
			}
		}
		init();
	}
	
	//Methode pour ajouter les cases dans la grille de la fenetre
	private void addSquare(Couleur couleur){
		Square goSquare = new Square(couleur);
		goSquare.addMouseListener(new ClickSquare(goSquare, this));
		add(goSquare);
	}
	
	//Methode pour faire les pions du jeu
	private Pion makePion(Couleur couleur, boolean monte){
		Pion pion = new Pion(couleur, monte);
		pion.addMouseListener(new ClickPion(pion, this));
		return pion;
	}
	
	//Methode pour initialiser les pions sur les cases
	private void init(){
		for(int d = 0; d < size * 3; d += 2){
			getSquare(d).add(makePion(Couleur.NOIR, false));
			getSquare(size * size - d - 1).add(makePion(Couleur.BLANC, true));
		}
	}
	
	//Getters des cases
	public Square getSquare(int x, int y){
		return (Square) getComponent(y + x * size);
	}

	public Square getSquare(int i){
		return (Square) getComponent(i);
	}
	
	//Affichage des chemin possible a prendre
	public void printChoix(Pion p){
		if ((p.getCouleur().equals(Couleur.NOIR) && tourNoir) || (p.getCouleur().equals(Couleur.BLANC) && !tourNoir)){
			int x = 0;
			int y = 0;
			for(int d = 0; d < size * size; d++){
				getSquare(d).setClick(false);
				if(getSquare(d).getComponentCount() != 0 && getSquare(d).getComponent(0).equals(p)){
					thisSquare = getSquare(d);
					x = d / size;
					y = d % size;
				}
			}
			selectSquare(x, y, p.getCouleur());
		}
	}
	
	//Methode pour selectionner une case
	public void selectSquare(int x, int y, Couleur couleur){
		Pion pion = (Pion)(getSquare(x, y).getComponent(0));
		if(pion.isUp()){
			if(x - 1 >= 0 && y - 1 >= 0 && getSquare(x - 1, y - 1).getComponentCount() == 0){
				getSquare(x - 1, y - 1).setClick(true);
			}
			else if (x - 2 >= 0 && y - 2 >= 0 && getSquare(x - 2, y - 2).getComponentCount() == 0 && !((Pion)(getSquare(x - 1, y - 1).getComponent(0))).getCouleur().equals(couleur)){
				getSquare(x - 2, y - 2).setClick(true);
			}
			if(x - 1 >= 0 && y + 1 < size && getSquare(x - 1, y + 1).getComponentCount() == 0){
				getSquare(x - 1, y + 1).setClick(true);
			}
			else if(x - 2 >= 0 && y + 2 < size && getSquare(x - 2, y + 2).getComponentCount()== 0 && !((Pion)(getSquare(x - 1, y + 1).getComponent(0))).getCouleur().equals(couleur)){
				getSquare(x - 2, y + 2).setClick(true);
			}
		}
		else{
			if(x + 1 < size && y + 1 < size && getSquare(x + 1, y + 1).getComponentCount() == 0){
				getSquare(x + 1, y + 1).setClick(true);
			}
			else if(x + 2 < size && y + 2 < size && getSquare(x + 2, y + 2).getComponentCount() == 0 && !((Pion)(getSquare(x + 1, y + 1).getComponent(0))).getCouleur().equals(couleur)){
				getSquare(x + 2, y + 2).setClick(true);
			}
			if(x + 1 < size && y - 1 >= 0 && getSquare(x + 1, y - 1).getComponentCount() == 0){
				getSquare(x + 1, y - 1).setClick(true);
			}
			else if(x + 2 < size && y - 2 >= 0 && getSquare(x + 2, y - 2).getComponentCount() == 0 && !((Pion)(getSquare(x + 1, y - 1).getComponent(0))).getCouleur().equals(couleur)){
				getSquare(x + 2, y - 2).setClick(true);
			}	
		}
	}
	
	//Methode pour se deplacer vers une autre case avec un pion
	public void move(Square goSquare){
		goSquare.add(thisSquare.getComponent(0));
		for(int d = 0; d < size * size; d++){
			getSquare(d).setClick(false);
		}
		if(Math.abs(getLine(goSquare) - getLine(thisSquare)) == 2){
			int x = (getLine(goSquare) + getLine(thisSquare)) / 2;
			int y = (getCol(goSquare) + getCol(thisSquare)) / 2;
			getSquare(x, y).removeAll();
			getSquare(x, y).validate();
			getSquare(x, y).repaint();
		}
		tourNoir = !tourNoir;
		thisSquare.removeAll();
		thisSquare.repaint();
		thisSquare = null;
		goSquare.repaint();
		if(getLine(goSquare) == 0){
			Pion p = (Pion)(goSquare.getComponent(0));
			p.setUp(false);
		}
		if(getLine(goSquare) == size - 1){
			Pion p = (Pion)(goSquare.getComponent(0));
			p.setUp(true);
		}
	}
	
	//Getter des lignes de la grille
	private int getLine(Square goSquare){
		int res = 0;
		for(int i = 0; i < size * size; i += 2){
			if(getSquare(i).equals(goSquare)){
				res = i / size;
			}
		}
		return res;
	}
	
	//Getter des colonnes de la grille
	private int getCol(Square goSquare){
		int res = 0;
		for(int i = 0; i < size * size; i += 2){
			if(getSquare(i).equals(goSquare)){
				res = i % size;
			}
		}
		return res;
	}
}
