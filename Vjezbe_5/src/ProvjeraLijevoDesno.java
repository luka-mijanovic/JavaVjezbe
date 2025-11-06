/*Dat je string sastavljen od karaktera 0 i 1. Karakter 0 predstavlja slobodno polje, a 1
predstavlja zauzeto polje. Vaš zadatak je da za zadatu poziciju u stringu provjerite da
li su susjedna polja slobodna (lijevo i desno). Napomena: za prvo polje gledate same
desno polje, za poslednje polje samo lijevo polje, a za ostala i lijevo i desno polje. Npr.
ako je string 01010, a zadata pozicija 2 (indeksiranje kreće od nule), treba štampati 0
jer nema slobodnih polja.*/
import java.util.Scanner;
public class ProvjeraLijevoDesno {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next(); // npr. 01010
		int pos = sc.nextInt(); // traÅ3/4ena pozicija
		
		// Provjera va3/4enja pozicije
		if (pos < 0 || pos >= s.length()) {
			System.out.println("Neispravna pozicija");
			return;
		}
		boolean slobodno = false;
		if (pos == 0) {
			slobodno = (s.charAt(1) == '0');
		} else if (pos == s.length() - 1) {
			slobodno = (s.charAt(s.length() - 2) == '0');
		} else {
			slobodno = (s.charAt(pos - 1) == '0') || (s.charAt(pos + 1) == '0');
		}
		System.out.println(slobodno ? 1 : 0);
		sc.close();
	}
}