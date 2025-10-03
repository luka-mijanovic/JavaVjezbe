import java.util.Scanner;
public class Zadatak15 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        double x = sc.nextDouble();
        int n = sc.nextInt();
        double rez = 1;
        for (int i = 0; i < n; i++) {
            rez *= x;
        }
        System.out.println(rez);
		sc.close();
	}

}
