
public class Player extends GameObject {
    private String name;
    private int health;

    public Player(String name, int health, int x, int y, Collidable collider) {
        super(x, y, collider);
        setName(name);
        setHealth(health);
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException("ime ne moze biti null");
        String trimmed = name.trim();
        if (trimmed.isEmpty()) throw new IllegalArgumentException("ime ne moze biti prazno");
        this.name = Character.toUpperCase(trimmed.charAt(0)) + trimmed.substring(1);
    }

    public int getHealth() { return health; }

    public void setHealth(int health) {
        if (health < 0 || health > 100) throw new IllegalArgumentException("health mora biti izmedju 0 i 100.");
        this.health = health;
    }

    @Override
    public String getDisplayName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Player[name=%s, health=%d, pos=(%d,%d), collider=%s]",
                name, health, getX(), getY(), getCollider());
    }

    public boolean isAlive() {
        return health > 0;
    }
}
