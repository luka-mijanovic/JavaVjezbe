/*
ZADATAK 3
"Za unijeti niz a uvećati svaki parni element za vrijednost x (x je prirodan broj)."
Izvor: četvrta nedelja.  :contentReference[oaicite:4]{index=4}
*/
public class Zadatak3 {
    // Ako je element paran (a[i] % 2 == 0), uvećamo ga za x
    public static void povecajParneZaX(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                a[i] = a[i] + x; // promjena in-place
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        povecajParneZaX(a, 3); // -> {1,5,3,7,5}
        for (int i = 0; i < a.length; i++) System.out.print(a[i] + " ");
    }
}