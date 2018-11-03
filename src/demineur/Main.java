package demineur;

import java.util.Scanner;

public class Main
{
	private static Scanner sc;

	public static void main(String[] args)
	{
		int ChoixMenu;
		int ChoixRegle;
		int ChoixJouer;
		do // boucle du menu principal,ChoixMenu doit etre egal a 4 pour quitter le programme
		{
			sc = new Scanner(System.in);
			System.out.println("Saisir en fonction de ce que vous voulez faire:\n 1. Jouer\n 2. Parametre\n 3. Regles\n 4. Quitter");
			ChoixMenu = sc.nextInt(); //saisie du choix du menu principal
			switch (ChoixMenu) // condition du choix du menu
			{
				case 1:
					Scanner st = new Scanner(System.in);
					do
					{
						System.out.println("Saisir le numéro correspondant à ce que vous voulez faire :\n 1. Devoiler une case\n 2. Poser un drapeau\n 3. Retirer un drapeau\n 4. Retour au menu principal");
						ChoixJouer = st.nextInt();
						switch (ChoixJouer)
						{
						case 1:
							System.out.println("Devoiler une case");
							break;
						case 2:
							System.out.println("Poser un drapeau");
							break;
						case 3:
							System.out.println("Retirer un drapeau");
							break;
						case 4:
							System.out.println("Vous quitter le mode Jouer");
							break;
							default:
								System.out.println("Erreur de saisi pour jouer");
						}
					}while(ChoixJouer != 4);
					// devoiler, drapeau, quitter
					break;
				case 2:
					System.out.println(" PARAMETRE");
					break;
				case 3:
					Scanner str = new Scanner(System.in);
					do // boucle du choix de regle, ChoixRegle doit etre egal a 6
					{
						System.out.println("Saisir en fonction de ce que vous voulez voir:\n 1. Parametre Partie\n 2. Grille\n 3. Devoiler case\n 4. Drapeau\n 5. Victoire\n 6. Pourcentage de bombe\n 7. Mode triche\n 8. Taille grille\n 9. Retourner au menu principale");
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
								System.out.println(" ECRIRE LES REGLE POURCENTAGE DE BOMBE");
								break;
							case 7:
								System.out.println(" ECRIRE LES REGLES DE MODE TRICHE");
								break;
							case 8:
								System.out.println(" ECRIRE TAILLE GRILLES");
								break;
							case 9:
								System.out.println("Retour au menu principal");
								break;
							default:
								System.out.println("Erreur de choix de regle");
						}
					}while(ChoixRegle != 9); //voir ligne 31
					break;
				case 4:
						System.out.println("Fin du programme");
					break;
				default:
					System.out.println("Erreur de choix du menu principal");
			}
		}while(ChoixMenu != 4); //voir ligne 14
	}
}