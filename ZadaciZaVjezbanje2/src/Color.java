/*
ZADATAK 1 (Color)
Kreirati klasu Color sa privatnim atributima red, green, blue (0–255).
a) Konstruktor + geteri/seteri; u seterima provjeriti opseg [0,255] (ako nije, ispisati poruku i NE mijenjati vrijednost).
b) Metode addRed(int), addGreen(int), addBlue(int) – promijene boju za zadatu količinu; ako izađe van [0,255], ispisati poruku i "zalijepiti" na 0 ili 255.
c) printColor(): ispis u formatu: "red: X, green: Y, blue: Z".
*/

class Color {
    private int red, green, blue;
// a) Konstruktor + geteri/seteri
    public Color(int red, int green, int blue) {
        // koristimo setere da primijenimo validaciju
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    public int getRed()   { return red; }
    public int getGreen() { return green; }
    public int getBlue()  { return blue; }

    public void setRed(int value) {
        if (value < 0 || value > 255) {
            System.out.println("Neispravna vrijednost za red: " + value + " (dozvoljeno 0-255) — ne mijenjam.");
            return; // bez promjene
        }
        this.red = value;
    }

    public void setGreen(int value) {
        if (value < 0 || value > 255) {
            System.out.println("Neispravna vrijednost za green: " + value + " (dozvoljeno 0-255) — ne mijenjam.");
            return;
        }
        this.green = value;
    }

    public void setBlue(int value) {
        if (value < 0 || value > 255) {
            System.out.println("Neispravna vrijednost za blue: " + value + " (dozvoljeno 0-255) — ne mijenjam.");
            return;
        }
        this.blue = value;
    }

    // metode za promjenu: ako pređe granicu, "zalijepi" i ispiši poruku
    public void addRed(int change)   { changeChannel("red",   change); }
    public void addGreen(int change) { changeChannel("green", change); }
    public void addBlue(int change)  { changeChannel("blue",  change); }
// pomoćna metoda za promjenu kanala
    private void changeChannel(String ch, int change) {
        int oldVal = (ch.equals("red") ? red : ch.equals("green") ? green : blue);
        int newVal = oldVal + change;
        if (newVal < 0) {
            System.out.println("Ispod minimalne vrijednosti (0) za " + ch + " — postavljam na 0.");
            newVal = 0;
        }
        if (newVal > 255) {
            System.out.println("Iznad maksimalne vrijednosti (255) za " + ch + " — postavljam na 255.");
            newVal = 255;
        }
        if (ch.equals("red")) red = newVal;
        else if (ch.equals("green")) green = newVal;
        else blue = newVal;
    }

    public void printColor() {
        System.out.println("red: " + red + ", green: " + green + ", blue: " + blue);
    }
}