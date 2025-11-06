/*
ZADATAK 6 (Najduži podstring bez ponavljanja)
Napisati program koji pronalazi najduži podstring bez ponavljanja
alfanumeričkih znakova, ne razlikujući mala i velika slova. Razmaci i crtice (' ',
'-') ne ulaze u podstring i prekidaju ga. Program treba da prikaže sam
podstring, njegovu dužinu i početni indeks u originalnom stringu
Traži kontinuirani podstring a-z0-9 (case-insensitive), bez ponavljanja; ' ' i '-' prekidaju.
Ispiši podstring, dužinu i start indeks. Korišćeno: toUpperCase, charAt, String.substring.  :contentReference[oaicite:6]{index=6}
*/
public class Zadatak6_Substring {
    public static void nadji(String s) {
        if (s == null) { System.out.println("Prazno."); return; }

        int[] last = new int[36]; // 26 slova + 10 cifara
        Arrays.fill(last, -1);    // Arrays.fill sa slajda  :contentReference[oaicite:7]{index=7}

        int bestStart = 0, bestLen = 0, curStart = 0, curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char raw = s.charAt(i);
            if (raw == ' ' || raw == '-') { Arrays.fill(last, -1); curStart = i + 1; curLen = 0; continue; }
            char c = Character.toUpperCase(raw);
            int idx = map(c);
            if (idx == -1) { Arrays.fill(last, -1); curStart = i + 1; curLen = 0; continue; }

            if (last[idx] >= curStart) { curStart = last[idx] + 1; curLen = i - curStart + 1; }
            else curLen++;
            last[idx] = i;

            if (curLen > bestLen) { bestLen = curLen; bestStart = curStart; }
        }
        String pod = (bestLen > 0) ? s.substring(bestStart, bestStart + bestLen) : "";
        System.out.println("Podstring: \"" + pod + "\", dužina: " + bestLen + ", indeks: " + bestStart);
    }

    private static int map(char c) {
        if (c >= 'A' && c <= 'Z') return c - 'A';
        if (c >= '0' && c <= '9') return 26 + (c - '0');
        return -1;
    }

    // potreban import za Arrays
    static class Arrays {
        static void fill(int[] a, int v) { for (int i = 0; i < a.length; i++) a[i] = v; }
    }

    public static void main(String[] args) {
        nadji("ABcdeF-12aB 99XYz");
    }
}