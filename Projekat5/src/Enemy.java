
public abstract class Enemy extends GameObject implements Attacker {
    private String type;
    private int damage;
    private int health;

    public Enemy(String type, int damage, int health, int x, int y, Collidable collider) {
        super(x, y, collider);
        setType(type);
        setDamage(damage);
        setHealth(health);
    }

    public String getType() { return type; }

    public void setType(String type) {
        if (type == null) throw new IllegalArgumentException("type ne moze biti null");
        String trimmed = type.trim();
        if (trimmed.isEmpty()) throw new IllegalArgumentException("type ne moze biti prazan");
        this.type = trimmed;
    }

    public int getDamage() { return damage; }

    public void setDamage(int damage) {
        if (damage < 0 || damage > 100) throw new IllegalArgumentException("damage mora biti izmedju 0 i 100.");
        this.damage = damage;
    }

    public int getHealth() { return health; }

    public void setHealth(int health) {
        if (health < 0 || health > 100) throw new IllegalArgumentException("health mora biti izmedju 0 i 100.");
        this.health = health;
    }

    @Override
    public String getDisplayName() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Enemy[type=%s, damage=%d, health=%d, pos=(%d,%d), collider=%s]",
                type, damage, health, getX(), getY(), getCollider());
    }

    @Override
    public int getEffectiveDamage() {
        return damage;
    }
}
