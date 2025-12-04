
import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Game {
    private Player player;
    private List<Enemy> enemies;
    private List<String> log;

    public Game() {
        this.enemies = new ArrayList<>();
        this.log = new ArrayList<>();
    }

    public Player getPlayer() { return player; }
    public void setPlayer(Player p) { this.player = p; }

    public List<Enemy> getEnemies() { return enemies; }
    public List<String> getLog() { return log; }

    public boolean checkCollision(Player p, Enemy e) {
        return p.intersects(e);
    }

    public void decreaseHealth(Player p, Enemy e) {
        int damage = e.getEffectiveDamage();
        int oldHealth = p.getHealth();
        int newHealth = Math.max(0, oldHealth - damage);
        p.setHealth(newHealth);
        log.add(String.format("Enemy '%s' (damage=%d) je udario igrača %s: health %d -> %d",
                e.getDisplayName(), damage, p.getDisplayName(), oldHealth, newHealth));
    }

    public void addEnemy(Enemy e) {
        enemies.add(e);
        log.add("dodat neprijatelj: " + e);
    }

    public List<Enemy> findByType(String query) {
        List<Enemy> res = new ArrayList<>();
        String q = query == null ? "" : query.toLowerCase();
        for (Enemy e : enemies) {
            if (e.getType().toLowerCase().contains(q)) res.add(e);
        }
        return res;
    }

    public List<Enemy> collidingWithPlayer() {
        List<Enemy> res = new ArrayList<>();
        if (player == null) return res;
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) res.add(e);
        }
        return res;
    }

    public void resolveCollisions() {
        if (player == null) throw new IllegalStateException("player nije postavljen");
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
                log.add(String.format("obrada sudara sa neprijateljem: %s", e));
            } else {
                log.add(String.format("nema sudara sa: %s", e));
            }
        }
        if (!player.isAlive()) {
            log.add("igrac je izgubio.");
        } else {
            log.add("igrac je prezivio: health=" + player.getHealth());
        }
    }

    public static List<Enemy> loadEnemiesFromCSV(String filePath) {
        List<Enemy> ret = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            int lineNo = 0;
            while ((line = br.readLine()) != null) {
                lineNo++;
                line = line.trim();
                if (line.isEmpty()) continue;
                if (lineNo == 1 && line.toLowerCase().contains("type") && line.toLowerCase().contains("class")) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length < 9) {
                    throw new IllegalArgumentException("neispravan zapis na liniji " + lineNo + ": premalo polja.");
                }
                String type = parts[0].trim();
                String cls = parts[1].trim().toLowerCase();
                int x = Integer.parseInt(parts[2].trim());
                int y = Integer.parseInt(parts[3].trim());
                String colliderType = parts[4].trim().toLowerCase();
                int colP1 = Integer.parseInt(parts[5].trim());
                int colP2 = Integer.parseInt(parts[6].trim());
                int damage = Integer.parseInt(parts[7].trim());
                int health = Integer.parseInt(parts[8].trim());

                Collidable collider;
                if ("rect".equals(colliderType)) {
                    int width = colP1;
                    int height = colP2;
                    collider = new RectangleCollider(x, y, width, height);
                } else if ("circle".equals(colliderType)) {
                    int radius = colP1;
                    collider = new CircleCollider(x, y, radius);
                } else {
                    throw new IllegalArgumentException("nepoznat collider " + lineNo);
                }

                Enemy e;
                if ("melee".equals(cls)) {
                    e = new MeleeEnemy(type, damage, health, x, y, collider);
                } else if ("boss".equals(cls)) {
                    e = new BossEnemy(type, damage, health, x, y, collider);
                } else {
                    throw new IllegalArgumentException("nepoznata klasa neprijatelja " + lineNo);
                }

                ret.add(e);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("greska pri čitanju fajla: " + ioe.getMessage(), ioe);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("neispravan broj u cvs fajlu: " + nfe.getMessage(), nfe);
        }
        return ret;
    }
}
