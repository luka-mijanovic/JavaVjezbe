// Klasa za garderobu
class Garderoba extends Proizvod {
	private String materijal;
	private String sezona;
	public Garderoba(String opis, String barkod, String zemljaProizvodnje, int
godinaProizvodnje, double uvoznaCijena, String materijal, String sezona) {
		super(opis, barkod, zemljaProizvodnje, godinaProizvodnje, uvoznaCijena);
		this.materijal = materijal;
		this.sezona = sezona;
	}
	public double izracunajMaloprodajnuCijenu() {
		return getUvoznaCijena() * 1.05;
	}
	public String toString() {
		return "[Garderoba] " + osnovneInfo() + " | Materijal: " + materijal + "| Sezona: " + sezona;
	}
}
