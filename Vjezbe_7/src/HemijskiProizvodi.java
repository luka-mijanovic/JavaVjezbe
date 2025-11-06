// Klasa za hemijske proizvode
class HemijskiProizvod extends Proizvod {
	private double temperaturaSkladistenja;
	private boolean zapaljivo;
public HemijskiProizvod(String opis, String barkod, String
zemljaProizvodnje, int godinaProizvodnje, double uvoznaCijena, double
temperaturaSkladistenja, boolean zapaljivo) {
		super(opis, barkod, zemljaProizvodnje, godinaProizvodnje, uvoznaCijena);
		this.temperaturaSkladistenja = temperaturaSkladistenja;
		this.zapaljivo = zapaljivo;
	}
	public double izracunajMaloprodajnuCijenu() {
		double faktor = zapaljivo ? 1.125 : 1.10;
		return getUvoznaCijena() * faktor;
	}
	public String toString() {
		return "[Hemijski] " + osnovneInfo() +
				" | Temp. skladištenja: " + temperaturaSkladistenja +
				"°C | Zapaljivo: " + (zapaljivo ? "da" : "ne");
	}
}