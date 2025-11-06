/*
ZADATAK 13
"Napisati funkciju longest_increasing(input_array) koja nalazi najduži 
NEOPADAJUĆI podniz pozitivnih cijelih brojeva i vraća taj niz."
Primjer: {1,2,3,-1,0,5,6,7,10,10,1} -> {5,6,7,10,10}.  :contentReference[oaicite:16]{index=16}
*/
import java.util.Arrays;

public class Zadatak13 {
    // Tražimo najduži KONTINUALNI segment sa uslovima: >0 i a[i-1] <= a[i]
    public static int[] longestNonDecreasingPositive(int[] a) {
        int bestStart = -1, bestLen = 0;
        int curStart = -1,  curLen  = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                if (curLen == 0) { // početak novog segmenta
                    curStart = i; curLen = 1;
                } else {
                    if (a[i - 1] <= a[i]) curLen++; // produži segment
                    else {
                        if (curLen > bestLen) { bestLen = curLen; bestStart = curStart; }
                        curStart = i; curLen = 1;      // novi segment
                    }
                }
            } else {
                if (curLen > bestLen) { bestLen = curLen; bestStart = curStart; }
                curStart = -1; curLen = 0;            // prekid segmenta
            }
        }
        if (curLen > bestLen) { bestLen = curLen; bestStart = curStart; }

        if (bestLen == 0) return new int[0];          // nema pozitivnih
        int[] out = new int[bestLen];
        for (int i = 0; i < bestLen; i++) out[i] = a[bestStart + i];
        return out;
    }

    public static void main(String[] args) {
        int[] in = {1,2,3,-1,0,5,6,7,10,10,1};
        System.out.println(Arrays.toString(longestNonDecreasingPositive(in))); // [5, 6, 7, 10, 10]
    }
}