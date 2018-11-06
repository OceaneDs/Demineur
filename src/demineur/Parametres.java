package demineur;

import java.util.Scanner;

public class Parametres
{
	private Scanner sc;
	private int choix, taille = 10, pBomb = 40;
	private boolean cheat = false;
	
	public void selection()
	{
		sc = new Scanner(System.in);
		do
		{
			System.out.println(" --- <PARAMETRES> ---");
			System.out.printf(" 1. Taille : %d\n 2. Bombes : %d%c\n", taille, pBomb, 37);
			if(cheat == false)
				System.out.println(" 3. Mode triche : desactive");
			else
				System.out.println(" 3. Mode triche : active");
			System.out.printf(" 4. Retour\n-> ");
			choix = sc.nextInt();
			switch(choix)
			{
				case 1:
					System.out.printf(" Taille : ");
					do
					{
						choix = sc.nextInt();
						if(choix < 1)
							System.out.printf(" [1;inf[\n-> ");
					}while(choix < 1);
					taille = choix;
					break;
				case 2:
					System.out.printf(" Bombes : ");
					do
					{
						choix = sc.nextInt();
						if(choix < 0 || choix >100)
							System.out.printf(" [0;100]\n-> ");
					}while(choix < 0 || choix >100);
					pBomb = choix;
					break;
				case 3:
					if(cheat == false)
						cheat = true;
					else
						cheat = false;
					break;
				case 4:
					break;
				default:
					System.out.println("<Erreur !>");
			}
		}while(choix != 4);
	}
	
	public int getTaille()
	{
		return taille;
	}
	
	public int getPBomb()
	{
		return pBomb;
	}
	
	public boolean getCheat()
	{
		return cheat;
	}
}
