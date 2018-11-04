package demineur;

public class Grille
{
	private Case[][] grille;
	private int taille, pBomb;
	private Bombe bomb;
	
	public Grille(int taille, int pBomb)
	{
		grille = new Case[taille][taille];
		this.taille = taille;
		this.pBomb = pBomb;
		iniGrille();
	}
	
	public void iniGrille()
	{
		bomb = new Bombe(pBomb);
		for(int x = 0; x < taille; x++)
		{
			for(int y = 0; y < taille; y++)
			{
				grille[x][y] = new Case(bomb.randBombe(), false);
			}
		}
		remplirValue();
	}
	
	private void remplirValue()
	{
		for(int x = 0; x < taille; x++)
		{
			for(int y = 0; y < taille; y++)
			{
				int c = 0;
				for(int x1 = -1; x1 < 2; x1++)
				{
					for(int y1 = -1; y1 < 2; y1++)
					{
						if((x1 != 0 || y1 != 0) && x + x1 >= 0 && x+x1 < taille && y+y1 >= 0 && y+y1 < taille)
							if(grille[x+x1][y+y1].getBomb())
								c++;
					}
				}
				grille[x][y].setValue(c);
			}
		}
		
	}
	
	public void setGrille(Case[][] grille)
	{
		this.grille = grille;
	}
	
	public Case[][] getGrille()
	{
		return grille;
	}
	
	public int getNbBomb()
	{
		return bomb.getNbBomb();
	}
}