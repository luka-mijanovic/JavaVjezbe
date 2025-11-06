
public class Kuvari extends Zaposleni {
	private static final double fiksniIznos = 1500.0;

	// Konstruktor
	public Kuvari(int iD, String ime, String prezime, double plataPoSatu, int ukupanBrojSati) {
		super(iD, ime, prezime, plataPoSatu, ukupanBrojSati);
	}

	// Metoda za obracun plate
	public double obracunPlate() {
		double osnovnaPlata = getUkupanBrojSati() * getPlataPoSatu() * 4;
		return osnovnaPlata + fiksniIznos;
	}

	@Override
	public double izracunajPlatu() {
		// TODO Auto-generated method stub
		return 0;
	}

}
