public class Menadzer extends Zaposleni {
	private static final double fiksniIznos = 1300.0;

	// Konstruktor
	public Menadzer(int iD, String ime, String prezime, double plataPoSatu, double ukupanBrojSati, double bonus) {
		super(iD, ime, prezime, plataPoSatu, ukupanBrojSati);
		setBonus(bonus);
	}

	// Metoda za obracun plate
	@Override
	public double izracunajPlatu() {
		// Nadjena logika iz originalne datoteke: mnozenje sedmicnih sati preko 4 sedmice
		double osnovnaPlata = getUkupanBrojSati() * getPlataPoSatu() * 4;
		return osnovnaPlata + fiksniIznos + getBonus();
	}
}