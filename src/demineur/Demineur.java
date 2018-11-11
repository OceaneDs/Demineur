package demineur;

public class Demineur
{
	private Parametres parametres = new Parametres();
	private Affichage affichage;
	
	public Demineur()
	{
		affichage = new Affichage(parametres);
		if(affichage.menu())
			new Partie(parametres);
	}
	
	/**
	 *garde en mémoire les parametres et relance une partie avec des parametres deja defini
	 */
	
	public Demineur(Parametres parametres) 
	{
		affichage = new Affichage(parametres);
		this.parametres = parametres;
		parametres.setTriche(false);
		if(affichage.menu())
			new Partie(parametres);
	}
}