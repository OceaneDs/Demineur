package demineur;
import java.lang.Math;

public class Bombe
{
	private int nb_Bombe = 0;
	private int pBomb;
	public Bombe(int pBomb){this.pBomb = pBomb;}
	public int getPourcentage(){return this.pBomb;} // retourne le pourcentage de bombes
	public void setPourcentage(int pourcentage){this.pBomb = pourcentage;} // Modifie le pourcentage de bombes
	public int getBombe(){return this.nb_Bombe;} // retourne le nombre total de bombes
	public boolean randBombe(){if( ((int) (Math.random() * 100)) > pBomb) return false; this.nb_Bombe++; return true;} // prend un nombre aleatoire entre 0 et 100, si ce nombre est superieur aux pourcentage retourne false (n'est pas une bombe) sinon, incremente le nombre total de bombe et retourne true (est une bombe)
}