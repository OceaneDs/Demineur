package demineur;
import java.util.Scanner;

public class Parametre
{
	private Scanner sc;
	public Parametre()
	{
		int ChoixParametre;
		sc = new Scanner(System.in);
		do
		{
			System.out.println("Saisir en fonction de ce que vous voulez modifier:\n 1.Taille de la grille\n 2. Pourcentage de bombes\n 3. Mode triche\n 4. Retour au menu principal");
			ChoixParametre = sc.nextInt();
			switch(ChoixParametre)
			{
				case 1:
					System.out.println("Modification de la taille de la grille");
					break;
				case 2:
					System.out.println("Modification du pourcentage de bombes");
					break;
				case 3:
					System.out.println("Mode triche");
					break;
				case 4:
					System.out.println("Retour au menu principal");
					break;
				default:
					System.out.println("Erreur du choix de parametre");
			}
		}while(ChoixParametre != 4);
	}
}
