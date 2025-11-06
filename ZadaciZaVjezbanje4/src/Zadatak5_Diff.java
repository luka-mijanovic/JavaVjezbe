/*
ZADATAK 5 (Diff riječi)
Zadate su dvije rečenice (verzija A i B). Vrati string koji označava:
a. riječi koje su uklonjene iz A (označi [-riječ-]),
b. riječi koje su dodate u B (označi {+riječ+}),
c. zajedničke riječi ostaju nepromijenjene.
Primjer: A: "Model je bio spor ali tačan"; B: "Model je veoma tačan" → "Model
je {+veoma+} tačan [-bio-] [-spor-] [-ali-]".
A i B su rečenice (riječi razdvojene razmakom). Zajedničke riječi ostaju, dodate u B -> {+...+},
izbačene iz A -> [-...-]. Korišćeno: nizovi String, equals, compareTo (LCS radi na riječima),
StringBuilder za sklapanje rezultata.  :contentReference[oaicite:5]{index=5}
*/
import java.util.ArrayList;

public class Zadatak5_Diff {
    public static String diff(String A, String B) {
        String[] a = splitBySpace(A);
        String[] b = splitBySpace(B);

        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1].equals(b[j - 1])) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = (dp[i - 1][j] >= dp[i][j - 1]) ? dp[i - 1][j] : dp[i][j - 1];
            }
        }

        ArrayList<String> out = new ArrayList<String>();
        int i = a.length, j = b.length;
        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && a[i - 1].equals(b[j - 1])) { out.add(0, a[i - 1]); i--; j--; }
            else if (j > 0 && (i == 0 || dp[i][j - 1] >= dp[i - 1][j])) { out.add(0, "{+" + b[j - 1] + "+}"); j--; }
            else { out.add(0, "[-" + a[i - 1] + "-]"); i--; }
        }

        StringBuilder sb = new StringBuilder(); // StringBuilder.append lančano
        for (int k = 0; k < out.size(); k++) {
            if (k > 0) sb.append(' ');
            sb.append(out.get(k));
        }
        return sb.toString();
    }

    // osnovno razbijanje po razmaku (po slajdovima koristimo length/charAt/substring)
    private static String[] splitBySpace(String s) {
        if (s == null) return new String[0];
        s = s.trim();
        ArrayList<String> list = new ArrayList<String>();
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') i++;
            if (i >= s.length()) break;
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') j++;
            list.add(s.substring(i, j));
            i = j;
        }
        String[] arr = new String[list.size()];
        list.toArray(arr); // ArrayList -> niz
        return arr;
    }

    public static void main(String[] args) {
        String A = "Model je bio spor ali tačan";
        String B = "Model je veoma tačan";
        System.out.println(diff(A,B));
    }
}