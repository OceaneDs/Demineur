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