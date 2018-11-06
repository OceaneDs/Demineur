package demineur;
import java.util.Scanner;

public class Menu
{
	private Scanner sc;
	private int choix;
	private Parametres parametres = new Parametres();
	
	public Menu()
	{
		System.out.println("   <DEMINEUR>");
		selection();
		System.out.println("     <FIN>");
	}
	
	private void selection()
	{
		do
		{
			System.out.println(" --- <MENU> ---");
			sc = new Scanner(System.in);
			System.out.printf(" 1. Jouer\n 2. Parametres\n 3. Quitter\n-> ");
			choix = sc.nextInt(); // saisie du choix
			switch(choix) // si le choix
			{
				case 1:
					int taille, pBomb;
					boolean cheat;
					taille = parametres.getTaille();
					pBomb = parametres.getPBomb();
					cheat = parametres.getCheat();
					new Partie(taille, pBomb, cheat);
					break;
				case 2: // = 2, ouvre les parametres
					parametres.selection();
					break;
				case 3: // stop la boucle
					break;
				default: // par defaut
					System.out.println("<Erreur !>");
			}
		}while(choix != 3);
	}
}