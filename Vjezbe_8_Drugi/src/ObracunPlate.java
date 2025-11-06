/*
Jedan obračun plate:
- mjesec/godina
- zaposleni (referenca)
- iznos u eurima
- napomene (npr. "prekovr: 12.00h, bonus: 50.00€")
*/
public class ObracunPlate {
    int mjesec;
    int godina;
    Zaposleni zaposleni;
    double iznosEur;
    String napomene;

    public ObracunPlate(int mjesec, int godina, Zaposleni z, double iznosEur, String napomene){
        this.mjesec = mjesec;
        this.godina = godina;
        this.zaposleni = z;
        this.iznosEur = iznosEur;
        this.napomene = napomene;
    }

    public String toString(){
        String mm = (mjesec<10? "0"+mjesec : String.valueOf(mjesec));
        return "[" + godina + "-" + mm + "] " + zaposleni.getID() + " " + zaposleni.getIme() + " " + zaposleni.getPrezime()
                + " -> " + String.format("%.2f", iznosEur) + "€ (" + napomene + ")";
    }
}