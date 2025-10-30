
public class Automobil extends Vozilo {
	private int brojVrata;	    
	private String tipMotora;

	    //konstruktor
	    public Automobil(String proizvodjac, int godProizvodnje, int kubikaza, String boja,
	                     int brojVrata, String tipMotora) {
	        super(proizvodjac, godProizvodnje, kubikaza, boja);
	        this.brojVrata = brojVrata;
	        this.tipMotora = tipMotora;
	    }

	    //getteri i setteri
	    public int getBrojVrata() { return brojVrata; }
		public void setBrojVrata(int brojVrata) {
			this.brojVrata = brojVrata;
		}

		
		public String getTipMotora() { return tipMotora; }
		public void setTipMotora(String tipMotora) {
			this.tipMotora = tipMotora;
		}

		//registracija
	    @Override
	    public double racunajRegistraciju() {
	        double cijena = super.racunajRegistraciju();

	        if (tipMotora.equalsIgnoreCase("dizel"))
	            cijena += 20;

	        return cijena;
	    } 
	    //ispis podataka
		@Override
	    public void ispisiPodatke() {
	        super.ispisiPodatke();
	        System.out.println("Broj vrata: " + brojVrata);
	        System.out.println("Tip motora: " + tipMotora);
	        System.out.println("Cijena registracije: " + racunajRegistraciju() + "e");
	    }
	}

