package demineur;

public class Affichage
{
	public void MenuPrincipal(){ System.out.println("Saisir en fonction de ce que vous voulez faire:\n 1. Jouer\n 2. Parametre\n 3. Règles\n 4. Quitter"); }
	public static void ErreurChoix() { System.out.println("Erreur de choix"); }
	public static void Regles(){ System.out.println("Saisir en fonction de ce que vous voulez voir:\n 1. Paramètre Partie\n 2. Grille\n 3. Dévoiler case\n 4. Drapeau\n 5. Victoire\n 6. Retourner au menu principale"); }
	public static void RegleParametrePartie(){ System.out.println(" ECRIRE LES REGLE PARAMETRE !!!"); }
	public static void RegleGrille() { System.out.println(" ECRIRE LES REGLES GRILLE !!!"); }
	public static void RegleDevoilerCase(){ System.out.println(" ECRIRE LES REGLES DEVOILER CASE");}
	public static void RegleDrapeaux() { System.out.println(" ECRIRE LES REGLES DRAPEAUX"); }
	public static void RegleVictoire() { System.out.println(" ECRIRE LES REGLES VICTOIRE"); }
}
// pourcentage de bombe, mode triche, taille de grille