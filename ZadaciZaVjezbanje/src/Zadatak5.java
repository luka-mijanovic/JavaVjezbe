import java.util.Scanner;
public class Zadatak5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double x = sc.nextDouble();
		
		double sprat = (x % 100)/10;
				
		System.out.printf("Stan broj %.0f se nalazi na spratu broj %.0f",x,sprat);
		sc.close();
	}

}
