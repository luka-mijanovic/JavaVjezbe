
public class Kamion extends Vozilo {	    
	private double kapacitetTereta; 
	private boolean prikolica;      

	    //konstruktoe    
	public Kamion(String proizvodjac, int godProizvodnje, int kubikaza, String boja,
	        double kapacitetTereta, boolean prikolica) {	        
		super(proizvodjac, godProizvodnje, kubikaza, boja);	        
		this.kapacitetTereta = kapacitetTereta;	        
		this.prikolica = prikolica;
	    }
	    
	    //getteri i stteri
	    public double getKapacitetTereta() { return kapacitetTereta; }
		public void setKapacitetTereta(double kapacitetTereta) {
			this.kapacitetTereta = kapacitetTereta;
		}


		public boolean isPrikolica() { return prikolica; }
		public void setPrikolica(boolean prikolica) {
			this.prikolica = prikolica;
		}

		//registracija
	    @Override
	    public double racunajRegistraciju() {
	        double cijena = super.racunajRegistraciju();

	        if (prikolica)
	            cijena += 50;

	        return cijena;
	    }
	    
	    //ispis podataka
		@Override
	    public void ispisiPodatke() {
	        super.ispisiPodatke();
	        System.out.println("Kapacitet tereta: " + kapacitetTereta);
	        System.out.println("Prikolica: " + (prikolica ? "da" : "ne"));
	        System.out.println("Cijena registracije: " + racunajRegistraciju() + "e");
	    }
	}

