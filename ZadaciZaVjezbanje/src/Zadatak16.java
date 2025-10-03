import java.util.Scanner;
public class Zadatak16 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double p1 = sc.nextDouble();
        double p2 = sc.nextDouble();
        double p3 = sc.nextDouble();
        
        double par12 = p1 + p2;
        double par13 = p1 + p3;
        double par23 = p2 + p3;
        
        double min = par12; 
        if (par13 < min) {
        	min = par13;
        }
        if (par23 < min) { 
        	min = par23;
        }
        System.out.printf("Najmanji zbir je %.2f", min);
		sc.close();
	}

}
