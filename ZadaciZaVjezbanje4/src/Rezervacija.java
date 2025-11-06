/*
ZADATAK 10 (Rezervacije)
Napraviti klasu Rezervacija sa atributima sala, datum, pocetakMin,
krajMin, predmet, nosilac. Data je ArrayList<Rezervacija>:
a. Napisati metodu koja za zadatu salu i datum vraća sve parove
rezervacija koje se preklapaju (konflikti).
b. Napisati metodu koja za zadatu salu i datum spaja preklapajuće
intervale i vraća komprimovanu listu zauzeća (npr. [08:00–09:30],
[10:00–12:00]…).
c. Napisati metodu slobodniSlotovi(sala, datum, odMin, doMin,
trajanjeMin) koja vraća sve slobodne slotove u datom prozoru koji traju
barem trajanjeMin
Klasa sadrži: sala, datum, pocetakMin, krajMin, predmet, nosilac. Interval je [pocetak, kraj).
*/
public class Rezervacija {
    String sala, datum, predmet, nosilac;
    int pocetakMin, krajMin;

    public Rezervacija(String sala, String datum, int poc, int kraj, String predmet, String nosilac) {
        this.sala = sala; this.datum = datum;
        this.pocetakMin = poc; this.krajMin = kraj;
        this.predmet = predmet; this.nosilac = nosilac;
    }

    static String fmt(int m){
        String hh = String.valueOf(m/60); if (hh.length()==1) hh = "0"+hh;
        String mm = String.valueOf(m%60); if (mm.length()==1) mm = "0"+mm;
        return hh + ":" + mm;
    }

    public String toString(){
        return sala + " " + datum + " [" + fmt(pocetakMin) + "-" + fmt(krajMin) + "] " + predmet;
    }
}