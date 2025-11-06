
public class EProizvodi {
	private String opisProizvoda;
	private int sifraProizvoda;
	private int uvoznaCijena;
	
	//Konstruktori
	public EProizvodi(String opisProizvoda, int sifraProizvoda, int uvoznaCijena) {
		super();
		this.opisProizvoda = opisProizvoda;
		this.sifraProizvoda = sifraProizvoda;
		this.uvoznaCijena = uvoznaCijena;
	}

	//Getteri i setteri
	public String getOpisProizvoda() {
		return opisProizvoda;
	}
	public void setOpisProizvoda(String opisProizvoda) {
		this.opisProizvoda = opisProizvoda;
	}

	
	public int getSifraProizvoda() {
		return sifraProizvoda;
	}
	public void setSifraProizvoda(int sifraProizvoda) {
		this.sifraProizvoda = sifraProizvoda;
	}

	
	public int getUvoznaCijena() {
		return uvoznaCijena;
	}
	public void setUvoznaCijena(int uvoznaCijena) {
		this.uvoznaCijena = uvoznaCijena;
	}
	
	//Metoda obracun maloprodajna cijene. uvecati za 5% u zavisnosti od tipa proizvoda
	//racunari +5% , telefon ako je ekran preko 6 inca +3%, tv +10% ako je preko 65 inca
	public double obracunMaloprodajneCijene(String sifraProizvoda, int velicinaEkrana) {
		double maloprodajnaCijena = uvoznaCijena;
		switch(sifraProizvoda.toLowerCase()) {
			case "RA":
				maloprodajnaCijena *= 1.05;
				break;
			case "TE":
				if(velicinaEkrana > 6) {
					maloprodajnaCijena *= 1.03;
				}
				break;
			case "TV":
				if(velicinaEkrana > 65) {
					maloprodajnaCijena *= 1.10;
				}
				break;
			default:
				System.out.println("Nema tip proizvoda.");
		}
		return maloprodajnaCijena;
	}
	
	//metoda koja stampa odredjenu grupu proizvoda, kao parametar prima niz uredaja i string tip uredaja
	//vraca sve uredaje tog tipa
	public static void stampaProizvodePoTipu(EProizvodi[] proizvodi, String sifraProizvoda) {
		System.out.println("Proizvodi tipa: " + sifraProizvoda);
		for(EProizvodi proizvod : proizvodi) {
			if(proizvod.getOpisProizvoda().toLowerCase().contains(sifraProizvoda.toLowerCase())) {
				System.out.println("Sifra: " + proizvod.getSifraProizvoda() + ", Opis: " + proizvod.getOpisProizvoda() + ", Uvozna cijena: " + proizvod.getUvoznaCijena());
			}
		}
	}
	
}
