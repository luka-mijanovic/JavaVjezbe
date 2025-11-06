/*
ZADATAK 6
"Za unijeti niz a i vrijednost max vratiti broj elemenata manjih od max."
Primjeri u tekstu: 
a={1,2,3}, max=3 -> 2; a={-1,0,5}, max=-2 -> 0.  :contentReference[oaicite:8]{index=8}
*/
public class Zadatak6 {
    public static int brojManjihOdMax(int[] a, int max) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < max) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(brojManjihOdMax(new int[]{1,2,3}, 3));   // 2
        System.out.println(brojManjihOdMax(new int[]{-1,0,5}, -2)); // 0
    }
}