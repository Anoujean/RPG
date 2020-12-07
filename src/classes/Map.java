package classes;

import java.util.*;

import entity.*;
import weapons.*;

public class Map {
	
	private Destructible[][] map;
	private List<Destructible> enemies;
	private Destructible hero;
	private int x = 3;
	private int y = 3;
	private int currentX; //player actual position
	private int currentY; //player actual position
	protected boolean win;
	
	
	public Map (Destructible hero) {
		this.hero = hero;
		this.enemies = new ArrayList<Destructible>();
		this.enemies.add(new Monster());
		this.enemies.add(new Stone());
		//this.x = (int)Math.random() * 10;
		//this.y = (int)Math.random() * 10;
		this.map = new Destructible[this.y][this.x];
		this.win = false;
		this.generateMap();
	}
	
	public String displayMap() {
		String result = "";
		for (int i = this.map.length-1 ; i > -1; i--) {
			for (int j = 0 ; j < this.map[i].length ; j++) {
				if (this.map[i][j] == null) {
					result += " "+"|";
				}
				else {
					result += this.map[i][j].ascii_art()+"|";
				}
			}
			result += "\n";
		}
		result = "--------------------------------\n"+result;
		result += "--------------------------------";
		return result;
	}
	
	public void moveHero(int positionNumber, Weapon weapon) {
		int tempCurrentX = this.currentX;
		int tempCurrentY = this.currentY;
		switch (positionNumber) {
			case 1: { //top
				this.currentY += 1;
				break;
			}
			case 2: { //bottom
				this.currentY -= 1;
				break;
			}
			case 3: { //right
				this.currentX += 1;
				break;
			}
			case 4: { //left
				this.currentX -= 1;
				break;
			}
			default: {
				break;
			}
		}
		try {
			if (this.map[this.currentY][this.currentX] == null) {
				this.map[this.currentY][this.currentX] = this.hero;
				this.map[tempCurrentY][tempCurrentX] = null;
			}
			/*else if (this.map[this.currentY][this.currentX].getClass().getSimpleName() == "Monster") {
				System.out.println("Combat engagé contre le monstre");
				while(!this.hero.isDead() && !this.map[this.currentY][this.currentX].isDead()) {
					this.map[this.currentY][this.currentX].hitMe(weapon.dealDamage());
					this.hero.hitMe(((Monster)this.map[this.currentY][this.currentX]).dealDamage());
				}
				if (this.map[this.currentY][this.currentX].isDead()) {
					this.map[this.currentY][this.currentX] = this.hero;
					this.map[tempCurrentY][tempCurrentX] = null;
				}
			}
			else if (this.map[this.currentY][this.currentX].getClass().getSimpleName() == "Stone") {
				System.out.println("Destruction de l'obstacle");
				while(!this.hero.isDead() && !this.map[this.currentY][this.currentX].isDead()) {
					this.map[this.currentY][this.currentX].hitMe(weapon.dealDamage());
				}
				if (this.map[this.currentY][this.currentX].isDead()) {
					this.map[this.currentY][this.currentX] = this.hero;
					this.map[tempCurrentY][tempCurrentX] = null;
				}
			}*/
			
		} catch(Exception e) {
			System.out.println("Déplacement impossible");
		}
		if(this.currentX == (this.x-1) && this.currentY == (this.y-1)) {
			this.win = true;
		}
		
	}
	
	private void generateMap() {
		for (int i = 0; i < this.enemies.size(); i++) {
			int localX = this.generateNumber(0, this.x);
			int localY = this.generateNumber(0, this.y);
			this.map[localY][localX] = this.enemies.get(i);
		}
		this.map[0][0] = this.hero;
		this.currentX = 0;
		this.currentY = 0;
	}
	
	private int generateNumber(int low, int high) {
		Random r = new Random();
		int result = r.nextInt(high - low) + low;
		return result;
	}
	

}
