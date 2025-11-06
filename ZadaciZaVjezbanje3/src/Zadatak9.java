/*
ZADATAK 9
"Za unijete nizove a i b vratiti niz zajedničkih elemenata."
Primjeri: 
a={1,2,3}, b={3,2} -> {2,3}
a={2,3,4}, b={1,1,7} -> {}  :contentReference[oaicite:11]{index=11}
*/
import java.util.ArrayList;
import java.util.Arrays;

public class Zadatak9 {
    // Linearno traženje i uklanjanje duplikata u rezultatu; rezultat sortiran (Arrays.sort je u lekcijama)
    public static int[] zajednicki(int[] a, int[] b) {
        ArrayList<Integer> rez = new ArrayList<Integer>();
        for (int i = 0; i < a.length; i++) {
            // postoji li a[i] u b?
            boolean uB = false;
            for (int j = 0; j < b.length; j++) if (a[i] == b[j]) { uB = true; break; }
            if (uB) {
                // izbjegni duplikate u rezultatu
                boolean vec = false;
                for (int k = 0; k < rez.size(); k++) if (rez.get(k) == a[i]) { vec = true; break; }
                if (!vec) rez.add(a[i]);
            }
        }
        // prebacimo u niz i sortiramo
        int[] out = new int[rez.size()];
        for (int i = 0; i < rez.size(); i++) out[i] = rez.get(i);
        Arrays.sort(out);
        return out;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(zajednicki(new int[]{1,2,3}, new int[]{3,2}))); // [2, 3]
        System.out.println(Arrays.toString(zajednicki(new int[]{2,3,4}, new int[]{1,1,7}))); // []
    }
}