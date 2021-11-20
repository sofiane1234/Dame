package model;

// Déclaration de la class Damier

public class Damier {
	private int damX;
	private int damY;
	private char[][] damier;
	
	// Construire le damier
	public Damier(int x, int y) {
		damX = x;
		damY = y;
		damier = new char[damX][damY]; 
		for (int i = 0; i < damX; i++) {
			for (int j = 0; j < damY; j++) {
				if((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)){
					damier[i][j] = '1';
				} else {
					damier[i][j] = '0';	
				}
				
				
			}
		}
	}
	
	
	// Afficher le damier
	public void printTab() {
		System.out.println(" ----------------------- ");
		for (int i = 0; i < damX; i++) {
			System.out.print("[ ");
			for (int j = 0; j < damY; j++) {
				System.out.print("|" + damier[i][j]);
			}
			System.out.println("| ]");
		}
		System.out.print(" ----------------------- ");
	}
	
	public void Placer(int x, int y, char c) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				x = x-1;
				y = y-1;
				System.out.println(damier[i][j]);
				if (x < 0 || y < 0 || x > damX || y > damY) {
					System.out.println("Erreur !");
					return;
				}
				if (damier[x][y] == '-' && damier[x][y] % 2 != 0) {
					damier[x][y] = c;
				} else {
					System.out.println("Erreur, case inaccessible !");
				}
			}
		}
	}
	public void printPion() {
		for (int i = 0; i < damX; i++) {
			for (int j = 0; j < damY; j++) {
				System.out.print(" B " + damier[i][j]);
			}
		}
	
	}
	
}
