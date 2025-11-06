/*
ZADATAK 8
"Naći platu zaposlenog koji ima DRUGO najveće primanje."
Primjer: {540, 690, 900} -> 690; Napomena: lista ima bar 2 elementa.  :contentReference[oaicite:10]{index=10}
*/
public class Zadatak8 {
    // Jedan prolaz: pratimo max1 (najveće) i max2 (drugo najveće) — različite vrijednosti
    public static int drugoNajvece(int[] plate) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < plate.length; i++) {
            int v = plate[i];
            if (v > max1) { max2 = max1; max1 = v; }           // novi najveći
            else if (v < max1 && v > max2) { max2 = v; }        // kandidat za 2.
        }
        return max2;
    }

    public static void main(String[] args) {
        System.out.println(drugoNajvece(new int[]{540,690,900})); // 690
    }
}