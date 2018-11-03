package demineur;
import java.util.Scanner;

public class Menu
{
	private Scanner sc;
	public Menu()
	{
		int choix;
		do // boucle du menu principal, ChoixMenu doit etre egal a 4 pour quitter le programme
		{
			sc = new Scanner(System.in);
			System.out.printf("<CHOIX>\n1. Jouer\n2. Parametres\n3. Regles\n4. Quitter\n: ");
			choix = sc.nextInt(); //saisie du choix du menu principal
			switch(choix) // condition du choix du menu
			{
				case 1:
					new Partie(5,0,true);
					break;
				case 2:
					new Parametre();
					break;
				case 3:
					System.out.println("<Regles>");
					new Regles();
					break;
				case 4:
						System.out.println("<FIN DEMINEUR>");
					break;
				default:
					System.out.println("<Err!>");
			}
		}while(choix != 4);
	}	
}