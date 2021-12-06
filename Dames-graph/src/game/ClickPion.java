package game;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ClickPion implements MouseListener {
	
	private Damier damier;
	private Pion pion;
	
	//Constructeur d'ecoute du choix de pion
	public ClickPion(Pion pion, Damier damier){
		this.damier = damier;
		this.pion = pion;
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
		damier.printChoix(pion);
	}
	
	//Methode prenant en charge le relachement de la souris
	public void mouseReleased(MouseEvent arg0) {
		
	}
}
