import java.util.Scanner;
public class Zadatak19 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double a = sc.nextDouble();
        double b = sc.nextDouble();
		
        if (b/2 >= a) {
        	System.out.println("Moguce je napraviti bar 2 kvadrata");
        }
        else {
        	System.out.println("Nije moguce");
        }
		sc.close();
	}

}
