//Kreirati StringBuilder sa sadržajem „programiranje“. Obrisati slova od 3. do 6. indeksa
public class BrisanjeSlova {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("programiranje");
		// delete(start, endExclusive) -> brisace 3,4,5,6
		sb.delete(3, 7);
		System.out.println(sb.toString());
	}
}
