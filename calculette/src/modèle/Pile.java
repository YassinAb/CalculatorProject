package modèle;

import java.util.Stack;


public class Pile {	
	
	Stack <Double> pile = new Stack <>();

	public Pile() {}
	
	public void push(double nombreChoisi) {
		pile.push(nombreChoisi);
	}
	
	public double pop() {
		return (pile.pop());	
	}

	public void drop() {
		pile.removeElementAt(0);
	}

	public void clear() {
		pile.clear();
	}

	public double peek(){
		 return pile.peek();
	}

	public int size() {
		return pile.size();
	}

}
