import java.util.Scanner;
public class Zadatak43 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        int n = Math.abs(sc.nextInt());
        int pregledano = 0;

        boolean sveRazlicite = true;
        while (n > 0) {
            int cifra = n % 10;
            n /= 10;

            int tmp = pregledano;
            boolean postoji = false;
            while (tmp > 0) {
                if (tmp % 10 == cifra) {
                    postoji = true;
                    break;
                }
                tmp /= 10;
            }

            if (postoji) {
                sveRazlicite = false;
            } else {

            	pregledano = pregledano * 10 + cifra;
            }
        }

        if (sveRazlicite) {
            System.out.println("Sve cifre su razlicite");
        } else {
            System.out.println("Postoje iste cifre");
        }
		sc.close();
	}

}
