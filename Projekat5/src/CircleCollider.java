
public class CircleCollider implements Collidable {
    private int centarX, centarY;
    private int poluprecnik;

    public CircleCollider(int centarX, int centarY, int poluprecnik) {
        if (poluprecnik <= 0) {
            throw new IllegalArgumentException("poluprecnik mora biti veci od nule");
        }
        this.centarX = centarX;
        this.centarY = centarY;
        this.poluprecnik = poluprecnik;
    }

    public int getCentarX() { return centarX; }
    public int getCentarY() { return centarY; }
    public int getPoluprecnik() { return poluprecnik; }

    public void setCentar(int x, int y) {
        this.centarX = x;
        this.centarY = y;
    }

    @Override
    public boolean intersects(Collidable other) {
        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            long dx = this.centarX - c.centarX;
            long dy = this.centarY - c.centarY;
            long dist = dx*dx + dy*dy;
            long poluSum = (long) this.poluprecnik + c.poluprecnik;
            return dist <= poluSum * poluSum;
        } else if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;

            int closestX = clamp(this.centarX, r.getX(), r.getX() + r.getWidth());
            int closestY = clamp(this.centarY, r.getY(), r.getY() + r.getHeight());
            long dx = this.centarX - closestX;
            long dy = this.centarY - closestY;
            long distSq = dx*dx + dy*dy;
            return distSq <= (long)this.poluprecnik * this.poluprecnik;
        } else {
            return false;
        }
    }

    private int clamp(int val, int min, int max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }

    @Override
    public String toString() {
        return String.format("Circle[cx=%d,cy=%d,r=%d]", centarX, centarY, poluprecnik);
    }
}
