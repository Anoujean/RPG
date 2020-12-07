package entity;

public abstract class Destructible {
	
	protected double life = 100;
	
	public Destructible () {}
	
	public void hitMe (double damage) {
		this.life -= damage;
	}
	
	public boolean isDead() {
		boolean dead = false;
		if (this.life < 1) {
			dead = true;
		}
		return dead;
	}
	
	public abstract String ascii_art();
	
	

}
