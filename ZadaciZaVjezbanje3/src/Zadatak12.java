/*
ZADATAK 12
"U nizu cijelih brojeva provjeriti koliko je NARCISTIČNIH (npr. 153)."
Definicija: broj = zbir cifara na stepen broja cifara.  :contentReference[oaicite:15]{index=15}
*/
public class Zadatak12 {
    // Broj cifara (0 ima 1 cifru)
    private static int brojCifara(int n) {
        if (n == 0) return 1;
        int d = 0; if (n < 0) n = -n;
        while (n > 0) { d++; n /= 10; }
        return d;
    }

    // c^d bez Math.pow (drži se osnovnih operacija iz lekcija)
    private static int stepen(int c, int d) {
        int p = 1;
        for (int i = 0; i < d; i++) p *= c;
        return p;
    }

    private static boolean jeNarcistican(int n) {
        if (n < 0) return false; // tipično se posmatraju nenegativni
        int d = brojCifara(n);
        if (n == 0) return true; // 0 = 0^1
        int s = 0, t = n;
        while (t > 0) {
            int c = t % 10;
            s += stepen(c, d);
            t /= 10;
        }
        return s == n;
    }

    public static int brojNarcistickih(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) if (jeNarcistican(a[i])) count++;
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {153, 10, 370, 371, 407, 7, 12};
        System.out.println(brojNarcistickih(arr)); // 5
    }
}