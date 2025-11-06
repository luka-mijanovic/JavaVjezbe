import java.util.ArrayList;

public class TestAuto {

	public static void main(String[] args) {
		ArrayList<Auto> auta = new ArrayList<>();
		auta.add(new Auto("Zastava 101", 1980, 40, false, 1100, true));
		auta.add(new Auto("VW Golf 3", 1995, 55, true, 1600, false));
		auta.add(new Auto("Opel Astra", 2005, 74, false, 1800, true));
		auta.add(new Auto("Toyota Corolla", 2015, 97, false, 1598, false));
		auta.add(new Auto("BMW 320d", 2020, 140, true, 1995, true));
		
		System.out.println("- Svi automobili -");
		for (Auto a : auta) System.out.println(a);
		
		System.out.println("\n - Mogu se registrovati, a NISU registrovani -");
		for (Auto a : AutoServis.neregistrovanKojiSeMoguRegistrovati(auta)) {
			System.out.println(a);
		}

		System.out.printf("\nUkupna cijena registracije: %.2f\n",
	AutoServis.ukupnaRegistracija(auta));
			System.out.printf("Broj prodatih auta: %d\n", Auto.getBrojProdatih());
	
			System.out.print("Prvo auto:" + auta.get(0));

	}
}