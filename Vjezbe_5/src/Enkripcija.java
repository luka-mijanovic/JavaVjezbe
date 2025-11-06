/* Napisati program koji za unijeti string s (karakteri stringa cifre od 0 do 9) enkriptuje
na sledeći način: ako je karakter paran broj pretvara se u 0, a ako je karakter neparan
broj pretvara se u 1. Npr. za s = ‘15023’ rezultat je 11001.*/
import java.util.Scanner;
public class Enkripcija {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next().trim(); // samo cifre 0-9
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int d = ch - '0';
			out.append((d % 2 == 0) ? '0' : '1');
		}
		System.out.println(out.toString());
		sc.close();
	}
}
