import java.util.Scanner;
public class Zadatak6 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int x = sc.nextInt();
		
		int c4 = x % 10;
		int c3 = (x / 10) % 10;
		int c2 = (x / 100) % 10;
		int c1 = x / 1000;

		double KvadratZbira = Math.pow((c1+c2+c3+c4), 2);

		System.out.printf("Kvadrat zbira cifara iznosi %.0f",KvadratZbira);
		sc.close();
	}

}
