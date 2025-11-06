//Napisati program kojim se učitava rečenica. Štampati rečenicu sa obrnutim
//redosledom karaktera u riječima. Primjer: Marko programira -> okraM arimargorp.
//Napomena: pogledati dokumentaciju StringBuilder klase.
import java.util.Scanner;
public class ObrnutiRedosle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] words = line.split(" ");
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
		String w = words[i];
		StringBuilder rev = new StringBuilder(w).reverse();
		result.append(rev);
		if (i < words.length - 1) result.append(" ");
		}
		System.out.println(result.toString());
		sc.close();
	}
}
