package modèle;


public class Accumulateur implements IAccumulateur {
	
	
	
	private Pile pile = new Pile();
	
	
	public Accumulateur() {	}

	public int taille() {
		return pile.size();
	}
	
	public void push(double nombreChoisi) {
		pile.push(nombreChoisi);
		
	}

	public void drop() {
		pile.drop();
	}

	
	public void swap() {
		double pop1= pile.pop();
		double pop2= pile.pop();
		pile.push(pop1);
		pile.push(pop2);
		
	}

	
	public void add() {
		pile.push(pile.pop() + pile.pop());
	}

	
	public void sub() {
		double pop1= pile.pop();
		double pop2= pile.pop();
		pile.push(pop2 - pop1);
		
	}

	
	public void mult() {
		pile.push(pile.pop() * pile.pop());
		
	}

	
	public void div() {
			swap();
		    pile.push(pile.pop()/ pile.pop());
	}

	
	public void neg() {
		pile.push(-pile.pop());
		
	}

	
	public void backspace() {
		pile.drop();
		
	}

	
	public void accumuler(String nombreChoisi) {
		double a= Double.parseDouble(nombreChoisi);
		push(a);
	}


	public void reset() {
		pile.clear();
		
	}
	
	public  double peek() {
		
		return pile.peek();
	}


}
	


	
	

