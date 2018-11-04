package demineur;

public class Case
{
	private int value = 0;
	private boolean bombe = false, flag = false, discovered = false;
	
	public Case(boolean bombe, boolean discovered) // constructeur de la class Case, attribue une valeur aux boolean bombe et discovered
	{
		this.bombe = bombe; 
		this.discovered = discovered;
	}
	
	public int getValue() // retourne la valeur de la variable value
	{
		return this.value;
	}
	
	public void setValue(int value) // modifie la valeur de la variable value
	{
		this.value = value;
	}
	
	public boolean getBomb() // retourne la valeur de la variable bombe
	{
		return this.bombe;
	}
	
	public void setBomb(boolean bombe) // modifie la valeur de la variable bombe
	{
		this.bombe = bombe;
	}
	
	public boolean getFlag() // retourne la valeur de la variable flag
	{
		return this.flag;
	}
	
	public void setFlag(boolean flag) // modifie la valeur de la variable flag
	{
		this.flag = flag;
	}
	
	public boolean getDiscovered() // retourne la valeur de la variable discovered
	{
		return this.discovered;
	}
	
	public void setDiscovered(boolean discovered) // modifie la valeur de la variable discovered
	{
		this.discovered = discovered;
	}
}