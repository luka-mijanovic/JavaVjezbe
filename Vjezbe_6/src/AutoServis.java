import java.util.ArrayList;

public class AutoServis {

	public static ArrayList<Auto> neregistrovanKojiSeMoguRegistrovati(ArrayList<Auto> auta) {
		ArrayList<Auto> lista = new ArrayList<>();
		for (Auto a : auta) {
			if (a.mozeSeRegistrovati() && !a.isRegistrovan()) {
				lista.add(a);
			}
		}
		return lista;
	}
	public static double ukupnaRegistracija(ArrayList<Auto>auta) {
		double suma = 0;
		for(Auto a : auta) {
			suma += a.cijenaRegistracije();
		}
		return suma;
	}
}
