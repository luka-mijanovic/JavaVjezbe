import java.util.Scanner;
public class Zadatak21 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n = sc.nextInt();
        if (n < 2) {
            System.out.println("Nije prost");
    		sc.close();
            return;
        }
        boolean prost = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
            	prost = false; break;
            }
        }
        System.out.println(prost ? "Prost" : "Nije prost");
		sc.close();
	}

}
