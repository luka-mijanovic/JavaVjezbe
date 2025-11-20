import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private List<Enemy> enemies;
    private List<String> eventLog;
    
    public Game(Player player) {
        if (player == null) {
            throw new IllegalArgumentException("Player ne smije biti null.");
        }
        this.player = player;
        this.enemies = new ArrayList<>();
        this.eventLog = new ArrayList<>();
    }

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(List<Enemy> enemies) {
		this.enemies = enemies;
	}

	public List<String> getEventLog() {
		return eventLog;
	}

	public void setEventLog(List<String> eventLog) {
		this.eventLog = eventLog;
	}
    
    public boolean checkCollision(Player p, Enemy e) {
        if (p == null || e == null) {
            throw new IllegalArgumentException("Player ili Enemy su null.");
        }
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        if (p == null || e == null) {
            throw new IllegalArgumentException("Player ili Enemy su null.");
        }
        int damage = e.getEffectiveDamage();
        int oldHp = p.getHealth();
        int newHp = oldHp - damage;
        if (newHp < 0) newHp = 0;
        p.setHealth(newHp);
        
        String log = "HIT: " + p.getName() + " by " + e.getType() + " for " + damage + " -> HP " + oldHp + " -> " + newHp;
        eventLog.add(log);
    }
    
    public void addEnemy(Enemy e) {
        if (e == null) {
            throw new IllegalArgumentException("Enemy ne moze biti null.");
        }
        enemies.add(e);
        eventLog.add("Dodaj: " + e.toString());
    }
    
    //da se nadje preko type 
    //....
    
    public List<Enemy> collidingWithPlayer() {
        List<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                result.add(e);
            }
        }
        return result;
    }
    
    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }
    
    public static Enemy parseEnemy(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Linija ne smije biti null.");
        }
        try {
            String[] djelovi = line.split(";");
            if (djelovi.length < 4 || djelovi.length > 5) {
            throw new IllegalArgumentException("Neispravan format stringa za neprijatelja: " + line);
        }
        String type = djelovi[0];
    
        String[] poz = djelovi[1].split(",");
        if (poz.length != 2) {
            throw new IllegalArgumentException("Neispravna pozicija u stringu: " + djelovi[1]);
        }
        int x = Integer.parseInt(poz[0]);
        int y = Integer.parseInt(poz[1]);
               
        String[] dimenzije = djelovi[2].split("x");
        if (dimenzije.length != 2) {
            throw new IllegalArgumentException("Neispravne dimenzije u stringu: " + djelovi[2]);
        }
        int w = Integer.parseInt(dimenzije[0]);
        int h = Integer.parseInt(dimenzije[1]);
        
        int damage = Integer.parseInt(djelovi[3]);
        boolean isBoss = djelovi.length == 5 && djelovi[4].equalsIgnoreCase("boss");

        Collidable collider = new RectangleCollider(x, y, w, h);

        if (isBoss) {
            return new BossEnemy(type, x, y, collider, damage, 100);
        } else {
            return new MeleeEnemy(type, x, y, collider, damage, 100);
        }
        }
    }
}
