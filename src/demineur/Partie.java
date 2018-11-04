package demineur;

public class Partie
{
	private Grille terrain;
	private Tour tour = new Tour();
	private CondiStop condition = new CondiStop();
	
	public Partie(int taille, int pBomb, boolean cheat)
	{
		boolean quitter;
		System.out.println(" --- <DEBUT PARTIE> ---");
		terrain = new Grille(taille, pBomb);
		do
		{
			new AfficherGrille(terrain, taille, cheat);
			quitter = tour.jouer();
			terrain = tour.getTerrain();
		}while(condition.victoire(terrain) == false && quitter == false);
		System.out.println(" --- <FIN PARTIE> ---");
	}
}
