package calculatrice;


//import java.beans.PropertyChangeSupport;
//import java.beans.PropertyChangeListener;

public class Accumulateur implements IAccumulateur {
	
	
	private  double pop1; // 1ere Variable de sauvegarde pour la méthode swap
	private double pop2; // 2eme Variable de sauvegarde 
	private Pile pile = new Pile();
	
	
	public Accumulateur() {	}

	
	public void push(Double nombreChoisi) {
		pile.push(nombreChoisi);
		
	}

	
	public void drop() {
		pile.drop();
	}

	
	public void swap() {
		pop1= pile.pop();
		pop2= pile.pop();
		pile.push(pop2);
		pile.push(pop1);
		
	}

	
	public void add() {
		//return pile.empty();
		pile.push(pile.pop() + pile.pop());

	}

	
	public void sub() {
		pile.push(pile.pop() - pile.pop());
		
	}

	
	public void mult() {
		pile.push(pile.pop() * pile.pop());
		
	}

	
	public void div() {
		swap();
		pile.push(pile.pop() / pile.pop());
		
	}

	
	public void neg() {
		pile.push(-pile.pop());
		
	}

	
	public void backspace() {
		pile.drop();
		
	}

	
	public void accumuler(String nombreChoisi) {
		/*switch (character) {
			case '+': 
				add();
			case '-':
				sub();
			case '/': 
				div();
			case '*':
				mult();
		}*/
		
		//string = pile.pop().toString();
		//string += pile.pop().toString();
		
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
	


	
	

