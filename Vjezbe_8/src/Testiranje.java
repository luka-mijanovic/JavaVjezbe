import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Testiranje {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<EProizvodi> proizvodi = new ArrayList<>();
		boolean running = true;
		while (running) {
			System.out.println("\nIzaberite opciju:");
			System.out.println("1 - Unos uredjaja");
			System.out.println("2 - Pregled svih uredjaja sa maloprodajnom cijenom");
			System.out.println("3 - Pregled svih uredjaja odredjenog tipa");
			System.out.print("Opcija: ");
			int opcija;
			try {
				opcija = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Neispravan unos. Pokusajte ponovo.");
				continue;
			}

			switch (opcija) {
			case 1:
				unosUredjaja(sc, proizvodi);
				break;
			case 2:
				pregledSvihSaMaloprodajnom(proizvodi);
				break;
			case 3:
				pregledPoTipu(sc, proizvodi);
				break;
			case 0:
				running = false;
				break;
			default:
				System.out.println("Nepoznata opcija.");
			}
		}
		sc.close();
		System.out.println("Kraj programa.");
	}

	private static void unosUredjaja(Scanner sc, List<EProizvodi> proizvodi) {
		System.out.println("Izaberite tip uredjaja: 1-Racunari, 2-Telefon, 3-TV");
		System.out.print("Tip: ");
		int tip;
		try {
			tip = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Neispravan unos tipa.");
			return;
		}

		System.out.print("Opis proizvoda: ");
		String opis = sc.nextLine();
		System.out.print("Sifra proizvoda (int): ");
		int sifra;
		try {
			sifra = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Neispravna sifra.");
			return;
		}
		System.out.print("Uvozna cijena (int): ");
		int uvozna;
		try {
			uvozna = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Neispravna cijena.");
			return;
		}

		switch (tip) {
		case 1:
			System.out.print("Procesor: ");
			String proc = sc.nextLine();
			System.out.print("Memorija (GB): ");
			int mem;
			try {
				mem = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Neispravan broj memorije.");
				return;
			}
			proizvodi.add(new Racunari(opis, sifra, uvozna, proc, mem));
			System.out.println("Racunari dodati.");
			break;
		case 2:
			System.out.print("Operativni sistem: ");
			String os = sc.nextLine();
			System.out.print("Velicina ekrana (incha): ");
			int vel;
			try {
				vel = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Neispravan broj za ekran.");
				return;
			}
			proizvodi.add(new Telefon(opis, sifra, uvozna, os, vel));
			System.out.println("Telefon dodan.");
			break;
		case 3:
			System.out.print("Velicina ekrana (incha): ");
			int velTV;
			try {
				velTV = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Neispravan broj za ekran.");
				return;
			}
			proizvodi.add(new TV(opis, sifra, uvozna, velTV));
			System.out.println("TV dodat.");
			break;
		default:
			System.out.println("Nepoznat tip.");
		}
	}

	private static void pregledSvihSaMaloprodajnom(List<EProizvodi> proizvodi) {
		if (proizvodi.isEmpty()) {
			System.out.println("Nema proizvoda.");
			return;
		}
		System.out.println("\nLista proizvoda sa maloprodajnom cijenom:");
		for (EProizvodi p : proizvodi) {
			String tip = "Nepoznat";
			int vel = 0;
			String sifraTip = "";
			if (p instanceof Racunari) {
				tip = "Racunari";
				sifraTip = "RA";
			} else if (p instanceof Telefon) {
				tip = "Telefon";
				vel = ((Telefon) p).getVelicinaEkrana();
				sifraTip = "TE";
			} else if (p instanceof TV) {
				tip = "TV";
				vel = ((TV) p).getVelicinaEkrana();
				sifraTip = "TV";
			}
			double maloprod = p.obracunMaloprodajneCijene(sifraTip, vel);
			System.out.printf("Tip: %s, Opis: %s, Sifra: %d, Uvozna: %d, Maloprodajna: %.2f\n",
				tip, p.getOpisProizvoda(), p.getSifraProizvoda(), p.getUvoznaCijena(), maloprod);
		}
	}

	private static void pregledPoTipu(Scanner sc, List<EProizvodi> proizvodi) {
		System.out.println("Unesite tip za prikaz: 1-Racunari, 2-Telefon, 3-TV");
		System.out.print("Tip: ");
		int tip;
		try {
			tip = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Neispravan unos.");
			return;
		}
		String trazeni = "";
		switch (tip) {
		case 1:
			trazeni = "Racunari";
			break;
		case 2:
			trazeni = "Telefon";
			break;
		case 3:
			trazeni = "TV";
			break;
		default:
			System.out.println("Nepoznat tip.");
			return;
		}
		System.out.println("\nProizvodi tipa: " + trazeni);
		boolean found = false;
		for (EProizvodi p : proizvodi) {
			if ((trazeni.equals("Racunari") && p instanceof Racunari)
					|| (trazeni.equals("Telefon") && p instanceof Telefon)
					|| (trazeni.equals("TV") && p instanceof TV)) {
				found = true;
				System.out.printf("Opis: %s, Sifra: %d, Uvozna: %d\n",
					p.getOpisProizvoda(), p.getSifraProizvoda(), p.getUvoznaCijena());
			}
		}
		if (!found) {
			System.out.println("Nema proizvoda tog tipa.");
		}
	}

}