package model;

import java.util.Scanner;

public class Jcj {
	
	public void Players() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Entrez le nom du Joueur 1 : ");
		String p1 = sc.nextLine();
		System.out.println("Joueur 1 : " + p1);
		System.out.print("Entrez le nom du Joueur 2 : ");
		String p2 = sc.nextLine();
		System.out.println("Joueur 2 : " + p2);
		System.out.println();
	}
}
