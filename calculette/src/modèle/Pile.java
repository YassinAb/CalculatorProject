package modèle;

import java.util.Stack;


public class Pile extends Stack {	
	
	

	Stack <Double> pile = new Stack <>();			//Instanciation de la Stack

	public Pile() {}
	
	public void push(Double nombreChoisi) {			//Même rôle que dans Accumulateur
		pile.push(nombreChoisi);
	}
	
	public Double pop() {
		return (pile.pop());	
	}

	public void drop() {
		pile.removeElementAt(0);
	}

	public void clear() {
		pile.clear();
	}

	public Double peek(){
		 return pile.peek();
	}

	public int size() {
		return pile.size();
	}

}
