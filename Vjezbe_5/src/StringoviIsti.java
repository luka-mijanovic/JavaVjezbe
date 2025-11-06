//Unijeti dva stringa i ispitati da li su ista bez obzira na veličinu slova.
import java.util.Scanner;
public class StringoviIsti {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine().trim();
		String s2 = sc.nextLine().trim();
		System.out.println(s1.equalsIgnoreCase(s2));
		sc.close();
	}
}
