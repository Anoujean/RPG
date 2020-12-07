package weapons;

public abstract class Weapon {

	protected double damage;
	protected double price;

	public Weapon(double damage, double price) {
		this.damage = damage;
		this.price = price;
	}
	
	public double dealDamage() {
		return this.damage;
	}
	
	public String toString() {
		return "Damage: "+this.damage+" | Price:"+this.price;
	}
	
	public double getPrice() {
		return this.price;
	}

	public abstract String ascii_art();
}
