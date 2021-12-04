package game;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.UIManager;

import utilitaires.Utilitaires;


public class Menu {

	//Lancement du menu
	public static void main(String[] args) {
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch(Exception e){}
		
		//Demonstration du choix et demande d'entree utilisateur
		System.out.println("Jeu de dames : ");
		System.out.println("1- J C J");
		System.out.println("2- Sortir");
		System.out.println("Entrez un chiffre entre 1 et 2 :");
		int choix = Utilitaires.readInt();
		switch (choix) {
			case 1:
				
				//Si l'utilisateur entre 1, il est demande d'entrer un nom pour les joueurs
				Scanner sc = new Scanner(System.in);
				System.out.print("Entrez le nom du joueur 1 : ");
				String p1 = sc.nextLine();
				System.out.println("Joueur 1 : " + p1);
				System.out.print("Entrez le nom du joueur 2 : ");
				String p2 = sc.nextLine();
				System.out.println("Joueur 2 : " + p2);
				
				//C'est ici que la fenetre se forme et s'ouvre
				JFrame f = new JFrame("Projet SoRisMa : Jeu de Dames");
				f.setSize(600, 600);
				f.setLocationRelativeTo(null);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//Ajout du damier
				f.add(new Damier(9));
			
				//La fenetre est rendu visible avec le boolean true
				f.setVisible(true);
				break;
			
			case 2:
				
				//Dans ce scenario, simplement, un dernier message est ecrit et la boucle s'arrete
				System.out.println("Merci d'avoir joue, ce fut tres rapide");
				break;
		}
				
	}

}

