/*
ZADATAK 5
"Računati apsolutnu sumu svih negativnih parnih elemenata niza."
Primjer: {-2, 7, -5, 3, 1, -4} -> 6 (|-2| + |-4|).  :contentReference[oaicite:7]{index=7}
*/
public class Zadatak5 {
    // Ako je element negativan i paran, sabiramo -a[i] (apsolutna vrijednost)
    public static int apsolutnaSumaNegativnihParnih(int[] a) {
        int suma = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0 && a[i] % 2 == 0) {
                suma += -a[i];
            }
        }
        return suma;
    }

    public static void main(String[] args) {
        int[] a = {-2, 7, -5, 3, 1, -4};
        System.out.println(apsolutnaSumaNegativnihParnih(a)); // 6
    }
}
