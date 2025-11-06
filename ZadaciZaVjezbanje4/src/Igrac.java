/*
Pomoćna klasa za Zadatak 9: igrač sa imenom i brojem bodova.
*/
public class Igrac {
    String ime;
    int bodovi;

    public Igrac(String ime){
        this.ime = ime;
        this.bodovi = 0;
    }

    public String toString(){ return ime + "(" + bodovi + ")"; }
}