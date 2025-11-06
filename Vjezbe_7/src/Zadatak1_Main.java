// Glavna klasa

import java.util.ArrayList;

public class Zadatak1_Main {
	public static void main(String[] args) {
		
	
		// -----------------------------
		// Varijanta 1: korišćenje niza
		// -----------------------------
		System.out.println("=== VARIJANTA SA NIZOM ===");
		Proizvod[] proizvodi = new Proizvod[6];
		

		proizvodi[0] = new Garderoba("Muška jakna", "111-AAA", "Turska", 2024,
80.0, "pamuk", "jesen/zima");
		proizvodi[1] = new Garderoba("Ženska majica", "112-BBB", "Bangladeš",
2025, 12.0, "pamuk", "proljeće/ljeto");
		proizvodi[2] = new HemijskiProizvod("Sredstvo za čišćenje", "221-CCC",
"Poljska", 2025, 3.5, 20.0, false);
		proizvodi[3] = new HemijskiProizvod("Rastvarač X", "222-DDD",
"Njemačka", 2025, 9.0, 15.0, true);
		proizvodi[4] = new Hrana("Mlijeko 1L", "331-EEE", "Srbija", 2025, 0.7,
640, 2);
		proizvodi[5] = new Hrana("Maslinovo ulje 0.5L", "332-FFF", "Italija",
2024, 4.2, 4500, 12);
	
		prikaziProizvode(proizvodi);
		prikaziCijene(proizvodi);
		prikaziProsjek(proizvodi);
		
		// -----------------------------
		// Varijanta 2: korišćenje ArrayList
		// -----------------------------
		System.out.println("\n=== VARIJANTA SA ARRAYLIST ===");
		
		ArrayList<Proizvod> lista = new ArrayList<>();
		lista.add(new Garderoba("Muška jakna", "111-AAA", "Turska", 2024, 80.0,
"pamuk", "jesen/zima"));
		lista.add(new Garderoba("Ženska majica", "112-BBB", "Bangladeš", 2025,
12.0, "pamuk", "proljeće/ljeto"));
		lista.add(new HemijskiProizvod("Sredstvo za čišćenje", "221-CCC",
"Poljska", 2025, 3.5, 20.0, false));
		lista.add(new HemijskiProizvod("Rastvarač X", "222-DDD", "Njemačka",
2025, 9.0, 15.0, true));
		lista.add(new Hrana("Mlijeko 1L", "331-EEE", "Srbija", 2025, 0.7, 640,
2));
		lista.add(new Hrana("Maslinovo ulje 0.5L", "332-FFF", "Italija", 2024,
4.2, 4500, 12));
		
		prikaziProizvode(lista);
		prikaziCijene(lista);
		prikaziProsjek(lista);
		}
	
		// Metode za niz
		public static void prikaziProizvode(Proizvod[] niz) {
			for (Proizvod p : niz) System.out.println(p);
		}
		
		public static void prikaziCijene(Proizvod[] niz) {
			for (Proizvod p : niz)
				System.out.printf("%s | Maloprodajna cijena: %.2f€%n", p.getOpis(),
	p.izracunajMaloprodajnuCijenu());
		}
		
		public static void prikaziProsjek(Proizvod[] niz) {
			System.out.printf("Garderoba: %.2f€%n", prosjekZaGrupu(niz,
	"garderoba"));
			System.out.printf("Hemijski proizvodi: %.2f€%n", prosjekZaGrupu(niz,
	"hemijski"));
			System.out.printf("Hrana: %.2f€%n", prosjekZaGrupu(niz, "hrana"));
		}
		
		// Metode za array list
		public static void prikaziProizvode(ArrayList<Proizvod> lista) {
			for (Proizvod p : lista) System.out.println(p);
		}
		
		public static void prikaziCijene(ArrayList<Proizvod> lista) {
			for (Proizvod p : lista)
				System.out.printf("%s | Maloprodajna cijena: %.2f€%n", p.getOpis(),
	p.izracunajMaloprodajnuCijenu());
		}
		
		public static void prikaziProsjek(ArrayList<Proizvod> lista) {
			System.out.printf("Garderoba: %.2f€%n", prosjekZaGrupu(lista,
	"garderoba"));
			System.out.printf("Hemijski proizvodi: %.2f€%n", prosjekZaGrupu(lista,
	"hemijski"));
			System.out.printf("Hrana: %.2f€%n", prosjekZaGrupu(lista, "hrana"));
		}
		
		// Pomocne metode
		public static double prosjekZaGrupu(Proizvod[] niz, String grupa) {
			double suma = 0; int broj = 0;
			for (Proizvod p : niz)
				if (pripadaGrupi(p, grupa)) { suma += p.izracunajMaloprodajnuCijenu(); broj++; }
			return broj == 0 ? 0 : suma / broj;
		}
		
			public static double prosjekZaGrupu(ArrayList<Proizvod> lista, String grupa)
		{
			double suma = 0; int broj = 0;
			for (Proizvod p : lista)
				if (pripadaGrupi(p, grupa)) { suma += p.izracunajMaloprodajnuCijenu(); broj++; }
			return broj == 0 ? 0 : suma / broj;
		}
			
		private static boolean pripadaGrupi(Proizvod p, String grupa) {
			grupa = grupa.toLowerCase();
			if (grupa.equals("garderoba") && p instanceof Garderoba) return true;
			if (grupa.equals("hemijski") && p instanceof HemijskiProizvod) return true;
			if (grupa.equals("hrana") && p instanceof Hrana) return true;
			return false;
		}
	}

