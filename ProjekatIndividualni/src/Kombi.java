
public class Kombi extends Vozilo {
    private int kapacitetPutnika;

    //konstruktor
    public Kombi(String proizvodjac, int godProizvodnje, int kubikaza, String boja,
                 int kapacitetPutnika) {
        super(proizvodjac, godProizvodnje, kubikaza, boja);
        this.kapacitetPutnika = kapacitetPutnika;
    }
    
    //getteri i setteri
    public int getKapacitetPutnika() { return kapacitetPutnika; }
	public void setKapacitetPutnika(int kapacitetPutnika) {
		this.kapacitetPutnika = kapacitetPutnika;
	}

	//cijena
    @Override
    public double racunajRegistraciju() {
        double cijena = super.racunajRegistraciju();

        if (kapacitetPutnika > 8)
            cijena += 30;

        return cijena;
    }
    
    //ispis
	@Override
    public void ispisiPodatke() {
        super.ispisiPodatke();
        System.out.println("Kapacitet putnika: " + kapacitetPutnika);
        System.out.println("Cijena registracije: " + racunajRegistraciju() + "e");
    }
}