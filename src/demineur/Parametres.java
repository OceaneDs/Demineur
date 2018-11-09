package demineur;

public class Parametres
{
	private int taille, probaBombe;
	private boolean triche;
	
	/**
	 * Initialise les valeurs des parametres par défauts
	 */
	public Parametres() {setTaille(10); setProbaBombe(20); setTriche(false);}
	
	/**
	 * 
	 * @param taille
	 */
	public void setTaille(int taille) {this.taille = taille;}
	
	/**
	 * 
	 * @param probaBombe
	 */
	public void setProbaBombe(int probaBombe) {this.probaBombe = probaBombe;}
	
	/**
	 * 
	 * @param triche
	 */
	public void setTriche(boolean triche) {this.triche = triche;}
	
	/**
	 * taille compris entre [1;+infini[
	 * @return taille
	 */
	public int getTaille() {return this.taille;}
	
	/**
	 * probaBomb compris entre [0;100] (%)
	 * @return probaBombe
	 */
	public int getProbaBombe() {return this.probaBombe;}
	
	/**
	 * 
	 * @return triche
	 */
	public boolean getTriche(){return this.triche;}
}
