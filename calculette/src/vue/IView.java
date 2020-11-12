package vue;

public interface IView {
	
	public String getEcranAffichage();
	public void setEcranAffichage(String nombreChoisi);
	public void nouvelleVue(String[] affichage);
}
