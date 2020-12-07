package entity;

public class Rogue extends Cast{
	
	public Rogue () {
		super();
	}
	
	public double generateMoney() {
		return Math.random() * 100;
	}

}
