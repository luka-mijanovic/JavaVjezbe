/*
ZADATAK 4 (Config)
Dat je string je tipa: "{host=udg.me;port=443;secure=true;paths=/ai,/dl,/cv}".
Validiraj format (parovi ključ=vrijednost odvojeni ;, lista paths odvojena
zarezima, svi ključevI prisutni). Ako je string validan, vrati "OK", u suprotnom
vratiti odgovarajuću grešku
Format: "{host=udg.me;port=443;secure=true;paths=/ai,/dl,/cv}".
Provjeriti sve ključeve i format vrijednosti. Korišćeno: indexOf, substring, trim,
toLowerCase; bez regex/split.  :contentReference[oaicite:4]{index=4}
*/
public class Zadatak4_Config {
    public static String validno(String s) {
        if (s == null) return "Greška: prazan ulaz.";
        s = s.trim();
        if (!(s.startsWith("{") && s.endsWith("}"))) return "Greška: nedostaju {}."; // startsWith/endsWith
        String body = s.substring(1, s.length() - 1);

        String host = null, port = null, secure = null, paths = null;
        int i = 0;
        while (i <= body.length()) {
            int semi = body.indexOf(';', i);
            int end = (semi == -1) ? body.length() : semi;
            if (end > i) {
                String par = body.substring(i, end).trim();
                int eq = par.indexOf('=');
                if (eq == -1) return "Greška: nema '=' u \"" + par + "\"";
                String k = par.substring(0, eq).trim();
                String v = par.substring(eq + 1).trim();
                if (k.equals("host")) host = v;
                else if (k.equals("port")) port = v;
                else if (k.equals("secure")) secure = v;
                else if (k.equals("paths")) paths = v;
                else return "Greška: nepoznat ključ: " + k;
            }
            if (semi == -1) break;
            i = semi + 1;
        }
        if (host == null) return "Greška: nedostaje host.";
        if (port == null) return "Greška: nedostaje port.";
        if (secure == null) return "Greška: nedostaje secure.";
        if (paths == null) return "Greška: nedostaje paths.";

        // port: cijeli >0
        int p = 0;
        for (int k = 0; k < port.length(); k++) {
            char c = port.charAt(k);
            if (c < '0' || c > '9') return "Greška: port nije broj.";
            p = p * 10 + (c - '0');
        }
        if (p <= 0) return "Greška: port <= 0.";

        String low = secure.toLowerCase();
        if (!(low.equals("true") || low.equals("false"))) return "Greška: secure mora biti true/false.";

        // paths: lista vrijednosti odvojena zarezom; svaka počinje '/'
        int pos = 0; int br = 0;
        while (pos <= paths.length()) {
            int c = paths.indexOf(',', pos);
            int e = (c == -1) ? paths.length() : c;
            if (e > pos) {
                String one = paths.substring(pos, e).trim();
                if (one.length() == 0) return "Greška: prazan path.";
                if (one.charAt(0) != '/') return "Greška: path mora početi sa '/'.";
                br++;
            }
            if (c == -1) break;
            pos = c + 1;
        }
        if (br == 0) return "Greška: nema putanja.";
        return "OK";
    }

    public static void main(String[] args) {
        System.out.println(validno("{host=udg.me;port=443;secure=true;paths=/ai,/dl,/cv}")); // OK
    }
}