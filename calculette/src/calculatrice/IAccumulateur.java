package calculatrice;

public interface IAccumulateur {
	
	public void push(Double nombreChoisi);
	
	public void drop();
	
	public void swap();
	
	public void add();
	
	public void sub();
	
	public void mult();
	
	public void div();
	
	public void neg();
	
	public void backspace();
	
	public void accumuler(String string);
	
	public void reset();

	
}
