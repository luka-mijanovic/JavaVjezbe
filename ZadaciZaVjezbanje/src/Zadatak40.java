import java.util.Scanner;
public class Zadatak40 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double cx = sc.nextDouble();
        double cy = sc.nextDouble();
        double R1 = sc.nextDouble();
        double R2 = sc.nextDouble(); // R1 < R2
        int N = sc.nextInt();
        int brojac = 0;
        double maxDist = -1;
        int najdalji = -1;
        
        for (int i = 1; i <= N; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            double d = Math.sqrt((x - cx)*(x - cx) + (y - cy)*(y - cy));
            if (d >= R1 && d <= R2 && y >= cy) {
                brojac++;
            }
            if (d > maxDist) {
                maxDist = d;
                najdalji = i;
            }
        }
        System.out.println("Broj trkaca u prstenu i gornjoj poluravni: " + brojac);
        System.out.println("Najudaljeniji trkac: index " + najdalji + ", dist = " + maxDist);
		sc.close();
	}

}
