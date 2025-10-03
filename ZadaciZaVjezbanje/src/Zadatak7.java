import java.util.Scanner;
public class Zadatak7 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int x = sc.nextInt();
		
		int c3 = x % 10;
		int c2 = (x / 10) % 10;
		int c1 = x / 100;
		
		System.out.printf("Novi broj koji dobijamo je %d%d%d",c3,c2,c1);
		sc.close();
	}

}
