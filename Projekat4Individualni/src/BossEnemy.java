
public class BossEnemy extends Enemy {

    public BossEnemy(String type, int x, int y, Collidable collider, int damage, int health) {
        super(type, x, y, collider, damage, health);
    }

    @Override
    public int getEffectiveDamage() {
        return getBaseDamage() * 2;
    }

    @Override
    public String toString() {
        return "BossEnemy[" + getDisplayName() + "] @(" + getX() + "," + getY() + ") " + getDimenzije() + " DMG=" + getBaseDamage() + "x2" + " HP=" + getHealth();
    }
}