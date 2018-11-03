package demineur;
import java.util.Scanner;

public class Menu
{
	private Scanner sc;
	public Menu()
	{
		int ChoixMenu;
		do // boucle du menu principal, ChoixMenu doit etre egal a 4 pour quitter le programme
		{
			sc = new Scanner(System.in);
			System.out.println("Saisir en fonction de ce que vous voulez faire:\n 1. Jouer\n 2. Parametre\n 3. Regles\n 4. Quitter");
			ChoixMenu = sc.nextInt(); //saisie du choix du menu principal
			switch (ChoixMenu) // condition du choix du menu
			{
				case 1:
					new Jouer();
					break;
				case 2:
					System.out.println(" PARAMETRE");
					break;
				case 3:
					new Regles();
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