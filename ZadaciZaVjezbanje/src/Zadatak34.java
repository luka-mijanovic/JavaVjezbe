import java.util.Scanner;
public class Zadatak34 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Unesi broj dana: ");
        int n = sc.nextInt();
        int poslednjiNeg = 0;
        for (int i = 1; i <= n; i++) {
    		System.out.print("Unesi dnevniu temperaturu: ");
            int t = sc.nextInt();
            if (t < 0) 
            	poslednjiNeg = i;
        }
        if (poslednjiNeg == 0) 
        	System.out.println("Nema dana sa negativnim temperaturama");
        else 
        	System.out.println(poslednjiNeg);
        
		sc.close();
	}

}
