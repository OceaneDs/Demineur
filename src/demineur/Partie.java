package demineur;

public class Partie
{
	private Grille terrain;
	private Tour tour;
	private CondiStop condition = new CondiStop();
	
	public Partie(int taille, int pBomb, boolean cheat)
	{
		boolean quitter;
		System.out.println(" --- <DEBUT PARTIE> ---");
		terrain = new Grille(taille, pBomb);
		tour = new Tour();
		do
		{
			new AfficherGrille(terrain, taille, cheat);
			quitter = tour.jouer(terrain, taille, cheat);
			terrain = tour.getTerrain();
		}while(!(condition.victoire(terrain) || quitter));
		System.out.println(" --- <FIN PARTIE> ---\n");
	}
}