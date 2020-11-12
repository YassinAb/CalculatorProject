package modèle;

public interface IAccumulateur {
	
	public void push(double nombreChoisi);
	
	public void drop();
	
	public void swap();
	
	public void add();
	
	public void sub();
	
	public void mult();
	
	public void div();
	
	public void neg();
	
	public void backspace();
	
	public void accumuler(String nombreChoisi);
	
	public void reset();
	
	public  double peek();
	
	public int taille();
	
	
}
