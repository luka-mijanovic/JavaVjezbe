/* Dobili ste zadatak da napisete program koji treba da izračuna prosječnu
temperaturu u Podgorici za poslednjih n dana. Poznato je da su temperature
(Celzijus) u poslednjih n dana pozitivni dvocifreni brojevi, a vrijednosti su sačuvane
u obliku stringa tako da su temperature odvojene blankom (space). Prosječnu
temperaturu prikazati kao cijeli broj.*/
import java.util.Scanner;
public class ProsjecnaTemp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine().trim();
		if (line.isEmpty()) {
			System.out.println(0);
			return;
		}
		
		String[] parts = line.split("\\s+");
		int sum = 0;
		for (String p : parts) {
			sum += Integer.parseInt(p);}
		int avg = sum / parts.length; // cjelobrojno
		System.out.println(avg);
		sc.close();
	}
}
