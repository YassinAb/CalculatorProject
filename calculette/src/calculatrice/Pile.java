package calculatrice;

import java.util.Stack;


//import java.util.Stack;

public class Pile/* extends Stack<Double>*/ {
	
	//private static final long serialVersionUID = 1L;
	
	
Stack <Double> pile = new Stack <>();
	public Pile() {
		}
	
public void push(double nombreChoisi) {
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

public double peek(){
		 return pile.peek();
	}
}
