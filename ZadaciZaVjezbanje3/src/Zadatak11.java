/*
ZADATAK 11
"Za zadatu listu brojeva štampati onaj koji ima NAJVEĆI ZBIR CIFARA.
Pretpostaviti da nema izjednačenja."  :contentReference[oaicite:14]{index=14}
*/
public class Zadatak11 {
    // Pomoćna funkcija: suma cifara (apsolutna vrijednost)
    private static int sumaCifara(int n) {
        if (n < 0) n = -n;
        int s = 0;
        while (n > 0) { s += n % 10; n /= 10; } // uzmi cifru pa pomjeri
        return s;
    }

    public static int brojSaNajvecimZbiromCifara(int[] a) {
        int najbolji = a[0];
        int maxS = sumaCifara(a[0]);
        for (int i = 1; i < a.length; i++) {
            int s = sumaCifara(a[i]);
            if (s > maxS) { maxS = s; najbolji = a[i]; }
        }
        return najbolji;
    }

    public static void main(String[] args) {
        int[] arr = {19, 38, 77}; // sume: 10, 11, 14 -> 77
        System.out.println(brojSaNajvecimZbiromCifara(arr)); // 77
    }
}