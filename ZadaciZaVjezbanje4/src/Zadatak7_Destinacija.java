import java.util.ArrayList;

/*
Glavni program za Zadatak 7: koristi ArrayList<Destinacija> i tri funkcije:
a) filterTopBliske, b) najvisePosjeta, c) sortOcjenaOpadajuce.
*/
public class Zadatak7_Destinacija {

    public static ArrayList<Destinacija> filterTopBliske(ArrayList<Destinacija> L) {
        ArrayList<Destinacija> out = new ArrayList<Destinacija>();
        for (int i = 0; i < L.size(); i++) {
            Destinacija d = L.get(i);
            if (d.getOcjena() > 8 && d.getUdaljenostKm() < 1000) out.add(d);
        }
        return out;
    }

    public static Destinacija najvisePosjeta(ArrayList<Destinacija> L) {
        if (L.size() == 0) return null;
        Destinacija best = L.get(0);
        for (int i = 1; i < L.size(); i++)
            if (L.get(i).getBrojPosjeta() > best.getBrojPosjeta()) best = L.get(i);
        return best;
    }

    public static void sortOcjenaOpadajuce(ArrayList<Destinacija> L) {
        // jednostavan bubble sort opadajuće po ocjeni
        for (int i = 0; i < L.size(); i++)
            for (int j = 0; j + 1 < L.size(); j++)
                if (L.get(j).getOcjena() < L.get(j + 1).getOcjena()) {
                    Destinacija t = L.get(j);
                    L.set(j, L.get(j + 1));
                    L.set(j + 1, t);
                }
    }

    public static void main(String[] args) {
        ArrayList<Destinacija> L = new ArrayList<Destinacija>();
        L.add(new Destinacija("Kotor","CG",9,90,5));
        L.add(new Destinacija("Beč","AT",8,900,7));
        L.add(new Destinacija("Barselona","ES",10,1800,3));
        L.add(new Destinacija("Dubrovnik","HR",9,120,12));

        System.out.println("a) >8 i <1000km:");
        ArrayList<Destinacija> a = filterTopBliske(L);
        for (int i=0;i<a.size();i++) System.out.println(a.get(i));

        System.out.println("b) Najviše posjeta: " + najvisePosjeta(L));

        System.out.println("c) Sortirano opadajuće po ocjeni:");
        sortOcjenaOpadajuce(L);
        for (int i=0;i<L.size();i++) System.out.println(L.get(i));
    }
}