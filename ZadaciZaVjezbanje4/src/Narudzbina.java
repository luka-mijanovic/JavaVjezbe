import java.util.ArrayList;

/*
ZADATAK 11 (Lager i narudžbine) — dio: Narudzbina
*/

public class Narudzbina {
    int id;
    int prioritet;
    ArrayList<Stavka> stavke = new ArrayList<Stavka>();

    public Narudzbina(int id, int prioritet) {
        this.id = id;
        this.prioritet = prioritet;
    }

    public String toString() {
        return "N#" + id + "[p=" + prioritet + "] " + stavke;
    }
}