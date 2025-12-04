
public abstract class GameObject {
    private int x;
    private int y;
    private Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        if (collider == null) throw new IllegalArgumentException("collider ne smije biti null");
        this.x = x;
        this.y = y;
        this.collider = collider;
        syncColliderPosition();
    }

    protected void syncColliderPosition() {
        if (collider instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) collider;
            r.setPosition(x, y);
        } else if (collider instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) collider;
            c.setCentar(x, y);
        }
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
        syncColliderPosition();
    }

    public Collidable getCollider() { return collider; }

    public void setCollider(Collidable collider) {
        if (collider == null) throw new IllegalArgumentException("collider ne smije biti null");
        this.collider = collider;
        syncColliderPosition();
    }

    public boolean intersects(GameObject other) {
        if (other == null) return false;
        return this.collider.intersects(other.getCollider());
    }

    public abstract String getDisplayName();

    @Override
    public String toString() {
        return String.format("%s @ (%d,%d) - %s", getDisplayName(), x, y, collider);
    }
}
