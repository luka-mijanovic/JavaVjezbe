
public class Vozilo {
	private String proizvodjac;
	private int godinaProizvodnje;
	private int kubikaza;
	private String boja;
	
	//konstruktor
    public Vozilo(String proizvodjac, int godProizvodnje, int kubikaza, String boja) {
        this.proizvodjac = proizvodjac;
        this.godinaProizvodnje = godProizvodnje;
        this.kubikaza = kubikaza;
        this.boja = boja;
	}

	//getteri i setteri
	public String getProizvodjac() { return proizvodjac; }
	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public int getGodinaProizvodnje() {return godinaProizvodnje; }
	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}

	public int getKubikaza() { return kubikaza; }
	public void setKubikaza(int kubikaza) {
		this.kubikaza = kubikaza;
	}

	public String getBoja() { return boja; }
	public void setBoja(String boja) {
		this.boja = boja;
	}
	
	//registracija
    public double racunajRegistraciju() {
        double cijena = 100;

        if (godinaProizvodnje < 2010)
            cijena += 30;

        if (kubikaza > 2000)
            cijena += 50;

        return cijena;
    }
    //ispis podataka
    public void ispisiPodatke() {
        System.out.println("Proizvođač: " + proizvodjac);
        System.out.println("Godina proizvodnje: " + godinaProizvodnje);
        System.out.println("Kubikaža: " + kubikaza);
        System.out.println("Boja: " + boja);
    }
    
}