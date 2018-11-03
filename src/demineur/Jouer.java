package demineur;
import java.util.Scanner;

public class Jouer
{
	protected Scanner sc;
	private int choix, abscisse, ordonnee;
	public Jouer(Case[][] grille)
	{
			sc = new Scanner(System.in);
			System.out.printf("<CHOIX>\n1. Devoiler une case\n2. Poser un drapeau\n3. Retirer un drapeau\n4. Retour\n: ");
			choix = sc.nextInt();
			switch(choix)
			{
				case 1:
					coordonnees();
					break;
				case 2:
					coordonnees();
					break;
				case 3:
					coordonnees();
					break;
				case 4:
					break;
				default:
					System.out.println("<Err!");
			}
			System.out.println("<FIN PARTIE>");
	}
	private void coordonnees()
	{
		System.out.println("<COORDONNEES>");
		System.out.printf("X : ");
		abscisse = sc.nextInt();
		System.out.printf("Y : ");
		ordonnee = sc.nextInt();
	}
}