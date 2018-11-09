package demineur;

public class Partie
{
	private Grille grille;
	private int taille;
	private Affichage affichage;
	
	public Partie(Parametres parametres)
	{
		this.taille = parametres.getTaille();
		affichage = new Affichage(parametres);
		grille = new Grille(parametres);
		affichage.debutPartie();
		do {
			affichage.grille(grille.getGrille());
			affichage.drapeaux(grille);
			affichage.tour(grille);
		}while(!victoire() && !perdu() && affichage.getQuitter());
		affichage.finPartie();
		new Demineur();
	}
	
	private boolean victoire()
	{
		int	nbCase = taille * taille - this.grille.getNbBombe(), 
			nbCaseDecouverte = 0;
		Case[][] tabCase = this.grille.getGrille();
		for(int x = 0; x < taille; x++)
		{
			for(int y = 0; y < taille; y++)
			{
				if(tabCase[x][y].getDecouvert())
					nbCaseDecouverte++;
			}
		}
		if(nbCaseDecouverte == nbCase)
		{
			affichage.victoire();
			return true;
		}
		return false;
	}
	
	private boolean perdu()
	{
		Case[][] tabCase = this.grille.getGrille();
		for(int x = 0; x < taille; x++)
		{
			for(int y = 0; y < taille; y++)
			{
				if(tabCase[x][y].getDecouvert() && tabCase[x][y].getBombe())
				{
					affichage.perdu(tabCase);
					return true;
				}
			}
		}
		return false;
	}
}