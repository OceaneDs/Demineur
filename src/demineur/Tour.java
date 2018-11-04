package demineur;
import java.util.Scanner;

public class Tour
{
	protected Scanner sc;
	private int choix, abscisse, ordonnee;
	
	public boolean jouer()
	{
		sc = new Scanner(System.in);
		System.out.printf(" 1. Devoiler\n 2. Poser un drapeau\n 3. Retirer un drapeau\n 4. Quitter\n-> ");
		choix = sc.nextInt();
		switch(choix)
		{
			case 1:
				coordonnees();
				devoiler();
				break;
			case 2:
				coordonnees();
				poserDrapeau();
				break;
			case 3:
				coordonnees();
				retirerDrapeau();
				break;
			case 4:
				return true;
			default:
				System.out.println("<Erreur !");
		}
		return false;
	}
	
	private void coordonnees()
	{
		System.out.printf("Coordonnee de X\n-> ");
		abscisse = sc.nextInt();
		System.out.printf("Coordonnee de Y\n-> ");
		ordonnee = sc.nextInt();
	}
	
	private void devoiler()
	{
		
	}
	
	private void poserDrapeau()
	{
		
	}
	
	private void retirerDrapeau()
	{
		
	}
}
