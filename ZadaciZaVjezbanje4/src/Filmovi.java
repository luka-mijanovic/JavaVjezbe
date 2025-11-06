/*
ZADATAK 8 (Filmovi)
Kreirati klasu Film sa atributima: naziv, zanr, ocjena, trajanjeMin i
odgovarajućim geterima, seterima i konstruktorom. Napraviti konstruktor sa
onoliko parametara koliko ima atributa klasa Film, ali i konsruktor koji nema
parametar i stavlja vrijednosti atributa na smislene pocetne (default)
vrijednosti. U glavnom programu formirati ArrayList<Film> i dodati nekoliko
filmova. Kreirati metode:
a. najduziFilm(ArrayList<Film> lista) - vraća film sa najdužim trajanjem,
b. filmoviPoZanru(ArrayList<Film> lista, String zanr) - vraća listu filmova
datog žanra,
c. prosjecnaOcjena(ArrayList<Film> lista) - vraća prosječnu ocjenu svih
filmova
Klasa Film: naziv, zanr, ocjena, trajanjeMin; pun konstruktor + podrazumijevani (smislene vrijednosti).
*/
public class Filmovi {
    private String naziv, zanr;
    private double ocjena;
    private int trajanjeMin;

    public Filmovi() {
        this.naziv = "N/A";
        this.zanr = "drama";
        this.ocjena = 5.0;
        this.trajanjeMin = 90;
    }
    public Filmovi(String naziv, String zanr, double ocjena, int trajanjeMin) {
        this.naziv = naziv;
        this.zanr = zanr;
        this.ocjena = ocjena;
        this.trajanjeMin = trajanjeMin;
    }

    public String getNaziv(){ return naziv; }
    public String getZanr(){ return zanr; }
    public double getOcjena(){ return ocjena; }
    public int getTrajanjeMin(){ return trajanjeMin; }

    public String toString(){
        return naziv + " [" + zanr + "] ocjena=" + ocjena + " trajanje=" + trajanjeMin;
    }
}