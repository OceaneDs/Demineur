package demineur;

public class CondiStop
{
	public boolean victoire(Grille terrain, int taille, boolean cheat)
	{
		Case[][] grille = terrain.getGrille();
		int nbCase = taille * taille - terrain.getNbBomb(), discovered = 0;
		for(int x = 0; x < taille; x++)
		{
			for(int y = 0; y < taille; y++)
			{
				if(grille[x][y].getDiscovered())
					discovered++;
			}
		}
		if(discovered == nbCase)
		{
			new AfficherGrille(terrain, taille, cheat);
			System.out.println("  --- <VICTOIRE> ---");
			return true;
		}
		return false;
	}
}
