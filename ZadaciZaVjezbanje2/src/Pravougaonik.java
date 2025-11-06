/*
ZADATAK 6 (Pravougaonik, Tacka, GeometryApp)
Pravougaonik: x, y, width, height — konstruktor; get/set; sadrzi(tx,ty) -> true ako je (tx,ty) unutra (ivice uključene); ispisi().
Tacka: x, y — konstruktor; get/set; ispisi().
Glavna klasa GeometryApp: kreira Pravougaonik i Tacka; poziva sadrzi(tacka.getX(), tacka.getY()) i ispisuje rezultat.
Dodatno: provjeriti PREKLAPANJE DVA PRAVOUGAONIKA koristeći samo njihove koordinate (u ovoj klasi).
*/

public class Pravougaonik {
    private int x, y, width, height;

    public Pravougaonik(int x, int y, int width, int height) {
        this.x = x; this.y = y; this.width = width; this.height = height;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth()  { return width; }
    public int getHeight() { return height; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int w)  { this.width = w; }
    public void setHeight(int h) { this.height = h; }

    // ivice uključene: [x, x+width], [y, y+height]
    public boolean sadrzi(int tx, int ty) {
        boolean uX = (tx >= x) && (tx <= x + width);
        boolean uY = (ty >= y) && (ty <= y + height);
        return uX && uY;
    }

    public void ispisi() {
        System.out.println("Pravougaonik @ (" + x + "," + y + ") " + width + "x" + height);
    }
}

class Tacka {
    private int x, y;

    public Tacka(int x, int y) { this.x = x; this.y = y; }

    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public void ispisi() {
        System.out.println("Tacka (" + x + "," + y + ")");
    }
}

class GeometryApp {
    // provjera preklapanja samo preko koordinata u ovoj klasi
    public static boolean preklapanje(int x1, int y1, int w1, int h1,
                                      int x2, int y2, int w2, int h2) {
        int r1 = x1 + w1, b1 = y1 + h1;
        int r2 = x2 + w2, b2 = y2 + h2;

        boolean hor = x1 <= r2 && r1 >= x2; // ivice uključene
        boolean ver = y1 <= b2 && b1 >= y2;
        return hor && ver;
    }

    public static void main(String[] args) {
        Pravougaonik p = new Pravougaonik(10, 10, 20, 15);
        Tacka t = new Tacka(25, 20);

        p.ispisi();
        t.ispisi();

        boolean unutra = p.sadrzi(t.getX(), t.getY());
        System.out.println("Tačka je unutar pravougaonika? " + (unutra ? "DA" : "NE"));

        // provjera preklapanja dva pravougaonika (samo preko koordinata)
        Pravougaonik q = new Pravougaonik(25, 18, 10, 10);
        boolean overl = preklapanje(p.getX(), p.getY(), p.getWidth(), p.getHeight(),
                                    q.getX(), q.getY(), q.getWidth(), q.getHeight());
        System.out.println("P i Q se preklapaju? " + (overl ? "DA" : "NE"));
    }
}