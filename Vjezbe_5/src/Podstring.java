//Za data dva stringa provjeriti da li je drugi podstring prvog.
import java.util.Scanner;
public class Podstring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(a.contains(b));
		sc.close();
	}
}
