/*Kreirati klasu Auto koja sadrži sledeće atribute: markaAuta, godišteAuta,
snagaMotora, prodato (da/ne), kubikažaMotora, registrovan(da/ne). Povesti računa
o tipovima podataka koje atributi uzimaju. Kreirati odgovarajuće getere i setere.
Kreirati konstruktorsku metodu koristeći this referencu. Ukoliko je godište auta
starije od 1985. godine, auto se ne može registrovati, stoga prilikom pozivanja
konstruktorske metode treba povesti računa o atributu registrovan. Precrtati
(@override) toString metodu koja štampa objekat klase Auto, formatirati po želji.
Kreirati i statički atribut klase koji prati koliko ima prodatih auta. Kreirati statičku
metodu klase koja vraće listu auta koja se mogu registrovati a koja nijesu
registrovana. Kreirati statičku metodu kojom se računa iznos registracije svih auta,
ukoliko se auto može registrovati. Neka formula za računanje iznosa registracije
bude: koeficijentGodišta*kubikaža*snagaMotora, gdje je koeficijent godišta
predstavljen u sledećoj tabeli:
Godište        Koeficijent
1985-2000    3.0
2001-2010    2.0
poslije 2010.  1.5
Kreirati testnu klasu sa makar 5 objekata. Testirati štampanje objekata, štampanje
objekata koji zadovoljavaju uslov za registraciju, i štampati iznos cijene registracije za
ta auta.
 */
public class Auto {
	private String markaAuta;
	private int godisteAuta;
	private int snagaMotora;
	private boolean prodato;
	private int kubikazaMotora;
	private boolean registrovan;
	private static int brojProdatih = 0;
	
	//konstruktori
	public Auto(String markaAuta, int godisteAuta, int snagaMotora, boolean prodato, int kubikazaMotora,
			boolean registrovan) {
		super();
		this.markaAuta = markaAuta;
		this.godisteAuta = godisteAuta;
		this.snagaMotora = snagaMotora;
		this.prodato = prodato;
		this.kubikazaMotora = kubikazaMotora;
		if (prodato) brojProdatih++;
		this.registrovan = godisteAuta < 1985 ? false: registrovan;
	}
	
	//getteri i setteri

	public String getMarkaAuta() { return markaAuta; }
	public void setMarkaAuta(String markaAuta) { this.markaAuta = markaAuta; }

	
	public int getGodisteAuta() {
		return godisteAuta;
	}
	public void setGodisteAuta(int godisteAuta) {
		this.godisteAuta = godisteAuta;
		if (godisteAuta < 1985) this.registrovan = false;
	}

	
	public int getSnagaMotora() {
		return snagaMotora;
	}
	public void setSnagaMotora(int snagaMotora) {
		this.snagaMotora = snagaMotora;
	}

	
	public boolean isProdato() {
		return prodato;
	}
	public void setProdato(boolean prodato) {
		if (this.prodato != prodato && prodato) brojProdatih++;
		this.prodato = prodato;
	}

	
	public int getKubikazaMotora() {
		return kubikazaMotora;
	}
	public void setKubikazaMotora(int kubikazaMotora) {
		this.kubikazaMotora = kubikazaMotora;
	}

	
	public boolean isRegistrovan() {
		return registrovan;
	}
	public void setRegistrovan(boolean registrovan) {
		if (this.godisteAuta >= 1985) this.registrovan = registrovan;
	}
	
	public static int getBrojProdatih() { return brojProdatih;}
	public boolean mozeSeRegistrovati() {
		return godisteAuta >= 1985;
	}
	public static double koeficijentZaGodiste(int godiste) {
		if (godiste < 1985) return 0.0;
		if (godiste <= 2000) return 3.0;
		if (godiste <= 2010) return 2.0;
		return 1.5;
	}
	public double cijenaRegistracije() {
		if (!mozeSeRegistrovati()) return 0.0;
		return koeficijentZaGodiste(godisteAuta) * kubikazaMotora * snagaMotora;
	}

	@Override
	public String toString() {
		return String.format("Auto [marka=%s, godiste=%d, snaga=%.1f, kubikaza=%.1f, registrovan=%s, prodat=%f",
				markaAuta, godisteAuta, snagaMotora, kubikazaMotora,
				registrovan ? "da" : "ne",
				prodato ? "da" : "ne",
				cijenaRegistracije());
	}
	
	
	
}
