package game;

public class Commandes {
	public int curX;
	public int curY;
	private int com;
	
	public Commandes() {
		this.curX = 0;
		this.curY = 0;
		System.out.println("Pour s�l�ctionner un pion, dux m�thodes sont disponibles :");
		System.out.println("* fl�ches du clavier puis entr�e");
		System.out.println("* si votre terminal n'est pac compatible, utilisez ZQSD pour se d�placer et Esapce pour valider");
		System.out.println("    et entre chaque touche il faudra appuyer sur enter");
		com = 0;
	    }
	
	 public void close() throws IOException {
	        RawConsoleInput.resetConsoleMode();
	    }

	    public void reset() { 
	        this.curX = 0;
	        this.curY = 0;
	    }
}
