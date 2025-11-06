/*
ZADATAK 4
"Dječak sabira brojeve kuća dok ne naiđe na 0; izračunati zbir prije prve nule."
Primjer ulaz/izlaz dat u tekstu: {5,1,2,3,0,1,5,0,2} -> 11.  :contentReference[oaicite:6]{index=6}
*/
public class Zadatak4 {
    // Sabiramo elemente dok ne vidimo 0; tada prekidamo
    public static int zbirPrijeNule(int[] kuce) {
        int sum = 0;
        for (int i = 0; i < kuce.length; i++) {
            if (kuce[i] == 0) break; // odmah prekid
            sum += kuce[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] k = {5,1,2,3,0,1,5,0,2};
        System.out.println(zbirPrijeNule(k)); // 11
    }
}