import java.util.Scanner;
public class Zadatak18 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double xt = sc.nextDouble();
        double yt = sc.nextDouble();
        
        double xlg = sc.nextDouble();
        double ylg = sc.nextDouble();
        double xdd = sc.nextDouble();
        double ydd = sc.nextDouble();
        
        boolean unutra = (xt >= xlg && xt <= xdd && yt <= ylg && yt >= ydd);
        if (unutra) {
        	System.out.println("Nalazi se unutar pravougaonika");
        }
        else {
        	System.out.println("Nalazi se van pravougaonika");
        }	
		sc.close();
	}

}
