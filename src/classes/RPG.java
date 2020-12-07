package classes;

import java.util.Scanner;

import entity.*;
import weapons.*;

public class RPG {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		WeaponStore ws = new WeaponStore();
		Destructible character = chooseCast(scanner);
		Weapon weapon = displayWeaponStore(scanner, ws);
		Player player = new Player(character, weapon);
		Map map = new Map(player.character);
		
		menu(scanner, map, player, ws);
		
		
		System.out.println(map.displayMap());
		

	}
	
	public static void menu(Scanner scanner, Map map, Player player, WeaponStore ws) {
		while (!map.win && !player.character.isDead()) {
			System.out.println(map.displayMap());
			System.out.println("Que voulez-vous faire: \n 1/ Déplacer \n 2/ Accéder à l'inventaire \n 3/ Acheter une arme \n 4/ Quitter");
			int choix = scanner.nextInt();
			switch (choix) {
				case 1: {
					moveHero(scanner, map, player);
					break;
				}
				case 2: {
					player.weapon = displayInventory(scanner, player);
					break;
				}
				case 3: {
					player.addWeapon(displayWeaponStore(scanner, ws));
					break;
				}
				case 4: {
					System.exit(0);
					break;
				}
				default: {
					break;
				}
			}
		}
		if (map.win) {
			System.out.println("YOU WIN");
		}
		if(player.character.isDead()) {
			System.out.println("YOU LOOSE");
		}
		
	}
	
	public static void moveHero(Scanner scanner, Map map, Player player) {
		System.out.println("Comment voulez-vous déplacer votre personnage: \n 1/ Haut \n 2/ Bas \n 3/ Droite \n 4/ Gauche");
		int choix = scanner.nextInt();
		map.moveHero(choix, player.weapon);
	}
	
	public static Destructible chooseCast(Scanner scanner) {
		System.out.println("Quel sera le type de votre personnage: \n 1/ Barbarian \n 2/ Rogue \n 3/ Sorcerer");
		int choix = scanner.nextInt();
		Destructible hero;
		switch (choix) {
			case 1: {
				hero = new Barbarian();
				break;
			}
			case 2: {
				hero = new Rogue();
				break;
			}
			case 3: {
				hero = new Sorcerer();
				break;
			}
			default: {
				hero = new Barbarian();
				break;
			}
		}
		return hero;
	}
	
	public static Weapon displayWeaponStore(Scanner scanner, WeaponStore ws) {
		System.out.println("Voici le marchand d'arme:");
		System.out.println(ws.displayWeaponStore());
		int choix = scanner.nextInt();
		Weapon weapon;
		switch (choix) {
			case 1: {
				weapon = new Axe();
				break;
			}
			case 2: {
				weapon = new Bow();
				break;
			}
			case 3: {
				weapon = new Hammer();
				break;
			}
			default: {
				weapon = new Hammer();
				break;
			}
		}
		return weapon;
		
	}
	
	public static Weapon displayInventory(Scanner scanner, Player player) {
		System.out.println("Voici votre inventaire:");
		System.out.println(player.displayInventory());
		int choix = scanner.nextInt();
		Weapon weapon = player.weapon;
		if (choix < player.inventory.size()) {
			weapon = player.inventory.get(choix);
			System.out.println("Arme changé");
		}
		return weapon;
	}
	
	public static void fight() {}

}