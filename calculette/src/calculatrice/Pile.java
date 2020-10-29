package calculatrice;
import java.util.Stack;

public class Pile extends Stack<Double> {
	
	private static final long serialVersionUID = 1L;
	Stack <Double> pile = new Stack <>();
	public Pile() {
		}
	
	public void push(double nombre) {
		pile.push(nombre);
	}
	
	public Double pop() {
		return (pile.pop());
		
	}
	public void drop() {
		pile.removeElementAt(-1);
	}

	public void clear() {
		pile.clear();
	}
}
