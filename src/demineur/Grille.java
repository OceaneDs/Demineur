package demineur;

import java.lang.Math;

public class Grille
{
	private Case[][] tabCase;
	private Parametres parametres;
	private int nbBombe, taille, pBombe;
	
	public Grille(Parametres parametres)
	{
		this.parametres = parametres;
		taille = parametres.getTaille();
		pBombe = parametres.getProbaBombe();
		iniGrille();
	}
	
	/**
	 * lors de l'initialisation de chaque case de la grille
	 * appel une methode bombe (placerBombe()) qui renvera si la case est une bombe ou non
	 */
	
	private void iniGrille()
	{
		tabCase = new Case[taille][taille];
		placerBombe();
		remplirValeur();
	}
	
	/**
	 * 
	 */
	
	private void placerBombe()
	{
		for(int x = 0; x < taille; x++)
		{
			for(int y = 0; y < taille; y++)
			{
				tabCase[x][y] = new Case(estUneBombe(), false);
			}
		}
	}
	
	/**
	 * prend un nombre au hasard entre 0 et 100
	 * si ce nombre et inferieur ou egal au pourcentage donné alors c'est une bombe
	 */
	
	private boolean estUneBombe()
	{
		if( ((int) (Math.random() * 100)) > pBombe) 
			return false; 
		nbBombe++;
		return true;
	}

	/**
	 * lors du dévoilage d'une case, recupere la valeur du nombre de bombe autour
	 */
	
	private void remplirValeur()
	{
		for(int x = 0; x < taille; x++)
		{
			for(int y = 0; y < taille; y++)
			{
				tabCase[x][y].setValeur(nbBombAutour(x, y));
			}
		}
	}
	
	/**
	 * @param x
	 * @param y
	 * @return
	 * 
	 */
	private int nbBombAutour(int x, int y)
	{
		int c = 0;
		for(int x1 = -1; x1 < 2; x1++)
		{
			for(int y1 = -1; y1 < 2; y1++)
			{
				if(etreDansLaGrille(x, y, x1, y1) && tabCase[x+x1][y+y1].getBombe())
						c++;
			}
		}
		return c;
	}
	
	private boolean etreDansLaGrille(int x, int y, int x1, int y1)
	{
		if((x1 != 0 || y1 != 0) && x + x1 >= 0 && x+x1 < taille && y+y1 >= 0 && y+y1 < taille)
			return true;
		return false;
	}
	
	public void poserDrapeau(int abscisse, int ordonnee)
	{
		Case[][] tabCase = getGrille();
		tabCase[ordonnee][abscisse].setDrapeau(true);
		setGrille(tabCase);
	}
	
	public void retirerDrapeau(int abscisse, int ordonnee)
	{
		Case[][] tabCase = getGrille();
		tabCase[ordonnee][abscisse].setDrapeau(false);
		setGrille(tabCase);
	}
	
	public void devoiler(int abscisse, int ordonnee)
	{
		Case[][] tabCase = getGrille();
		tabCase[ordonnee][abscisse].setDecouvert(true);
		if(tabCase[ordonnee][abscisse].getValeur() == 0 && !tabCase[ordonnee][abscisse].getBombe())
			tabCase = casesAutour(tabCase, abscisse, ordonnee);
		setGrille(tabCase);
	}
	
	private Case[][] casesAutour(Case[][] tabCase, int x, int y)
	{
		for(int x1 = -1; x1 < 2; x1++)
		{
			for(int y1 = -1; y1 < 2; y1++)
			{
				if(etreDansLaGrille(x, y, x1, y1) && !tabCase[y+y1][x+x1].getDecouvert())
				{
					if(tabCase[y+y1][x+x1].getValeur() == 0 && !tabCase[y+y1][x+x1].getBombe())
					{
						tabCase[y+y1][x+x1].setDecouvert(true);
						tabCase = casesAutour(tabCase, x+x1, y+y1);
					}
					else if(tabCase[y+y1][x+x1].getValeur() != 0)
						tabCase[y+y1][x+x1].setDecouvert(true);
				}					
			}
		}
		return tabCase;
	}
	
	public int NbDrapeau()
	{
		int nbDrapeau = 0;
		for(int x = 0; x < taille; x++)
		{
			for(int y = 0; y < taille; y++)			
			{
				if(tabCase[x][y].getDrapeau())
					nbDrapeau++;
			}
		}
		return nbDrapeau;
	}
	
	public void setGrille(Case[][] grille)
	{
		this.tabCase = grille;
	}
	
	public void setParametres(Parametres parametres)
	{
		this.parametres = parametres;
	}
	
	public Case[][] getGrille()
	{
		return tabCase;
	}
	
	public int getNbBombe()
	{
		return nbBombe;
	}
	
	public int getNbDrapeau()
	{
		return NbDrapeau();
	}
	
	public Parametres getParametres()
	{
		return parametres;
	}
}