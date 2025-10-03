import java.util.Scanner;
public class Zadatak25 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n = sc.nextInt();
		
        if (n % 2 == 0) {
            int zbir = 0;
            while (n > 0) {
                int c = n % 10;
                if (c % 2 == 0) {
                	zbir += c;
                }
                n /= 10;
            }
        System.out.println(zbir);
        }
        else {
        	int proizvod = 1;
            while (n > 0) {
                int c = n % 10;
                if (c % 2 != 0) {
                	proizvod *= c;
                }
                n /= 10;
            }
        System.out.println(proizvod);
        }
		sc.close();
	}

}
