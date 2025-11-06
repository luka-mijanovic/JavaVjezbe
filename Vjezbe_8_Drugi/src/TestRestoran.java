
public class TestRestoran {
    public static void main(String[] args) {
        Restoran r = new Restoran("Bistro Cetinje", "Njegoševa 12", "PIB-123456");

        Konobari k1 = new Konobari(101, "Marko", "Radovic", 5.0, 0);
        Konobari k2 = new Konobari(102, "Ana", "Jovanovic", 5.0, 0);
        Kuvari   ku1 = new Kuvari(201, "Milo", "Kovacevic", 6.0, 0);
        Kuvari   ku2 = new Kuvari(202, "Ivana", "Petrovic", 6.0, 0);
        Menadzer m1  = new Menadzer(301, "Luka", "Mijanovic", 10.0, 0, 120.0);

        k1.setUkupanBrojSati(168); k1.setPrekovremeniSati(8);  k1.setBonus(20);
        k2.setUkupanBrojSati(150); k2.setPrekovremeniSati(0);  k2.setBonus(0);
        ku1.setUkupanBrojSati(175); ku1.setPrekovremeniSati(5); ku1.setBonus(50);
        ku2.setUkupanBrojSati(160); ku2.setPrekovremeniSati(0); ku2.setBonus(0);
        m1.setUkupanBrojSati(180);

        r.dodajZaposlenog(k1);
        r.dodajZaposlenog(k2);
        r.dodajZaposlenog(ku1);
        r.dodajZaposlenog(ku2);
        r.dodajZaposlenog(m1);

        System.out.println("\n--- OBRACUN (bez smjena) ---");
        r.mjesecniTrosakPlata(11, 2025);

        Smjena s1 = new Smjena("2025-11-05", Smjena.parseHHMMuMinute("08:00"), Smjena.parseHHMMuMinute("16:00"), "jutarnja");
        s1.zaposleniIds.add(101);
        s1.zaposleniIds.add(201);

        Smjena s2 = new Smjena("2025-11-05", Smjena.parseHHMMuMinute("16:00"), Smjena.parseHHMMuMinute("22:00"), "popodnevna");
        s2.zaposleniIds.add(102);
        s2.zaposleniIds.add(202);

        Smjena s3 = new Smjena("2025-11-06", Smjena.parseHHMMuMinute("08:00"), Smjena.parseHHMMuMinute("16:00"), "jutarnja");
        s3.zaposleniIds.add(101);
        s3.zaposleniIds.add(201);

        r.dodajSmjenu(s1);
        r.dodajSmjenu(s2);
        r.dodajSmjenu(s3);

        System.out.println("\n--- OBRACUN (sa smjenama) ---");
        r.mjesecniTrosakPlata(11, 2025);

        // Pretraga i uklanjanje
        System.out.println("\nPronadji 201: " + r.pronadjiPoId(201));
        System.out.println("Ukloni 202: " + r.ukloniZaposlenogPoId(202));
        System.out.println("Pronadji 202: " + r.pronadjiPoId(202));
    }
}