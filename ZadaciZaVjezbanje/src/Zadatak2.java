import java.util.Scanner;
public class Zadatak2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double x = sc.nextDouble(); 
		double y = sc.nextDouble();
		
		double z = x;
		double Ana = y;
		double Milica = z;
		
		System.out.printf("Ana je obisla teren %.2f puta a Milica %.2f puta",Ana,Milica);
		sc.close();
	}

}
