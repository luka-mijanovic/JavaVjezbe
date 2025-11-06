import java.util.ArrayList;

/*
ZADATAK 11 (Lager i narudžbine) — glavni program i sve metode
USLOVI:
- Bez dodatnih klasa osim Stavka i Narudzbina (ovaj fajl je "test").
- Bez @SuppressWarnings.
- Koristiti samo osnove: ArrayList, for/if, equals, jednostavno (ručno) sortiranje.

Šta sadrži:
a) konsolidujLager(lager)
b) sortNarudzbine(nar)  // prioritet opadajuće, pa id rastuće
c) ispuniNarudzbine(lager, nar, potpunoOut, djelimicnoOut)
   - rezultate vraćamo kroz DVIJE izlazne liste (parametri), da izbjegnemo generičke nizove
d) generisiBackorder(djelimicno) -> ArrayList<Stavka>
*/

public class Zadatak11_Stavka {

    // a) Konsoliduj lager: saberi iste SKU, ukloni <=0
    public static void konsolidujLager(ArrayList<Stavka> lager) {
        for (int i = 0; i < lager.size(); i++) {
            Stavka s = lager.get(i);
            int j = i + 1;
            while (j < lager.size()) {
                if (lager.get(j).sku.equals(s.sku)) {
                    s.kolicina += lager.get(j).kolicina;
                    lager.remove(j);
                } else {
                    j++;
                }
            }
            if (s.kolicina <= 0) {
                lager.remove(i);
                i--;
            }
        }
    }

    // b) Sortiranje narudžbina: prioritet opadajuće, pa id rastuće
    public static void sortNarudzbine(ArrayList<Narudzbina> nar) {
        for (int i = 0; i < nar.size(); i++) {
            for (int j = 0; j + 1 < nar.size(); j++) {
                Narudzbina a = nar.get(j);
                Narudzbina b = nar.get(j + 1);
                boolean trebaZamjena =
                        (a.prioritet < b.prioritet) ||
                        (a.prioritet == b.prioritet && a.id > b.id);
                if (trebaZamjena) {
                    nar.set(j, b);
                    nar.set(j + 1, a);
                }
            }
        }
    }

    // pomoćno: nađi indeks SKU u listi stavki (ili -1)
    private static int indeksSku(ArrayList<Stavka> L, String sku) {
        for (int i = 0; i < L.size(); i++) {
            if (L.get(i).sku.equals(sku)) return i;
        }
        return -1;
    }

    // c) Ispuni narudžbine
    // REZULTATI SE VRAĆAJU KROZ DVIJE IZLAZNE LISTE: potpunoOut i djelimicnoOut
    public static void ispuniNarudzbine(
            ArrayList<Stavka> lager,
            ArrayList<Narudzbina> nar,
            ArrayList<Narudzbina> potpunoOut,
            ArrayList<Narudzbina> djelimicnoOut
    ) {
        konsolidujLager(lager);
        sortNarudzbine(nar);

        for (int i = 0; i < nar.size(); i++) {
            Narudzbina N = nar.get(i);
            ArrayList<Stavka> back = new ArrayList<Stavka>();
            boolean sveIspunjeno = true;

            for (int k = 0; k < N.stavke.size(); k++) {
                Stavka zeljeno = N.stavke.get(k);
                int idx = indeksSku(lager, zeljeno.sku);

                if (idx == -1 || lager.get(idx).kolicina == 0) {
                    // ništa na lageru
                    back.add(new Stavka(zeljeno.sku, zeljeno.naziv, zeljeno.kolicina));
                    sveIspunjeno = false;
                } else {
                    int dostupno = lager.get(idx).kolicina;
                    int isporuceno = (dostupno >= zeljeno.kolicina) ? zeljeno.kolicina : dostupno;
                    lager.get(idx).kolicina -= isporuceno;
                    int ostalo = zeljeno.kolicina - isporuceno;
                    if (ostalo > 0) {
                        back.add(new Stavka(zeljeno.sku, zeljeno.naziv, ostalo));
                        sveIspunjeno = false;
                    }
                }
            }

            if (sveIspunjeno) {
                potpunoOut.add(N);
            } else {
                Narudzbina djel = new Narudzbina(N.id, N.prioritet);
                djel.stavke = back; // preostalo = backorder
                djelimicnoOut.add(djel);
            }
        }
    }

    // d) Iz djelimično isporučenih saberi nedostatke po SKU i sortiraj opadajuće po kolicini
    public static ArrayList<Stavka> generisiBackorder(ArrayList<Narudzbina> djelimicno) {
        ArrayList<Stavka> agg = new ArrayList<Stavka>();

        // saberi nedostatke po SKU
        for (int i = 0; i < djelimicno.size(); i++) {
            ArrayList<Stavka> L = djelimicno.get(i).stavke;
            for (int k = 0; k < L.size(); k++) {
                Stavka s = L.get(k);
                int idx = indeksSku(agg, s.sku);
                if (idx == -1) {
                    agg.add(new Stavka(s.sku, s.naziv, s.kolicina));
                } else {
                    agg.get(idx).kolicina += s.kolicina;
                }
            }
        }

        // bubble sort opadajuće po količini
        for (int i = 0; i < agg.size(); i++) {
            for (int j = 0; j + 1 < agg.size(); j++) {
                if (agg.get(j).kolicina < agg.get(j + 1).kolicina) {
                    Stavka t = agg.get(j);
                    agg.set(j, agg.get(j + 1));
                    agg.set(j + 1, t);
                }
            }
        }
        return agg;
    }

    // ===== DEMO =====
    public static void main(String[] args) {
        ArrayList<Stavka> lager = new ArrayList<Stavka>();
        lager.add(new Stavka("A1", "USB", 5));
        lager.add(new Stavka("A1", "USB", 2));
        lager.add(new Stavka("B2", "Kabl", 1));

        ArrayList<Narudzbina> nar = new ArrayList<Narudzbina>();
        Narudzbina n1 = new Narudzbina(2, 1);
        n1.stavke.add(new Stavka("A1","USB",4));
        Narudzbina n2 = new Narudzbina(1, 2);
        n2.stavke.add(new Stavka("A1","USB",5));
        n2.stavke.add(new Stavka("C3","Adapter",1));
        nar.add(n1);
        nar.add(n2);

        ArrayList<Narudzbina> potpuno = new ArrayList<Narudzbina>();
        ArrayList<Narudzbina> djelimicno = new ArrayList<Narudzbina>();

        ispuniNarudzbine(lager, nar, potpuno, djelimicno);

        System.out.println("Potpuno isporučene: " + potpuno);
        System.out.println("Djelimično isporučene: " + djelimicno);
        System.out.println("Backorder: " + generisiBackorder(djelimicno));
    }
}