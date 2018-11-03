package demineur;
import java.util.Scanner;

public class Jouer
{
	protected Scanner sc;
	public Jouer()
	{
		int ChoixJouer;
		do
		{
			sc = new Scanner(System.in);
			System.out.println("Saisir le numéro correspondant à ce que vous voulez faire :\n 1. Devoiler une case\n 2. Poser un drapeau\n 3. Retirer un drapeau\n 4. Retour au menu principal");
			ChoixJouer = sc.nextInt();
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
	}	
}