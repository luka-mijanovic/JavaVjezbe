/*
Glavni program: ispis opis() za svaku sezonu i nalaženje sezone sa najvećim rasponom (max-min).
*/
public class Zadatak12_Sezona {

    public static Sezona najveciRaspon() {
        Sezona best = Sezona.PROLJECE;
        int r = best.getMax() - best.getMin();
        for (Sezona s : Sezona.values()) {
            int rr = s.getMax() - s.getMin();
            if (rr > r) { r = rr; best = s; }
        }
        return best;
    }

    public static void main(String[] args) {
        for (Sezona s : Sezona.values()) {
            System.out.println(s.opis());
        }
        System.out.println("Najveći raspon: " + najveciRaspon());
    }
}