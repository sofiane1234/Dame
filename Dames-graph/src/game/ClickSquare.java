package game;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ClickSquare implements MouseListener{
	
	private Square goSquare;
	private Damier damier;

	//Constructeur d'ecoute du choix de case
	public ClickSquare(Square goSquare, Damier damier) {
		super();
		this.goSquare = goSquare;
		this.damier = damier;
	}

	//Methodes prenant en charge le click de la souris
	public void mouseClicked(MouseEvent arg0) {
	
	}

	
	public void mouseEntered(MouseEvent arg0) {
		
	}


	public void mouseExited(MouseEvent arg0) {
		
	}

	//Methode determinant si un bouton de la souris est toujours appuye
	public void mousePressed(MouseEvent arg0) {
		if(goSquare.isClicked()){
			damier.move(goSquare);
		}
	}

	//Methode prenant en charge le relachement de la souris
	public void mouseReleased(MouseEvent arg0) {
		
	}
}
