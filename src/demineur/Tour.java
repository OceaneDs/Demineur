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
				if(terrain.getNbBomb() - terrain.getNbFlag() == 0)
					System.out.println("<Erreur !> disponnibilite drapeaux = 0");
				else
				{
					coordonnees();
					poserDrapeau();
				}
				break;
			case 3:
				if(terrain.getNbFlag() == 0)
					System.out.println("<Erreur !> aucun drapeau");
				else
				{
					coordonnees();
					retirerDrapeau();
				}
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
		if(grille[abscisse][ordonnee].getValue() == 0)
			grille = otherCase(grille, abscisse, ordonnee);
		terrain.setGrille(grille);
		return false;
	}	
	
	private void poserDrapeau()
	{
		Case[][] grille = terrain.getGrille();
		do
		{
			if(grille[abscisse][ordonnee].getDiscovered())
			{
				System.out.println("<Erreur !> case decouverte");
				coordonnees();
			}
			else if(grille[abscisse][ordonnee].getFlag())
			{
				System.out.println("<Erreur !> deja un drapeau");
				coordonnees();
			}
		}while((grille[abscisse][ordonnee].getDiscovered() || grille[abscisse][ordonnee].getFlag()));
		grille[abscisse][ordonnee].setFlag(true);
		terrain.setGrille(grille);
	}
	
	private void retirerDrapeau()
	{
		Case[][] grille = terrain.getGrille();
		do
		{
			if(!grille[abscisse][ordonnee].getFlag())
			{
				System.out.println("<Erreur !> aucun drapeau sur la case");
				coordonnees();
			}
		}while(!grille[abscisse][ordonnee].getFlag());
		grille[abscisse][ordonnee].setFlag(false);
		terrain.setGrille(grille);
	}
	
	private Case[][] otherCase(Case[][] grille, int x, int y)
	{
		int abscisse, ordonnee;
		for(int x1 = -1; x1 < 2; x1++)
		{
			for(int y1 = -1; y1 < 2; y1++)
			{
				if((x1 != 0 || y1 != 0) && x + x1 >= 0 && x+x1 < taille && y+y1 >= 0 && y+y1 < taille && !grille[x+x1][y+y1].getDiscovered())
				{
					if(grille[x+x1][y+y1].getValue() == 0)
					{
						grille[x+x1][y+y1].setDiscovered(true);
						abscisse = x+x1;
						ordonnee = y+y1;
						grille = otherCase(grille, abscisse, ordonnee);
					}
					else if(grille[x+x1][y+y1].getValue() != 0)
						grille[x+x1][y+y1].setDiscovered(true);
				}					
			}
		}
		return grille;
	}
}
