package demineur;

public class Grille
{
	private int taille = 10, pBomb = 50;
	private Bombe bomb = new Bombe(pBomb);
	private Case[][] grille = new Case[taille][taille]; // cree un tableau multidimetionnel de Case
	public Grille(int taille, int pBomb){setTaille(taille); setPBomb(pBomb); iniGrille();} // definie la taille, puis appel l'initialisation de la grille
	private void iniGrille() // cree la grille par defaut
	{
		for(int x = 0; x < this.taille; x++)
		{
			for(int y = 0; y < this.taille; y++)
			{
				grille[x][y] = new Case(bomb.randBombe(), false);
			}
		}
	}
	public void afficher()
	{
		for(int x = 0; x < this.taille; x++)
		{
			for(int y = 0; y < this.taille; y++)
			{
				if(grille[x][y].getDiscovered() == false)
					System.out.printf(" X |");
				else 
					System.out.printf("   |");
			}
			System.out.printf("\n");
		}
	}
	public int getTaille(){return this.taille;} // retourne la taille de la grille
	public void setTaille(int taille){this.taille = taille;} // modifie la taille de la grille
	public int getPBomb(){return this.pBomb;} // retourne le pourcentage de bombes
	public void setPBomb(int pBomb){this.pBomb = pBomb;} // modifie le pourcentage de bombes
}


//Grille grille = new Grille(10, 50);
//grille.afficher();