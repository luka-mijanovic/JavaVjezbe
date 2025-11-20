
public class Player extends GameObject  {
    private String name;
    private int health;
    
    public Player(String name, int health, int x, int y, Collidable collider) {
		super(x, y, collider);
		this.name = name;
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		 if (name == null) {
	            throw new IllegalArgumentException("Ime ne smije biti null.");
		 }
		 String s = name.trim();
		 
	     String[] parts = s.toLowerCase().split(" ");
	     StringBuilder ime = new StringBuilder();
	     	for (int i = 0; i < parts.length; i++) {
	     		if (parts[i].isEmpty()) continue;
	     		ime.append(Character.toUpperCase(parts[i].charAt(0)));
	            if (parts[i].length() > 1) {
	            	ime.append(parts[i].substring(1));
	            }
	            if (i < parts.length - 1) ime.append(" ");
	     	}
	     	this.name = ime.toString();
	}

	public int getHealth() {
		return health;
	}

    public void setHealth(int health) {
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health mora biti u opsegu 0-100.");
        }
        this.health = health;
    }
    @Override
    public String toString() {
    	return "Player[" + name + "] @(" + getX() + "," + getY() + ") " + getDimenzije() + " HP=" + health;
    }

    @Override
    public String getDisplayName() {
        return name;
    }
    

}
