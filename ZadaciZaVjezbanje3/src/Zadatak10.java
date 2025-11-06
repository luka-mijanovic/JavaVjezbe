/*
ZADATAK 10
"Za niz cijelih brojeva (bez nule) vratiti BROJ elemenata koji imaju suprotnog (x i -x). 
Smatra se da se broj pojavljuje jednom."  :contentReference[oaicite:13]{index=13}
*/
public class Zadatak10 {
    // Brojimo samo za x>0 da ne dupliramo par (x,-x)
    public static int brojSuprotnihParova(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int x = a[i];
            if (x > 0) {
                boolean imaNeg = false;
                for (int j = 0; j < a.length; j++) if (a[j] == -x) { imaNeg = true; break; }
                if (imaNeg) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(brojSuprotnihParova(new int[]{1,2,-1,3,-3}));      // 2
        System.out.println(brojSuprotnihParova(new int[]{20,10,-10,100}));    // 1
    }
}