/*
ZADATAK 8 (Vektor2D, Projektil, Simulator)
Vektor2D: x(double), y(double) — konstruktor; get/set; pomjeri(dx,dy); postavi(nx,ny).
Projektil: pozX, pozY, velX, velY — konstruktor; get/set; update(dt): poz += vel*dt;
odbijAkoVanOkvira(xMin,xMax,yMin,yMax): ako izađe, "zalijepi" na granicu i invertuj odgovarajuću komponentu brzine.
Simulator: kreira Projektil i jedan Vektor2D (pomoćna tačka okvira npr. za ispis/reset); više puta poziva update(dt), zatim odbijAkoVanOkvira(...), i ispisuje poziciju.
*/

public class Vektor2D {
    private double x, y;

    public Vektor2D(double x, double y) { this.x = x; this.y = y; }

    public double getX() { return x; }
    public double getY() { return y; }

    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public void pomjeri(double dx, double dy) {
        x += dx; y += dy;
    }

    public void postavi(double nx, double ny) {
        x = nx; y = ny;
    }
}

class Projektil {
    private double pozX, pozY;
    private double velX, velY;

    public Projektil(double pozX, double pozY, double velX, double velY) {
        this.pozX = pozX; this.pozY = pozY;
        this.velX = velX; this.velY = velY;
    }

    public double getPozX() { return pozX; }
    public double getPozY() { return pozY; }
    public double getVelX() { return velX; }
    public double getVelY() { return velY; }

    public void setPozX(double x) { this.pozX = x; }
    public void setPozY(double y) { this.pozY = y; }
    public void setVelX(double vx) { this.velX = vx; }
    public void setVelY(double vy) { this.velY = vy; }

    // ažuriranje pozicije: poz += vel * dt
    public void update(double dt) {
        pozX += velX * dt;
        pozY += velY * dt;
    }

    // ako izađe iz [xMin,xMax] ili [yMin,yMax], "zalijepi" i invertuj brzinu te ose
    public void odbijAkoVanOkvira(int xMin, int xMax, int yMin, int yMax) {
        if (pozX < xMin) { pozX = xMin; velX = -velX; }
        if (pozX > xMax) { pozX = xMax; velX = -velX; }
        if (pozY < yMin) { pozY = yMin; velY = -velY; }
        if (pozY > yMax) { pozY = yMax; velY = -velY; }
    }
}

class Simulator {
    public static void main(String[] args) {
        // okvir od (0,0) do (100,50); pomoćna tačka za ispis
        Vektor2D okvirInfo = new Vektor2D(100, 50);

        // projektil: početna pozicija (10,10), brzina (15, 8)
        Projektil p = new Projektil(10, 10, 15, 8);

        double dt = 0.5; // vremenski korak
        for (int i = 0; i < 20; i++) {
            p.update(dt);
            p.odbijAkoVanOkvira(0, (int)okvirInfo.getX(), 0, (int)okvirInfo.getY());
            System.out.println("t=" + ((i+1)*dt) + "s -> poz=(" + p.getPozX() + "," + p.getPozY() + ")"
                    + " vel=(" + p.getVelX() + "," + p.getVelY() + ")");
        }
    }
}