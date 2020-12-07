package classes;
import java.util.*;
import entity.*;
import weapons.*;

public class Player {
	
	protected Destructible character;
	protected Weapon weapon;
	protected List<Weapon> inventory;
	protected int xp;
	protected double money;
	
	public Player(Destructible character, Weapon weapon) {
		super();
		this.character = character;
		this.weapon = weapon;
		this.inventory = new ArrayList<Weapon>();
		this.inventory.add(weapon);
		this.xp = 0;
		this.money = 100;
	}
	
	public String displayInventory() {
		String result = "Votre expérience: "+this.xp+"\t & votre argent: "+this.money;
		for (int i = 0; i < this.inventory.size(); i++) {
			int indice = i+1;
			result += "\n"+indice+"/ \n"+this.inventory.get(i).ascii_art()+"\n "+this.inventory.get(i).toString()+"\n";
		}
		return result;
	}
	
	public void addWeapon(Weapon w) {
		if (this.money > w.getPrice()) {
			this.inventory.add(w);
			this.weapon = w;
			this.money -= w.getPrice();
		}
		else {
			System.out.println("Vous ne posséder pas assez de ressource pour obtenir cette arme");
		}
		
	}
	
	public void spendMoney(double money) {
		this.money -= money;
	}
	
	public void gainXp(int xp) {
		this.xp += xp;
	}
	
	

}
