/*
ZADATAK 2
"Napisati program koji prikazuje samo parne negativne elemente unijetog niza."
Izvor: četvrta nedelja.  :contentReference[oaicite:3]{index=3}
*/
public class Zadatak2 {
    // Ispisujemo elemente koji su < 0 i deljivi sa 2
    public static void stampajParneNegativne(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0 && a[i] % 2 == 0) {
                System.out.println(a[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {-3, -4, 5, -8, 11, 0, 6};
        stampajParneNegativne(a); // ispis: -4, -8
    }
}