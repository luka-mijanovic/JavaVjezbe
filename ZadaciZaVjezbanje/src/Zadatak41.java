import java.util.Scanner;
public class Zadatak41 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        int N = sc.nextInt();
        double R = sc.nextDouble();
        int pogodjeni = 0;
        double minDist = R + 1;
        int najblizi = -1;
        
        for (int i = 1; i <= N; i++) {
            double xi = sc.nextDouble();
            double yi = sc.nextDouble();
            double d2 = (xi - x)*(xi - x) + (yi - y)*(yi - y);
            if (d2 <= R*R) {
                pogodjeni++;
            }
            if (d2 < minDist) {
                minDist = d2;
                najblizi = i;
            }
        }
        System.out.println("Broj pogodjenih neprijatelja: " + pogodjeni);
        System.out.println("Najblizi neprijatelj: " + najblizi + ", dist = " + Math.sqrt(minDist));
		sc.close();
	}

}
