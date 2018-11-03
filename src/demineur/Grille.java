package demineur;

public class Grille
{
	private int taille = 10, pBomb, abscisse, ordonnee;
	private Case[][] grille = new Case[taille][taille]; // cree un tableau multidimentionnel de Case
	public Grille(int taille, int pBomb){setTaille(taille); setPBomb(pBomb); iniGrille();} // definie la taille, puis appel l'initialisation de la grille
	private void iniGrille()
	{
		Bombe bomb = new Bombe(pBomb);
		for(int x = 0; x < taille; x++)
		{
			for(int y = 0; y < taille; y++)
			{
				grille[x][y] = new Case(bomb.randBombe(), false);
			}
		}
	}
	public void afficher(boolean cheat)
	{
		ordonnee = taille;
		abscisse = 0;
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
					}else
					{
						reperes(abscisse);
						abscisse++;
					}
				}
			}
			System.out.printf("\n");
		}
	}
	private void reperes(int nb){ // permet d'annuler les decalages graphique pour les reperes abscisse et ordonnee (jusqu'a une taille de 999)
		if(nb > 99) // si le repere est supperieur a 3 caracteres
			System.out.printf("%d|", nb); // aucun espace
		else if(nb > 9) // sinon si le repere est supperieur a 2 caracteres
			System.out.printf("%d |", nb); // 1 espace
		else // sinon le repere a 1 caractere
			System.out.printf(" %d |", nb);	// 2 espaces
	}
	public int getTaille(){return this.taille;} // retourne la taille de la grille
	public void setTaille(int taille){this.taille = taille;} // modifie la taille de la grille
	public int getPBomb(){return this.pBomb;} // retourne le pourcentage de bombes
	public void setPBomb(int pBomb){this.pBomb = pBomb;} // modifie le pourcentage de bombes
	public void jouer()
	{
		new Jouer(grille);
	}
	public boolean verifVic()
	{
		return false;
	}
}