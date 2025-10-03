import java.util.Scanner;
public class Zadatak32 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Unesi broj radnika: ");
        int N = sc.nextInt();
        double ukupno = 0.0;
        
        for (int i = 0; i < N; i++) {
    		System.out.print("Unesi platu radnika: ");
            double plata = sc.nextDouble();
            if (plata <= 1000.0) 
            	ukupno += plata * 0.10;
            else ukupno += plata * 0.20;
        }
        System.out.println(ukupno);
		sc.close();
	}

}
