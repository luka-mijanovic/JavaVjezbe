/*
ZADATAK 11 (Lager i narudžbine) — dio: Stavka
Tekst (sažeto):
Napraviti klase Stavka(sku, naziv, kolicina) i Narudzbina(id, prioritet,
ArrayList<Stavka> stavke). Data su: ArrayList<Stavka> lager i
ArrayList<Narudzbina> narudzbine. Kreirati sledece metode:
a. konsolidujLager - spojiti stavke istog sku u lageru (saberi količine) i
ukloniti nule/negativne.
b. ispuniNarudzbine - isporučiti što je moguće više stavki po poretku: veći
prioritet pa manji id. Vratiti dvije liste narudžbina: potpuno isporučene i
djelimično isporučene (sa preostalim stavkama označenim kao
backorder).
c. generisiBackorder - iz djelimično isporučenih izračunati ukupno
nedostajuće količine po sku i vratiti kao ArrayList<Stavka> sortirano
opadajuće po nedostatku.
Napraviti klase Stavka(sku, naziv, kolicina) i Narudzbina(id, prioritet, ArrayList<Stavka> stavke).
Data su: ArrayList<Stavka> lager i ArrayList<Narudzbina> narudzbine.
Metode:
a) konsolidujLager — spoji stavke istog sku (saberi količine), ukloni one sa kolicina<=0
b) ispuniNarudzbine — isporuči što je moguće više: veći prioritet, pa manji id.
   Vraćaju se dvije liste: potpuno isporučene i djelimično isporučene (preostale stavke=backorder).
c) generisiBackorder — iz djelimično isporučenih saberi ukupne nedostatke po sku
   i vrati listu Stavka sortiranu opadajuće po kolicini (nedostatku).
*/

public class Stavka {
    String sku;
    String naziv;
    int kolicina;

    public Stavka(String sku, String naziv, int kolicina) {
        this.sku = sku;
        this.naziv = naziv;
        this.kolicina = kolicina;
    }

    public String toString() {
        return sku + "(" + naziv + ") x" + kolicina;
    }
}