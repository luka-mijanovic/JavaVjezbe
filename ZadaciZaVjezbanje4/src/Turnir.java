import java.util.ArrayList;
import java.util.Random;

/*
ZADATAK 9 (Turnir)
Napisati klasu Turnir koja se sastoji od sljedećih atributa: nazivTurnira (string),
listaIgrača (niz parova oblika [ime, brojBodova], par kao niz od 2 elementa),
brojRundi (integer). Potrebno je implementirati sljedeće funkcionalnosti:
a. Konstruktor klase Turnir koji postavlja početne vrijednosti atributa
nazivTurnira, listaIgrača, brojIgrača i brojRundi. Atribut listaIgrača treba
da bude prazna lista.
b. Getteri i setteri za sve atribute klase. Obratiti pažnju na ograničenja
atributa brojRundi čija vrijednost je veća od 0, a manja od 10.
c. Metod dodajIgrača sa parametrom imeIgrača koja dodaje novog igrača
(par) u listu/niz igrača turnira tako da je brojBodova inicijalno 0.
d. Metod obrišiIgrača sa parametrom imeIgrača kojom se briše igrač na
osnovu unesenog imena.
e. Metod pokreniRundu koja simulira odigravanje jedne runde između dva
igrača. Funkcija treba da prikaže ishod runde i par igrača u jednoj
rudni. Na kraju treba uvećati broj odigranih rundi za 1. Za rudnu se
nasumično iz liste/niza igrača biraju 2 igrača. U jednoj rundi igrač koji
ima više bodova pobjeđuje sa vjerovatnoćom od 60% u odnosu na
protivnika. Napomena: importovati Random iz util paketa. Nakon toga:
Random random = new Random();
int randomNumber = random.nextInt(10) + 1;//ovo ce generisati
random broj izmedju 1 i 10.
f. Metod prikaziNajboljegIgrača koja prikazuje ime igrača koji je na putu
da osvoji turnir. To je igrač sa najvećim brojem bodova.
g. Metod prikaziNajboljegIgrača koja prikazuje ime igrača koji je na putu
da osvoji turnir. To je igrač sa najvećim brojem bodova
Turnir: nazivTurnira, listaIgrača (parovi ime/bodovi), brojRundi (0<r<10).
Funkcije: dodaj, obriši, pokreniRundu (nasumično bira 2 igrača; 60% prednost jačeg), prikaziNajboljegIgrača.
*/
public class Turnir {
    private String nazivTurnira;
    private ArrayList<Igrac> listaIgraca = new ArrayList<Igrac>();
    private int brojRundi;

    public Turnir(String nazivTurnira, int brojRundi) {
        this.nazivTurnira = nazivTurnira;
        this.brojRundi = (brojRundi > 0 && brojRundi < 10) ? brojRundi : 1;
    }

    public String getNazivTurnira(){ return nazivTurnira; }
    public int getBrojRundi(){ return brojRundi; }
    public ArrayList<Igrac> getListaIgraca(){ return listaIgraca; }

    public void setNazivTurnira(String n){ nazivTurnira = n; }
    public void setBrojRundi(int br){ if (br>0 && br<10) brojRundi = br; }

    public void dodajIgraca(String ime){ listaIgraca.add(new Igrac(ime)); }

    public void obrisiIgraca(String ime){
        for (int i=0;i<listaIgraca.size();i++)
            if (listaIgraca.get(i).ime.equals(ime)) { listaIgraca.remove(i); return; }
    }

    public void pokreniRundu() {
        if (listaIgraca.size() < 2) { System.out.println("Nema dovoljno igraca."); return; }
        Random rnd = new Random();
        int i = rnd.nextInt(listaIgraca.size());
        int j = rnd.nextInt(listaIgraca.size());
        while (j == i) j = rnd.nextInt(listaIgraca.size());

        Igrac A = listaIgraca.get(i);
        Igrac B = listaIgraca.get(j);

        int roll = rnd.nextInt(10) + 1; // 1..10
        boolean aPobjeđuje;
        if (A.bodovi > B.bodovi) aPobjeđuje = (roll <= 6);
        else if (B.bodovi > A.bodovi) aPobjeđuje = !(roll <= 6);
        else aPobjeđuje = (roll <= 5);

        if (aPobjeđuje) {
            A.bodovi++;
            System.out.println("Runda: " + A.ime + " pobjeđuje protiv " + B.ime);
        } else {
            B.bodovi++;
            System.out.println("Runda: " + B.ime + " pobjeđuje protiv " + A.ime);
        }
        brojRundi++;
    }

    public void prikaziNajboljegIgraca() {
        if (listaIgraca.size()==0) { System.out.println("Nema igraca."); return; }
        Igrac best = listaIgraca.get(0);
        for (int i=1;i<listaIgraca.size();i++)
            if (listaIgraca.get(i).bodovi > best.bodovi) best = listaIgraca.get(i);
        System.out.println("Najbolji: " + best.ime + " (" + best.bodovi + " bodova)");
    }

    public void stampajStanje() {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<listaIgraca.size();i++){
            if (i>0) sb.append(", ");
            sb.append(listaIgraca.get(i).toString());
        }
        System.out.println("Turnir " + nazivTurnira + ": " + sb.toString());
    }
}