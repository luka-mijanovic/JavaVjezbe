/*
ZADATAK 4 (BankovniRacun)
Atributi: imeVlasnika, stanje (double).
a) Konstruktor + geteri/seteri.
b) uplati(double): povećava stanje.
c) isplati(double): smanjuje samo ako ima dovoljno sredstava.
d) ispisi(): trenutno stanje računa.
*/

public class BankovniRacun {
    private String imeVlasnika;
    private double stanje;

    public BankovniRacun(String imeVlasnika, double pocetno) {
        this.imeVlasnika = imeVlasnika;
        this.stanje = pocetno;
    }

    public String getImeVlasnika() { return imeVlasnika; }
    public double getStanje()      { return stanje; }

    public void setImeVlasnika(String ime) { this.imeVlasnika = ime; }
    public void setStanje(double novo) { this.stanje = novo; }

    public void uplati(double iznos) {
        if (iznos < 0) {
            System.out.println("Neispravan iznos uplate.");
            return;
        }
        stanje += iznos;
    }

    public void isplati(double iznos) {
        if (iznos < 0) {
            System.out.println("Neispravan iznos isplate.");
            return;
        }
        if (stanje >= iznos) {
            stanje -= iznos;
        } else {
            System.out.println("Nema dovoljno sredstava za isplatu " + iznos);
        }
    }

    public void ispisi() {
        System.out.println("Vlasnik: " + imeVlasnika + ", stanje: " + stanje);
    }
}