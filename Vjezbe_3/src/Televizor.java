
public class Televizor {
	private int brojKanala;
	private String nazivKanala;
	private int jacinaTona;
	
	//Konstruktor
	public Televizor(int brojKanala, String nazivKanala, int jacinaTona) {
		
		if (brojKanala >= 1) this.brojKanala = brojKanala;
		else this.brojKanala = 1;
		if (jacinaTona >= 0 && jacinaTona <= 10) {
			this.jacinaTona = jacinaTona;}
		else this.jacinaTona = 5;
	}
	//Getteri
	public int getBrojKanala() { return brojKanala; }
	public String getNazivKanala() { return nazivKanala; }
	public int getJacinaTona() { return jacinaTona; }
	//Setteri
	
	
	//Metod za pojacavanje tona
	public void pojacajTon() {
		if (jacinaTona < 10) {
			jacinaTona ++;
		} else {
			System.out.println("Ton je već na maksimum (10).");
		}
	}
	//Ispis
	public void ispisi() {
		System.out.println("Kanal " + brojKanala + "Naziv kanala " + nazivKanala);
	}
	
	
	public static void main(String[] args) {
		Televizor tv = new Televizor(1, "RTCG", 5);
	}

}
