/*
ZADATAK 1
"Napisati program koji provjerava koliko niz ima pozitivnih cijelih brojeva."
Izvor: Zadaci za vježbanje, četvrta nedelja.  :contentReference[oaicite:1]{index=1}
*/
public class Zadatak1 {
    // Prolazimo kroz niz i brojimo elemente > 0
    public static int brojPozitivnih(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) { // klasična for petlja iz lekcija
            if (a[i] > 0) count++;           // uslov: pozitivan broj
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, -3, 0, 7, 5, -1};
        System.out.println(brojPozitivnih(a)); // očekivano: 3
    }
}