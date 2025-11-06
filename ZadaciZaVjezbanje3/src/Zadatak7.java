/*
ZADATAK 7
"Dat je niz cijena; market je spustio cijene svim proizvodima. 
Kolika će zarada biti manja u odnosu na originalnu cijenu?"
Napomena: Tekst ne precizira model sniženja — tipično: dati procenat p (0..100).
Tada je smanjenje = suma(cijena) * p/100.  :contentReference[oaicite:9]{index=9}
*/
public class Zadatak7 {
    public static double umanjenjeZarade(double[] cijene, double procenat) {
        double suma = 0.0;
        for (int i = 0; i < cijene.length; i++) suma += cijene[i];
        return suma * (procenat / 100.0);
    }

    public static void main(String[] args) {
        double[] c = {100, 50, 30};
        System.out.println(umanjenjeZarade(c, 10)); // 18.0 (10% od 180)
    }
}
