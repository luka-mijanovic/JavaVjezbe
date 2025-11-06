/*
ZADATAK 3 (Hashtagovi)
 Ulaz je niz etiketa spojenih zarezima i tarabama, npr.
"AI,urgent,#students,#aiClub,research,#hpc,UDG,#Students".
Napisati metodu koja treba da vrati uređenu listu/niz jedinstvenih hashtagova
(samo one koje počinju sa #), bez duplikata i bez razlike malih/velikih slova,
spojenu nazad u string odvojen zarezom (npr. "#ai","#students","#hpc").
Ostatak riječi ignoriši.
Ulaz: "AI,urgent,#students,#aiClub,research,#hpc,UDG,#Students"
Vrati zarezom-spojenu listu JEDINSTVENIH hashtagova (#...), bez obzira na veličinu slova,
sortiranu abecedno. Korišćeno: ArrayList (add, contains, toArray), Arrays.sort, String.toLowerCase,
String.indexOf, substring, trim.  :contentReference[oaicite:3]{index=3}
*/
import java.util.ArrayList;
import java.util.Arrays;

public class Zadatak3_Hashtags {
    public static String uradi(String s) {
        if (s == null) return "";
        s = s.trim();
        ArrayList<String> kol = new ArrayList<String>();

        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && (s.charAt(i) == ' ' || s.charAt(i) == ',')) i++;
            if (i >= s.length()) break;
            int c = s.indexOf(',', i);
            int end = (c == -1) ? s.length() : c;
            String tok = s.substring(i, end).trim();
            if (tok.length() > 0 && tok.charAt(0) == '#') {
                String norm = tok.toLowerCase();
                if (!kol.contains(norm)) kol.add(norm); // ArrayList.contains
            }
            i = end + 1;
        }
        String[] arr = new String[kol.size()];
        kol.toArray(arr);        // ArrayList -> niz
        Arrays.sort(arr);        // Arrays.sort po slajdovima
        // sklopi CSV preko StringBuilder.append
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < arr.length; k++) {
            if (k > 0) sb.append(',');
            sb.append(arr[k]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(uradi("AI,urgent,#students,#aiClub,research,#hpc,UDG,#Students"));
    }
}