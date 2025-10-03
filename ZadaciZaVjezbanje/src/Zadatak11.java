import java.util.Scanner;
public class Zadatak11 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int x = sc.nextInt();
		
		int c5 = x % 10;
		int c4 = (x / 10) % 10;
		
		int sprat = c4 + c5;
		System.out.printf("Stan se nalazi na spratu broj: %d",sprat);

		sc.close();
	}

}
