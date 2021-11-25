package model;

public class Damier {
	private Square[][] damier;
	public int size;
	public Damier(int size) {
		this.size = size;
		this.damier = new Square[size][size];
		boolean caseBlanche;
		for (int i = 0; i < damier.length; i++) {
			caseBlanche = (i % 2 == 0);
			for (int j = 0; j < this.damier.length; j++) {
				if (caseBlanche) {
					this.damier[i][j] = new Square();
					this.damier[i][j].setBlanc();
					caseBlanche = false;
				
			} else {
				this.damier[i][j] = new Square();
				caseBlanche = true; 	
				}
			}
		}		
	}
	
	public void printTab([int[] curseur]) {
		System.out.println("┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐");
		for (int i = 0; i < this.damier[j].length; i++) {
			Square theSquare = this.damier[i][j];
			if (i == curseur[0] && i == curseur[1]) {
				System.print("|[+D+]");
			} else {
				if (theSquare(estBlanc)) {
					System.out.print("|[+W+]|");
				} else {
					System.print("│   ");
				}
			}
			System.out.println("|");
			if (i != this.damier.length - 1) {
				System.out.println("├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤");
			} else {
				System.out.println("└───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘");
			}
		}
	}

	public void printPion(Pion[] pions]) {
		this.update(pions);
		printTab(new int[] {-1, -1);
	}
	public Square[][] getDamier() {
			return this.damier;
	}
	
	public void updatePion(Pion[] pions) {
		for (Square[] line: this.damier) {
			for (Square theSquare: line) {
				theSquare.pion = null;
			}
			for (int i = 0; i < pions.length; i++) {
				this.damier[pions[i]].getY()[pions[i].getX()].setPion(pions[i]);
			}
		}
	}
	public Pion getPionFromSquare(int[] place) {
		try {
			return this.damier[place[1][place[0]].pion;
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean mangeOuPas(Pion pion) {
		boolean oui = false;
		for (int i = pion.getX() -2; i < pion.getX()+2; i += 1) {
			for (int j = pion.getY() - 2; j < pion.getY() +2; j += 1) {
				int[] curseur = {i, j};
				if(this.hasPion(curseur) {
					Pion target = this.getPionFromSquare(curseur);
					if(!pion.equals(target)) {
						String oldTypeTarget = target.getTypePion();
	                    int[] oldPosPion = pion.getPlace();
	                    if(pion.mange(target, this)) {
	                    	oui = true;
	                    	target.setTypePion(oldTypeTarget);
	                        pion.setPos(oldPosPion);
	                    }
	                }
                 }
			 }
		}
		return oui;
	}	
	
	public boolean hasPion(int[] place) {
		try {
			return this.damier[place[1][0]].hasPion();
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public boolean isEmpty(int[] place) {
		return !hasPion();
	}
}
	
class Squares{
	
}