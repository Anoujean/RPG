package weapons;

public class Bow extends Weapon{
	
	private static final double DAMAGE = 7;
	private static final double PRICE = 100;

	public Bow() {
		super(DAMAGE, PRICE);
	}
					   
   public String ascii_art() {
		return
		"  (        " + '\n'+
		"   L      " + '\n'+
		"   |      " + '\n'+
		"o-------->  " + '\n'+
		"   |     " + '\n'+
		"   7       " + '\n'+
		"  (        ";
	}
	
}
