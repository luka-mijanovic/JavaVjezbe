/*
ZADATAK 7 (Soba, Termostat, SmartHome)
Soba: trenTemp, ciljTemp — konstruktor; get/set.
Termostat: minTemp=16, maxTemp=28, mod ("GRIJANJE" ili "HLADJENJE") — konstruktor; get/set (validacija moda).
korakPromjene(int tren, int cilj):
  - ako je GRIJANJE i tren < cilj -> vrati tren+1, inače tren
  - ako je HLADJENJE i tren > cilj -> vrati tren-1, inače tren
SmartHome: kreira Soba i Termostat; postavi cilj u [min,max]; više puta ažurira trenTemp=korakPromjene(...) i ispisuje promjene.
*/

public class Soba {
    private int trenTemp;
    private int ciljTemp;

    public Soba(int trenTemp, int ciljTemp) {
        this.trenTemp = trenTemp;
        this.ciljTemp = ciljTemp;
    }

    public int getTrenTemp() { return trenTemp; }
    public int getCiljTemp() { return ciljTemp; }

    public void setTrenTemp(int t) { this.trenTemp = t; }
    public void setCiljTemp(int c) { this.ciljTemp = c; }
}

class Termostat {
    private int minTemp = 16;
    private int maxTemp = 28;
    private String mod; // "GRIJANJE" ili "HLADJENJE"

    public Termostat(String mod) {
        setMod(mod);
    }

    public int getMinTemp() { return minTemp; }
    public int getMaxTemp() { return maxTemp; }
    public String getMod()  { return mod; }

    public void setMod(String mod) {
        if (mod == null) mod = "";
        mod = mod.trim().toUpperCase();
        if (!mod.equals("GRIJANJE") && !mod.equals("HLADJENJE")) {
            System.out.println("Nepoznat mod, postavljam GRIJANJE.");
            mod = "GRIJANJE";
        }
        this.mod = mod;
    }

    public int korakPromjene(int tren, int cilj) {
        if (mod.equals("GRIJANJE")) {
            if (tren < cilj) return tren + 1;
            return tren;
        } else { // HLADJENJE
            if (tren > cilj) return tren - 1;
            return tren;
        }
    }
}

class SmartHome {
    public static void main(String[] args) {
        Soba soba = new Soba(20, 27); // trenutna 20, cilj 27
        Termostat t = new Termostat("GRIJANJE");

        // ciljnu ograniči na [min,max]
        int cilj = soba.getCiljTemp();
        if (cilj < t.getMinTemp()) cilj = t.getMinTemp();
        if (cilj > t.getMaxTemp()) cilj = t.getMaxTemp();
        soba.setCiljTemp(cilj);

        System.out.println("Start: tren=" + soba.getTrenTemp() + ", cilj=" + soba.getCiljTemp() + ", mod=" + t.getMod());

        // nekoliko koraka promjene
        for (int i = 0; i < 15; i++) {
            int novo = t.korakPromjene(soba.getTrenTemp(), soba.getCiljTemp());
            soba.setTrenTemp(novo);
            System.out.println("Korak " + (i+1) + ": tren=" + soba.getTrenTemp());
        }
    }
}