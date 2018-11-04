package demineur;
import java.util.Scanner;

public class Tour
{
	protected Scanner sc;
	private int choix, abscisse, ordonnee;
	private Grille terrain;
	
	public boolean jouer(Grille terrain, int taille, boolean cheat)
	{
		this.terrain = terrain;
		sc = new Scanner(System.in);
		System.out.printf(" 1. Devoiler | 2. Poser un drapeau | 3. Retirer un drapeau | 4. Quitter\n-> ");
		choix = sc.nextInt();
		switch(choix)
		{
			case 1:
				coordonnees(taille);
				devoiler();
				break;
			case 2:
				coordonnees(taille);
				poserDrapeau();
				break;
			case 3:
				coordonnees(taille);
				retirerDrapeau();
				break;
			case 4:
				return true;
			default:
				System.out.println("<Erreur !");
		}
		return false;
	}
	
	public Grille getTerrain()
	{
		return this.terrain;
	}
	
	private void coordonnees(int taille)
	{
		System.out.printf("Coordonnee en x\n-> ");
		do
		{
			choix = sc.nextInt();
			if(choix < 1 || choix > taille)
				System.out.printf("<Erreur !> x E [1;%d]\n-> ", taille);
			else
				abscisse = taille - choix;
		}while(choix < 1 || choix > taille);
		System.out.printf("Coordonnee en y\n-> ");
		do
		{
			choix = sc.nextInt();
			if(choix < 1 || choix > taille)
				System.out.printf("<Erreur !> y E [1;%d]\n-> ", taille);
			else
				ordonnee = choix - 1;
		}while(choix < 1 || choix > taille);
	}
	
	private void devoiler()
	{
		System.out.println("code");
//		this.terrain = terrain;
	}
	
	private void poserDrapeau()
	{
		
		this.terrain = terrain;
	}
	
	private void retirerDrapeau()
	{
		
		this.terrain = terrain;
	}
}
