import java.util.Scanner;
public class Zadatak2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double cx = sc.nextDouble();
        double cy = sc.nextDouble();
        double r1 = sc.nextDouble();
        double r2 = sc.nextDouble();
        int n = sc.nextInt();
        int brojTrkaca = 0;
        
        double minD = 1000000;
        double maxD = -1;
        int najblizi = -1;
        int najdalji = -1;

        for (int i = 1; i <= n; i++) {
            long xi = sc.nextLong();
            long yi = sc.nextLong();
    		double d = Math.sqrt(Math.pow(yi-cy,2)+Math.pow(xi-cx,2)) / 2;
    		
            if (yi <= cy && d <= r1 && d >= r2 ) {
            	brojTrkaca ++;
            }
            if (d < minD) {
            	minD = d;
            	najblizi = i;
            } if (d > maxD) {
            	maxD = d; 
            	najdalji = i;
            }
        }
    System.out.println("Broj Trkaca: " + brojTrkaca);
    System.out.println("Najblizi Trkac: " + najblizi);
    System.out.println("Najdalji Trkac: " + najdalji);
		sc.close();
	}

}
