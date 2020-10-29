package controle;

import calculatrice.Accumulateur;
import vue.VueInterface;

public class Main {

	public static void main(String[] args) {
		Accumulateur accumul = new Accumulateur();
		VueInterface vue = new VueInterface();
		Controleur controle = new Controleur(accumul,vue);
	    
		

	}

}
