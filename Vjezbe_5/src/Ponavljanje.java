/*. Napisati program koji kompresuje string tako da zamijeni uzastopno ponavljajuće
karaktere brojem njihovih ponavljanja. Ako se karakter ne ponavlja prepisati karakter.
Primjer:
Ulaz: "aaabbcccc" Izlaz: “a3b2c4”
Ulaz: “abc” Izlaz: “abc”
Ulaz: “abab” Izlaz: “abab”*/

import java.util.Scanner;
public class Ponavljanje {
	public static String kompresuj(String s) {
		if (s.isEmpty()) return s;
		StringBuilder out = new StringBuilder();
		int count = 1;
		for (int i = 1; i <= s.length(); i++) {
			if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
				count++;
				} else {
				out.append(s.charAt(i - 1));
				if (count > 1) out.append(count);
				count = 1;
				}
			}
			return out.toString();
		}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String s = sc.nextLine();
			System.out.println(kompresuj(s));
			sc.close();
			}
		}
