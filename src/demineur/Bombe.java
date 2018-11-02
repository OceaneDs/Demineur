package demineur;
import java.lang.Math;

public class Bombe
{
	private int nb_Bombe = 0, pourcentage = 50;
	public int getPourcentage(){return this.pourcentage;} // Retourne le pourcentage de bombes
	public void setPourcentage(int pourcentage){this.pourcentage = pourcentage;} // Modifie le pourcentage de bombes
	public int getBombe(){return this.nb_Bombe;} // Retourne le nombre total de bombes
	public boolean randBombe(){if( ((int) (Math.random() * 100)) > pourcentage) return false; this.nb_Bombe++; return true;} // Prend un nombre aléatoire entre 0 et 100, si ce nombre est supérieur aux pourcentage retourne false (n'est pas une bombe) sinon, incremente le nombre total de bombe avant et retourne true (est une bombe)
}