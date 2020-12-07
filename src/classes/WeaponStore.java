package classes;

import java.util.*;

import weapons.*;

public class WeaponStore {
	
	protected List<Weapon> weapons;

	public WeaponStore() {
		this.weapons = new ArrayList<Weapon>();
		this.weapons.add(new Axe());
		this.weapons.add(new Bow());
		this.weapons.add(new Hammer());
	}
	
	public int price (Weapon w) {
		return 0;
	}
	
	public String displayWeaponStore() {
		String result = "";
		int indice = 0;
		for (int i = 0; i < this.weapons.size(); i++) {
			indice = i+1;
			result += "\n"+indice+"/"+this.weapons.get(i).getClass().getSimpleName()+" \n"+this.weapons.get(i).ascii_art()+"\n "+this.weapons.get(i).toString()+"\n";
		}
		indice+=1;
		result += "\n"+indice+"/ exit";
		return result;
		
	}
	
}
