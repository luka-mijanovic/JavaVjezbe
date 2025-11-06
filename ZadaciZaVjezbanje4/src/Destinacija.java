/*
ZADATAK 7 (Destinacije)
Kreirati klasu Destinacija sa atributima: naziv, drzava, ocjena (0–10), udaljenostKm, brojPosjeta.
Metode:
a) izdvoj >8 i <1000km,
b) nađi destinaciju sa najvećim brojem posjeta,
c) sortiraj listu po ocjeni opadajuće.
*/
public class Destinacija {
    private String naziv, drzava;
    private int ocjena, udaljenostKm, brojPosjeta;

    public Destinacija(String naziv, String drzava, int ocjena, int udaljenostKm, int brojPosjeta) {
        this.naziv = naziv;
        this.drzava = drzava;
        this.ocjena = (ocjena < 0) ? 0 : (ocjena > 10 ? 10 : ocjena);
        this.udaljenostKm = udaljenostKm;
        this.brojPosjeta = brojPosjeta;
    }

    public String getNaziv(){ return naziv; }
    public String getDrzava(){ return drzava; }
    public int getOcjena(){ return ocjena; }
    public int getUdaljenostKm(){ return udaljenostKm; }
    public int getBrojPosjeta(){ return brojPosjeta; }

    public void setOcjena(int o){ this.ocjena = (o < 0) ? 0 : (o > 10 ? 10 : o); }

    public String toString(){
        return naziv + " (" + drzava + "), ocjena=" + ocjena +
               ", dist=" + udaljenostKm + "km, posjeta=" + brojPosjeta;
    }
}