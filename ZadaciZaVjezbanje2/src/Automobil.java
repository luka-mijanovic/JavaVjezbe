
 /*
ZADATAK 3 (Automobil)
Klasa sa atributima: marka, model, godiste, brzina (int).
a) Konstruktor + geteri/seteri.
b) ubrzaj(int): povećava brzinu, ali max 200.
c) uspori(int): smanjuje brzinu, ali min 0.
d) ispisi(): prikaz podataka o automobilu.
*/

public class Automobil {
    private String marka, model;
    private int godiste;
    private int brzina;

    public Automobil(String marka, String model, int godiste) {
        this.marka = marka;
        this.model = model;
        this.godiste = godiste;
        this.brzina = 0; // startna brzina
    }

    public String getMarka()   { return marka; }
    public String getModel()   { return model; }
    public int getGodiste()    { return godiste; }
    public int getBrzina()     { return brzina; }

    public void setMarka(String m) { this.marka = m; }
    public void setModel(String m) { this.model = m; }
    public void setGodiste(int g)  { this.godiste = g; }

    public void ubrzaj(int vrijednost) {
        // povećava brzinu ali najviše do 200
        int nova = brzina + vrijednost;
        if (nova > 200) nova = 200;
        brzina = (nova < 0) ? 0 : nova;
    }

    public void uspori(int vrijednost) {
        // smanjuje brzinu ali ne ispod 0
        int nova = brzina - vrijednost;
        if (nova < 0) nova = 0;
        if (nova > 200) nova = 200;
        brzina = nova;
    }

    public void ispisi() {
        System.out.println(marka + " " + model + " (" + godiste + "), brzina: " + brzina);
    }
}

class AutomobilTest {
    public static void main(String[] args) {
        Automobil a = new Automobil("Opel", "Astra", 2015);
        a.ispisi();
        a.ubrzaj(50);
        a.ispisi();
        a.ubrzaj(200);
        a.ispisi();
        a.uspori(70);
        a.ispisi();
    }
}