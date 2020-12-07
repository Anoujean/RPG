package weapons;

public class Hammer extends Weapon{
	
	private static final double DAMAGE = 20;
	private static final double PRICE = 100;
	
	public Hammer() {
		super (DAMAGE, PRICE);
	}
	
	public String ascii_art() {
		return
		" __ __  \n" + 
		"|__|__| \n" + 
		"   |    \n" + 
		"   |    \n";
	}

}
