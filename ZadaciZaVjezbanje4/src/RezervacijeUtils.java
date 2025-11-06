import java.util.ArrayList;

/*
Pomoćne metode za Zadatak 10:
a) konflikti (parovi koji se preklapaju),
b) spoji intervale,
c) slobodni slotovi u [od, do] duži od trajanjeMin.
*/
public class RezervacijeUtils {

    public static ArrayList<Rezervacija> filtriraj(ArrayList<Rezervacija> L, String sala, String datum){
        ArrayList<Rezervacija> out = new ArrayList<Rezervacija>();
        for (int i=0;i<L.size();i++)
            if (L.get(i).sala.equals(sala) && L.get(i).datum.equals(datum)) out.add(L.get(i));
        return out;
    }

    public static void sortPoPocetku(ArrayList<Rezervacija> X){
        for (int i=0;i<X.size();i++)
            for (int j=0;j+1<X.size();j++)
                if (X.get(j).pocetakMin > X.get(j+1).pocetakMin){
                    Rezervacija t = X.get(j); X.set(j, X.get(j+1)); X.set(j+1, t);
                }
    }

    public static ArrayList<String> konflikti(ArrayList<Rezervacija> L, String sala, String datum){
        ArrayList<Rezervacija> X = filtriraj(L, sala, datum);
        sortPoPocetku(X);
        ArrayList<String> parovi = new ArrayList<String>();
        for (int i=0;i<X.size();i++)
            for (int j=i+1;j<X.size();j++)
                if (Math.max(X.get(i).pocetakMin, X.get(j).pocetakMin) <
                    Math.min(X.get(i).krajMin, X.get(j).krajMin))
                    parovi.add(X.get(i).toString() + " <-> " + X.get(j).toString());
        return parovi;
    }

    public static ArrayList<int[]> spoji(ArrayList<Rezervacija> L, String sala, String datum){
        ArrayList<Rezervacija> X = filtriraj(L, sala, datum);
        sortPoPocetku(X);
        ArrayList<int[]> out = new ArrayList<int[]>();
        for (int i=0;i<X.size();i++){
            int s = X.get(i).pocetakMin, e = X.get(i).krajMin;
            int j = i+1;
            while (j<X.size() && X.get(j).pocetakMin <= e) {
                if (X.get(j).krajMin > e) e = X.get(j).krajMin;
                j++;
            }
            i = j-1;
            out.add(new int[]{s,e});
        }
        return out;
    }

    public static ArrayList<int[]> slobodni(ArrayList<Rezervacija> L, String sala, String datum,
                                            int odMin, int doMin, int trajanjeMin){
        ArrayList<int[]> busy = spoji(L, sala, datum);
        ArrayList<int[]> free = new ArrayList<int[]>();
        int cur = odMin;
        for (int i=0;i<busy.size();i++){
            int s = busy.get(i)[0], e = busy.get(i)[1];
            if (e<=odMin || s>=doMin) continue;
            int startFree = cur;
            int endFree = Math.min(doMin, s);
            if (endFree - startFree >= trajanjeMin) free.add(new int[]{startFree, endFree});
            cur = Math.max(cur, Math.min(doMin, e));
        }
        if (doMin - cur >= trajanjeMin) free.add(new int[]{cur, doMin});
        return free;
    }
}