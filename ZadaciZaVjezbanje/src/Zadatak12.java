import java.util.Scanner;
public class Zadatak12 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int x = sc.nextInt();
		
		int c2 = x % 10;
		int c1 = x / 10;
		
		if (c1 > c2) {
		System.out.printf("%d",c1-c2);
		} else if (c1 < c2) {
		System.out.printf("%d",c1+c2);
		} else {
		System.out.printf("%d",c1*c2);
		}
		sc.close();
	}

}
