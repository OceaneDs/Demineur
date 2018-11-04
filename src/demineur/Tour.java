package demineur;
import java.util.Scanner;

public class Tour
{
	protected Scanner sc;
	private int choix, abscisse, ordonnee;
	private Grille terrain;
	
	public boolean jouer(int taille, boolean cheat)
	{
		sc = new Scanner(System.in);
		System.out.printf(" 1. Devoiler\n 2. Poser un drapeau\n 3. Retirer un drapeau\n 4. Quitter\n-> ");
		choix = sc.nextInt();
		switch(choix)
		{
			case 1:
				coordonnees(taille, cheat);
				devoiler();
				break;
			case 2:
				coordonnees(taille, cheat);
				poserDrapeau();
				break;
			case 3:
				coordonnees(taille, cheat);
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
	
	private void coordonnees(int taille, boolean cheat)
	{
		do
		{
			new AfficherGrille(terrain, taille, cheat);
			System.out.printf("Coordonnee de X\n-> ");
			choix = sc.nextInt();
			if(choix < 1 || choix > taille)
				System.out.printf("<Erreur !> x E [1;%d]\n-> ", taille);
			else
				abscisse = taille - choix;
		}while(choix < 1 || choix > taille);
		do
		{
			new AfficherGrille(terrain, taille, cheat);
			System.out.printf("Coordonnee de Y\n-> ");
			choix = sc.nextInt();
			if(choix < 1 || choix > taille)
				System.out.printf("<Erreur !> y E [1;%d]\n-> ", taille);
			else
				ordonnee = choix - 1;
		}while(choix < 1 || choix > taille);
	}
	
	private void devoiler()
	{
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
