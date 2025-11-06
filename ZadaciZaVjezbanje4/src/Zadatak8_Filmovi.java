import java.util.ArrayList;

/*
Glavni program za Zadatak 8:
a) najduziFilm, b) filmoviPoZanru (equalsIgnoreCase), c) prosjecnaOcjena.
*/
public class Zadatak8_Filmovi {

    public static Filmovi najduziFilm(ArrayList<Filmovi> L) {
        if (L.size()==0) return null;
        Filmovi best = L.get(0);
        for (int i=1;i<L.size();i++)
            if (L.get(i).getTrajanjeMin() > best.getTrajanjeMin()) best = L.get(i);
        return best;
    }

    public static ArrayList<Filmovi> filmoviPoZanru(ArrayList<Filmovi> L, String zanr) {
        ArrayList<Filmovi> out = new ArrayList<Filmovi>();
        for (int i=0;i<L.size();i++)
            if (L.get(i).getZanr().equalsIgnoreCase(zanr)) out.add(L.get(i));
        return out;
    }

    public static double prosjecnaOcjena(ArrayList<Filmovi> L) {
        if (L.size()==0) return 0.0;
        double s=0.0;
        for (int i=0;i<L.size();i++) s+=L.get(i).getOcjena();
        return s/L.size();
    }

    public static void main(String[] args) {
        ArrayList<Filmovi> L = new ArrayList<Filmovi>();
        L.add(new Filmovi("Inception","SF",8.8,148));
        L.add(new Filmovi("Braveheart","DRAMA",8.5,177));
        L.add(new Filmovi()); // podrazumijevani

        System.out.println("Najduži: " + najduziFilm(L));
        System.out.println("Drama (count): " + filmoviPoZanru(L, "drama").size());
        System.out.println("Prosjek ocjena: " + prosjecnaOcjena(L));
    }
}