
public class TV extends EProizvodi {
	private int velicinaEkrana;

	// Konstruktor
	public TV(String opisProizvoda, int sifraProizvoda, int uvoznaCijena, int velicinaEkrana) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijena);
		this.velicinaEkrana = velicinaEkrana;
	}

	//Getteri i setteri
	public int getVelicinaEkrana() {
		return velicinaEkrana;
	}
	public void setVelicinaEkrana(int velicinaEkrana) {
		this.velicinaEkrana = velicinaEkrana;
	}
	
	// Metoda obracun maloprodajne cijene za TV
	@Override
	public double obracunMaloprodajneCijene(String sifraProizvoda, int velicinaEkrana) {
		double maloprodajnaCijena = getUvoznaCijena();
		if(velicinaEkrana > 65) {
			maloprodajnaCijena *= 1.10; // TV +10% ako je preko 65 inca
		}
		return maloprodajnaCijena;
	}
	

}
