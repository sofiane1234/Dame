package main;
import game.Ia;
import game.Jcj;
import model.Damier;
import utilitaires.Utilitaires;

public class Menu {
	String nom;

	// Creation du menu principal
	
	public void menuPrincipal() {
			
			Damier damier = new Damier(15,15);
			System.out.println("Jeu de dames");
			System.out.println("1. JCJ");
			System.out.println("2. JC IA");
			System.out.println("3. Sortir");				
			System.out.println("Entrez un chiffre entre 1 et 3 : ");
			int choix = Utilitaires.readInt();
			switch (choix) {
				case 1:
					System.out.println("Lancement de partie joueur contre joueur !");
					
					// Appel de la fonction Player depuis le constructeur du Joueur
					Jcj multi = new Jcj();
					multi.Players();
					// Appel de la fonction d'affichage du damier depuis le constructeur du damier
					damier.printTab();
					break;
				case 2:
					System.out.println("Lancement de partie joueur contre IA !");
					Ia single = new Ia();
					single.Player();
					damier.printTab();
					break;
				case 3:
					System.out.println("Fermeture du programme");
				default:
					System.out.println("Votre choix n'est pas dans la liste !");
					break;
				}
 
		
		}
		
}
