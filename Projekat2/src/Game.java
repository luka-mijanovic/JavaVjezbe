//Luka Mijanovic 24/074
//Ana Kovacevic 24/075

import java.util.ArrayList;

class Player {
	private String ime;
	private int x;
	private int y;
	private int width;
	private int height;
	private int health;
	
//konstruktor
	public Player(String ime, int x, int y, int width, int height, int health) {
		this.ime = ime;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.health = health;
		}
	@Override
	public String toString() {
		return String.format("Player[ime=%s], @ (%d,%d), %dx%d, HP=%d", ime, x, y, width, height, health);
	}
	
	public String getIme() { return ime; }
	public void setIme(String ime) {
		String ime1 = ime.trim();
		
		if (ime1.length()>0) {
			this.ime = ime1;
		}else 
			System.out.println("Igrac mora imati ime.");
		}
	
	
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	
	public int getY() {	return y; }
	public void setY(int y) { this.y = y; }
	
	public int getWidth() {	return width; }
	public void setWidth(int width) { this.width = width; }
	
	public int getHeight() { return height; }
	public void setHeight(int height) {	this.height = height; }
	
	public int getHealth() { return health; }
	public void setHealth(int health) { 
		if (health >= 0 && health <= 100) {
			this.health = health; 
		}else {
			System.out.println("health mora biti izmedju 0 i 100.");
		}
	
	}
	
	
class Enemy {
	private String type;
	private int x;
	private int y;
	private int width;
	private int height;
	private int damage;

	//konstruktor
	public Enemy(String type, int x, int y, int width, int height, int damage) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.damage = damage;
	}
	@Override
	public String toString() {
		return String.format("Enemy[type=%s], @ (%d,%d), %dx%d, DMG=%d", type, x, y, width, height, damage);
	}
	
	public String getType() { return type; }
	public void setType(String type) {
		String type1 = type.trim();
		
		if (type1.length()>0) {
			this.type = type1;
		}else 
			System.out.println("Enemy mora imati neki tip.");
		}
	
	public int getX() { return x; }
	public void setX(int x) { this.x = x; }
	
	public int getY() {	return y; }
	public void setY(int y) { this.y = y; }
	
	public int getWidth() {	return width; }
	public void setWidth(int width) { this.width = width; }
	
	public int getHeight() { return height; }
	public void setHeight(int height) {	this.height = height; }
	
	public int getDamage() { return damage; }
	public void setDamage(int damage) { 
		if (damage >= 0 && damage <= 100) {
			this.damage = damage; 
		}else {
			System.out.println("damage mora biti izmedju 0 i 100.");
		}
	}
public class Game {
	public Player player; //objekat tipa Player
	public ArrayList<Enemy> enemies; //lista neprijatelja
	public ArrayList<String> eventLog; //lista dogadjaja

	//konstruktor
	public Game() {
		this.player = null;
		this.enemies = new ArrayList<Enemy>();
		this.eventLog = new ArrayList<String>();
	}

	//provjera sudara
	public static boolean checkCollision (Player p, Enemy e) {
		return (p.getX()<e.getX() + e.getWidth() && p.getX() + p.getWidth()>e.getX() && p.getY()<e.getY()+ e.getHeight() && p.getY() + p.getHeight() > e.getY());
	}
		
	//smanji health ako ima sudara
	public static void decreaseHealth(Player p, Enemy e) {
		if (checkCollision(p,e)) {
			int novoHealth = p.getHealth() - e.getDamage();
				if (novoHealth<0) novoHealth = 0;
					p.setHealth(novoHealth);
			System.out.println("Kolizija ! Health smanjen na: " + p.getHealth());
		}
	}
}
}
}
	



