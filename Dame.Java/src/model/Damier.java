package model;

// Déclaration de la class Damier

public class Damier {
	private int damX;
	private int damY;
	private boolean blanc;
	private char[][] damier;
	
	// Construire le damier
	
	public Damier(int x, int y) {
		damX = x;
		damY = y;
		damier = new char[damX][damY]; 
		for (int i = 0; i < damX; i++) {
			for (int j = 0; j < damY; j++) {
				damier[i][j] = '0';
				if (i % 2 == 0) {
					blanc = true;
				} else {
					blanc = false;
				}			
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
	
	  public boolean estVide(int[] pos) {
	        return !hasPion(pos);
	    }
}