/*
ZADATAK 5 (Transakcija + App)
Transakcija: iznos (double), tip (String: "uplata" ili "isplata"), opis (String)
a) Konstruktor + geteri/seteri (iznos >= 0)
b) jeUplata(): vraća true ako je tip "uplata"
Glavna klasa App: kreira BankovniRacun i dvije Transakcija (uplata i isplata).
Na osnovu jeUplata() poziva racun.uplati(...) ili racun.isplati(...).
*/

public class Transakcija {
    private double iznos;
    private String tip;   // "uplata" ili "isplata"
    private String opis;

    public Transakcija(double iznos, String tip, String opis) {
        setIznos(iznos);
        setTip(tip);
        setOpis(opis);
    }

    public double getIznos() { return iznos; }
    public String getTip()   { return tip; }
    public String getOpis()  { return opis; }

    public void setIznos(double iznos) {
        if (iznos < 0) {
            System.out.println("Iznos ne može biti negativan — postavljam na 0.");
            this.iznos = 0;
            return;
        }
        this.iznos = iznos;
    }

    public void setTip(String tip) {
        if (tip == null) tip = "";
        tip = tip.trim().toLowerCase();
        // dozvoljene vrijednosti: "uplata" ili "isplata"
        if (!tip.equals("uplata") && !tip.equals("isplata")) {
            System.out.println("Nepoznat tip transakcije: " + tip + " — postavljam 'uplata'.");
            tip = "uplata";
        }
        this.tip = tip;
    }

    public void setOpis(String opis) {
        if (opis == null) opis = "";
        this.opis = opis.trim();
    }

    public boolean jeUplata() {
        return tip.equals("uplata");
    }
}

