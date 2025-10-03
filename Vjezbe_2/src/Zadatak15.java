import java.util.Scanner;
public class Zadatak15 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double x1 = sc.nextDouble(), y1 = sc.nextDouble(), xi = sc.nextDouble(), yi = sc.nextDouble();
		
		for(int i=2;i<5;i++);
			double a = Math.abs(x1-xi);
			double b = Math.abs(yi-y1);
			
			double rastojanje = Math.sqrt(a*a+b*b);
			double ukupno_rastojanje = + rastojanje;
			
			System.out.printf("Ukupna razdaljina koju dron prodje je:%.2f",ukupno_rastojanje);
			sc.close();

	}

}
