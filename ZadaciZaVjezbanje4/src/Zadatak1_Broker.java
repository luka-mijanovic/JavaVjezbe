/*ZADATAK 1 (Broker)
Napisati program koji za unijeti string provjerava da li je broker u plusu ili
minus nakon trgovine akcijama. Prefiks stringa sadrzi S kada je odradjena
prodaja, a B kada je odradjena kupovina akcija.
Ulaz: string sa tokenima "Sxx" i "Bxx" razdvojenim razmakom (npr. "S50 S40 B50 B100").
S = prodaja (+), B = kupovina (-). Izračunaj neto rezultat.
Korišćene metode: String.trim, String.indexOf, String.substring, String.charAt, String.toUpperCase.
(Sve po slajdovima o String metodama.)  :contentReference[oaicite:1]{index=1}
*/
public class Zadatak1_Broker {
    public static int rezultat(String s) {
        if (s == null) return 0;
        s = s.trim();
        int sum = 0, start = 0;
        while (start < s.length()) {
            int space = s.indexOf(' ', start);
            int end = (space == -1) ? s.length() : space;

            if (end > start) {
                char pref = Character.toUpperCase(s.charAt(start));
                String broj = s.substring(start + 1, end).trim(); // npr. "50"
                // Parsiranje cijelog broja (samo cifre)
                int val = 0;
                for (int i = 0; i < broj.length(); i++) {
                    char c = broj.charAt(i);
                    if (c < '0' || c > '9') { val = 0; break; }
                    val = val * 10 + (c - '0');
                }
                if (pref == 'S') sum += val;
                else if (pref == 'B') sum -= val;
            }
            if (space == -1) break;
            start = space + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(rezultat("S50 S40 B50 B100")); // -60
    }
}