package modèle;


public class Accumulateur implements IAccumulateur {
	
	
	
	private Pile pile = new Pile();
	
	
	public Accumulateur() {	}

	public int taille() {
		return pile.size();
	}
	
	public void push(Double nombreChoisi) {
		pile.push(nombreChoisi);
		
	}

	public void drop() {
		pile.drop();
	}

	
	public void swap() {
		Double pop1= pile.pop();
		Double pop2= pile.pop();
		pile.push(pop1);
		pile.push(pop2);
		
	}

	
	public void add() {
		pile.push(pile.pop() + pile.pop());
	}

	
	public void sub() {
		Double pop1= pile.pop();
		Double pop2= pile.pop();
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
		Double a= Double.parseDouble(nombreChoisi);
		push(a);
	}


	public void reset() {
		pile.clear();
		
	}
	
	public  Double peek() {
		
		return pile.peek();
	}


}
	


	
	

