public abstract class Zaposleni {
	private int ID;
	private String ime;
	private String prezime;
	private double plataPoSatu;
	private double ukupanBrojSati;

	private int prekovremeniSati;
	private double bonus;

	//Konstruktor
	public Zaposleni(int iD, String ime, String prezime, double plataPoSatu, double ukupanBrojSati) {
		super();
		ID = iD;
		this.ime = ime;
		this.prezime = prezime;
		this.plataPoSatu = plataPoSatu;
		this.ukupanBrojSati = ukupanBrojSati;
		this.prekovremeniSati = 0;
		this.bonus = 0;
	}

	//Getteri i setteri
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}

	
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	
	public double getPlataPoSatu() {
		return plataPoSatu;
	}
	public void setPlataPoSatu(double plataPoSatu) {
		this.plataPoSatu = plataPoSatu;
	}

	
	public double getUkupanBrojSati() {
		return ukupanBrojSati;
	}
	public void setUkupanBrojSati(double ukupanBrojSati) {
		this.ukupanBrojSati = ukupanBrojSati;
	}

	public int getPrekovremeniSati() {
		return prekovremeniSati;
	}

	public void setPrekovremeniSati(int prekovremeniSati) {
		this.prekovremeniSati = prekovremeniSati;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public String getTip() {
		return this.getClass().getSimpleName();
	}

	public abstract double izracunajPlatu();

}