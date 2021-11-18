package game;

import java.util.Scanner;

// Declaration de la class Joueur

public class Ia {
	
		// Creation du constructeur du Joueur
	
		public void Player() {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			System.out.print("Entrez le nom du Joueur 1 : ");
			String p1 = sc.nextLine();
			System.out.println("Joueur 1 : " + p1);
			System.out.print("Entrez le nom de l'IA : ");
			String com = sc.nextLine();
			System.out.println("IA : " + com);
			System.out.println();
		}
		
}
