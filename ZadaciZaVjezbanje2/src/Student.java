 
/*
ZADATAK 2 (Student)
Upravljanje studentima: ime, prezime, broj indeksa + 3 ocjene.
a) U testnoj klasi dodati nekoliko studenata i informacije.
b) Izračunati prosjek; ako je prosjek > 9, student ostvaruje pravo na studentski kredit.
c) Na kraju, (statički) odštampati spisak u formatu: (Ime, Prezime, Stipendija (Da/Ne)).
NAPOMENA: Ne koristiti nizove (arrays). Dozvoljen je mali broj studenata i korišćenje ArrayList.
*/

import java.util.ArrayList;

public class Student {
    private String ime, prezime, indeks;
    private int oc1, oc2, oc3;

    // statička lista za zajednički spisak (nije niz!)
    private static ArrayList<String> spisak = new ArrayList<String>();

    public Student(String ime, String prezime, String indeks, int oc1, int oc2, int oc3) {
        this.ime = ime;
        this.prezime = prezime;
        this.indeks = indeks;
        this.oc1 = oc1; this.oc2 = oc2; this.oc3 = oc3;
    }

    public double prosjek() {
        // prosjek tri ocjene (cijeli u double sabiranju radi preciznosti)
        return (oc1 + oc2 + oc3) / 3.0;
    }

    public boolean imaStipendiju() {
        return prosjek() > 9.0;
    }

    public void dodajUSpisak() {
        String stavka = "(" + ime + ", " + prezime + ", Stipendija " + (imaStipendiju() ? "Da" : "Ne") + ")";
        spisak.add(stavka);
    }

    public static void odstampajSpisak() {
        System.out.println("--- SPISAK STUDENATA ---");
        for (int i = 0; i < spisak.size(); i++) {
            System.out.println(spisak.get(i));
        }
    }
}

// Test bez nizova: ručno dodajemo 3-4 studenta i koristimo ArrayList unutar klase
class StudentskaSluzbaTest {
    public static void main(String[] args) {
        Student s1 = new Student("Ana", "Marković", "IB123/21", 10, 9, 10);
        Student s2 = new Student("Petar", "Jovanović", "IB124/21", 8, 9, 9);
        Student s3 = new Student("Mila", "Nikolić", "IB125/21", 10, 10, 10);

        s1.dodajUSpisak();
        s2.dodajUSpisak();
        s3.dodajUSpisak();

        Student.odstampajSpisak();
    }
}


