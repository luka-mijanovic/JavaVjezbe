import java.util.Scanner;
public class Zadatak1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double a = sc.nextDouble(); 
		double b = sc.nextDouble();
		
		double SrednjaVrijednost = (a+b)/2;
		
		System.out.printf("Srednja vijednost je: %.2f ",SrednjaVrijednost);
		sc.close();
	}

}
