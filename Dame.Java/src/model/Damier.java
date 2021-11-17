package model;

// D�claration de la class Damier

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
				damier[i][j] = '0';
				
			}
		}
	}
	
	// Afficher le damier
	
	public void printTab() {
		System.out.println();
		for (int i = 0; i < damX; i++) {
			for (int j = 0; j < damY; j++) {
				System.out.print(" | " + damier[i][j]);
			}
			System.out.println(" | ");
		}
		System.out.println();
	}
}