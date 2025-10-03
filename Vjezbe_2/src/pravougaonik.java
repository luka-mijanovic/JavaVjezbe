import java.util.Scanner;
public class pravougaonik {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double a = sc.nextDouble(); 
		double b = sc.nextDouble();
		
		double P = a*b;
		double O = 2*a+2*b;
				
		System.out.printf("Povrsina je:%.2f O=%.2f%n",P,O);
		sc.close();
	}

}
