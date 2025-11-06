import java.util.ArrayList;

/*
Glavni program: demonstrira a) konflikte, b) spajanje zauzeća, c) slobodne slotove.
*/
public class Zadatak10_Rezervacije {
    public static void main(String[] args) {
        ArrayList<Rezervacija> L = new ArrayList<Rezervacija>();
        L.add(new Rezervacija("A1","2025-10-31",8*60,9*60+30,"Mat","A"));
        L.add(new Rezervacija("A1","2025-10-31",9*60,10*60,"Eng","B"));
        L.add(new Rezervacija("A1","2025-10-31",11*60,12*60,"Prog","C"));

        System.out.println("Konflikti:");
        ArrayList<String> K = RezervacijeUtils.konflikti(L,"A1","2025-10-31");
        for (int i=0;i<K.size();i++) System.out.println(K.get(i));

        System.out.println("Zauzeća (spojeno):");
        ArrayList<int[]> S = RezervacijeUtils.spoji(L,"A1","2025-10-31");
        for (int i=0;i<S.size();i++)
            System.out.println("[" + Rezervacija.fmt(S.get(i)[0]) + "-" + Rezervacija.fmt(S.get(i)[1]) + "]");

        System.out.println("Slobodno 08:00–13:00 (≥30min):");
        ArrayList<int[]> F = RezervacijeUtils.slobodni(L,"A1","2025-10-31",8*60,13*60,30);
        for (int i=0;i<F.size();i++)
            System.out.println("[" + Rezervacija.fmt(F.get(i)[0]) + "-" + Rezervacija.fmt(F.get(i)[1]) + "]");
    }
}