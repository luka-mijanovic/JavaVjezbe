import java.util.Scanner;
public class PetiZadatak {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		double xh = sc.nextDouble(), xk = sc.nextDouble(), yh = sc.nextDouble(), yk = sc.nextDouble();
		double xb = xk + 2;
		double yb = yk - 3;
		
		double a1 = Math.abs(xh-xb);
		double b1 = Math.abs(yh-yb);

		double rastojanjeHrastBlago = Math.sqrt(Math.pow(a1,2)+Math.pow(b1,2));
		
		double a2 = Math.abs(xh-xk);
		double b2 = Math.abs(yh-yk);
		double a3 = Math.abs(xk-xb);
		double b3 = Math.abs(yk-yb);
		
		double rastojanjeHrastKucaBlago = Math.sqrt(Math.pow(a2,2)+Math.pow(b2,2))+Math.sqrt(Math.pow(a3,2)+Math.pow(b3,2));
		System.out.printf("Razdaljina od hrasta do blaga je: %.2f",rastojanjeHrastBlago);
		System.out.printf("Razdaljina od hrasta do blaga ako prolazimo pored kuce je je: %.2f",rastojanjeHrastKucaBlago);
		sc.close();
	}

}
