package game;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;

//Creation de Class Pion fille de JPanel
@SuppressWarnings("serial")
public class Pion extends JPanel {


	private Couleur couleur;
	private boolean move;

	//Constructeur de la class Pion
	public Pion(Couleur couleur, boolean move) {
		this.move = move;
		this.couleur = couleur;
		setOpaque(false);
		switch (couleur) {
		case BLANC :
			//Ajout des couleurs sur les pions
			setForeground(Color.WHITE);
			setBackground(new Color(220, 220, 220));
			break;
		case NOIR :
			//Ajout de couleur sur les autres pions
			setForeground(new Color(255, 0, 0));
			setBackground(new Color(200, 200, 200));
			break;
		}
	}
	
	//Methode pour "peindre" les elements de la fenetre
	@Override
	public void paintComponent(Graphics g){
		Paint paint;
		Graphics2D gp;
		if (g instanceof Graphics2D) {
			gp = (Graphics2D) g;
		}
		else {
			System.out.println("Erreur !");
			return;
		}
		paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
		gp.setPaint(paint);
		g.fillOval(5, 5, getWidth()-10, getHeight()-10);

	}
	
	//Getter des couleurs des pions
	public Couleur getCouleur() {
		return couleur;
	}
	
	//Getter de l'avancee des pions
	public boolean isUp() {
		return move;
	}
	
	//Setter de l'avancee des pions
	public void setUp(boolean move) {
		this.move = move;
	}

}
