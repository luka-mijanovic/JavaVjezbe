import java.util.Scanner;
public class Zadatak20 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double x = sc.nextDouble();

        
        if (x > 0 && x < 100) {
        	System.out.println("Tečno");
        }
        else if (x <= 0) {
        	System.out.println("Čvrsto");
        }
        else {
        	System.out.println("Gasovito");
        }
		sc.close();
	}

}
