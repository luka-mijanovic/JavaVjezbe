/*
Kreirati enumeraciju koja predstavlja dane u nedjelji. Uz to kreirati metode
isWeekend() ili isWeekDay() koje provjeravaju da li je inicijalizovana konstanta
vikend (subota,nedjelja) ili dan u nedjelji (pon-pet). Ove metode vraćaju boolean
vrijednosti. Testirati enumeraciju.
 */
public enum DaniUNedelji {
	PONEDELJAK,
	UTORAK,
	SRIJEDA,
	CETVRTAK,
	PETAK,
	SUBOTA,
	NEDELJA;
	// Metoda koja provjerava da li je dan vikend
	public boolean isWeekend() {
		return this == SUBOTA || this == NEDELJA;
	}
	// Metoda koja provjerava da li je dan radni (pon-pet)
	public boolean isWeekDay() {
		return !isWeekend();
	}
	
	@Override
	public String toString() {
		String ime = this.name().toLowerCase();
		return ime.substring(0, 1).toUpperCase() + ime.substring(1);
	}
}

