import java.util.Scanner;
public class Zadatak37 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double x0 = sc.nextDouble();
        double y0 = sc.nextDouble();
        int n = sc.nextInt();
        int najblizi = -1;
        int najdalji = -1;
        
        double minD = 1000000;
        double maxD = -1;
        for (int i = 1; i <= n; i++) {
            double xi = sc.nextDouble();
            double yi = sc.nextDouble();
            double d = Math.abs(xi - x0) + Math.abs(yi - y0);
            
            System.out.println("Incident " + i + " - Manhattan rastojanje: " + d);
            if (d < minD) {
            	minD = d;
            	najblizi = i;
            } if (d > maxD) {
            	maxD = d; 
            	najdalji = i;
            }
        }
        System.out.println("Najblizi incident: " + najblizi);
        System.out.println("Najdalji incident: " + najdalji);
		sc.close();
	}

}
