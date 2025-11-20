
public class CircleCollider implements Collidable {
    private int centarX;
    private int centarY;
    private int poluprecnik;
    
    public CircleCollider(int centarX, int centarY, int poluprecnik) {
        if (poluprecnik <= 0) {
            throw new IllegalArgumentException("Poluprecnik mora biti veći od nule.");
        }
        this.centarX = centarX;
        this.centarY = centarY;
        this.poluprecnik = poluprecnik;
    }

	public int getCentarX() {
		return centarX;
	}

	public void setCentarX(int centarX) {
		this.centarX = centarX;
	}

	public int getCentarY() {
		return centarY;
	}

	public void setCentarY(int centarY) {
		this.centarY = centarY;
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

    @Override
    public boolean intersects(Collidable other) {
        if (other instanceof CircleCollider) {
            CircleCollider c = (CircleCollider) other;
            int dx = this.centarX - c.centarX;
            int dy = this.centarY - c.centarY;
            int distanca2 = dx * dx + dy * dy;
            int rSuma = this.poluprecnik + c.poluprecnik;
            return distanca2 <= rSuma * rSuma;
        } else if (other instanceof RectangleCollider) {
            RectangleCollider r = (RectangleCollider) other;

            int najbliziX = clamp(centarX, r.getX(), r.getX() + r.getWidth());
            int najbliziY = clamp(centarY, r.getY(), r.getY() + r.getHeight());

            int dx = centarX - najbliziX;
            int dy = centarY - najbliziY;

            return dx * dx + dy * dy <= poluprecnik * poluprecnik;
        } else {
            throw new IllegalArgumentException("Nepoznat tip kolajdera.");
    		}
    	}

        private int clamp(int vrijednost, int min, int max) {
            if (vrijednost < min) return min;
            if (vrijednost > max) return max;
            return vrijednost;
        }
    }
