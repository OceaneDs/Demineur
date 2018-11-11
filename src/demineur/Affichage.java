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
					vide		= " La case est d�voil�",
					choixInv	= " Le choix demand� n'est pas valide",
					tailleInv 	= " La taille saisie n'est pas valide [1;+infini[",
					pourcentInv = " Le pourcentage saisie est invalide [0;100]",
					titreMenu 	= " --- <MENU> ---",
					textMenu 	= " 1. Nouvelle Partie | 2. Parametres | -1. Quitter\n-> ",
					titrePara	= " --- <PARAMETRES> ---",
					textPara	= " 1. Taille : %d | 2. Bombes : %d%c | 3. Mode triche : %s | -1. Retour\n-> ",
					textTour	= " <0. Poser drapeau | -1. Quitter la partie | -2. Triche(%s) | rien> <abscisse> <ordonnee>\n-> ",
					drapeaux	= " Drapeau(x) disponible(s) : %d\n",
					horsGrille	= " Coordonn�es hors de la grille",
					dejaDrapeaux= " Impossible de d�voiler un drapeau",
					val1		= " #  ", // case non d�voil�
					val2		= " ?  ", // case avec drapeau
					val3		= " x  ", // case non d�voil� avec bombe affich� si mode triche ou perdu
					val4		= " !  ", // case d�voil� avec une bombe
					val5		= " %d  ", // case d�voil� avec valeur
					val6		= "    " // case d�voil� sans valeur
					;
	
	public Affichage(Parametres parametres)
	{
		this.parametres = parametres;
	}
	
	/**
	 * @return
	 * affichage permettant de lancer une partie et/ou d'acceder au parametre
	 */
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
	
	/**
	 * affichage permettant l'acces a la modification des parametres
	 */
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
	
	/**
	 * affichage de la modification direct de la taille de la grille
	 */
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
	
	/**
	 * affichage de la modification direct du pourcentage de bombes
	 */
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
	
	/**
	 * affichage de l'activation ou desactivation direct du mode triche
	 */
	public void ModifTriche()
	{
		if(parametres.getTriche())
			parametres.setTriche(false);
		else
			parametres.setTriche(true);
	}
	
	/**
	 * @param tabCase
	 * parcours la grille et l'affiche
	 */
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
						conditionAffichage(tabCase, x, y);
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
	
	/**
	 * @param tabCase
	 * @param x
	 * @param y
	 * regroupe toutes les methodes d'affichage
	 */
	private void conditionAffichage(Case[][] tabCase, int x, int y)
	{
			boolean triche = parametres.getTriche();
			if(estUnDrapeau(tabCase, x, y, triche))
				System.out.printf("%s", val2);
			else if(estLaBombe(tabCase, x, y))
				System.out.printf("%s", val4);
			else if(estUneBombe(tabCase, x, y, triche))
				System.out.printf("%s", val3);
			else if(estCache(tabCase, x, y))
				System.out.printf("%s", val1);
			else if(estDevoile(tabCase, x, y))
			{
				if(tabCase[x][y].getValeur() != 0)
					System.out.printf(val5, tabCase[x][y].getValeur());
				else
					System.out.printf("%s", val6);
			}
	}
	
	/**
	 * @param tabCase
	 * @param x
	 * @param y
	 * @return
	 * retourne vrai si la case n'est pas d�couverte et qu'elle n'est pas un drapeau
	 */
	private boolean estCache(Case[][] tabCase, int x, int y)
	{
		if(!tabCase[x][y].getDecouvert() && !tabCase[x][y].getDrapeau()) 
			return true;
		return false;
	}
	
	/**
	 * @param tabCase
	 * @param x
	 * @param y
	 * @param triche
	 * @return
	 * retourne vrai si la case n'est pas decouverte, qu'elle est un drapeau && que le mode triche n'est pas actif
	 */
	private boolean estUnDrapeau(Case[][] tabCase, int x, int y, boolean triche)
	{
		if(!tabCase[x][y].getDecouvert() && tabCase[x][y].getDrapeau() && !triche) 
			return true;
		return false;
	}
	
	/**
	 * @param tabCase
	 * @param x
	 * @param y
	 * @param triche
	 * @return
	 * retourne vrai si la case est une bombe, n'est pas un drapeau et que le mode triche est actif
	 */
	private boolean estUneBombe(Case[][] tabCase, int x, int y, boolean triche)
	{
		if(tabCase[x][y].getBombe() && !tabCase[x][y].getDrapeau() && triche) 
			return true;
		return false;
	}
	
	/**
	 * @param tabCase
	 * @param x
	 * @param y
	 * @return
	 * retourne vrai si la case decouverte est une bombe
	 */
	private boolean estLaBombe(Case[][] tabCase, int x, int y)
	{
		if(tabCase[x][y].getDecouvert() && tabCase[x][y].getBombe())
			return true;
		return false;
	}
	
	/**
	 * @param tabCase
	 * @param x
	 * @param y
	 * @return
	 * retourne vrai si la case est d�voil�
	 */
	private boolean estDevoile(Case[][] tabCase, int x, int y)
	{
		if(tabCase[x][y].getDecouvert())
			return true;
		return false;
	}
	
	/**
	 * @param nb
	 * permet d'eviter le decalage dans l'affichage de la grille
	 */
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
	
	/**
	 * @param tabCase
	 * active le mode triche pour l'affichage des bombes en fin de partie en cas de victoire
	 */
	public void victoire(Case[][] tabCase)
	{
		parametres.setTriche(true);
		grille(tabCase);
		System.out.println(victoire);
	}
	
	/**
	 * @param tabCase
	 * active le mode triche pour l'affichage des bombes en fin de partie en cas de defaite
	 */
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
	
	/**
	 * @param grille
	 * permet de choisir l'action du joueur
	 */
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
	
	/**
	 * @param tabCase
	 * @param abscisse
	 * @param ordonnee
	 * @return
	 * rassemble toutes les conditions pour l'affichage
	 */
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