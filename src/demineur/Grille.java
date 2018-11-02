package demineur;

public class Grille extends Bombe
{
	private int taille = 0;
	public Grille(int taille){this.taille = taille; iniGrille();} // d�finie la taille, puis appel l'initialisation de la grille
	private void iniGrille() // cr�� la grille par d�faut
	{
		Case[][] grille = new Case[taille][taille]; // cr�� un tableau multidimetionnel de Case
		for(int x=0; x<taille; x++)
		{
			for(int y=0; y<taille; y++)
			{
				boolean bombe = randBombe();
				grille[x][y] = new Case(bombe, false);
			}
		}
	}
}