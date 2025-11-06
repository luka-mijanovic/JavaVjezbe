
public class Racunari extends EProizvodi {
	private String procesor;
	private int memorija;
	
	//Konstruktor
	public Racunari(String opisProizvoda, int sifraProizvoda, int uvoznaCijena, String procesor, int memorija) {
		super(opisProizvoda, sifraProizvoda, uvoznaCijena);
		this.procesor = procesor;
		this.memorija = memorija;
	}
	
	// Getteri i setteri
	public String getProcesor() {
		return procesor;
	}
	public void setProcesor(String procesor) {
		this.procesor = procesor;
	}


	public int getMemorija() {
		return memorija;
	}
	public void setMemorija(int memorija) {
		this.memorija = memorija;
	}


	// Metoda obracun maloprodajne cijene za racunare
	@Override
	public double obracunMaloprodajneCijene(String sifraProizvoda, int velicinaEkrana) {
		double maloprodajnaCijena = getUvoznaCijena();
		maloprodajnaCijena *= 1.05; // Racunari +5%
		return maloprodajnaCijena;
	}

}
