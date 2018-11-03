package demineur;
import java.util.Scanner;

public class Regles
{
	private Scanner sc;
	public Regles()
	{
		int ChoixRegle;
		sc = new Scanner(System.in);
		do // boucle du choix de regle, ChoixRegle doit etre egal a 6
		{
			System.out.println("Saisir en fonction de ce que vous voulez voir:\n 1. Parametre Partie\n 2. Grille\n 3. Devoiler case\n 4. Drapeau\n 5. Victoire\n 6. Pourcentage de bombe\n 7. Mode triche\n 8. Taille grille\n 9. Retourner au menu principale");
			ChoixRegle = sc.nextInt();
			switch (ChoixRegle)
			{
				case 1:
					System.out.println("ECRIRE LES REGLE PARAMETRE !!!");
					break;
				case 2 :
					System.out.println("ECRIRE LES REGLES GRILLE !!!");
					break;
				case 3:
					System.out.println("ECRIRE LES REGLES DEVOILER CASE");
					break;
				case 4 :
					System.out.println("ECRIRE LES REGLES DRAPEAUX");
					break;
				case 5:
					System.out.println("ECRIRE LES REGLES VICTOIRE");
					break;
				case 6:
					System.out.println("ECRIRE LES REGLE POURCENTAGE DE BOMBE");
					break;
				case 7:
					System.out.println("ECRIRE LES REGLES DE MODE TRICHE");
					break;
				case 8:
					System.out.println("ECRIRE LES REGLES DES TAILLES DE LA GRILLE");
					break;
				case 9:
					System.out.println("Retour au menu principal");
					break;
				default:
					System.out.println("Erreur dans le choix de la regle");
			}
		}while(ChoixRegle != 9); //voir ligne 31
	}
}