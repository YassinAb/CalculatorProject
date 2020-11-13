package mod�le;


public class Accumulateur implements IAccumulateur {
	
	
	
	private Pile pile = new Pile();    // Instanciation d'une pile pour r�cup�rer les m�thodes
	
	
	public Accumulateur() {	}

	public int taille() {                      //R�cup�re la taille de la pile
		return pile.size();
	}
	
	public void push(Double nombreChoisi) {   //Ajout d'un Double dans la pile
		pile.push(nombreChoisi);
		
	}

	public void drop() {					  //Suppr�ssion de la derni�re valeur entr�e dans la pile
		pile.drop();
	}

	
	public void swap() {					  //Permutation des deux derni�res valeurs 
		Double pop1= pile.pop();
		Double pop2= pile.pop();
		pile.push(pop1);
		pile.push(pop2);
		
	}

	
	public void add() {									//Sommation des deux derni�res valeurs
		pile.push(pile.pop() + pile.pop());
	}

	
	public void sub() {									//Soustraction des deux derni�res valeurs
		Double pop1= pile.pop();
		Double pop2= pile.pop();
		pile.push(pop2 - pop1);
		
	}

	
	public void mult() {								//Multiplication
		pile.push(pile.pop() * pile.pop());
		
	}

	
	public void div() {									//Division
			swap();
		    pile.push(pile.pop()/ pile.pop());
	}

	
	public void neg() {									//Changement de signe de la derni�re valeur accumul�e
		pile.push(-pile.pop());
		
	}

	
	public void backspace() {							//Efface derni�re valeur
		pile.drop();
		
	}

	
	public void accumuler(String nombreChoisi) {		// transformation du string en double puis insertion dans la pile
		Double a= Double.parseDouble(nombreChoisi);
		push(a);
	}


	public void reset() {								//Clear
		pile.clear();
		
	}
	
	public  Double peek() {							    // R�cup�ration du derni�re �l�ment
		
		return pile.peek();
	}


}
	


	
	

