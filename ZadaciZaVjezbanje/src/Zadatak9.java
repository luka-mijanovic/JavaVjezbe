import java.util.Scanner;
public class Zadatak9 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a = 543;
		int b = 130;
		int strana = 65;
		int broj = (a / strana) * (b / strana);
		System.out.printf("Moguce je izrezati: %d kvadrata",broj);
		sc.close();
	}

}
