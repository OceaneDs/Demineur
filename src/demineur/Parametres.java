package demineur;

public class Parametres
{
	private int taille, probaBombe;
	private boolean triche;

	public Parametres() {setTaille(10); setProbaBombe(20); setTriche(false);}
	
	public void setTaille(int taille) {this.taille = taille;}
	
	public void setProbaBombe(int probaBombe) {this.probaBombe = probaBombe;}
	
	public void setTriche(boolean triche) {this.triche = triche;}

	public int getTaille() {return this.taille;}

	public int getProbaBombe() {return this.probaBombe;}

	public boolean getTriche(){return this.triche;}
}
