package demineur;

import java.util.Scanner;

public class Main
{
	private static Scanner sc;

	public static void main(String[] args)
	{
		int ChoixMenu;
		int ChoixRegle;
		do // boucle du menu principal,ChoixMenu doit etre egal a 4 pour quitter le programme
		{
			sc = new Scanner(System.in);
			System.out.println("Saisir en fonction de ce que vous voulez faire:\n 1. Jouer\n 2. Parametre\n 3. Regles\n 4. Quitter");
			ChoixMenu = sc.nextInt(); //saisie du choix du menu principal
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
					System.out.println("Saisir en fonction de ce que vous voulez voir:\n 1. Parametre Partie\n 2. Grille\n 3. Devoiler case\n 4. Drapeau\n 5. Victoire\n 6. Retourner au menu principale");
					do // boucle du choix de regle, ChoixRegle doit etre egal a 6
					{
						ChoixRegle = str.nextInt();
						switch (ChoixRegle)
						{
							case 1:
								System.out.println(" ECRIRE LES REGLE PARAMETRE !!!");
								break;
							case 2 :
								System.out.println(" ECRIRE LES REGLES GRILLE !!!");
								break;
							case 3:
								System.out.println(" ECRIRE LES REGLES DEVOILER CASE");
								break;
							case 4 :
								System.out.println(" ECRIRE LES REGLES DRAPEAUX");
								break;
							case 5:
								System.out.println(" ECRIRE LES REGLES VICTOIRE");
								break;
							case 6:
								System.out.println("Retour au menu principal");
								break;
							default:
								System.out.println("Erreur de choix1");
						}
					}while(ChoixRegle != 6); //voir ligne 31
					break;
				default:
					System.out.println("Erreur de choix");
			}
		}while(ChoixMenu != 4); //voir ligne 14
	}
}