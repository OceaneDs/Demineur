package demineur;
import java.util.Scanner;

public class Tour
{
	protected Scanner sc;
	private int choix, abscisse, ordonnee, taille;
	private Grille terrain;
	private boolean cheat;
	
	public boolean jouer(Grille terrain, int taille, boolean cheat)
	{
		this.terrain = terrain;
		this.taille = taille;
		this.cheat = cheat;
		sc = new Scanner(System.in);
		System.out.printf(" 1. Devoiler | 2. Poser un drapeau | 3. Retirer un drapeau | 4. Quitter\n-> ");
		choix = sc.nextInt();
		switch(choix)
		{
			case 1:
				coordonnees();
				if(devoiler())
					return true;
				break;
			case 2:
				coordonnees();
				poserDrapeau();
				break;
			case 3:
				coordonnees();
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
	
	private void coordonnees()
	{
		System.out.printf("Coordonnee en x\n-> ");
		do
		{
			choix = sc.nextInt();
			if(choix < 1 || choix > taille)
				System.out.printf("<Erreur !> x E [1;%d]\n-> ", taille);
			else
				ordonnee = choix - 1;
		}while(choix < 1 || choix > taille);
		System.out.printf("Coordonnee en y\n-> ");
		do
		{
			choix = sc.nextInt();
			if(choix < 1 || choix > taille)
				System.out.printf("<Erreur !> y E [1;%d]\n-> ", taille);
			else
				abscisse = taille - choix;
		}while(choix < 1 || choix > taille);
	}
	
	private boolean devoiler()
	{
		Case[][] grille = terrain.getGrille();
		do
		{
			if(grille[abscisse][ordonnee].getDiscovered())
			{
				System.out.println("<Erreur !> la case est deja devoile");
				coordonnees();
			}else if(grille[abscisse][ordonnee].getFlag())
			{
				System.out.println("<Erreur !> la case est un drapeau");
				coordonnees();
			}
			if(grille[abscisse][ordonnee].getBomb())
			{
				for(int i = 0; i < taille; i++)
					for(int j = 0; j < taille; j++)
					{
						grille[i][j].setDiscovered(true);
						grille[i][j].setValue(0);
					}
				new AfficherGrille(terrain, taille, cheat);
				System.out.println("   --- <PERDU> ---");
				return true;
			}
		}while(grille[abscisse][ordonnee].getDiscovered());
		grille[abscisse][ordonnee].setDiscovered(true);
		
		terrain.setGrille(grille);
		return false;
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
