/*Kreirati statičku metodu izračunaj kojoj se prosleđuje string koji predstvalja prosti
aritmetički izraz u formatu „operand operacija operand“ (npr. „32+1“), gdje su
operandi prirodni brojevi, a operacija jedna od osnovne četiri aritmetičke operacije
(sabiranje, oduzimanje, dijeljenje i množenje). Metoda, kao razultat, treba da vrati
vrijednost prosleđenog aritmetičkog izraza. U glavnom programu, učitati string,
pozvati metodu i prikazati rezultat. Pomoć: Za pretvaranje stringa u cijeli broj, koristiti
statičku metodu parseInt, klase Integer. Primjer: Za proslijeđeni string „3*12“,
metoda vraća 36.*/
import java.util.Scanner;
public class AritmetickeOperacije {
	public static int izracunaj(String expr) {
		expr = expr.trim();
		char op = 0;
		int idx = -1;
		for (int i = 0; i < expr.length(); i++) {
			char c = expr.charAt(i);
			if (c == '+' || c == '-' || c == '*' || c == '/') {
				op = c;
				idx = i;
				break;
			}
		}
		if (idx == -1) { System.out.println("Operator nije pronadjen."); return 0; }
		int a = Integer.parseInt(expr.substring(0, idx).trim());
		int b = Integer.parseInt(expr.substring(idx + 1).trim());
		switch (op) {
			case '+': return a + b;
			case '-': return a - b;
			case '*': return a * b;
			case '/':
				if (b == 0) System.out.println("Dijeljenje nulom!");
				else {return a / b;} // cjelobrojno dijeljenje
			default: System.out.println("Nepoznat operator.");
			}
		return 0;
		}
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String expr = sc.nextLine();
			System.out.println(izracunaj(expr));
			sc.close();
			}
		}
