/*Kreirati enumeraciju Studenti. Unutar enumeracije se nalazi pet studenata. Konstante
enumeracije su imena studenata a njihove ocjene na 3 predmeta služe za njihovu
inicijalizaciju. Kreirati metodu unutar enumeracije kojom se računa prosjek studenta.
U okviru testnog programa, štampati studente(ime i prezime) i njihov prosjek.
*/
public enum Studenti {

	//Konstane 5 studenata sa ocjnama iz 3 predmeta
	PETAR_PETROVIC(8, 9, 10),
	MILICA_MILIC(9, 9, 8),
	IVAN_IVANOVIC(10, 10, 9),
	JOVANA_JOVANOVIC(7, 8, 8),
	MARKO_MARKOVIC(6, 7, 8);
	
	//Atributi
	private final int ocjena1;
	private final int ocjena2;
	private final int ocjena3;
	//Konstruktor
	Studenti(int ocjena1, int ocjena2, int ocjena3) {
		this.ocjena1 = ocjena1;
		this.ocjena2 = ocjena2;
		this.ocjena3 = ocjena3;
	}
	//Metoda za racunanje prosjeka ocjena
		public double prosjek() {
			return (ocjena1 + ocjena2 + ocjena3) / 3.0;
		}
		
	//Lijepo formatiran prikaz
		@Override
		public String toString() {
			// zamjenjujemo donju crtu razmakom i pišemo veliko prvo slovo
			String ime = this.name().replace("_", " ");
			return ime.charAt(0) + ime.substring(1).toLowerCase();
	}
}


