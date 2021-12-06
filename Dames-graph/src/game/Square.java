package game;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;

import javax.swing.JPanel;

//Creation de class fille de JPanel
public class Square extends JPanel {
	
	private static final long serialVersionUID = -1839026893240660968L;
	
	private Couleur couleur;
	private boolean clicked;
	
	//Constructeur de la class Square
	public Square(Couleur couleur){
		setLayout(new GridLayout(1,0));
		this.couleur = couleur;
		initCouleur();
	}
	
	//Getter des couleurs
	public Couleur getCouleur() {
		return couleur;
	}
	//Methode servant de getter de case selectionnee
	public boolean isClicked() {
		return clicked;
	}
	
	//Setter de selection des cases
	public void setClick(boolean clicked) {
		this.clicked = clicked;
		if(clicked){
			setBackground(Color.BLACK);
			setForeground(Color.BLACK);
		}
		else {
			initCouleur();
		}
	}
	
	//Methode d'initialisation des couleurs
	private void initCouleur(){
		switch(couleur){
		case BLANC :
			setBackground(Color.GRAY);
			setForeground(new Color(128, 128, 128));
			
			break;
		case NOIR :
			setBackground(Color.BLACK);
			setForeground(new Color(20, 20, 20));
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
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
