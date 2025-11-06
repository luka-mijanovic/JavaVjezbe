/*Uradi ovaj zadatak u Javi koristeći isključivo principe i sintaksu sa osnovnih časova. Nemoj koristiti nikakve napredne funkcije, biblioteke ili trikove. Prati samo sljedeće uslove:
koristi čiste nizove (int[], double[] itd.) i/ili ArrayList, klase itd... ali jednostavno ili ne ako nije potrebno
koristi for petlje i if-else logiku
koristi statičke metode kada je potrebno
ne koristi stream-ove, lambda funkcije, map-ove, set-ove, klase iz java.util osim ArrayList i Arrays (za sortiranje) ako treba
ne koristi OOP koncepte koje još nijesmo učili (nema apstrakcija, interfejsi, generici itd. ako nijesu u zadatku)
možeš koristiti samo String metode koje smo radili na predavanju, (npr. length(), charAt(), equals(), toUpperCase(), toLowerCase(), substring(), indexOf())
ne koristi biblioteke osim java.util.ArrayList i java.util.Arrays (za sortiranje) ako treba
bilo bi fino da kod ima komentare koji objašnjavaju šta radi
kod mora biti što jednostavniji, jasan i razumljiv početniku
ucio sam nasljedjivanje i emulaciju pa koristi ako je potrebno
ne koristi optimizacije i "pametne" trikove — radi polako i čitljivo*/
/*Uradi zadatak koristeći isključivo koncepte koje sam učio na osnovnom Java kursu.
Rješenje treba da izgleda kao studentsko, jednostavno, jasno i bez naprednih trikova.

KORISTI:
klase sa privatnim atributima
get i set metode
konstruktor(e)
toString() metodu
nasljeđivanje SAMO ako zadatak traži
ArrayList (osnovno korišćenje)
statičke metode
for, while, if/else
osnovne string metode:
length()
charAt()
substring()
indexOf()
contains()
trim()
toLowerCase()
StringBuilder za rad sa stringovima
ručno parsiranje indexOf + substring (ne split)
ručno traženje minimuma/maksimuma
bubble sort ako treba sortiranje
Math.PI i Math.pow() samo ako je neophodno

NE KORISTI:
stream API (stream(), map, filter, forEach, lambda funkcije)
kolekcije osim ArrayList (Map, Set, HashMap, HashSet…)
split() i regularne izraze (osim ako zadatak izričito traži)
Collections.sort i Comparator
generike napredno
interface i abstract class (osim ako zadatak to traži)
naprednu obradu izuzetaka (try/catch samo osnovno)
bilo kakve biblioteke i frameworke

STIL KODA:
jasna, jednostavna logika
komentari u kodu koji objašnjavaju korake
imena metoda na srpskom (npr. pronadjiNajveci, izdvojiPoOpsegu)
metoda main za testiranje (kreiraj objekte, pozovi metode)
ne koristi nepotrebne klase — samo ono što zadatak traži*/


class zadatakTest {

    // Metoda koja računa zbir brojeva kuća duž rute.
    // Ulaz: int[] route - niz brojeva; -1 znači da kuća nema broj.
    // Izlaz: int - zbir svih brojeva koji postoje na ruti.
    static int sumAddresses(int[] route) {
        // inicijalizujemo zbir na 0
        int sum = 0;
        // prolazimo kroz sve elemente niza
        for (int i = 0; i < route.length; i++) {
            // ako kuća ima broj (nije -1), dodajemo ga u zbir
            if (route[i] != -1) {
                sum = sum + route[i];
            } else {
                // ako nema broja, preskačemo
                // ovdje ne radimo ništa (ostavljeno zbog čitljivosti)
            }
        }
        // vraćamo konačan zbir
        return sum;
    }

    // Metoda koja broji koliko kuća na ruti ima broj.
    // Ulaz: int[] route - niz brojeva; -1 znači da kuća nema broj.
    // Izlaz: int - broj kuća koje imaju adresu.
    static int countNumberedHouses(int[] route) {
        int count = 0;
        for (int i = 0; i < route.length; i++) {
            if (route[i] != -1) {
                count = count + 1;
            }
        }
        return count;
    }

    // Pomoćna metoda koja ispisuje rutu u razumljivom obliku.
    // Prikazuje '-' za kuće bez broja i stvarne brojeve za one sa adresom.
    static void printRoute(int[] route) {
        System.out.print("Ruta: [");
        for (int i = 0; i < route.length; i++) {
            if (route[i] == -1) {
                System.out.print("-");
            } else {
                System.out.print(route[i]);
            }
            if (i < route.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Glavna metoda sa primjerima ruta i ispisom rezultata.
    public static void main(String[] args) {
        // Primjer 1: neka kuće imaju brojeve, neke nemaju (-1)
        int[] ruta1 = {12, -1, 5, -1, 23, 7};
        // Primjer 2: različiti rasporedi i još bez nekih brojeva
        int[] ruta2 = {-1, 3, 3, 10, -1, 1, -1};
        // Primjer 3: sve kuće imaju brojeve
        int[] ruta3 = {2, 4, 6, 8};
        // Primjer 4: nijedna kuća nema brojeve
        int[] ruta4 = {-1, -1, -1};

        // Ispis i račun za svaku rutu
        printRoute(ruta1);
        System.out.println("Broj kuća sa brojem: " + countNumberedHouses(ruta1));
        System.out.println("Zbir brojeva na ruti: " + sumAddresses(ruta1));
        System.out.println();

        printRoute(ruta2);
        System.out.println("Broj kuća sa brojem: " + countNumberedHouses(ruta2));
        System.out.println("Zbir brojeva na ruti: " + sumAddresses(ruta2));
        System.out.println();

        printRoute(ruta3);
        System.out.println("Broj kuća sa brojem: " + countNumberedHouses(ruta3));
        System.out.println("Zbir brojeva na ruti: " + sumAddresses(ruta3));
        System.out.println();

        printRoute(ruta4);
        System.out.println("Broj kuća sa brojem: " + countNumberedHouses(ruta4));
        System.out.println("Zbir brojeva na ruti: " + sumAddresses(ruta4));
        System.out.println();

        // Kratko objašnjenje za korisnika
        System.out.println("Napomena: ovdje je -1 korišteno da označi kuću bez broja.");
        System.out.println("Program koristi jednostavne for petlje i if-else logiku.");
    }

}