//Provjeriti da li je unesena riječ palindrom
import java.util.Scanner;
public class Palindrom {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		String s = sc.next().trim();
		String rev = new StringBuilder(s).reverse().toString();
		System.out.println(s.equalsIgnoreCase(rev) ? "DA" : "NE");
		
		sc.close();
	}

}
