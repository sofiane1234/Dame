package game;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class Damier extends JPanel {

	private static final long serialVersionUID = 6726708245444190460L;

	private static final int size = 9;

	private Square caseActive;

	private boolean tourNoir;
	
	//Constructeur avec un int representant la taille du damier
	public Damier(int size){
		//Determination du tour des pions noirs qui ne commencent pas la partie en premier avec le boolean false
		tourNoir = false;
		//setter de la grille
		setLayout(new GridLayout(size, size));
		//Boucle pour remplir les case de deux couleurs differentes
		//Quand le resultat est pair colorons la case suivante d'une autre couleur
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)){
					ajouterCase(Couleur.NOIR);
				}
				else{
					ajouterCase(Couleur.BLANC);
				}
			}
		}
		init();
	}
	
	//Methode pour ajouter les cases dans la grille de la fenetre
	private void ajouterCase(Couleur couleur){
		Square goSquare = new Square(couleur);
		goSquare.addMouseListener(new ListenerCase(goSquare, this));
		add(goSquare);
	}
	
	//Methode pour faire les pions du jeu
	private Pion creerPion(Couleur couleur, boolean monte){
		Pion pion = new Pion(couleur, monte);
		pion.addMouseListener(new ListenerPion(pion, this));
		return pion;
	}
	
	//Methode pour initialiser les pions sur les cases
	private void init(){
		for(int j = 0; j < size * 3; j += 2){
			getCase(j).add(creerPion(Couleur.NOIR, false));
			getCase(size * size - j - 1).add(creerPion(Couleur.BLANC, true));
		}
	}
	
	//Getters des cases
	public Square getCase(int i, int j){
		return (Square) getComponent(j + i * size);
	}

	public Square getCase(int i){
		return (Square) getComponent(i);
	}
	
	//Affichage des chemin possible a prendre
	public void afficherPossibilites(Pion p){
		if((p.getCouleur().equals(Couleur.NOIR) && tourNoir) || (p.getCouleur().equals(Couleur.BLANC) && !tourNoir)){
			int i = 0;
			int j = 0;
			for(int k = 0; k < size * size; k++){
				getCase(k).setSelectionnee(false);
				if(getCase(k).getComponentCount() != 0 && getCase(k).getComponent(0).equals(p)){
					caseActive=getCase(k);
					i = k / size;
					j = k % size;

				}
			}
			selectionnerCases(i, j, p.getCouleur());
		}
	}
	
	//Methode pour selectionner une case
	public void selectionnerCases(int i, int j, Couleur couleur){
		Pion pion = (Pion)(getCase(i, j).getComponent(0));
		if(pion.isMonte()){
			if(i - 1 >= 0 && j - 1 >= 0 && getCase(i - 1, j - 1).getComponentCount() == 0){
				getCase(i - 1, j - 1).setSelectionnee(true);
			}
			else if(i - 2 >= 0 && j - 2 >= 0 && getCase(i - 2, j - 2).getComponentCount() == 0 && !((Pion)(getCase(i - 1, j - 1).getComponent(0))).getCouleur().equals(couleur)){
				getCase(i - 2, j - 2).setSelectionnee(true);
			}
			if(i - 1 >= 0 && j + 1 < size && getCase(i - 1, j + 1).getComponentCount() == 0){
				getCase(i - 1, j + 1).setSelectionnee(true);
			}
			else if(i - 2 >= 0 && j + 2 < size && getCase(i - 2, j + 2).getComponentCount()== 0 && !((Pion)(getCase(i - 1, j + 1).getComponent(0))).getCouleur().equals(couleur)){
				getCase(i - 2, j + 2).setSelectionnee(true);
			}
		}
		else{
			if(i + 1 < size && j + 1 < size && getCase(i + 1, j + 1).getComponentCount() == 0){
				getCase(i + 1, j + 1).setSelectionnee(true);
			}
			else if(i + 2 < size && j + 2 < size && getCase(i + 2, j + 2).getComponentCount() == 0 && !((Pion)(getCase(i + 1, j + 1).getComponent(0))).getCouleur().equals(couleur)){
				getCase(i + 2, j + 2).setSelectionnee(true);
			}
			if(i + 1 < size && j - 1 >= 0 && getCase(i + 1, j - 1).getComponentCount() == 0){
				getCase(i+1, j-1).setSelectionnee(true);
			}
			else if(i + 2 < size && j - 2 >= 0 && getCase(i + 2, j - 2).getComponentCount() == 0 && !((Pion)(getCase(i + 1, j - 1).getComponent(0))).getCouleur().equals(couleur)){
				getCase(i + 2, j - 2).setSelectionnee(true);
			}	
		}
	}
	
	//Methode pour se deplacer vers une autre case avec un pion
	public void deplacer(Square goSquare){
		goSquare.add(caseActive.getComponent(0));
		for(int k = 0; k < size * size; k++){
			getCase(k).setSelectionnee(false);
		}
		if(Math.abs(getLigne(goSquare) - getLigne(caseActive)) == 2){
			int i = (getLigne(goSquare) + getLigne(caseActive)) / 2;
			int j = (getColonne(goSquare) + getColonne(caseActive)) / 2;
			getCase(i, j).removeAll();
			getCase(i, j).validate();
			getCase(i, j).repaint();
		}
		tourNoir = !tourNoir;
		caseActive.removeAll();
		caseActive.repaint();
		caseActive = null;
		goSquare.repaint();
		if(getLigne(goSquare) == 0){
			Pion p = (Pion)(goSquare.getComponent(0));
			p.setMonte(false);
		}
		if(getLigne(goSquare) == size - 1){
			Pion p = (Pion)(goSquare.getComponent(0));
			p.setMonte(true);
		}
	}
	
	//Getter des lignes de la grille
	private int getLigne(Square goSquare){
		int res = 0;
		for(int i = 0; i < size * size; i += 2){
			if(getCase(i).equals(goSquare)){
				res = i / size;
			}
		}
		return res;
	}
	
	//Getter des colonnes de la grille
	private int getColonne(Square goSquare){
		int res = 0;
		for(int i = 0; i < size * size; i += 2){
			if(getCase(i).equals(goSquare)){
				res = i % size;
			}
		}
		return res;
	}
}
