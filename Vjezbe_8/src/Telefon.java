
public class Telefon extends EProizvodi {
	private String operativniSistem;
	private int velicinaEkrana;
	
	// Konstruktor
	public Telefon(String opisProizvoda, int sifraProizvoda, int uvoznaCijena, String operativniSistem,
			int velicinaEkrana) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijena);
		this.operativniSistem = operativniSistem;
		this.velicinaEkrana = velicinaEkrana;
	}

	//Getteri i setteri
	public String getOperativniSistem() {
		return operativniSistem;
	}
	public void setOperativniSistem(String operativniSistem) {
		this.operativniSistem = operativniSistem;
	}

	
	public int getVelicinaEkrana() {
		return velicinaEkrana;
	}
	public void setVelicinaEkrana(int velicinaEkrana) {
		this.velicinaEkrana = velicinaEkrana;
	}
	
	// Metoda obracun maloprodajne cijene za telefone
	@Override
	public double obracunMaloprodajneCijene(String sifraProizvoda, int velicinaEkrana) {
		double maloprodajnaCijena = getUvoznaCijena();
		if(velicinaEkrana > 6) {
			maloprodajnaCijena *= 1.03; // Telefon ako je ekran preko 6 inca +3%
		}
		return maloprodajnaCijena;
	}

}
