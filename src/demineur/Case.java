package demineur;

public class Case
{
	private int value = 0;
	private boolean bombe = false, flag = false, discovered = false;
	public Case(boolean bombe, boolean discovered){this.bombe = bombe; this.discovered = discovered;} // constructeur de la class Case, attribue une valeur aux boolean bombe et discovered 
	public int getValue(){return this.value;} // retourne la valeur de la variable value
	public void setValue(int value){this.value = value;} // modifie la valeur de la variable value
	public boolean getBomb(){return this.bombe;} // retourne la valeur de la variable bombe
	public void setBomb(boolean bombe){this.bombe = bombe;} // modifie la valeur de la variable bombe
	public boolean getFlag(){return this.flag;} // retourne la valeur de la variable flag
	public void setFlag(boolean flag){this.flag = flag;} // modifie la valeur de la variable flag
	public boolean getDiscovered(){return this.discovered;} // retourne la valeur de la variable discovered
	public void setDiscovered(boolean discovered){this.discovered = discovered;} // modifie la valeur de la variable discovered
}