import java.util.Scanner;
public class Zadatak26 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double lx = sc.nextDouble();
        double ly = sc.nextDouble();
        double dx = sc.nextDouble();
        double dy = sc.nextDouble();
        
        boolean naIvici = false;
        
        if (x == lx && y >= dy && y <= ly) {
        	naIvici = true;
        }
        else if (x == dx && y >= dy && y <= ly) {
        	naIvici = true;
        }
        else if (y == ly && x >= lx && x <= dx) {
        	naIvici = true;
        }
        else if (y == dy && x >= lx && x <= dx) {
        	naIvici = true;
        }

        if (naIvici) {
            System.out.println("Da");
        } else {
            System.out.println("Ne");
        }
		sc.close();
	}

}
