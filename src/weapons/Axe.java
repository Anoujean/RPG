package weapons;

public class Axe extends Weapon{
	
	private static final double DAMAGE = 10;
	private static final double PRICE = 100;
	
	public Axe() {
		super (DAMAGE, PRICE);
	}
	
	public String ascii_art() {
		return
		" /’-./\\_    \n" +
		":    ||,>    \n" +
		" \\.-’||     \n" + 
		"     ||      \n" +
		"     ||      \n" +
		"     ||      \n";
	}

}
