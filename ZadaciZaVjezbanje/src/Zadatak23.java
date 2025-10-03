import java.util.Scanner;
public class Zadatak23 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double d = sc.nextDouble();
        int n = sc.nextInt();
        double s = sc.nextDouble();
        
        double ukupnoCm = d * 100;
        double pokriveno = n * s;
        double r = (ukupnoCm - pokriveno) / (n + 1);

        System.out.printf("%.2f%n", r);
		sc.close();
	}

}
