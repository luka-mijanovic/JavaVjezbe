import java.util.Scanner;
public class Zadatak39 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        int N = sc.nextInt();
        int T = sc.nextInt();
        int poz = 0;
        
        for (int i = 0; i < T; i++) {
            int K = sc.nextInt();
            poz = (poz + K) % N;
            System.out.println("Pozicija nakon poteza " + (i+1) + ": " + poz);
        }
        System.out.println("Koncna pozicija: " + poz);
		sc.close();
	}

}
