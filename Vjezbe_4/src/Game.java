class Player {
	private int x;
	private int y;
	private int width;
	private int height;
	private int health;
	
	//konstruktor
	public Player(int x, int y, int width, int height, int health) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.health = health;
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
		private int x;
		private int y;
		private int width;
		private int height;
		private int damage;
		
		//konstruktor
		public Enemy(int x, int y, int width, int height, int damage) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.damage = damage;
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
}

}
public class Game {
	
}
