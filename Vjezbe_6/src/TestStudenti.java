
public class TestStudenti {
	public static void main(String[] args) {
		
	System.out.println("=== Spisak studenata i njihovih prosjeka ===");
	
		for (Studenti s : Studenti.values()) {
			System.out.printf("%-20s -> prosjek: %.2f%n", s.toString(),s.prosjek());
		}
	}
}