/*Napisati program kojim se za unijeti string provjeravate koliko ima jednocifrenih
negativnih brojeva. String se sastoji od negativnih i pozitivnih brojeva i oznaka za
negativne (-) i pozitivne (+). Primjer: +23-2-32+4-22-4 izlaz je 2*/
import java.util.Scanner;
public class BrojNegativnih {
	private static boolean isDigit(char c) { return c >= '0' && c <= '9'; }
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		String s = sc.nextLine().trim();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) == '-' && i + 1 < s.length() && isDigit(s.charAt(i +1)))
		{
		// Ako nakon cifre NE slijedi jos jedna cifra, onda je jednocifren broj
		if (i + 2 >= s.length() || !isDigit(s.charAt(i + 2))) {
			count++;
		}
	}
}
		System.out.println(count);
		sc.close();
	}
}