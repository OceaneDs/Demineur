package demineur;

public class AfficherGrille
{
	private Case[][] grille;
	private int nbBomb, nbFlag = 0;
	
	public AfficherGrille(Grille terrain, int taille, boolean cheat)
	{
		grille = terrain.getGrille();
		nbBomb = terrain.getNbBomb();
		afficher(taille, cheat);
	}
	
	private void afficher(int taille, boolean cheat)
	{
		int ordonnee = taille;
		int abscisse = 0;
		for(int x = 0; x < taille+1; x++)
		{
			for(int y = -1; y < taille; y++)
			{
				if( y== -1 && x < taille)
				{
					reperes(ordonnee);
					ordonnee--;
				}else
				{
					if(x < taille)
					{
						if(grille[x][y].getDiscovered() == false && (grille[x][y].getBomb() == false || cheat == false))
							System.out.printf(" %c |", 176);
						else if(grille[x][y].getDiscovered() == false && cheat == true && grille[x][y].getBomb() == true)
							System.out.printf(" x |");
						else 
							System.out.printf("   |");
						if(grille[x][y].getFlag() == true)
							nbFlag++;
					}else
					{
						reperes(abscisse);
						abscisse++;
					}
				}
			}
			System.out.printf("\n");
		}
		System.out.printf("Drapeau(x) disponible(s) : %d\n", nbBomb-nbFlag);
	}
	
	private void reperes(int nb){ // permet d'annuler les decalages graphique pour les reperes abscisse et ordonnee (jusqu'a une taille de 999)
		if(nb > 99) // si le repere est supperieur a 3 caracteres
			System.out.printf("%d|", nb); // aucun espace
		else if(nb > 9) // sinon si le repere est supperieur a 2 caracteres
			System.out.printf("%d |", nb); // 1 espace
		else // sinon le repere a 1 caractere
			System.out.printf(" %d |", nb);	// 2 espaces
	}
}
