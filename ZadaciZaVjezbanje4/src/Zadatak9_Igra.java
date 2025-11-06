/*
Glavni program za Zadatak 9: kreira turnir, dodaje igrače, pokreće runde, prikazuje najboljeg.
*/
public class Zadatak9_Igra {
    public static void main(String[] args) {
        Turnir t = new Turnir("UDG Open", 1);
        t.dodajIgraca("Ana");
        t.dodajIgraca("Marko");
        t.dodajIgraca("Mia");
        t.dodajIgraca("Luka");

        t.stampajStanje();
        t.pokreniRundu();
        t.stampajStanje();
        t.prikaziNajboljegIgraca();
    }
}