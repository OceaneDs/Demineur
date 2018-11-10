package demineur;

import java.util.Scanner;

public class Affichage
{
	private Scanner sc;
	private Parametres parametres;
	private boolean quitter = true;
	private String 	txtT		= " Taille : ",
					txtP		= " Pourcentage bombe : ",
					debutPartie = " --- <DEBUT PARTIE> ---",
					finPartie	= " --- <FIN PARTIE> ---",
					victoire	= " VOUS AVEZ GAGNE !",
					perdu		= " PERDU... Vous ferrez mieux la prochaine fois (ou pas)",
					erreur		= " <Erreur !>",
					errX		= " abscisse [0;%d]",
					errY		= " ordonnee [0;%d]",
					vide		= " La case est dévoilé",
					choixInv	= " Le choix demandé n'est pas valide",
					tailleInv 	= " La taille saisie n'est pas valide [1;+infini[",
					pourcentInv = " Le pourcentage saisie est invalide [0;100]",
					titreMenu 	= " --- <MENU> ---",
					textMenu 	= " 1. Nouvelle Partie | 2. Parametres | -1. Quitter\n-> ",
					titrePara	= " --- <PARAMETRES> ---",
					textPara	= " 1. Taille : %d | 2. Bombes : %d%c | 3. Mode triche : %s | -1. Retour\n-> ",
					textTour	= " <0. Poser drapeau | -1. Quitter la partie | -2. Triche(%s) | rien> <abscisse> <ordonnee>\n-> ",
					drapeaux	= " Drapeau(x) disponible(s) : %d\n",
					horsGrille	= " Coordonnées hors de la grille",
					dejaDrapeaux= " Impossible de dévoiler un drapeau"
					;
	
	public Affichage(Parametres parametres)
	{
		this.parametres = parametres;
	}
	
	public boolean menu()
	{
		int choix;
		sc = new Scanner(System.in);
		System.out.println(titreMenu);
		do
		{
			System.out.printf(textMenu);
			choix = sc.nextInt();
			switch(choix)
			{
				case 1:
					return true;
				case 2:
					parametres();
					break;
				case -1:
					break;
				default:
					System.out.println(erreur + choixInv);
			}
		}while(choix != -1);
		return false;
	}
	
	private void parametres()
	{
		int choix;
		sc = new Scanner(System.in);
		System.out.println(titrePara);
		do
		{
			System.out.printf(textPara, parametres.getTaille(), parametres.getProbaBombe(), 37, parametres.getTriche());
			choix = sc.nextInt();
			switch(choix)
			{
				case 1:
					ModifTaille();
					break;
				case 2:
					ModifPourcentage();
					break;
				case 3:
					ModifTriche();
					break;
				case -1:
					break;
				default:
					System.out.println(erreur + choixInv);
			}
		}while(choix != -1);
	}
	
	private void ModifTaille()
	{
		int choix;
		sc = new Scanner(System.in);
		do
		{
			System.out.printf("%s", txtT);
			choix = sc.nextInt();
			if(choix > 0)
				parametres.setTaille(choix);
			else if(choix != -1)
				System.out.println(erreur + tailleInv);
		}while(choix != -1 && choix < 1);
	}
	
	private void ModifPourcentage()
	{
		int choix;
		sc = new Scanner(System.in);
		do
		{
			System.out.printf("%s", txtP);
			choix = sc.nextInt();
			if(choix >= 0 && choix <= 100)
				parametres.setProbaBombe(choix);
			else if(choix != -1)
				System.out.println(erreur + pourcentInv);
		}while(choix != -1 && (choix < 0 || choix > 100));
	}
	
	public void ModifTriche()
	{
		if(parametres.getTriche())
			parametres.setTriche(false);
		else
			parametres.setTriche(true);
	}
	
	public void grille(Case[][] tabCase)
	{
		int	taille = parametres.getTaille(),
			ordonnee = taille,
			abscisse = 0;
		for(int x = 0; x < taille+1; x++)
		{
			for(int y = -1; y < taille; y++)
			{
				if( y== -1 && x < taille)
				{
					reperes(ordonnee);
					ordonnee--;
				}else
				{
					if(x < taille)
						conditionAffichage(tabCase, taille, x, y);
					else
					{
						reperes(abscisse);
						abscisse++;
					}
				}
			}
			System.out.printf("\n");
		}
	}
	
