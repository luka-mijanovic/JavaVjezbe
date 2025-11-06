/*
ZADATAK 2 (Senzor log)
Dat je primjera log-a sa nekog senzora koji se koristi za mjerenje određenih
parametara vazduha i to u sledećem obliku (tip podatka je string):
"T=18.6C;H=55%;TS=2025-10-24T11:03|T=19.1C;H=54%;TS=2025-10-24T1
1:08|...". Napisati metodu koja iz stringa izdvaja sve zapise i vraća prosječnu
temperaturu (sa 1 decimalom) samo za zapise čiji je minut u intervalu [10,20).
Ako postoji greška u formatu zapisa, taj zapis preskoči.
Log zapisi razdvojeni '|', npr: "T=18.6C;H=55%;TS=2025-10-24T11:03|T=19.1C;...".
Izdvojiti T i minute iz TS; računati prosjek temperatura za minute u [10,20). Zaokružiti na 1 dec.
Korišćeno: String.indexOf, substring, trim; bez split/regex — po slajdovima.  :contentReference[oaicite:2]{index=2}
*/
public class Zadatak2_Senzor {
    public static double prosjek1019(String s) {
        if (s == null) return 0.0;
        int start = 0; double suma = 0.0; int cnt = 0;

        while (start < s.length()) {
            int bar = s.indexOf('|', start);
            int end = (bar == -1) ? s.length() : bar;
            if (end > start) {
                String rec = s.substring(start, end).trim();
                Double t = temp(rec);
                Integer m = minute(rec);
                if (t != null && m != null && m >= 10 && m < 20) { suma += t; cnt++; }
            }
            if (bar == -1) break;
            start = bar + 1;
        }
        if (cnt == 0) return 0.0;
        double avg = suma / cnt;
        // ručno zaokruži na 1 decimalu (bez DecimalFormat)
        int x10 = (int)(avg * 10 + 0.5);
        return x10 / 10.0;
    }

    private static Double temp(String rec) {
        int tEq = rec.indexOf("T=");
        int cPos = (tEq == -1) ? -1 : rec.indexOf('C', tEq + 2);
        if (tEq == -1 || cPos == -1) return null;
        String broj = rec.substring(tEq + 2, cPos).trim(); // npr. "18.6"
        // ručni parser double-a sa tačkom
        boolean dot = false; double v = 0.0, div = 1.0;
        for (int i = 0; i < broj.length(); i++) {
            char c = broj.charAt(i);
            if (c == '.' && !dot) { dot = true; continue; }
            if (c < '0' || c > '9') return null;
            int d = c - '0';
            if (!dot) v = v * 10 + d; else { div *= 10; v += d / div; }
        }
        return v;
    }

    private static Integer minute(String rec) {
        int ts = rec.indexOf("TS=");
        if (ts == -1) return null;
        int lastColon = rec.lastIndexOf(':');
        if (lastColon == -1 || lastColon + 2 >= rec.length()) return null;
        char c1 = rec.charAt(lastColon + 1), c2 = rec.charAt(lastColon + 2);
        if (c1 < '0' || c1 > '9' || c2 < '0' || c2 > '9') return null;
        return (c1 - '0') * 10 + (c2 - '0');
    }

    public static void main(String[] args) {
        String s = "T=18.6C;H=55%;TS=2025-10-24T11:03|T=19.1C;H=54%;TS=2025-10-24T11:12|T=20.0C;H=52%;TS=2025-10-24T11:19";
        System.out.println(prosjek1019(s)); // 19.6
    }
}