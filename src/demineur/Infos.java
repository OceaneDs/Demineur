package demineur;

import java.util.Scanner;

public class Infos
{
	private Scanner sc;
	private int choix;
	
	public Infos()
	{
		selection();
	}
	
	private void selection()
	{
		sc = new Scanner(System.in);
		do // tant que choix != 3 (retour), boucle
		{
			System.out.println(" --- <INFOS> ---");
			System.out.printf(" 1. Parametres\n 2. Jouer\n 3. Retour\n-> ");
			choix = sc.nextInt();
			switch(choix)
			{
				case 1:
					System.out.println(" - Parametres -");
					parametres();
					break;
				case 2 :
					System.out.println(" - Jouer -");
					jouer();
					break;
				case 3:
					break;
				default:
					System.out.println("<Erreur !>");
			}
		}while(choix != 3);
	}
	
	private void parametres()
	{
		System.out.println(" Dans les parametres (accessibles depuis le menu), vous trouverez 3 varibales pouvant etres modifies\n"
				+ " - Taille : vous permet de regler la taille de la grille (longueur = largeur)\n"
				+ " - Pourcentage bombes : pourcentage que la case soit ou non une bombe\n"
				+ " - Mode triche : permet de reperer les bombes lors d'une partie (aide aux tests)");
		ok();
	}
	
	private void jouer()
	{
		System.out.println(" Lors d'une partie il sera possible de faire 4 choix\n"
				+ " - Devoiler : devoile une case\n"
				+ " - Poser un drapeau : pose un repere sur une case\n"
				+ " - Retirer un drapeau : permet de retirer un marqeur\n"
				+ " - Quitter : quitte la partie en cours");
		ok();
	}
	
	private void ok()
	{
		System.out.println(" 1. Retour");
		do
		{
			System.out.printf("-> ");
			choix = sc.nextInt();
		}while(choix != 1);
	}
}
