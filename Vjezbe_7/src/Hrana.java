// Klasa Hrana
class Hrana extends Proizvod {
	private int brojKalorija;
	private int mjeseciDoRoka; // broj mjeseci do isteka roka
	public Hrana(String opis, String barkod, String zemljaProizvodnje, int
godinaProizvodnje, double uvoznaCijena, int brojKalorija, int mjeseciDoRoka) {
		super(opis, barkod, zemljaProizvodnje, godinaProizvodnje, uvoznaCijena);
		this.brojKalorija = brojKalorija;
		this.mjeseciDoRoka = mjeseciDoRoka;
	}
	public double izracunajMaloprodajnuCijenu() {
		double faktor = (mjeseciDoRoka < 6) ? 1.05 : 1.10;
		return getUvoznaCijena() * faktor;
	}
	public String toString() {
		return "[Hrana] " + osnovneInfo() +
			" | Kalorije: " + brojKalorija +
			" | Rok (mjeseci): " + mjeseciDoRoka;
	}
}
