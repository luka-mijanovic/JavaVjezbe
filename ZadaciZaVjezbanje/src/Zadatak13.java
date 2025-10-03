import java.util.Scanner;
public class Zadatak13 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double r1 = sc.nextDouble(),r2 = sc.nextDouble();
		
		double P1 = Math.pow(r1, 2)*Math.PI;
		double P2 = Math.pow(r2, 2)*Math.PI;
		
		double O1 = 2*r1*Math.PI;
		double O2 = 2*r2*Math.PI;

		if (P1 > P2) {
		System.out.printf("O1=%.2f",O1);
		} else if (P1 < P2) {
			System.out.printf("O2=%.2f",O2);
		} else {
		System.out.printf("Povrsina oba kruga je ista");
		}
		sc.close();
	}

}
