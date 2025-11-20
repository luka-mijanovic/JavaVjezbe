
public class RectangleCollider implements Collidable {
    private int x;
    private int y;
    private int width;
    private int height;
    
    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Dimenzije pravougaonika moraju biti veće od nule.");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
    @Override
    public boolean intersects(Collidable other) {
        if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;

            return this.x < r.x + r.width &&
                   this.x + this.width > r.x &&
                   this.y < r.y + r.height &&
                   this.y + this.height > r.y;
        } else if (other instanceof CircleCollider) {

            return other.intersects(this);
        } else {
            throw new IllegalArgumentException("Nepoznat tip.");
        }
    }

}