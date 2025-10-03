import java.util.Scanner;
public class Zadatak4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double g1 = sc.nextDouble(); 
		double g2 = sc.nextDouble();
		double g3 = sc.nextDouble(); 
		double g4 = sc.nextDouble();
		
		double ProsjekStanovnika = (g1+g2+g3+g4)/4;
		System.out.printf("Prosjecni broj stanovnika za 4 grada je: %.0f",ProsjekStanovnika);
		sc.close();
	}

}
