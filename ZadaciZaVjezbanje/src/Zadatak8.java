import java.util.Scanner;
public class Zadatak8 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double x1 = sc.nextDouble(), y1 = sc.nextDouble(), x2 = sc.nextDouble(), y2 = sc.nextDouble();

		double a = Math.abs(x1-x2);
		double b = Math.abs(y2-y1);
		
		double rastojanje = Math.sqrt(Math.pow(a,2)+Math.pow(b,2)) / 2;
		
		double x3 = (x1 + x2) / 2;
		double y3 = (y1 + y2) / 2;
		
		System.out.printf("Tacka sustreta je x3=%.0f, y3=%.0f a rastojanje od tacaka je %.2f",x3,y3,rastojanje);

		sc.close();
	}

}