	private void conditionAffichage(Case[][] tabCase, int taille, int x, int y) // #CodeDePorc
	{
			boolean triche = parametres.getTriche();
			if((!tabCase[x][y].getDecouvert() && !tabCase[x][y].getBombe() && !tabCase[x][y].getDrapeau())  || (!tabCase[x][y].getDecouvert() && tabCase[x][y].getBombe() && !tabCase[x][y].getDrapeau() && !triche))
				System.out.printf(" %c  ", 176);
			else if((!tabCase[x][y].getDecouvert() && !tabCase[x][y].getBombe() && tabCase[x][y].getDrapeau()) || (!tabCase[x][y].getDecouvert() && tabCase[x][y].getBombe() && tabCase[x][y].getDrapeau()))
				System.out.printf(" ?  ");
			else if(!tabCase[x][y].getDecouvert() && tabCase[x][y].getBombe() && !tabCase[x][y].getDrapeau() && triche)
				System.out.printf(" x  ");
			else if(tabCase[x][y].getDecouvert() && tabCase[x][y].getBombe() && !tabCase[x][y].getDrapeau())
				System.out.printf(" !  ");
			else if(tabCase[x][y].getDecouvert() && !tabCase[x][y].getBombe() && !tabCase[x][y].getDrapeau())
			{
				if(tabCase[x][y].getValeur() != 0)
					System.out.printf(" %d  ", tabCase[x][y].getValeur());
				else
					System.out.printf("    ");
			}
	}
	
	private void reperes(int nb){
		if(nb > 99)
			System.out.printf("%d|", nb);
		else if(nb > 9)
			System.out.printf("%d |", nb);
		else
			System.out.printf(" %d |", nb);
	}
	
	public void drapeaux(Grille grille)
	{
		System.out.printf(drapeaux, grille.getNbBombe()-grille.getNbDrapeau());
	}
	
	public void victoire(Case[][] tabCase)
	{
		parametres.setTriche(true);
		grille(tabCase);
		System.out.println(victoire);
	}
	
	public void perdu(Case[][] tabCase)
	{
		parametres.setTriche(true);
		grille(tabCase);
		System.out.println(perdu);
	}
	
	public void debutPartie()
	{
		System.out.println(debutPartie);
	}
	
	public void finPartie()
	{
		System.out.println(finPartie);
	}
	
	public void tour(Grille grille) // #CodeDePorc
	{
		boolean erreur;
		int option, abscisse, ordonnee;
		Case[][] tabCase = grille.getGrille();
		sc = new Scanner(System.in);
		do
		{
			erreur = false;
			System.out.printf(textTour, parametres.getTriche());
			option = sc.nextInt();
			if(option > 0 || option == 0)
			{
				abscisse = sc.nextInt();
				if(option == 0)
				{
					abscisse = abscisse - 1;
					ordonnee = parametres.getTaille() - sc.nextInt();
					erreur = condi(tabCase, abscisse, ordonnee);
				}
				else
				{
					ordonnee = parametres.getTaille() - abscisse;
					abscisse = option - 1;
					erreur = condi(tabCase, abscisse, ordonnee);
				}
				if(!erreur)
				{
					if(option == 0)
					{
						if(tabCase[ordonnee][abscisse].getDrapeau())
							grille.retirerDrapeau(abscisse, ordonnee);
						else
							grille.poserDrapeau(abscisse, ordonnee);
					}
					else
					{
						if(tabCase[ordonnee][abscisse].getDrapeau())
						{
							erreur = true;
							System.out.println(this.erreur + dejaDrapeaux);
						}
						else
							grille.devoiler(abscisse, ordonnee);
					}
				}
			}else
			{
				if(option == -1)
					setQuitter(false);
				else if(option == -2)
				{
					if(parametres.getTriche())
						parametres.setTriche(false);
					else
						parametres.setTriche(true);
				}else
				{
					erreur = true;
					System.out.println(erreur + choixInv);
				}
			}		
		}while(erreur);
	}
	
	private boolean condi(Case[][] tabCase, int abscisse, int ordonnee)
	{
		int taille = parametres.getTaille();
		if(abscisse < taille && ordonnee < taille)
		{
			if(abscisse < 0 && abscisse > parametres.getTaille())
			{
				System.out.printf("%s %s\n", erreur, errX, parametres.getTaille());
				return true;
			}	
			if(ordonnee < 0 && ordonnee > parametres.getTaille())
			{
				System.out.printf("%s %s\n", erreur, errY, parametres.getTaille());
				return true;
			}
			if(tabCase[ordonnee][abscisse].getDecouvert())
			{
				System.out.println(erreur + vide);
				return true;
			}
		}else
		{
			System.out.println(erreur + horsGrille);
			return true;
		}
		return false;
	}
	
	public void setQuitter(boolean quitter)
	{
		this.quitter = quitter;
	}
	
	public boolean getQuitter()
	{
		return quitter;
	}
}