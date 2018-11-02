package demineur;

import java.util.Scanner;

public class Main
{

	private static Scanner sc;

	public static void main(String[] args)
	{
		do // boucle du menu principal,ChoixMenu doit etre egal à 4 pour quitter le programme
		{
			sc = new Scanner(System.in);
			MenuPrincipal(); // appel de méthode pour l'affichage du menu principal
			int ChoixMenu = sc.nextInt(); //saisie du choix du menu principal
			switch (ChoixMenu) // condition du choix du menu
			{
				case 1:
					System.out.println("JOUER");
					break;
				case 2:
					System.out.println(" PARAMETRE");
					break;
				case 3:
					Scanner str = new Scanner(System.in);
					Affichage.Regles();
					int ChoixRegle = str.nextInt();
					do // boucle du choix de regle, ChoixRegle doit etre egal à 6
					{
						switch (ChoixRegle)
						{
							case 1:
								Affichage.RegleParametrePartie();
								break;
							case 2 :
								Affichage.RegleGrille();
								break;
							case 3:
								Affichage.RegleDevoilerCase();
								break;
							case 4 :
								Affichage.RegleDrapeaux();
								break;
							case 5:
								Affichage.RegleVictoire();
							default:
								Affichage.ErreurChoix(); // appel méthode static pour l'affichage en cas d'erreur de saisie du nombre
						}
					}while(ChoixRegle != 6); //voir ligne 31
				default:
					Affichage.ErreurChoix();
			}
		}while(ChoixMenu != 4); //voir ligne 14
	}
}