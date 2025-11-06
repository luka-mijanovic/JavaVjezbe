
public class TestDani {
	public static void main(String[] args) {
		System.out.println("=== Dani u nedjelji i da li su vikend ===");
		for (DaniUNedelji dan : DaniUNedelji.values()) {
			System.out.printf("%-10s -> vikend: %-5s | radni dan: %-5s%n",dan, dan.isWeekend(), dan.isWeekDay());
		}
		
		// Primjer pojedinačne provjere:
		DaniUNedelji danas = DaniUNedelji.SUBOTA;
		if (danas.isWeekend()) {
			System.out.println("\nDanas je vikend, super!");
		} else {
			System.out.println("\nRadni dan je, izdrži!");
		}
	}
}

