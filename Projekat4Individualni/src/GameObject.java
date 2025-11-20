
public abstract class GameObject {
	private int x;
	private int y;
	private Collidable collider;
	
	public GameObject(int x, int y, Collidable collider) {
		this.x = x;
		this.y = y;
		this.setCollider(collider);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
    public Collidable getCollider() {
        return collider;
    }

    public void setCollider(Collidable collider) {
        if (collider == null) {
            throw new IllegalArgumentException("Collider ne smije biti null.");
        }
        this.collider = collider;
    }
    
    public boolean intersects(GameObject other) {
        if (other == null) {
            throw new IllegalArgumentException("Drugi objekat ne smije biti null.");
        }
        return this.collider.intersects(other.collider);
    }
    public abstract String getDisplayName();

    @Override
    public String toString() {
        return "GameObject[" + getDisplayName() + "] @(" + x + "," + y + ")";
    }
    protected String getDimenzije() {
        if (collider instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) collider;
            return r.getWidth() + "x" + r.getHeight();
        } else if (collider instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) collider;
            return "r=" + c.getPoluprecnik();
        }
        return "";
    }
}

