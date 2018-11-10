package demineur;

public class Demineur
{
	private Parametres parametres = new Parametres();
	private Affichage affichage = new Affichage(parametres);
	
	public Demineur()
	{
		if(affichage.menu())
			new Partie(parametres);
	}
	
	public Demineur(Parametres parametres) // garde en mémoire les parametres
	{
		this.parametres = parametres;
		parametres.setTriche(false);
		if(affichage.menu())
			new Partie(parametres);
	}
}