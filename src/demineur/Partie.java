package demineur;

public class Partie
{
	public Partie(int taille, int pBomb, boolean cheat)
	{
		Grille grille = new Grille(taille, pBomb);
		do
		{
		grille.afficher(cheat);
		new Jouer();
		}while()
	}
}
