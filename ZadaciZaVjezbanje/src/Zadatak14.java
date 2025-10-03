import java.util.Scanner;
public class Zadatak14 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        
        double min = a;        
        if (b < min) {
        min = b;
        }
        if (c < min) {
        min = c;
        }
        
        double max = a;
        if (b > max) {
        max = b;
        }
        if (c > max) {
        max = c;
        }
        
        System.out.printf("Minimum: %.0f%n", min);
        System.out.printf("Maximum: %.0f", max);
		sc.close();
	}

}
