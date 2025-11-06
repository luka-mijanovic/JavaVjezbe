//1. Unijeti rečenicu koja sadrži više riječi odvojenih prazninama i odrediti broj riječi.
import java.util.Scanner;
public class Recenica {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		System.out.print("Unesite recenicu: ");
		String line = sc.nextLine();
		line = line.trim();
		
		// Razdvajanje po jednoj ili vise bjelina
		String[] parts = line.split("\\s+");
		System.out.println(parts.length);

		sc.close();
	}

}
