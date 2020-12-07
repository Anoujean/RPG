package entity;

public class Monster extends Destructible{
	
	protected double damage;
	
	public Monster() {
		super();
		this.damage = Math.random()*100;
	}
	
	public String ascii_art() {
		return
		"M";
	}
	
	public double dealDamage() {
		return this.damage;
	}

}
