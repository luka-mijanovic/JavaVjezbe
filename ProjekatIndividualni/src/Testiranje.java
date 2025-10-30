
public class Testiranje {
	//testiranje
	public static void main(String[] args) {
            
		Automobil a = new Automobil("Audi", 2020, 2000, "Crna", 4, "Dizel");           
		Kamion k = new Kamion("Volvo", 2018, 6000, "Bijela", 12.5, true);           
		Kombi kombi = new Kombi("Mercedes", 2021, 2500, "Siva", 9);

            System.out.println("Automobil");
            a.ispisiPodatke();
            
            System.out.println("\nKamion");
            k.ispisiPodatke();
            
            System.out.println("\nKombi");
            kombi.ispisiPodatke();

	}

}
