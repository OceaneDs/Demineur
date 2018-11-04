package demineur;
import java.lang.Math;

public class Bombe
{
	private int nbBomb = 0;
	private int pBomb;
	public Bombe(int pBomb){this.pBomb = pBomb;}
	public int getPourcentage(){return this.pBomb;} // retourne le pourcentage de bombes
	public void setPourcentage(int pourcentage){this.pBomb = pourcentage;} // Modifie le pourcentage de bombes
	public int getNbBomb(){return this.nbBomb;} // retourne le nombre total de bombes
	public boolean randBombe()
	{
		if( ((int) (Math.random() * 100)) >= pBomb) 
			return false; 
		this.nbBomb++; 
		return true;
	} // prend un nombre aleatoire entre 0 et 100, si ce nombre est superieur aux pourcentage retourne false (n'est pas une bombe) sinon, incremente le nombre total de bombe et retourne true (est une bombe)
}