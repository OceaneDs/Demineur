package demineur;

public class Case
{
	private int valeur = 0;
	private boolean bombe = false, drapeau = false, decouvert = false;
	
	public Case(boolean bombe, boolean decouvert)
	{
		this.bombe = bombe; 
		this.decouvert = decouvert;
	}
	
	public void setValeur(int valeur)
	{
		this.valeur = valeur;
	}
	
	public void setBombe(boolean bombe)
	{
		this.bombe = bombe;
	}
	
	public void setDrapeau(boolean drapeau)
	{
		this.drapeau = drapeau;
	}
	
	public void setDecouvert(boolean decouvert)
	{
		this.decouvert = decouvert;
	}
	
	public int getValeur()
	{
		return valeur;
	}
	
	public boolean getBombe()
	{
		return bombe;
	}
	
	public boolean getDrapeau()
	{
		return drapeau;
	}
	
	public boolean getDecouvert()
	{
		return decouvert;
	}
}