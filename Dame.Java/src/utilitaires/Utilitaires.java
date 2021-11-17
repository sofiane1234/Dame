package utilitaires;
import java.util.Scanner;


public class Utilitaires {
	
		public static int readInt() {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			int i = 0;
			try {
				i = sc.nextInt();
			}
			catch(Exception e) {
				
			}
			return i;
		}
		public String readStrng() {
			Scanner sc = new Scanner(System.in);
			String nom = "";
			try {
				nom = sc.nom();
			}
			catch(Exception e) {
				
			}
			return nom;
		}

}


