package demineur;

public class Partie
{
	public Partie(int taille, int pBomb, boolean cheat)
	{
		System.out.println("<DEBUT PARTIE>");
		Grille grille = new Grille(taille, pBomb);
		grille.afficher(cheat);
		grille.jouer();
	}
}
