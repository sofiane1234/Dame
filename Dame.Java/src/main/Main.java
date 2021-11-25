package main;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

// Declaration de la class principale
public class Main  {
	public static int x = 8;
	public static int y = 8;
	public static Color x1 = Color.BLACK;
	public static Color x2 = Color.LIGHT_GRAY;
	
		
	public static void main(String[] args) {
		JFrame checkerBoard = new JFrame();
		checkerBoard.setSize(800, 800);
		checkerBoard.setTitle("Projet SoRiMa : jeu de dames");
		Container pane = checkerBoard.getContentPane();
		pane.setLayout(new GridLayout(x,y));
	}
	

		/* Appel du menu principal depuis l'objet de type Menu
		
		Menu m = new Menu();
		m.menuPrincipal();
	}*/

}
